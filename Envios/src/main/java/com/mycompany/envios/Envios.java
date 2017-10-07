/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.envios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author chris
 */
@WebService(serviceName = "Envios")
public class Envios {

    @WebMethod(operationName = "guardar_Id_Transferencia")
    public String guardar_Id_Transferencia(@WebParam(name = "id_Transferencia") int id_Transferencia, @WebParam(name = "monto_Compra") double monto_Compra) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();
        if(id_Transferencia>=0 && monto_Compra>0.0){
            
            Transferencia transferencia=new Transferencia(id_Transferencia,monto_Compra);
            int coneccion=transferencia.Coneccion();
            if(coneccion==0){
                ((ObjectNode) rootNode).put("status", "1");
                ((ObjectNode) rootNode).put("descripción", "No se pudo conectar a la base de datos");
            }else{
                int Ingreso=transferencia.IngresarTransferencia();
                if(Ingreso==0){
                    ((ObjectNode) rootNode).put("status", "1");
                    ((ObjectNode) rootNode).put("descripción", "No se pudo conectar a la base de datos");
                }else{
                    ((ObjectNode) rootNode).put("status", "0");
                    ((ObjectNode) rootNode).put("descripción", "Exitoso");
                }
            }
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        }else{
            ((ObjectNode) rootNode).put("status", "1");
            ((ObjectNode) rootNode).put("descripción", "Los parametros son incorrectos");
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        }
    }
}
