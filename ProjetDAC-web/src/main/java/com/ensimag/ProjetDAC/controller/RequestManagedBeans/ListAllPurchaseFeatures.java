/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.RequestManagedBeans;

import com.ensimag.ProjetDAC.controller.SessionManagedBeans.AuthenticationBean;
import com.ensimag.projetDAC.entity.DeliveryMethod;
import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.DeliveryMethodFacadeLocal;
import com.ensimag.projetDAC.stateless.PurchaseFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author muleta
 */
@Named(value = "listAllPurchaseFeatures")
@RequestScoped
public class ListAllPurchaseFeatures {

    @EJB
    private DeliveryMethodFacadeLocal deliveryMethodFacade;
    
    @EJB
    private PurchaseFacadeLocal purchaseFacade;
    
    private List<DeliveryMethod> deliveryMethods = null;
    
    /**
     * Creates a new instance of ListAllOrderFeatures
     */
    public ListAllPurchaseFeatures() {
    }
    
    public List<DeliveryMethod> getDeliveryMethods() {
        if (deliveryMethods == null)
            deliveryMethods = deliveryMethodFacade.findAll();
        return deliveryMethods;
    }
    
    public List<Purchase> getCurrentUserPurchases(User user) {
        return purchaseFacade.findByUser(user);
    }
}
