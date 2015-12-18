/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.parfums;

import com.ensimag.projetDAC.stateless.ParfumFacadeLocal;
import com.ensimag.projetDac.entity.Parfum;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author muleta
 */
@Named(value = "listAllParfums")
@RequestScoped
public class ListAll {
    @EJB
    private ParfumFacadeLocal parfumFacade;
    
    private List<Parfum> parfums = null;

    /**
     * Creates a new instance of ListAll
     */
    public ListAll() {
    }
    
    public List<Parfum> getParfums() {
        if (parfums == null)
            parfums = parfumFacade.findAll();
        return parfums;
    }
    
}
