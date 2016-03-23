/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.RequestManagedBeans;

import com.ensimag.projetDAC.entity.DeliveryMethod;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.DeliveryMethodFacadeLocal;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.stateless.PurchaseFacadeLocal;
import com.ensimag.projetDAC.stateless.UserFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author muleta
 */
@Named(value = "listAllPurchaseFeatures")
@RequestScoped
public class ListAllPurchaseFeatures {

    @EJB
    private DeliveryMethodFacadeLocal deliveryMethodFacade;
    private List<DeliveryMethod> deliveryMethods = null;
    @EJB
    private PurchaseFacadeLocal purchaseFacade;
    
    
    
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
