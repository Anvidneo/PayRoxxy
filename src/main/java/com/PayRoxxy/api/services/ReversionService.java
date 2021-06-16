package com.PayRoxxy.api.services;

import com.PayRoxxy.api.models.ConsultReversionModel;
import com.PayRoxxy.api.models.HeadResponseModelB;
import com.PayRoxxy.api.models.ResponseReversionModel;
import com.PayRoxxy.api.models.ReverserdPaidsModel;
import com.PayRoxxy.api.models.UserModel;
import com.PayRoxxy.api.models.UtilResponseModelR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReversionService {
    @Autowired
    UserService userService;
    @Autowired
    EntityService entityService;
    @Autowired
    CondominiumService condominiumService;
    @Autowired
    ReversedPaidService reversedPaidService;
    @Autowired
    FeesPaidService feesPaidService;
    
    public ResponseReversionModel reversion (ConsultReversionModel params){
        // Init variables
        HeadResponseModelB headRes = new HeadResponseModelB();
        UtilResponseModelR utilRes = new UtilResponseModelR();
        ResponseReversionModel response = new ResponseReversionModel();
        // Define head response
        headRes.setCodError("");
        headRes.setDescription("");
        // Define util response
        // --

        // Get params
        String user = (params.getHead()).getUser();
        String pass = (params.getHead()).getPassword();
        String entityId = (params.getHead()).getEntity();

        // CodigoBusqueda
        String codCon = (params.getUtil().getCodSearch());
        Integer idPay = (params.getUtil().getIdPay());
        Integer idReversion = (params.getUtil().getIdReversion());
        String dateReversion = (params.getUtil().getDateReversion());

        Integer id = Integer.parseInt(entityId);
        
        // Check if user and password correct, and if id entity is correct
        UserModel entity = this.userService.getUserByEntityIdAndEntityId(user, pass, id);
        if (entity != null) {
            // Integer idUser = this.userService.getIdUser(user, pass);
            // Check if entity exist
            Boolean optionalEntityModel = entityService.getByIdifExists(id);
            if (optionalEntityModel) {
                String nameCond = this.condominiumService.getByName(codCon).getName();
                if (codCon.equals(nameCond)) {
                    Boolean payExists = feesPaidService.getByIdifExists(idPay);
                    if (payExists) {
                        // Check if pay have reversion
                        Boolean haveReversion = reversedPaidService.getByIdifExists(idPay);
                        if (!haveReversion) {
                            // Save reversion
                            ReverserdPaidsModel reversion = new ReverserdPaidsModel();
                            reversion.setIdQuota(idPay);
                            reversion.setIdTransaction(idReversion);
                            reversion.setDateReverserd(dateReversion);
                            reversedPaidService.saveReversedPaid(reversion);
                            // Get id reversion
                            Integer lastId = reversedPaidService.getLastId();
                            // Delete payment
                            Boolean feesDeleted = feesPaidService.deleteFeedsPaid(idPay);
                            if (feesDeleted) {
                                // Define head response
                                headRes.setCodError("000");
                                headRes.setDescription("Don't have error");
                                // Define util response
                                utilRes.setCodSearch(codCon);
                                utilRes.setIdTxnNeivorReversion(lastId);
                                utilRes.setIdTxnReversed(idReversion);
                            } else {
                                reversedPaidService.deleteReversion(idPay);
                                // Define head response
                                headRes.setCodError("210");
                                headRes.setDescription("Reversion not possible");
                            }
                        } else {
                            // Define head response
                            headRes.setCodError("209");
                            headRes.setDescription("Payment have reversion");
                        }
                    } else {
                        // Define head response
                        headRes.setCodError("208");
                        headRes.setDescription("Payment not found");
                    }
                } else {
                    // Define head response
                    headRes.setCodError("204");
                    headRes.setDescription("Condominium not found");
                }
            } else {
                // Define head response
                headRes.setCodError("203");
                headRes.setDescription("Entity not found");
            }
        } else {
            // Define head response
            headRes.setCodError("202");
            headRes.setDescription("User not found");
        }
        // Define response
        response.setHead(headRes);
        response.setUtil(utilRes);
        
        // Return response
        return response;
    }
}
