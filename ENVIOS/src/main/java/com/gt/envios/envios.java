/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.envios;

import com.gt.svc.envioSvc;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 *
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@WebService(serviceName = "envios")
public class envios {

    @Inject
    envioSvc enviosvc;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "cargar_Vehiculos")
    public String hello() {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);
        String jsonStr="";
        try {
            jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(enviosvc.findAllVehiculo());
        } catch (IOException ex) {
            Logger.getLogger(envios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonStr;
    }
    @WebMethod(operationName = "calcular_Costo_Viaje")
    public String costo_Viaje(@WebParam(name="id_Vehiculo") int id_Vehiculo ,@WebParam(name = "pais_Destino") String pais_Destino) {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);
        String jsonStr="";
        try {
            jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(enviosvc.calcular_Costo_Viaje(id_Vehiculo, pais_Destino));
        } catch (IOException ex) {
            Logger.getLogger(envios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonStr;
    }
    @WebMethod(operationName = "guardar_Transferencia")
    public String save_Transfer(@WebParam(name="id_Transferencia") int id_Transferencia ,@WebParam(name = "monto") double monto) {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);
        String jsonStr="";
        try {
            jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(enviosvc.create(id_Transferencia, monto));
        } catch (IOException ex) {
            Logger.getLogger(envios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonStr;
    }
}
