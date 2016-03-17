/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.RequestManagedBeans;

import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author muleta
 */
@Named(value = "shoppingZoneBean")
@RequestScoped
public class shoppingZoneBean {

    @EJB
    private PerfumeFacadeLocal perfumeFacade;
    
    private List<Perfume> perfumes = null;
    
    private Perfume selectedPerfume = null;
    
    /**
     * Creates a new instance of shoppingZoneBean
     */
    public shoppingZoneBean() {
    }
    
    public List<Perfume> getPerfumesBySelection() {
        perfumes = perfumeFacade.findBySelection();
        return perfumes;
    }
    
    public Perfume getSelectedPerfume() {
        return selectedPerfume;
    }
 
    public void setSelectedPerfume(Perfume selectedFragrance) {
        this.selectedPerfume = selectedFragrance;
    }
    
}
