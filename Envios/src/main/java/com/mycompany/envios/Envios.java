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
import java.text.DecimalFormat;
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
                ((ObjectNode) rootNode).put("status", 1);
                ((ObjectNode) rootNode).put("descripción", "No se pudo conectar a la base de datos");
            }else{
                int Ingreso=transferencia.IngresarTransferencia();
                if(Ingreso==0){
                    ((ObjectNode) rootNode).put("status", 1);
                    ((ObjectNode) rootNode).put("descripción", "No se pudo conectar a la base de datos");
                }else{
                    ((ObjectNode) rootNode).put("status", 0);
                    ((ObjectNode) rootNode).put("descripción", "Exitoso");
                }
            }
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        }else{
            ((ObjectNode) rootNode).put("status", 1);
            ((ObjectNode) rootNode).put("descripción", "Los parametros son incorrectos");
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        }
    }
    @WebMethod(operationName = "calcular_Costo_Viaje")
    public String calcular_Costo_Viaje(@WebParam(name = "id_Vehiculo") int id_Vehiculo, @WebParam(name = "pais_Destino") String pais_Destino) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();
        DecimalFormat df = new DecimalFormat("#.00"); 
        if(id_Vehiculo>=0 && !pais_Destino.equals("")){
            
            Vehiculo vehiculo=new Vehiculo(id_Vehiculo);
            MySqlHanddler MSQ=new MySqlHanddler();
            int coneccion=vehiculo.Coneccion();
            if(coneccion==0 || MSQ.Conectar()==0 ){
                ((ObjectNode) rootNode).put("costo_viaje", 0.0);
                ((ObjectNode) rootNode).put("status", 1);
                ((ObjectNode) rootNode).put("descripción", "No se pudo conectar a la base de datos");
            }else{
                if(vehiculo.Existeid()==0){
                    ((ObjectNode) rootNode).put("costo_viaje", 0.0);
                    ((ObjectNode) rootNode).put("status", 1);
                    ((ObjectNode) rootNode).put("descripción", "No existe el id del vehiculo");
                }else if(MSQ.ExistePais(pais_Destino)==0){
                    ((ObjectNode) rootNode).put("costo_viaje", 0.0);
                    ((ObjectNode) rootNode).put("status", 1);
                    ((ObjectNode) rootNode).put("descripción", "El pais destino no existe");
                }else{
                    double factor=MSQ.FactorPais(pais_Destino);
                    double peso=vehiculo.peso();
                    double Costo_Basico=vehiculo.Costo_Basico();
                    ((ObjectNode) rootNode).put("costo_viaje", Double.parseDouble(df.format(Costo_Basico+(factor*peso))));
                    ((ObjectNode) rootNode).put("status", 0);
                    ((ObjectNode) rootNode).put("descripción", "Exitoso");
                }
            }
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        }else{
            ((ObjectNode) rootNode).put("costo_viaje", 0.0);
            ((ObjectNode) rootNode).put("status", 1);
            ((ObjectNode) rootNode).put("descripción", "Los parametros son incorrectos");
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        }
    }
}
