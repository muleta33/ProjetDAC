/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author souihlic
 */
@Entity
public class Basket implements Serializable {
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
    
    private Map<Perfume,Integer> perfumes;
    
    public Map<Perfume,Integer> getPerfumes() {
        return perfumes;
    }

    public void setPerfumes(Map<Perfume,Integer> perfumes) {
        this.perfumes = perfumes;
    }
    
    private double price;

    public void computePrice() {
        price = 0.0;
        Set cles = perfumes.keySet();
        Iterator it = cles.iterator();
        while (it.hasNext()){
            Perfume cle = (Perfume) it.next();
            price += perfumes.get(cle) * cle.getPrice();
        }
    }
    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public double getPrice() {
        
        return price;
    }

    public Basket() {
        perfumes = new HashMap<Perfume, Integer>();
    }
    
    public void addPerfume(Perfume perfume, Integer quantity) {
        perfumes.put(perfume, quantity);
    }
    
    public void addPerfume(Perfume perfume) {
        if (perfumes.containsKey(perfume)) {
            perfumes.put(perfume, perfumes.get(perfume) + 1);
        } else {
            perfumes.put(perfume, 1);
        }
    }

    public void clear() {
        perfumes.clear();
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
        if (!(object instanceof Basket)) {
            return false;
        }
        Basket other = (Basket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensimag.projetDAC.entity.Basket[ id=" + id + " ]";
    }
    
}
