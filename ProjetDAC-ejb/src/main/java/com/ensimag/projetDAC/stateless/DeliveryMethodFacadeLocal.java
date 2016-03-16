/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.DeliveryMethod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author margotj
 */
@Local
public interface DeliveryMethodFacadeLocal {

    void create(DeliveryMethod deliveryMethod);

    void edit(DeliveryMethod deliveryMethod);

    void remove(DeliveryMethod deliveryMethod);

    DeliveryMethod find(Object id);

    List<DeliveryMethod> findAll();

    List<DeliveryMethod> findRange(int[] range);

    int count();
    
}
