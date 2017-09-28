/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.svc;

import com.gt.dao.enviosDao;
import com.gt.entity.ModeloVehiculo;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@RequestScoped
public class envioSvcImpl implements envioSvc{
    
    @Inject
    enviosDao enviosdao;

    @Override
    public List<ModeloVehiculo> findAllModel() {
        return enviosdao.findAllModel();
    }

}
