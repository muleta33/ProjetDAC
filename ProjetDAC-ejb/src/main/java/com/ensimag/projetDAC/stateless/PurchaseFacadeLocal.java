/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author margotj
 */
@Local
public interface PurchaseFacadeLocal {

    void create(Purchase purchase);

    void edit(Purchase purchase);

    void remove(Purchase purchase);

    Purchase find(Object id);

    List<Purchase> findByUser(User user);
    
    List<Purchase> findAll();

    List<Purchase> findRange(int[] range);

    int count();
    
}
