/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@Entity
@Table(name = "locacion_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocacionVehiculo.findAll", query = "SELECT l FROM LocacionVehiculo l"),
    @NamedQuery(name = "LocacionVehiculo.findByDbid", query = "SELECT l FROM LocacionVehiculo l WHERE l.dbid = :dbid")})
public class LocacionVehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid")
    private Integer dbid;
    @JoinColumn(name = "pais", referencedColumnName = "dbid")
    @ManyToOne(optional = false)
    private Pais pais;
    @JoinColumn(name = "marca", referencedColumnName = "dbid")
    @ManyToOne(optional = false)
    private Marca marca;

    public LocacionVehiculo() {
    }

    public LocacionVehiculo(Integer dbid) {
        this.dbid = dbid;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
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
        if (!(object instanceof LocacionVehiculo)) {
            return false;
        }
        LocacionVehiculo other = (LocacionVehiculo) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gt.entity.LocacionVehiculo[ dbid=" + dbid + " ]";
    }

}
