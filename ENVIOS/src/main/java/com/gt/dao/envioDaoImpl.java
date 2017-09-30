/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.dao;

import com.gt.dto.InformacionVehiculo;
import com.gt.entity.Pais;
import com.gt.entity.Transferencia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@Stateless
public class envioDaoImpl implements enviosDao {

    @PersistenceContext(unitName = "com.gt_envios_ws")
    private EntityManager em;

    @Override
    public List<InformacionVehiculo> findAllVehiculo() {
        StringBuilder sql = new StringBuilder("select v.dbid 'id_Vehiculo',m.nombre 'marca',l.nombre 'linea',v.anio 'modelo',p.nombre 'pais_Origen',l.precio 'precio_Vehiculo' \n");
        sql.append("from locacion_vehiculo lv, pais p, vehiculo v, linea l, marca m \n");
        sql.append("where p.dbid=lv.pais \n");
        sql.append("and lv.vehiculo = v.dbid \n");
        sql.append("and v.linea = l.dbid \n");
        sql.append("and l.marca = m.dbid");
        Query runsql = em.createNativeQuery(sql.toString(), InformacionVehiculo.class);
        return runsql.getResultList();
    }

    @Override
    public Pais findOriginPai(int id_Vehiculo) {
        System.out.println("param-->"+id_Vehiculo);
        try {
            StringBuilder sql = new StringBuilder("select p.* from locacion_vehiculo lv, pais p \n");
            sql.append("where lv.pais = p.dbid \n");
            sql.append("and lv.vehiculo = #idvehi");
            Query runsql = em.createNativeQuery(sql.toString(),Pais.class);
            runsql.setParameter("idvehi", id_Vehiculo);
            return (Pais) runsql.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }

    }

    @Override
    public Transferencia findByIdTransferencia(int id_Transferencia) {
        try{
            StringBuilder sql = new StringBuilder("select * from transferencia t \n");
            sql.append("where exists(select * from transferencia t where t.id_Transferencia= #idtransfer) \n");
            Query runsql = em.createNativeQuery(sql.toString(),Transferencia.class);
            runsql.setParameter("idtransfer", id_Transferencia);
            return (Transferencia) runsql.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public Transferencia create(Transferencia newt) {
        
        em.persist(newt);
        em.flush();
        return newt;
        
    }

    

}
