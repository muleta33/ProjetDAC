/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.Bottle;
import com.ensimag.projetDAC.entity.BottleType;
import com.ensimag.projetDAC.entity.Capacity;
import com.ensimag.projetDAC.entity.DeliveryMethod;
import com.ensimag.projetDAC.entity.DeliveryStatus;
import com.ensimag.projetDAC.entity.Fragrance;
import com.ensimag.projetDAC.entity.Inscription;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.entity.SprayerType;
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.BottleFacadeLocal;
import com.ensimag.projetDAC.stateless.BottleTypeFacadeLocal;
import com.ensimag.projetDAC.stateless.CapacityFacadeLocal;
import com.ensimag.projetDAC.stateless.FragranceFacadeLocal;
import com.ensimag.projetDAC.stateless.InscriptionFacadeLocal;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.stateless.PurchaseFacadeLocal;
import com.ensimag.projetDAC.stateless.SprayerTypeFacadeLocal;
import com.ensimag.projetDAC.stateless.UserFacadeLocal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author souihlic
 */
@Named(value = "managerBean")
@RequestScoped
public class ManagerBean {

    @EJB
    private PurchaseFacadeLocal purchaseFacade;

    @EJB
    private SprayerTypeFacadeLocal sprayerTypeFacade;

    @EJB
    private BottleTypeFacadeLocal bottleTypeFacade;

    @EJB
    private BottleFacadeLocal bottleFacade;

    @EJB
    private CapacityFacadeLocal capacityFacade;

    @EJB
    private InscriptionFacadeLocal inscriptionFacade;

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
    
    @EJB
    private FragranceFacadeLocal fragranceFacade;

    private Integer activeTabIndex = 0;

    public Integer getActiveTabIndex() {
        return activeTabIndex;
    }

    public void setActiveTabIndex(Integer activeTabIndex) {
        this.activeTabIndex = activeTabIndex;
    }
    
    
    private Long fragranceId1;

    /**
     * Get the value of fragranceId1
     *
     * @return the value of fragranceId1
     */
    public Long getFragranceId1() {
        return fragranceId1;
    }

    /**
     * Set the value of fragranceId1
     *
     * @param fragranceId1 new value of fragranceId1
     */
    public void setFragranceId1(Long fragranceId1) {
        this.fragranceId1 = fragranceId1;
    }

    private Long fragranceId2;

    /**
     * Get the value of fragranceId2
     *
     * @return the value of fragranceId2
     */
    public Long getFragranceId2() {
        return fragranceId2;
    }

    /**
     * Set the value of fragranceId2
     *
     * @param fragranceId2 new value of fragranceId2
     */
    public void setFragranceId2(Long fragranceId2) {
        this.fragranceId2 = fragranceId2;
    }
    
    private Long fragranceId3;

    /**
     * Get the value of fragranceId3
     *
     * @return the value of fragranceId3
     */
    public Long getFragranceId3() {
        return fragranceId3;
    }

    /**
     * Set the value of fragranceId3
     *
     * @param fragranceId3 new value of fragranceId3
     */
    public void setFragranceId3(Long fragranceId3) {
        this.fragranceId3 = fragranceId3;
    }

    private Long capacityId;

    /**
     * Get the value of capacity
     *
     * @return the value of capacityId
     */
    public Long getCapacityId() {
        return capacityId;
    }

    /**
     * Set the value of capacity
     *
     * @param capacityId new value of capacityId
     */
    public void setCapacityId(Long capacityId) {
        this.capacityId = capacityId;
    }

    private Long sprayerId;

    /**
     * Get the value of sprayerId
     *
     * @return the value of sprayer
     */
    public Long getSprayerId() {
        return sprayerId;
    }

    /**
     * Set the value of sprayerId
     *
     * @param sprayerId new value of sprayerId
     */
    public void setSprayerId(Long sprayerId) {
        this.sprayerId = sprayerId;
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

    private Long bottleTypeId;

    /**
     * Get the value of bottleTypeId
     *
     * @return the value of bottleTypeId
     */
    public Long getBottleTypeId() {
        return bottleTypeId;
    }

    /**
     * Set the value of bottleTypeId
     *
     * @param bottleTypeId new value of bottleTypeId
     */
    public void setBottleTypeId(Long bottleTypeId) {
        this.bottleTypeId = bottleTypeId;
    }

    private Long spayerTypeId;

    /**
     * Get the value of nameSpayerType
     *
     * @return the value of nameSpayerType
     */
    public Long getSpayerTypeId() {
        return spayerTypeId;
    }

    /**
     * Set the value of nameSpayerType
     *
     * @param spayerTypeId new value of nameSpayerType
     */
    public void setSpayerTypeId(Long spayerTypeId) {
        this.spayerTypeId = spayerTypeId;
    }

    private int intensity;

    /**
     * Get the value of intensity
     *
     * @return the value of intensity
     */
    public int getIntensity() {
        return intensity;
    }

    /**
     * Set the value of intensity
     *
     * @param intensity new value of intensity
     */
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    /**
     * Creates a new instance of ManagerBean
     */
    public ManagerBean() {

    }

    public List<Purchase> getOrders() {
        if (orders == null) {
            orders = orderFacade.findAll();
        }
        Collections.sort(orders, new Comparator<Purchase>() {
            @Override
            public int compare(Purchase order1, Purchase order2) {

                return order1.getId().compareTo(order2.getId());
            }
        });
        return orders;
    }

    public List<User> getClients() {
        clients = userFacade.findAll();
        return clients;
    }

    public List<Perfume> getPerfumes() {
        perfumes = perfumeFacadeLocal.findBySelection();
        return perfumes;
    }

    public void removePerfume(Perfume perfume) {
        perfume.setBelongToSelection(false);
        perfumeFacadeLocal.edit(perfume);
    }

    public boolean containsPerfume(Perfume perfume) {
        return false;
    }
    
    public void onTabChange(TabChangeEvent event) {
        TabView tabView = (TabView) event.getComponent(); 
        this.activeTabIndex = tabView.getActiveIndex();
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

    public void savePerfume() {
        // On récupère les senteurs sélectionnées
        Fragrance fragrance1 = fragranceFacade.find(fragranceId1);
        Fragrance fragrance2 = fragranceFacade.find(fragranceId2);
        Fragrance fragrance3 = fragranceFacade.find(fragranceId3);
        
        List<Fragrance> fragrancesList = new ArrayList<>();
        fragrancesList.add(fragrance1);
        fragrancesList.add(fragrance2);
        fragrancesList.add(fragrance3);

        SprayerType sprayerType = sprayerTypeFacade.find(sprayerId);

        Capacity cap = capacityFacade.find(capacityId);
        BottleType bottleType = bottleTypeFacade.find(bottleTypeId);
        Inscription inscription = new Inscription(name);
        inscriptionFacade.create(inscription);

        Bottle bottle = new Bottle(bottleType, cap, sprayerType, inscription);
        bottleFacade.create(bottle);

        Perfume perfume = new Perfume(name, fragrancesList, intensity - 1, bottle, false, true);
        perfumeFacadeLocal.create(perfume);

    }
}
