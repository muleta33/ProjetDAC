/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.RequestManagedBeans;

import com.ensimag.projetDAC.entity.DeliveryMethod;
import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.DeliveryMethodFacadeLocal;
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
    
    @EJB
    private PurchaseFacadeLocal purchaseFacade;
    
    private List<DeliveryMethod> deliveryMethods = null;
    
    @EJB
    private UserFacadeLocal userFacade;
    
    private List<User> clients = null;
    
    @EJB
    private PurchaseFacadeLocal orderFacade;
    
    private List<Purchase> orders = null;
    
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
    
    
    
    public List<Purchase> getOrders() {
        if (orders == null)
            orders = orderFacade.findAll();
        return orders;
    }
    
    
    public List<User> getClients() {
        if (clients == null)
            clients = userFacade.findAll();
        return clients;
    }
}
