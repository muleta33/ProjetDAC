/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Capacity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ensimag
 */
@Stateless
public class CapacityFacade extends AbstractFacade<Capacity> implements CapacityFacadeLocal {

    @PersistenceContext(unitName = "ProjetDAC_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapacityFacade() {
        super(Capacity.class);
    }
    
}
