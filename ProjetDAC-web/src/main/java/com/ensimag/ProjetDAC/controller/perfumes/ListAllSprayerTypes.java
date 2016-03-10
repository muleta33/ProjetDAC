/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.perfumes;

import com.ensimag.projetDAC.entity.SprayerType;
import com.ensimag.projetDAC.stateless.SprayerTypeFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author margotj
 */
@Named(value = "listAllSprayerTypes")
@RequestScoped
public class ListAllSprayerTypes {

    @EJB
    private SprayerTypeFacadeLocal sprayerTypeFacade;
    
    private List<SprayerType> sprayerTypes = null;

    /**
     * Creates a new instance of ListAll
     */
    public ListAllSprayerTypes() {
    }
    
    public List<SprayerType> getSprayerTypes() {
        if (sprayerTypes == null)
            sprayerTypes = sprayerTypeFacade.findAll();
        return sprayerTypes;
    }
    
}
