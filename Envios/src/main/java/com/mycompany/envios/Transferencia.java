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
public class Transferencia {
    private String NombreBanco="Banco";
    private int NumeroTransferencia;
    private double Monto;
    MySqlHanddler MSH;
    
    public Transferencia(int NumeroTransferencia, double Monto){
        this.NumeroTransferencia=NumeroTransferencia;
        this.Monto=Monto;
        MSH=new MySqlHanddler();
    }
    public String getNombreBanco(){
        return this.NombreBanco;
    }
    public int getNumeroTransferencia(){
        return this.NumeroTransferencia;
    }
    public double getMonto(){
        return this.Monto;
    }
    public int Coneccion(){
        return MSH.Conectar();
    }
    public int IngresarTransferencia(){
        int retorno=0;
        retorno=MSH.IngresarTransferencia(this);
        return retorno;
    }
}
