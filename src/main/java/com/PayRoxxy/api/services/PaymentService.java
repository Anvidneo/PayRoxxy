package com.PayRoxxy.api.services;

import com.PayRoxxy.api.models.FeesPaidModel;
import com.PayRoxxy.api.models.HeadResponseModelB;
import com.PayRoxxy.api.models.ConsultPaymentModel;
import com.PayRoxxy.api.models.ResponsePaymentModel;
import com.PayRoxxy.api.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    UserService userService;
    @Autowired
    EntityService entityService;
    @Autowired
    CondominiumService condominiumService;
    @Autowired
    QuotaService quotaService;
    @Autowired
    FeesPaidService feesPaidService;


    public ResponsePaymentModel payment (ConsultPaymentModel params){
        // Init variables
        HeadResponseModelB headRes = new HeadResponseModelB();
        FeesPaidModel utilRes = new FeesPaidModel();
        ResponsePaymentModel response = new ResponsePaymentModel();
        // Define head response
        headRes.setCodError("");
        headRes.setDescription("");
        // Define util response
        // --

        // Get params
        String user = params.getHead().getUser();
        String pass = params.getHead().getPassword();
        String entityId = params.getHead().getEntity();

        Integer idTransaction = params.getUtil().getIdTransaction();
        String datePayment = params.getUtil().getDatePayment();
        String codCon = params.getUtil().getCodSearch();
        Double amountTotal = params.getUtil().getAmountTotal();
        String placePayment = params.getUtil().getPlacePayment();
        Integer invoice = params.getUtil().getListDetail().getinvoice();

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
                    Boolean quota = quotaService.getByIdifExists(invoice);
                    if (quota) {
                        // Check if quota have available balance
                        Boolean availableBalance = feesPaidService.getByIdQuotaIfHave(invoice);
                        if (availableBalance) {
                            Double availableAmount = feesPaidService.getAmountAvailable(invoice, amountTotal);
                            if (Double.compare(amountTotal, availableAmount) <= 0){
                                // Save paid in database
                                FeesPaidModel paid = new FeesPaidModel();
                                paid.setIdTransaction(idTransaction);
                                paid.setAmountPaid(amountTotal);
                                paid.setIdQuota(invoice);
                                paid.setDatePaid(datePayment);
                                paid.setPlacePaid(placePayment);
                                feesPaidService.saveFeedPaid(paid);

                                utilRes = paid;
                                // Define head response
                                headRes.setCodError("000");
                                headRes.setDescription("Don't have error");
                            } else {
                                // Define head response
                                headRes.setCodError("207");
                                headRes.setDescription("Amount total beats quota amount available");
                            }
                        } else {
                            // Define head response
                            headRes.setCodError("206");
                            headRes.setDescription("Balance not avalaible");
                        }
                    } else {
                        // Define head response
                        headRes.setCodError("205");
                        headRes.setDescription("Quota not found");
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
