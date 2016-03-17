/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author souihlic
 */
@Entity
public class Purchase implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
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
    private User client;
    
    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
    
    @ManyToMany
    @ElementCollection
    private Map<Perfume, Integer> perfumes;
    
    public Map<Perfume, Integer> getPerfumes() {
        return perfumes;
    }

    @ManyToOne
    private DeliveryMethod deliveryMethod;
    
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }
    
    public void setDeliveryMethod(DeliveryMethod method) {
        this.deliveryMethod = method;
    }
    
    private String deliveryAddress;

    /**
     * Get the value of deliveryAddress
     *
     * @return the value of deliveryAddress
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    
    /**
     * Set the value of deliveryAddress
     *
     * @param deliveryAddress new value of deliveryAddress
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    private double price;

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne
    private DeliveryStatus deliveryStatus;
    
    public DeliveryStatus getStatus() {
        return deliveryStatus;
    }
    
    public void setStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Purchase() {
        this.perfumes = new HashMap<>();
    }
    
    public Purchase(User client, Map<Perfume, Integer> perfumes, DeliveryMethod deliveryMethod, String deliveryAddress, DeliveryStatus deliveryStatus, double price) {
        this.client = client;
        this.perfumes = perfumes;
        this.deliveryMethod = deliveryMethod;
        this.deliveryAddress = deliveryAddress;
        this.deliveryStatus = deliveryStatus;
        this.price = price;
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
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensimag.projetDAC.entity.Order[ id=" + id + " ]";
    }
    
}
