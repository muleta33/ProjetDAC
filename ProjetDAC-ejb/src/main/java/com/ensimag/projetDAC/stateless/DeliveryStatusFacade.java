/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.DeliveryStatus;
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
public class DeliveryStatusFacade extends AbstractFacade<DeliveryStatus> implements DeliveryStatusFacadeLocal {
    @PersistenceContext(unitName = "ProjetDAC_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeliveryStatusFacade() {
        super(DeliveryStatus.class);
    }
    
    @Override
    public List<DeliveryStatus> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // Création du critère
        CriteriaQuery<DeliveryStatus> q = cb.createQuery(DeliveryStatus.class);
        // Propriété sur laquelle porte le WHERE
        Root<DeliveryStatus> deliveryStatus = q.from(DeliveryStatus.class);
        Path<String> perfumeName = deliveryStatus.get("name");
        // Paramètre sur lequel porte le test du WHERE
        ParameterExpression<String> param = cb.parameter(String.class, "param");
        // Création de la requête
        q.select(deliveryStatus).where(cb.like(perfumeName, param));
        TypedQuery<DeliveryStatus> query = em.createQuery(q);
        // Valeur pour le paramètre
        List<String> p = new ArrayList<>();
        p.add(name);
        query.setParameter("param", p);
        // Exécution de requête
        List<DeliveryStatus> results = query.getResultList();
        return results;
    }
    
}
