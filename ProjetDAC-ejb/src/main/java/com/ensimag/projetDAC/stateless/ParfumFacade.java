/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDac.entity.Parfum;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author muleta
 */
@Stateless
public class ParfumFacade extends AbstractFacade<Parfum> implements ParfumFacadeLocal {
    @PersistenceContext(unitName = "ProjetDAC_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParfumFacade() {
        super(Parfum.class);
    }
    
}
