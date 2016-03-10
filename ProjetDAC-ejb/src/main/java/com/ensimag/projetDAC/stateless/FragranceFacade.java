/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Fragrance;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 *
 * @author muleta
 */
@Stateless
public class FragranceFacade extends AbstractFacade<Fragrance> implements FragranceFacadeLocal {
    @PersistenceContext(unitName = "ProjetDAC_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FragranceFacade() {
        super(Fragrance.class);
    }
    
    @Override
    public List<Fragrance> findByCategory(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // Création du critère
        CriteriaQuery<Fragrance> q = cb.createQuery(Fragrance.class);
        // Propriété sur lequel porte le WHERE
        Root<Fragrance> c = q.from(Fragrance.class);
        Expression<String> path = c.get("category");
        // Paramètre sur lequel porte le test du WHERE
        ParameterExpression<String> param = cb.parameter(String.class);
        // Création de la requête
        q.select(c).where(cb.like(path, param));
        TypedQuery<Fragrance> query = em.createQuery(q);
        // Valeur pour le paramètre
        query.setParameter(param, name);
        // Exécution de la requête
        List<Fragrance> results = query.getResultList();
        return results;
    }
}
