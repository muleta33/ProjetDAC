/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author souihlic
 */
@Entity
public class Order implements Serializable {
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
    private Map<Perfume, Integer> perfumes;
    
    public Map<Perfume, Integer> getPerfumes() {
        return perfumes;
    }

    @OneToMany
    private DeliveryMethod deliveryMethod;
    
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }
    
    public void setDeliveryMethod(DeliveryMethod method) {
        this.deliveryMethod = method;
    }
    
    private String deliveryAdress;

    /**
     * Get the value of deliveryAdress
     *
     * @return the value of deliveryAdress
     */
    public String getDeliveryAdress() {
        return deliveryAdress;
    }
    
    /**
     * Set the value of deliveryAdress
     *
     * @param deliveryAdress new value of deliveryAdress
     */
    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
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

    @OneToMany
    DeliveryStatus status;
    
    public DeliveryStatus getStatus() {
        return status;
    }
    
    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public Order() {
        this.perfumes = new HashMap<>();
    }

    
    public Order(User client, Map<Perfume, Integer> perfumes, DeliveryMethod deliveryMethod, String deliveryAdress, double price, DeliveryStatus status) {
        this.client = client;
        this.deliveryMethod = deliveryMethod;
        this.deliveryAdress = deliveryAdress;
        this.status = status;
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
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
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
