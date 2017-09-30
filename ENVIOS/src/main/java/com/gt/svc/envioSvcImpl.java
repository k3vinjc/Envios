/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.svc;

import com.gt.dao.enviosDao;
import com.gt.dto.InformacionVehiculo;
import com.gt.dto.Response_Info_Vehiculos;
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
    public  Response_Info_Vehiculos findAllVehiculo() {
        Response_Info_Vehiculos retorno;
        List<InformacionVehiculo> datos = enviosdao.findAllVehiculo();
        if(datos != null){
            retorno= new Response_Info_Vehiculos();
            retorno.setVehiculos(datos);
            retorno.setStatus(0);
            retorno.setDescripcion("Exitoso");
        }else{
            retorno= new Response_Info_Vehiculos();
            retorno.setStatus(1);
            retorno.setDescripcion("Error con la conexión a la BD de Envios");
        }
        
        return retorno;
    }

}
