/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.perfumes;

import com.ensimag.projetDAC.entity.Fragrance;
import com.ensimag.projetDAC.stateless.FragranceFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author margotj
 */
@Named(value = "listAllFragrances")
@RequestScoped
public class ListAllFragrances {

    @EJB
    private FragranceFacadeLocal fragranceFacade;
    
    private List<Fragrance> fragrances = null;

    /**
     * Creates a new instance of ListAll
     */
    public ListAllFragrances() {
    }
    
    public List<Fragrance> getFragrances() {
        if (fragrances == null)
            fragrances = fragranceFacade.findAll();
        return fragrances;
    }
    
}
