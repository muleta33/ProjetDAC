/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.entity.User;
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
 * @author margotj
 */
@Stateless
public class PurchaseFacade extends AbstractFacade<Purchase> implements PurchaseFacadeLocal {
    @PersistenceContext(unitName = "ProjetDAC_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseFacade() {
        super(Purchase.class);
    }
    
    @Override
    public List<Purchase> findByUser(User user) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // Création du critère
        CriteriaQuery<Purchase> q = cb.createQuery(Purchase.class);
        // Propriété sur laquelle porte le WHERE
        Root<Purchase> purchase = q.from(Purchase.class);
        Path<String> purchaseUser = purchase.get("client");
        // Paramètre sur lequel porte le test du WHERE
        ParameterExpression<String> param = cb.parameter(String.class, "param");
        // Création de la requête
        q.select(purchase).where(cb.like(purchaseUser, param));
        TypedQuery<Purchase> query = em.createQuery(q);
        // Valeur pour le paramètre
        List<String> parameters = new ArrayList<>();
        parameters.add(user.getEmail());
        query.setParameter("param", parameters);
        // Exécution de requête
        List<Purchase> results = query.getResultList();
        return results;
    }
    
}
