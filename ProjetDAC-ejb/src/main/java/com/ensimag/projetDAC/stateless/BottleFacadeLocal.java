/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Bottle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author muleta
 */
@Local
public interface BottleFacadeLocal {

    void create(Bottle bottle);

    void edit(Bottle bottle);

    void remove(Bottle bottle);

    Bottle find(Object id);

    List<Bottle> findAll();

    List<Bottle> findRange(int[] range);

    int count();
    
}
