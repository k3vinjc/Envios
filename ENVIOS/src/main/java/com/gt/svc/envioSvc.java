/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.svc;

import com.gt.dto.Response_Cost_Viaje;
import com.gt.dto.Response_Info_Vehiculos;
import com.gt.dto.Response_transaction;

/**
 *
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
public interface envioSvc {
    public  Response_Info_Vehiculos findAllVehiculo();
    public Response_Cost_Viaje calcular_Costo_Viaje(int id_Vehiculo,String pais_Destino);
    public Response_transaction create(int id_Transferencia,double monto);
    
}
