/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.Capacity;
import com.ensimag.projetDAC.entity.DeliveryMethod;
import com.ensimag.projetDAC.entity.DeliveryStatus;
import com.ensimag.projetDAC.entity.Fragrance;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.entity.SprayerType;
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.stateless.PurchaseFacadeLocal;
import com.ensimag.projetDAC.stateless.UserFacadeLocal;
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
    private PurchaseFacadeLocal purchaseFacade;
    
    private List<DeliveryMethod> deliveryMethods = null;
    
    @EJB
    private UserFacadeLocal userFacade;
    
    private List<User> clients = null;
    
    @EJB
    private PurchaseFacadeLocal orderFacade;
    
    private List<Purchase> orders = null;
    
    @EJB 
    private PerfumeFacadeLocal perfumeFacadeLocal;
    
    private List<Perfume> perfumes = null;
    
    @EJB
    private PurchaseFacadeLocal purchaseFacadeLocal;
    
    private Fragrance senteur1;
    private Fragrance senteur2;
    private Fragrance senteur3;
    
        private Capacity capacity;

    /**
     * Get the value of capacity
     *
     * @return the value of capacity
     */
    public Capacity getCapacity() {
        return capacity;
    }

    /**
     * Set the value of capacity
     *
     * @param capacity new value of capacity
     */
    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    private SprayerType sprayer;

    /**
     * Get the value of sprayer
     *
     * @return the value of sprayer
     */
    public SprayerType getSprayer() {
        return sprayer;
    }

    /**
     * Set the value of sprayer
     *
     * @param sprayer new value of sprayer
     */
    public void setSprayer(SprayerType sprayer) {
        this.sprayer = sprayer;
    }

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Creates a new instance of ManagerBean
     */
    public ManagerBean() {
        
    }
    
    public Fragrance getSenteur1() {
        return senteur1;
    }
    
    public Fragrance getSenteur2() {
        return senteur2;
    }
    
    public Fragrance getSenteur3() {
        return senteur3;
    }
    
    public void setSenteur1(Fragrance senteur) {
        senteur1 = senteur;
    }
    
    public void setSenteur2(Fragrance senteur) {
        senteur2 = senteur;
    }
    
    public void setSenteur3(Fragrance senteur) {
        senteur3 = senteur;
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
    
    public List<Perfume> getPerfumes() {
        perfumes = perfumeFacadeLocal.findBySelection();
        return perfumes;
    }
    
    public void removePerfume(Perfume perfume) {
        perfume.setBelongToSelection(false);
        System.err.println(perfume);
        perfumeFacadeLocal.edit(perfume);
    }
    public boolean containsPerfume(Perfume perfume) {
        return false;
    }
    
    public void setStatus(Purchase purchase) {
        switch (purchase.getDeliveryStatus().getName()) {
            case "en attente":
                purchase.setDeliveryStatus(new DeliveryStatus("en cours de préparation"));
                break;
            case "en cours de préparation":
                purchase.setDeliveryStatus(new DeliveryStatus("expédiée"));
                break;
            case "expédiée":
                purchase.setDeliveryStatus(new DeliveryStatus("reçue"));
                break;
        }
        purchaseFacadeLocal.edit(purchase);
    }
}
