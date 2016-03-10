/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.FragranceCategory;
import com.ensimag.projetDAC.entity.Fragrance;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
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
        Root<Fragrance> fragrance = q.from(Fragrance.class);
        Join<Fragrance, FragranceCategory> category = fragrance.join("category");
        Path<String> categoryName = category.get("name");
        // Paramètre sur lequel porte le test du WHERE
        ParameterExpression<String> param = cb.parameter(String.class, "param");
        // Création de la requête
        q.select(fragrance).where(cb.like(categoryName, param));
        TypedQuery<Fragrance> query = em.createQuery(q);
        // Valeur pour le paramètre
        List<String> p = new ArrayList<>();
        p.add(name);
        query.setParameter("param", p);
        // Exécution de requête
        List<Fragrance> results = query.getResultList();
        return results;
    }
}
