/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.dao;

import com.gt.dto.InformacionVehiculo;
import com.gt.entity.Pais;
import java.util.List;

/**
 *
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
public interface enviosDao {
    
    public List<InformacionVehiculo> findAllVehiculo();
    public Pais findOriginPai(int id_Vehiculo);
    
}
