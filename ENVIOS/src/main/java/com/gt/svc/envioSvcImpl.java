/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.svc;

import com.gt.dao.enviosDao;
import com.gt.dto.InformacionVehiculo;
import com.gt.dto.Response_Cost_Viaje;
import com.gt.dto.Response_Info_Vehiculos;
import com.gt.dto.Response_transaction;
import com.gt.entity.Pais;
import com.gt.entity.Transferencia;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@RequestScoped
public class envioSvcImpl implements envioSvc {

    @Inject
    enviosDao enviosdao;

    @Override
    public Response_Info_Vehiculos findAllVehiculo() {
        Response_Info_Vehiculos retorno;
        List<InformacionVehiculo> datos = enviosdao.findAllVehiculo();
        if (datos != null) {
            retorno = new Response_Info_Vehiculos();
            retorno.setVehiculos(datos);
            retorno.setStatus(0);
            retorno.setDescripcion("Exitoso");
        } else {
            retorno = new Response_Info_Vehiculos();
            retorno.setStatus(1);
            retorno.setDescripcion("Error con la conexión a la BD de Envios");
        }

        return retorno;
    }

    @Override
    public Response_Cost_Viaje calcular_Costo_Viaje(int id_Vehiculo, String pais_Destino) {
        Response_Cost_Viaje retorno;
        Pais p = enviosdao.findOriginPai(id_Vehiculo);
        if (p != null) {
            switch (p.getCodigo()) { //pais origen
                case "US": {
                    int constante = 5355;
                    switch (pais_Destino) {
                        case "GT": {
                            int numero = (int) (Math.random() * 3825) + 1;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }
                        case "SV": {
                            int numero = (int) (Math.random() * 3900) + 3825;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }
                        case "HN": {
                            int numero = (int) (Math.random() * 3900) + 3825;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }
                        case "NI": {
                            int numero = (int) (Math.random() * 4000) + 3900;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }
                        case "MX": {
                            int numero = (int) (Math.random() * 3825) + 3200;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }

                        default: {
                            //double numero = (double) (Math.random() * 3200) + 1;
                            //double precio = constante+numero;
                            retorno = new Response_Cost_Viaje();
                            //retorno.setCosto_viaje(precio);
                            retorno.setStatus(1);
                            retorno.setDescripcion("Promedio de precio no definido");
                            break;
                        }

                    }
                    break;
                }
                case "CA": {
                    int constante = 6120;
                    switch (pais_Destino) {
                        case "GT": {
                            int numero = (int) (Math.random() * 3825) + 1;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }
                        case "SV": {
                            int numero = (int) (Math.random() * 3900) + 3825;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }
                        case "HN": {
                            int numero = (int) (Math.random() * 3900) + 3825;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }
                        case "NI": {
                            int numero = (int) (Math.random() * 4000) + 3900;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }
                        case "MX": {
                            int numero = (int) (Math.random() * 3825) + 3200;
                            int precio = constante + numero;
                            retorno = new Response_Cost_Viaje();
                            retorno.setCosto_viaje(precio);
                            retorno.setStatus(0);
                            retorno.setDescripcion("Exitoso");
                            break;
                        }

                        default: {
                            retorno = new Response_Cost_Viaje();
                            //retorno.setCosto_viaje(precio);
                            retorno.setStatus(1);
                            retorno.setDescripcion("Promedio de precio no definido");
                            break;

                        }
                    }
                    break;
                }
                default: {
                    retorno = new Response_Cost_Viaje();
                    //retorno.setCosto_viaje(precio);
                    retorno.setStatus(1);
                    retorno.setDescripcion("Promedio de precio no definido");
                    break;
                }
            }

        } else {
            retorno = new Response_Cost_Viaje();
            retorno.setStatus(1);
            retorno.setDescripcion("Error con la conexión a la BD de Envios");
        }
        return retorno;
    }

    @Override
    public Response_transaction create(int id_Transferencia, double monto) {

        Transferencia tem = enviosdao.findByIdTransferencia(id_Transferencia);
        Response_transaction retorno;
        if (tem == null) {
            Transferencia newt = new Transferencia();
            newt.setIdTransferencia(id_Transferencia);
            newt.setMonto(monto);
            Transferencia resp = enviosdao.create(newt);
            if (resp != null) {
                retorno = new Response_transaction();
                retorno.setDescripcion("Exitoso");
                retorno.setStatus(0);
            } else {
                retorno = new Response_transaction();
                retorno.setDescripcion("Error al almacenar en la base de datos");
                retorno.setStatus(0);
                
            }

        } else {
            retorno = new Response_transaction();
            retorno.setDescripcion("Ya existe la transfericia");
            retorno.setStatus(1);
        }
        return retorno;
    }

}
