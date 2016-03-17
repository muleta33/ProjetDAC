/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.RequestManagedBeans;

import com.ensimag.projetDAC.entity.DeliveryMethod;
import com.ensimag.projetDAC.stateless.DeliveryMethodFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author muleta
 */
@Named(value = "listAllOrderFeatures")
@RequestScoped
public class ListAllOrderFeatures {

    @EJB
    private DeliveryMethodFacadeLocal deliveryMethodFacade;
    
    private List<DeliveryMethod> deliveryMethods = null;
    
    /**
     * Creates a new instance of ListAllOrderFeatures
     */
    public ListAllOrderFeatures() {
    }
    
    public List<DeliveryMethod> getDeliveryMethods() {
        if (deliveryMethods == null)
            deliveryMethods = deliveryMethodFacade.findAll();
        return deliveryMethods;
    }
}
