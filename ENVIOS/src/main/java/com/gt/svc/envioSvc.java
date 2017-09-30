/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.svc;

import com.gt.dto.Response_Info_Vehiculos;
import java.util.List;

/**
 *
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
public interface envioSvc {
    public  Response_Info_Vehiculos findAllVehiculo();
    
}
