/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.perfumes;

import com.ensimag.projetDAC.entity.BottleType;
import com.ensimag.projetDAC.stateless.BottleTypeFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author margotj
 */
@Named(value = "listAllBottleTypes")
@RequestScoped
public class ListAllBottleTypes {

    @EJB
    private BottleTypeFacadeLocal bottleTypeFacade;
    
    private List<BottleType> bottleTypes = null;

    /**
     * Creates a new instance of ListAll
     */
    public ListAllBottleTypes() {
    }
    
    public List<BottleType> getBottleTypes() {
        if (bottleTypes == null)
            bottleTypes = bottleTypeFacade.findAll();
        return bottleTypes;
    }
    
}
