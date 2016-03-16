/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.DeliveryStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author margotj
 */
@Local
public interface DeliveryStatusFacadeLocal {

    void create(DeliveryStatus deliveryStatus);

    void edit(DeliveryStatus deliveryStatus);

    void remove(DeliveryStatus deliveryStatus);

    DeliveryStatus find(Object id);

    List<DeliveryStatus> findAll();

    List<DeliveryStatus> findRange(int[] range);

    int count();
    
}
