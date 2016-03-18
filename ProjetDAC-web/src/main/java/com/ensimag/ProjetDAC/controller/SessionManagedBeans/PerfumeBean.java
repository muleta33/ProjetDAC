/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.Bottle;
import com.ensimag.projetDAC.entity.BottleType;
import com.ensimag.projetDAC.entity.Capacity;
import com.ensimag.projetDAC.entity.Fragrance;
import com.ensimag.projetDAC.entity.Inscription;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.SprayerType;
import com.ensimag.projetDAC.stateless.BottleFacadeLocal;
import com.ensimag.projetDAC.stateless.BottleTypeFacadeLocal;
import com.ensimag.projetDAC.stateless.CapacityFacadeLocal;
import com.ensimag.projetDAC.stateless.FragranceFacadeLocal;
import com.ensimag.projetDAC.stateless.InscriptionFacadeLocal;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.stateless.SprayerTypeFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author margotj
 */
@Named(value = "perfumeBean")
@SessionScoped
public class PerfumeBean implements Serializable {
    @EJB
    private PerfumeFacadeLocal perfumeFacade;
    
    @EJB
    private FragranceFacadeLocal fragranceFacade;
    
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
    
    @Inject
    private ShoppingCartBean shoppingCartBean;
    
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
    
    private Long[] fragranceIds;

    /**
     * Get the value of fragrances
     *
     * @return the value of fragrances
     */
    public Long[] getFragranceIds() {
        return fragranceIds;
    }

    /**
     * Set the value of fragrances
     *
     * @param fragranceIds new value of fragrances
     */
    public void setFragranceIds(Long[] fragranceIds) {
        this.fragranceIds = fragranceIds;
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
    
    private Long capacityId;

    /**
     * Get the value of capacityId
     *
     * @return the value of capacityId
     */
    public Long getCapacityId() {
        return capacityId;
    }

    /**
     * Set the value of capacityId
     *
     * @param capacityId new value of capacityId
     */
    public void setCapacityId(Long capacityId) {
        this.capacityId = capacityId;
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

    private String isGift;

    /**
     * Get the value of isGift
     *
     * @return the value of isGift
     */
    public String getIsGift() {
        return isGift;
    }

    /**
     * Set the value of isGift
     *
     * @param isGift new value of isGift
     */
    public void setIsGift(String isGift) {
        this.isGift = isGift;
    }

    private Perfume perfume;

    /**
     * Get the value of perfume
     *
     * @return the value of perfume
     */
    public Perfume getPerfume() {
        return perfume;
    }

    /**
     * Set the value of perfume
     *
     * @param perfume new value of perfume
     */
    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }


    
    /**
     * Creates a new instance of PerfumeBean
     */
    public PerfumeBean() {
    }
    
    public String onFlowProcess(FlowEvent event) {
        if (event.getNewStep().equals("confirmation"))
            constructPerfume();
        return event.getNewStep();
    }
    
    public List<Fragrance> constructFragranceList() {
        List<Fragrance> fragrancesList = new ArrayList<>();
        for (Long fragranceId : fragranceIds)
            fragrancesList.add(fragranceFacade.find(fragranceId));
        return fragrancesList;
    }
    
    public Capacity constructCapacity() {
        return capacityFacade.find(capacityId);
    }
    
    public SprayerType constructSprayerType() {
        return sprayerTypeFacade.find(spayerTypeId);
    }
    
    public BottleType constructBottleType() {
        return bottleTypeFacade.find(bottleTypeId);
    }
    
    public Bottle constructBottle() {
        // On récupère le pulvérisateur
        SprayerType sprayerType = constructSprayerType();
        
        // On récupère le type du flacon
        BottleType bottleType = constructBottleType();
        
        // On récupère la capacité
        Capacity capacity = constructCapacity();
        
        // Faire un findOrCreate pour l'inscription !!!   
        Inscription inscription = new Inscription(name);
        inscriptionFacade.create(inscription);
        
        Bottle bottle = new Bottle(bottleType, capacity, sprayerType, inscription);
        return bottle;
    }
    
    public Perfume constructPerfume() {
        // On récupère les senteurs
        List<Fragrance> fragrancesList = constructFragranceList();

        // On récupère ou crée le flacon TODO
        Bottle bottle = constructBottle();
        bottleFacade.create(bottle);

        // On crée le parfum
        perfume = new Perfume(name, fragrancesList, intensity, bottle, Boolean.parseBoolean(isGift), false);
        
        return perfume;
    }
    
    public String savePerfume() {
        // On crée le parfum
        perfumeFacade.create(perfume);
        
        // On l'ajoute au panier
        shoppingCartBean.addPerfume(perfume);
        
        return "/secure/shoppingCart?faces-redirect=true";
    }
}
