/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@Entity
@Table(name = "modelo_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeloVehiculo.findAll", query = "SELECT m FROM ModeloVehiculo m"),
    @NamedQuery(name = "ModeloVehiculo.findByDbid", query = "SELECT m FROM ModeloVehiculo m WHERE m.dbid = :dbid"),
    @NamedQuery(name = "ModeloVehiculo.findByAnio", query = "SELECT m FROM ModeloVehiculo m WHERE m.anio = :anio")})
public class ModeloVehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid")
    private Integer dbid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private int anio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelo")
    private List<Vehiculo> vehiculoList;

    public ModeloVehiculo() {
    }

    public ModeloVehiculo(Integer dbid) {
        this.dbid = dbid;
    }

    public ModeloVehiculo(Integer dbid, int anio) {
        this.dbid = dbid;
        this.anio = anio;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbid != null ? dbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloVehiculo)) {
            return false;
        }
        ModeloVehiculo other = (ModeloVehiculo) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gt.entity.ModeloVehiculo[ dbid=" + dbid + " ]";
    }

}
