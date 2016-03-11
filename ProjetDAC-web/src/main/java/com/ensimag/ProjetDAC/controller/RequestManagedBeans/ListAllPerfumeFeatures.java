/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.RequestManagedBeans;

import com.ensimag.projetDAC.entity.BottleType;
import com.ensimag.projetDAC.entity.Capacity;
import com.ensimag.projetDAC.entity.FragranceCategory;
import com.ensimag.projetDAC.entity.Fragrance;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.SprayerType;
import com.ensimag.projetDAC.stateless.BottleTypeFacadeLocal;
import com.ensimag.projetDAC.stateless.CapacityFacadeLocal;
import com.ensimag.projetDAC.stateless.FragranceCategoryFacadeLocal;
import com.ensimag.projetDAC.stateless.FragranceFacadeLocal;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.stateless.SprayerTypeFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author muleta
 */
@Named(value = "listAllPerfumeFeatures")
@RequestScoped
public class ListAllPerfumeFeatures {

    @EJB
    private BottleTypeFacadeLocal bottleTypeFacade;
    
    private List<BottleType> bottleTypes = null;
    
    @EJB
    private CapacityFacadeLocal capacityFacade;
    
    private List<Capacity> capacities = null;
    
    @EJB
    private FragranceFacadeLocal fragranceFacade;
    
    private List<Fragrance> fragrances = null;
    
    private List<Fragrance> fragrancesByCategory = null;
    
    @EJB
    private FragranceCategoryFacadeLocal fragranceCategoryFacade;
    
    private List<FragranceCategory> fragranceCategories = null;
    
    @EJB
    private PerfumeFacadeLocal perfumeFacade;
    
    private List<Perfume> perfumes = null;
    
    @EJB
    private SprayerTypeFacadeLocal sprayerTypeFacade;
    
    private List<SprayerType> sprayerTypes = null;
    
    /**
     * Creates a new instance of ListAllPerfumeFeatures
     */
    public ListAllPerfumeFeatures() {
    }
    
    public List<BottleType> getBottleTypes() {
        if (bottleTypes == null)
            bottleTypes = bottleTypeFacade.findAll();
        return bottleTypes;
    }
    
    public List<Capacity> getCapacities() {
        if (capacities == null)
            capacities = capacityFacade.findAll();
        return capacities;
    }
    
    public List<Fragrance> getFragrances() {
        if (fragrances == null)
            fragrances = fragranceFacade.findAll();
        return fragrances;
    }
    
    public List<Fragrance> getFragrancesByCategory(String name) {
        fragrancesByCategory = fragranceFacade.findByCategory(name);
        return fragrancesByCategory;
    }
    
    public List<FragranceCategory> getFragranceCategories() {
        if (fragranceCategories == null)
            fragranceCategories = fragranceCategoryFacade.findAll();
        return fragranceCategories;
    }
    
    public List<Perfume> getPerfumes() {
        if (perfumes == null)
            perfumes = perfumeFacade.findAll();
        return perfumes;
    }
    
    public List<SprayerType> getSprayerTypes() {
        if (sprayerTypes == null)
            sprayerTypes = sprayerTypeFacade.findAll();
        return sprayerTypes;
    }
}
