/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.envios;

/**
 *
 * @author christianescobar
 */
public class Vehiculo {
    private int id;
    private MySqlHanddler MSH;
     String marca;
    String linea;
     int modelo;
     String pais_Origen;
     double precio_Vehiculo;
    public Vehiculo(int id){
        this.id=id;
        MSH=new MySqlHanddler();
    }
    
    public Vehiculo(int id, String marca, String linea, int modelo, String pais_Origen, double precio_Vehiculo){
        MSH=new MySqlHanddler();
        this.id=id;
        this.marca=marca;
        this.linea=linea;
        this.modelo=modelo;
        this.pais_Origen=pais_Origen;
        this.precio_Vehiculo=precio_Vehiculo;
    }
    
    public int getid(){
        return id;
    }
    
    public int Coneccion(){
        return MSH.Conectar();
    }
    
    public int Existeid(){
        int retorno=0;
        retorno=MSH.Existeid(this);
        return retorno;
    }
    
    public double Costo_Basico(){
        double retorno=0.0;
        retorno=MSH.Costo_Base(this);
        return retorno;
    }
    
    public double peso(){
        double retorno=0.0;
        retorno=MSH.Peso(this);
        return retorno;
    }
    
    public double Costo_Viaje(String Pais){
        double retorno=0.0;
        return retorno;
    }
}
