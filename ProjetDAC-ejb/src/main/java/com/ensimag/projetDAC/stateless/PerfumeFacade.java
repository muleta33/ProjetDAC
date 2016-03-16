/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Perfume;
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
public class PerfumeFacade extends AbstractFacade<Perfume> implements PerfumeFacadeLocal {
    @PersistenceContext(unitName = "ProjetDAC_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfumeFacade() {
        super(Perfume.class);
    }
    
    @Override
    public List<Perfume> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // Création du critère
        CriteriaQuery<Perfume> q = cb.createQuery(Perfume.class);
        // Propriété sur laquelle porte le WHERE
        Root<Perfume> perfume = q.from(Perfume.class);
        Path<String> perfumeName = perfume.get("name");
        // Paramètre sur lequel porte le test du WHERE
        ParameterExpression<String> param = cb.parameter(String.class, "param");
        // Création de la requête
        q.select(perfume).where(cb.like(perfumeName, param));
        TypedQuery<Perfume> query = em.createQuery(q);
        // Valeur pour le paramètre
        List<String> p = new ArrayList<>();
        p.add(name);
        query.setParameter("param", p);
        // Exécution de requête
        List<Perfume> results = query.getResultList();
        return results;
    }
    
}
