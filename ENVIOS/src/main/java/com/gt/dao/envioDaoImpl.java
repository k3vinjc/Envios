/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.dao;

import com.gt.entity.ModeloVehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@Stateless
public class envioDaoImpl implements enviosDao{
    
    @PersistenceContext(unitName = "com.gt_enviios_ws")
    private EntityManager em;
    
    @Override
    public List<ModeloVehiculo> findAllModel() {
        TypedQuery<ModeloVehiculo> runsql = em.createNamedQuery("ModeloVehiculo.findAll", ModeloVehiculo.class);
        return runsql.getResultList();
    }

    
}
