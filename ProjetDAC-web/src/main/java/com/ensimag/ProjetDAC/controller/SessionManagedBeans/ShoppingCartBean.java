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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author ensimag
 */
@Named(value = "shoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {
    
    private List<Perfume> content = null;

    /**
     * Creates a new instance of ShoppingCartBean
     */
    public ShoppingCartBean() {
    }
    
    @PostConstruct
    public void init() {
        content = new ArrayList<>();
    }
    
    public List<Perfume> getContent() {
        return content;
    }
    
    public void addPerfume(Perfume perfume) {
        content.add(perfume);
    }
    
    public void removePerfume(Perfume perfume) {
        content.remove(perfume);
    }
    
    public boolean containsPerfume(Perfume perfume) {
        return content.contains(perfume);
    }
    
    public boolean isEmpty() {
        return content.isEmpty();
    }
    
}
