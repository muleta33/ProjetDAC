/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.DeliveryMethod;
import com.ensimag.projetDAC.entity.DeliveryStatus;
import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.DeliveryMethodFacadeLocal;
import com.ensimag.projetDAC.stateless.DeliveryStatusFacadeLocal;
import com.ensimag.projetDAC.stateless.PurchaseFacadeLocal;
import com.ensimag.projetDAC.stateless.UserFacadeLocal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author margotj
 */
@Named(value = "purchaseBean")
@SessionScoped
public class PurchaseBean implements Serializable {
    @EJB
    private PurchaseFacadeLocal purchaseFacade;
    
    @EJB
    private DeliveryMethodFacadeLocal deliveryMethodFacade;
    
    @EJB
    private UserFacadeLocal userFacade;
    
    @EJB
    private DeliveryStatusFacadeLocal deliveryStatusFacade;
    
    @Inject
    private ShoppingCartBean shoppingCartBean;

    private String addressStreet;

    /**
     * Get the value of addressStreet
     *
     * @return the value of addressStreet
     */
    public String getAddressStreet() {
        return addressStreet;
    }

    /**
     * Set the value of addressStreet
     *
     * @param addressStreet new value of addressStreet
     */
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    private String addressCity;

    /**
     * Get the value of addressCity
     *
     * @return the value of addressCity
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * Set the value of addressCity
     *
     * @param addressCity new value of addressCity
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    private String addressPostalCode;

    /**
     * Get the value of addressPostalCode
     *
     * @return the value of addressPostalCode
     */
    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    /**
     * Set the value of addressPostalCode
     *
     * @param addressPostalCode new value of addressPostalCode
     */
    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    private Long deliveryMethodId;

    /**
     * Get the value of deliveryMethodId
     *
     * @return the value of deliveryMethodId
     */
    public Long getDeliveryMethodId() {
        return deliveryMethodId;
    }

    /**
     * Set the value of deliveryMethodId
     *
     * @param deliveryMethodId new value of deliveryMethodId
     */
    public void setDeliveryMethodId(Long deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    private double price;

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public double getPrice() {
        computePrice();
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Map<Perfume, Integer> constructPerfumesMap() {
        Map<Perfume, Integer> perfumes = new HashMap<>();
        for (Perfume perfume : shoppingCartBean.getContent())
            perfumes.put(perfume, 1); // Attention, toujours un parfum pour l'instant
        return perfumes;
    }

    public double computePrice() {
        Map<Perfume, Integer> perfumes = constructPerfumesMap();
        price = 0;
        for (Map.Entry<Perfume, Integer> entry : perfumes.entrySet())
            price += entry.getKey().getPrice() * entry.getValue();
        if (deliveryMethodId != null)
            price += deliveryMethodFacade.find(deliveryMethodId).getPrice();
        return price;
    }
    
    /**
     * Creates a new instance of OrderBean
     */
    public PurchaseBean() {
    }
    
    public String savePurchase() {
        Map<Perfume, Integer> perfumes = constructPerfumesMap();
        
        // Récupération de la méthode de livraison
        DeliveryMethod deliveryMethod = deliveryMethodFacade.find(deliveryMethodId);
        
        // Concaténation de l'adresse
        String deliveryAddress = addressStreet + " " + addressCity + " " + addressPostalCode;
        
        // Find or create pour statut de livraison
        DeliveryStatus deliveryStatus = new DeliveryStatus("En cours");
        deliveryStatusFacade.create(deliveryStatus);
        
        // Récupération de l'utilisateur courant
        User user = userFacade.find(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName());
        
        // Calcul du prix de la commande
        double currentPrice = computePrice();
        
        if (!perfumes.isEmpty()) {
            Purchase purchase = new Purchase(user, perfumes, deliveryMethod, deliveryAddress, deliveryStatus, currentPrice);
            purchaseFacade.create(purchase);
        }
        
        // On supprime les parfums du panier de l'utilisateur
        for (Map.Entry<Perfume, Integer> entry : perfumes.entrySet())
            shoppingCartBean.removePerfume(entry.getKey());
        
        return "/secure/shoppingCart?logout=false&faces-redirect=true";
    }
}
