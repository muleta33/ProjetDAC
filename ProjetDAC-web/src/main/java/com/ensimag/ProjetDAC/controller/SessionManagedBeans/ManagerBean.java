/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.DeliveryStatus;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.stateless.PurchaseFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author souihlic
 */
@Named(value = "managerBean")
@RequestScoped
public class ManagerBean {

    @EJB
    private PerfumeFacadeLocal perfumeFacade;
    
    @EJB
    private PurchaseFacadeLocal purchaseFacadeLocal;
    


    /**
     * Creates a new instance of ManagerBean
     */
    public ManagerBean() {
        
    }
    
    public void removePerfume(Perfume perfume) {
        perfumeFacade.remove(perfume);
    }
    public boolean containsPerfume(Perfume perfume) {
        return false;
    }
    
    public void setStatus(Purchase purchase) {
        if (purchase.getDeliveryStatus().getName().equals("en attente")) {
            purchase.setDeliveryStatus(new DeliveryStatus("en cours de préparation"));
        } else if (purchase.getDeliveryStatus().getName().equals("en cours de préparation")) {
            purchase.setDeliveryStatus(new DeliveryStatus("expédiée"));
        } else if (purchase.getDeliveryStatus().getName().equals("expédiée")) {
            purchase.setDeliveryStatus(new DeliveryStatus("reçue"));
        }
        purchaseFacadeLocal.edit(purchase);
    }
}
