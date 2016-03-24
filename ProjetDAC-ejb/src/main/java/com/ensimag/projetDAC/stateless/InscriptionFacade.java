/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Inscription;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

/**
 *
 * @author muleta
 */
@Stateless
public class InscriptionFacade extends AbstractFacade<Inscription> implements InscriptionFacadeLocal {
    @PersistenceContext(unitName = "ProjetDAC_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscriptionFacade() {
        super(Inscription.class);
    }
    
    @Override
    public List<Inscription> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // Création du critère
        CriteriaQuery<Inscription> q = cb.createQuery(Inscription.class);
        // Propriété sur laquelle porte le WHERE
        Root<Inscription> inscription = q.from(Inscription.class);
        Path<String> inscriptionName = inscription.get("text");
        // Paramètre sur lequel porte le test du WHERE
        ParameterExpression<String> param = cb.parameter(String.class, "param");
        // Création de la requête
        q.select(inscription).where(cb.like(inscriptionName, param));
        TypedQuery<Inscription> query = em.createQuery(q);
        // Valeur pour le paramètre
        List<String> p = new ArrayList<>();
        p.add(name);
        query.setParameter("param", p);
        // Exécution de requête
        List<Inscription> results = query.getResultList();
        return results;
    }
    
    @Override
    public Inscription findByNameOrCreate(String name) {
        List<Inscription> inscriptions = findByName(name);
        if ((inscriptions != null) && (!inscriptions.isEmpty()))
            return inscriptions.get(0);
        else {
            Inscription inscription = new Inscription(name);
            create(inscription);
            return inscription;
        }
    }
    
}
