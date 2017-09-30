/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */

public class Response_Info_Vehiculos implements Serializable{
    private List<InformacionVehiculo> vehiculos;
    private int status;
    private String descripcion;

    public List<InformacionVehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<InformacionVehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
