/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.Perfume;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ensimag
 */
@Named(value = "shoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {
    
    private Map<Perfume, Integer> content = null;

    private int temporaryQuantityOfPerfume;

    /**
     * Get the value of temporaryQuantityOfPerfume
     *
     * @return the value of temporaryQuantityOfPerfume
     */
    public int getTemporaryQuantityOfPerfume() {
        return temporaryQuantityOfPerfume;
    }

    /**
     * Set the value of temporaryQuantityOfPerfume
     *
     * @param temporaryQuantityOfPerfume new value of temporaryQuantityOfPerfume
     */
    public void setTemporaryQuantityOfPerfume(int temporaryQuantityOfPerfume) {
        this.temporaryQuantityOfPerfume = temporaryQuantityOfPerfume;
    }

    
    /**
     * Creates a new instance of ShoppingCartBean
     */
    public ShoppingCartBean() {
    }
    
    @PostConstruct
    public void init() {
        content = new HashMap<>();
        temporaryQuantityOfPerfume = 1;
    }
    
    public Map<Perfume, Integer> getContent() {
        return content;
    }
    
    public void setNumberOfPerfumes(Perfume perfume) {
        content.replace(perfume, temporaryQuantityOfPerfume);
    }
    
    public String addPerfume(Perfume perfume) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("message", new FacesMessage("Info", "Le parfum a bien été ajouté au panier."));
        context.getExternalContext().getFlash().setKeepMessages(true);
        content.put(perfume, 1);
        return "shoppingZone.xhtml?faces-redirect=true";
    }
        
    public double getPriceOfPerfume(Perfume perfume) {
        return content.get(perfume) * perfume.getPrice();
    }
    
    public void removePerfume(Perfume perfume) {
        content.remove(perfume);
    }
    
    public boolean containsPerfume(Perfume perfume) {
        return content.containsKey(perfume);
    }
    
    public boolean isEmpty() {
        return content.isEmpty();
    }
    
}
