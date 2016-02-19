/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author muleta
 */
@Entity
public class Bottle implements Serializable {
    private static final long serialVersionUID = 1L;

    public Bottle() {
    }

    public Bottle(BottleType type, float capacity, SprayerType sprayer, Inscription inscription) {
        this.type = type;
        this.capacity = capacity;
        this.sprayer = sprayer;
        this.inscription = inscription;
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
    
    
    @ManyToOne
    private BottleType type;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public BottleType getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(BottleType type) {
        this.type = type;
    }

    
    private float capacity;

    /**
     * Get the value of capacity
     *
     * @return the value of capacity
     */
    public float getCapacity() {
        return capacity;
    }

    /**
     * Set the value of capacity
     *
     * @param capacity new value of capacity
     */
    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    
    @ManyToOne
    private SprayerType sprayer;

    /**
     * Get the value of sprayer
     *
     * @return the value of sprayer
     */
    public SprayerType getSprayer() {
        return sprayer;
    }

    /**
     * Set the value of sprayer
     *
     * @param sprayer new value of sprayer
     */
    public void setSprayer(SprayerType sprayer) {
        this.sprayer = sprayer;
    }
    
    
    @ManyToOne
    private Inscription inscription;

    /**
     * Get the value of inscription
     *
     * @return the value of inscription
     */
    public Inscription getInscription() {
        return inscription;
    }

    /**
     * Set the value of inscription
     *
     * @param inscription new value of inscription
     */
    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
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
        if (!(object instanceof Bottle)) {
            return false;
        }
        Bottle other = (Bottle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensimag.projetDAC.entity.Bottle[ id=" + id + " ]";
    }
    
}
