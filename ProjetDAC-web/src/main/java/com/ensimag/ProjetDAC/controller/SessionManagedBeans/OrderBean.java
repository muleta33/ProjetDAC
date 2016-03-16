/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author margotj
 */
@Named(value = "orderBean")
@SessionScoped
public class OrderBean implements Serializable {

    /**
     * Creates a new instance of OrderBean
     */
    public OrderBean() {
    }
    
    public String savePerfume() {
        
        
        return "/secure/shoppingCart?logout=false&faces-redirect=true";
    }
}
