/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.Purchase;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

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
    
    private DateFormat dateFormat;

    /**
     * Get the value of dateFormat
     *
     * @return the value of dateFormat
     */
    public DateFormat getDateFormat() {
        return dateFormat;
    }

    /**
     * Set the value of dateFormat
     *
     * @param dateFormat new value of dateFormat
     */
    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    /**
     * Creates a new instance of UserAccountBean
     */
    public UserAccountBean() {
    }
    
    @PostConstruct
    public void init() {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    public int numberOfPerfumes(Purchase purchase) {
        int totalNumberOfPerfumes = 0;
        for (Map.Entry<Perfume, Integer> entry : purchase.getPerfumes().entrySet()) {
            totalNumberOfPerfumes += entry.getValue();
	}
        return totalNumberOfPerfumes;
    }
    
}
