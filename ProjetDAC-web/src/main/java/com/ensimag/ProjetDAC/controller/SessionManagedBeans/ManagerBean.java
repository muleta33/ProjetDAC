/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
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
    private PerfumeFacadeLocal perfumeFacade;
    


    /**
     * Creates a new instance of ManagerBean
     */
    public ManagerBean() {
        
    }
    
    public void removePerfume(Perfume perfume) {
        perfumeFacade.remove(perfume);
    }
}
