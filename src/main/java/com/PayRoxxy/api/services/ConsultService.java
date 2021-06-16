package com.PayRoxxy.api.services;

import com.PayRoxxy.api.models.UserModel;
import com.PayRoxxy.api.models.UtilResponseModelB;
import com.PayRoxxy.api.models.HeadResponseModelB;
import com.PayRoxxy.api.models.QuotaModel;
import com.PayRoxxy.api.models.ResponseModelB;

import java.util.ArrayList;

import com.PayRoxxy.api.models.ConsultModelB;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ConsultService {
    @Autowired
    UserService userService;
    @Autowired
    EntityService entityService;
    @Autowired
    CondominiumService condominiumService;
    @Autowired
    QuotaService quotaService;

    public ResponseModelB consultByCliente(ConsultModelB params) {
        // Init variables
        HeadResponseModelB headRes = new HeadResponseModelB();
        UtilResponseModelB utilRes = new UtilResponseModelB();
        ResponseModelB response = new ResponseModelB();
        // Define head response
        headRes.setCodError("");
        headRes.setDescription("");
        // Define util response
        utilRes.setCodSearch("");
        utilRes.setCodService("");
        utilRes.setAmountOwed(0.0);
        utilRes.setAmountMinimum(0.0);
        utilRes.setAmountComission(0.0);
        utilRes.setNameClien("");

        // Get params
        String user = params.getHead().getUser();
        String pass = params.getHead().getPassword();
        String entityId = params.getHead().getEntity();
        String codCon = params.getUtil().getCodSearch();
        String codSer = params.getUtil().getCodService();
        Integer id = Integer.parseInt(entityId);
        
        // Check if user and password correct, and if id entity is correct
        UserModel entity = this.userService.getUserByEntityIdAndEntityId(user, pass, id);
        if (entity != null) {
            Integer idUser = this.userService.getIdUser(user, pass);
            // Check if entity exist
            Boolean optionalEntityModel = entityService.getByIdifExists(id);
            if (optionalEntityModel) {
                // Check if condominium exist
                String nameCond = this.condominiumService.getByName(codCon).getName();
                if (codCon.equals(nameCond)) {
                    // Define head response
                    headRes.setCodError("000");
                    headRes.setDescription("Don't have error");
                    // Define util response
                    String nameClient = entity.getName();
                    utilRes.setNameClien(nameClient);
                    Double amount = quotaService.getAmountTotalByUser(idUser);
                    // If amount is 0 get list of quotas
                    if (amount.equals(0.0)) {
                        ArrayList<QuotaModel> list = quotaService.getByIdUser(idUser);
                        utilRes.setList(list);
                    } else {
                        utilRes.setAmountOwed(amount);
                        utilRes.setList(null);
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
        // Define util response
        utilRes.setCodSearch(codCon);
        utilRes.setCodService(codSer);
        // Define response
        response.setHead(headRes);
        response.setUtil(utilRes);
        
        // Return response
        return response;
    }
}
