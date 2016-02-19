/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.BottleType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author muleta
 */
@Local
public interface BottleTypeFacadeLocal {

    void create(BottleType bottleType);

    void edit(BottleType bottleType);

    void remove(BottleType bottleType);

    BottleType find(Object id);

    List<BottleType> findAll();

    List<BottleType> findRange(int[] range);

    int count();
    
}
