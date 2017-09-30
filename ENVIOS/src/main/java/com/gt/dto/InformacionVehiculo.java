/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@Entity
public class InformacionVehiculo implements Serializable{
    
    @Id
    @Column(name = "id_Vehiculo")
    private int id_Vehiculo;
    @Column(name = "marca")
    private String marca;
    @Column(name ="linea")
    private String linea;
    @Column(name = "modelo")
    private int modelo;
    @Column(name = "pais_Origen")
    private String pais_Origen;
    @Column(name = "precio_Vehiculo")
    private double precio_Vehiculo;

    public int getId_Vehiculo() {
        return id_Vehiculo;
    }

    public void setId_Vehiculo(int id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getPais_Origen() {
        return pais_Origen;
    }

    public void setPais_Origen(String pais_Origen) {
        this.pais_Origen = pais_Origen;
    }

    public double getPrecio_Vehiculo() {
        return precio_Vehiculo;
    }

    public void setPrecio_Vehiculo(double precio_Vehiculo) {
        this.precio_Vehiculo = precio_Vehiculo;
    }
    

}
