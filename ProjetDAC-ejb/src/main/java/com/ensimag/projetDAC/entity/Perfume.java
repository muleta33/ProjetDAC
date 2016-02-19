/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author muleta
 */
@Entity
public class Perfume implements Serializable {
    private static final long serialVersionUID = 1L;

    public Perfume() {
        this.Name = "DefaultName";
    }

    public Perfume(String Name, List<Fragance> fragances, int intensity, Bottle bottle, boolean isGift) {
        this.Name = Name;
        this.fragances = fragances;
        this.intensity = intensity;
        this.bottle = bottle;
        this.isGift = isGift;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    private String Name;

    /**
     * Get the value of Name
     *
     * @return the value of Name
     */
    public String getName() {
        return Name;
    }

    /**
     * Set the value of Name
     *
     * @param Name new value of Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }
    
    
    @ManyToMany
    private List<Fragance> fragances;

    /**
     * Get the value of fragances
     *
     * @return the value of fragances
     */
    public List<Fragance> getFragances() {
        return fragances;
    }

    /**
     * Set the value of fragances
     *
     * @param fragances new value of fragances
     */
    public void setFragances(List<Fragance> fragances) {
        this.fragances = fragances;
    }

    
    private int intensity;

    /**
     * Get the value of intensity
     *
     * @return the value of intensity
     */
    public int getIntensity() {
        return intensity;
    }

    /**
     * Set the value of intensity
     *
     * @param intensity new value of intensity
     */
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
    
    
    @ManyToOne
    private Bottle bottle;

    /**
     * Get the value of bottle
     *
     * @return the value of bottle
     */
    public Bottle getBottle() {
        return bottle;
    }

    /**
     * Set the value of bottle
     *
     * @param bottle new value of bottle
     */
    public void setBottle(Bottle bottle) {
        this.bottle = bottle;
    }
    
    
    private boolean isGift;

    /**
     * Get the value of isGift
     *
     * @return the value of isGift
     */
    public boolean getIsGift() {
        return isGift;
    }

    /**
     * Set the value of isGift
     *
     * @param isGift new value of isGift
     */
    public void setIsGift(boolean isGift) {
        this.isGift = isGift;
    }

    public double getPrice() {
        return bottle.getCapacity().getPrice();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfume)) {
            return false;
        }
        Perfume other = (Perfume) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensimag.projetDac.entity.Parfum[ id=" + id + " ]";
    }
    
}
