/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.perfumes;

import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.entity.Perfume;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author muleta
 */
@Named(value = "listAllPerfumes")
@RequestScoped
public class ListAll {
    @EJB
    private PerfumeFacadeLocal perfumeFacade;
    
    private List<Perfume> perfumes = null;

    /**
     * Creates a new instance of ListAll
     */
    public ListAll() {
    }
    
    public List<Perfume> getPerfumes() {
        if (perfumes == null)
            perfumes = perfumeFacade.findAll();
        return perfumes;
    }
    
}
