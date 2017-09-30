/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.dto;

import java.io.Serializable;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
public class Response_transaction implements Serializable{
    private int status;
    private String descripcion;

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
