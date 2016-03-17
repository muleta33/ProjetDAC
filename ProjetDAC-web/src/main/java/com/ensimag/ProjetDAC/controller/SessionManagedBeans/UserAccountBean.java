/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.Purchase;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author margotj
 */
@Named(value = "userAccountBean")
@SessionScoped
public class UserAccountBean implements Serializable {

    private Purchase selectedPurchase;

    /**
     * Get the value of selectedPurchase
     *
     * @return the value of selectedPurchase
     */
    public Purchase getSelectedPurchase() {
        return selectedPurchase;
    }

    /**
     * Set the value of selectedPurchase
     *
     * @param selectedPurchase new value of selectedPurchase
     */
    public void setSelectedPurchase(Purchase selectedPurchase) {
        this.selectedPurchase = selectedPurchase;
    }
    
    /**
     * Creates a new instance of UserAccountBean
     */
    public UserAccountBean() {
    }
    
}
