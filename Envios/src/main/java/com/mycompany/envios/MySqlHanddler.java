/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.envios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    
    public int ExistePais(String nombre){
        int retorno=0;
        try{
            Coneccion=DriverManager.getConnection(CadenaConeccion,"Usuario","1234");
            Statement stmt=Coneccion.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from pais where nombre='"+nombre+"'");
            while(rs.next())
                retorno=1;
            Coneccion.close();  
        }catch(Exception e){
            retorno=0; //error
        }
        return retorno;
    }
    
    public int Existeid(Vehiculo vehiculo){
        int retorno=0;
        try{
            Coneccion=DriverManager.getConnection(CadenaConeccion,"Usuario","1234");
            Statement stmt=Coneccion.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from vehiculo_Existente where dbid="+vehiculo.getid());
            while(rs.next())
                retorno=1;
            Coneccion.close();  
        }catch(Exception e){
            retorno=0; //error
        }
        return retorno;
    }
    public double Costo_Base(Vehiculo vehiculo){
        double retorno=0.0;
        try{
            Coneccion=DriverManager.getConnection(CadenaConeccion,"Usuario","1234");
            Statement stmt=Coneccion.createStatement();  
            ResultSet rs=stmt.executeQuery("select precio_Base from vehiculo_Existente where dbid="+vehiculo.getid());
            while(rs.next())
                retorno=rs.getDouble(1);
            Coneccion.close();  
        }catch(Exception e){
            retorno=0.0; //error
        }
        return retorno;
    }
    public double Peso(Vehiculo vehiculo){
        double retorno=0.0;
        try{
            Coneccion=DriverManager.getConnection(CadenaConeccion,"Usuario","1234");
            Statement stmt=Coneccion.createStatement();  
            ResultSet rs=stmt.executeQuery("select peso from vehiculo_Existente inner join vehiculo on vehiculo_Existente.vehiculo=vehiculo.dbid where vehiculo_Existente.dbid="+vehiculo.getid());
            while(rs.next())
                retorno=rs.getDouble(1);
            Coneccion.close();  
        }catch(Exception e){
            retorno=0.0; //error
        }
        return retorno;
    }
    public double FactorPais(String nombre){
        double retorno=10.0;
        try{
            Coneccion=DriverManager.getConnection(CadenaConeccion,"Usuario","1234");
            Statement stmt=Coneccion.createStatement();  
            ResultSet rs=stmt.executeQuery("select factor from factor_Envio inner join pais as Origen on factor_Envio.pais_Origen=Origen.dbid inner join pais as Destino on factor_Envio.pais_Destino=Destino.dbid where Origen.nombre='"+nombre+"' and Destino.nombre='Guatemala'");
            while(rs.next())
                retorno=rs.getDouble(1);
            Coneccion.close();  
        }catch(Exception e){
            retorno=0.0; //error
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
    public List<Vehiculo> CargarVehiculo(){
        List<Vehiculo> retorno=new ArrayList<Vehiculo>();
        try{
            Coneccion=DriverManager.getConnection(CadenaConeccion,"Usuario","1234");
            Statement stmt=Coneccion.createStatement();  
            ResultSet rs=stmt.executeQuery("select vehiculo_Existente.dbid,marca.nombre, linea.nombre, anio, pais.nombre, precio_Base from vehiculo_Existente inner join vehiculo on vehiculo_Existente.vehiculo=vehiculo.dbid inner join linea on vehiculo.linea=linea.dbid inner join marca on marca.dbid=linea.marca inner join pais on vehiculo_Existente.pais=pais.dbid");
            Vehiculo vehiculo=null;
            while(rs.next()){
                vehiculo=new Vehiculo(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6));
                retorno.add(vehiculo);
            }
                //retorno=rs.getDouble(1);
            Coneccion.close();  
        }catch(Exception e){
        }
        return retorno;
    }
    public Vehiculo CargarVehiculoId(int id){
        Vehiculo retorno=null;
        try{
            Coneccion=DriverManager.getConnection(CadenaConeccion,"Usuario","1234");
            Statement stmt=Coneccion.createStatement();  
            ResultSet rs=stmt.executeQuery("select vehiculo_Existente.dbid,marca.nombre, linea.nombre, anio, pais.nombre, precio_Base from vehiculo_Existente inner join vehiculo on vehiculo_Existente.vehiculo=vehiculo.dbid inner join linea on vehiculo.linea=linea.dbid inner join marca on marca.dbid=linea.marca inner join pais on vehiculo_Existente.pais=pais.dbid where vehiculo_Existente.dbid="+id);
            while(rs.next()){
                retorno=new Vehiculo(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6));
            }
            Coneccion.close();  
        }catch(Exception e){
        }
        return retorno;
    }
}
