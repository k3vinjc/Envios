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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@Entity
@Table(name = "marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"),
    @NamedQuery(name = "Marca.findByDbid", query = "SELECT m FROM Marca m WHERE m.dbid = :dbid"),
    @NamedQuery(name = "Marca.findByNombre", query = "SELECT m FROM Marca m WHERE m.nombre = :nombre")})
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbid")
    private Integer dbid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marca")
    private List<MarcaModelo> marcaModeloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marca")
    private List<Linea> lineaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marca")
    private List<LocacionVehiculo> locacionVehiculoList;

    public Marca() {
    }

    public Marca(Integer dbid) {
        this.dbid = dbid;
    }

    public Marca(Integer dbid, String nombre) {
        this.dbid = dbid;
        this.nombre = nombre;
    }

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<MarcaModelo> getMarcaModeloList() {
        return marcaModeloList;
    }

    public void setMarcaModeloList(List<MarcaModelo> marcaModeloList) {
        this.marcaModeloList = marcaModeloList;
    }

    @XmlTransient
    public List<Linea> getLineaList() {
        return lineaList;
    }

    public void setLineaList(List<Linea> lineaList) {
        this.lineaList = lineaList;
    }

    @XmlTransient
    public List<LocacionVehiculo> getLocacionVehiculoList() {
        return locacionVehiculoList;
    }

    public void setLocacionVehiculoList(List<LocacionVehiculo> locacionVehiculoList) {
        this.locacionVehiculoList = locacionVehiculoList;
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
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gt.entity.Marca[ dbid=" + dbid + " ]";
    }

}
