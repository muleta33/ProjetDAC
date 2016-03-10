/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.perfumes;

import com.ensimag.projetDAC.entity.Capacity;
import com.ensimag.projetDAC.stateless.CapacityFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author margotj
 */
@Named(value = "listAllCapacities")
@RequestScoped
public class ListAllCapacities {

    @EJB
    private CapacityFacadeLocal capacityFacade;
    
    private List<Capacity> capacities = null;

    /**
     * Creates a new instance of ListAll
     */
    public ListAllCapacities() {
    }
    
    public List<Capacity> getCapacities() {
        if (capacities == null)
            capacities = capacityFacade.findAll();
        return capacities;
    }
    
}
