/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.envios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author christianescobar
 */
public class MySqlHanddler {
    private Connection Coneccion;
    private String CadenaConeccion;
    
    public MySqlHanddler()
    {
          
    }
    public int Conectar(){
        int retorno=0;// Todo Correcto
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            CadenaConeccion="jdbc:mysql://www.envios.com:3306/envios";
            Coneccion=DriverManager.getConnection(CadenaConeccion,"Usuario","1234");
            retorno=1;
        }catch(Exception e){
            retorno=0; //error
        }
        return retorno;
    }
    public int IngresarTransferencia(Transferencia transferencia){
        int retorno=0;
        try{
            Coneccion=DriverManager.getConnection(CadenaConeccion,"Usuario","1234");
            Statement stmt=Coneccion.createStatement();  
            stmt.executeUpdate("insert into Transferencia(numeroTransferencia,monto,idBanco) values("+transferencia.getNumeroTransferencia()+", "+transferencia.getMonto()+", (select id from Banco where nombre='"+transferencia.getNombreBanco()+"'));");
            //stmt.executeQuery("insert into Transferencia(numeroTransferencia,monto,idBanco) values("+transferencia.getNumeroTransferencia()+", "+transferencia.getMonto()+", (select id from Banco where nombre='"+transferencia.getNombreBanco()+"'));");             
            Coneccion.close();  
            retorno=1;
        }catch(Exception e){
            retorno=0; //error
        }
        return retorno;
    }
}
