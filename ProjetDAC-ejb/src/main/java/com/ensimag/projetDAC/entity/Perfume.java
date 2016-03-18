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
        this.name = "DefaultName";
    }

    public Perfume(String Name, List<Fragrance> fragrances, int intensity, 
            Bottle bottle, boolean isGift, boolean belongToSelection) {
        this.name = Name;
        this.fragrances = fragrances;
        this.intensity = intensity;
        this.bottle = bottle;
        this.isGift = isGift;
        this.belongToSelection = belongToSelection;
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

    
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    @ManyToMany
    private List<Fragrance> fragrances;

    /**
     * Get the value of fragances
     *
     * @return the value of fragances
     */
    public List<Fragrance> getFragrances() {
        return fragrances;
    }

    /**
     * Set the value of fragances
     *
     * @param fragrances new value of fragrances
     */
    public void setFragrances(List<Fragrance> fragrances) {
        this.fragrances = fragrances;
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
    
    
    private boolean belongToSelection;

    /**
     * Get the value of belongToSelection
     *
     * @return the value of belongToSelection
     */
    public boolean getBelongToSelection() {
        return belongToSelection;
    }

    /**
     * Set the value of belongToSelection
     *
     * @param belongToSelection new value of belongToSelection
     */
    public void setBelongToSelection(boolean belongToSelection) {
        this.belongToSelection = belongToSelection;
    }


    public double getPrice() {
        double price = 0;
        if (bottle != null && bottle.getCapacity() != null)
            price += bottle.getCapacity().getPrice();
        if (isGift)
            price += 20;
        return price;
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
