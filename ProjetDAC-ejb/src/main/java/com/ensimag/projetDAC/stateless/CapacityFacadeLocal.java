/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Capacity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ensimag
 */
@Local
public interface CapacityFacadeLocal {

    void create(Capacity capacity);

    void edit(Capacity capacity);

    void remove(Capacity capacity);

    Capacity find(Object id);

    List<Capacity> findAll();

    List<Capacity> findRange(int[] range);

    int count();
    
}
