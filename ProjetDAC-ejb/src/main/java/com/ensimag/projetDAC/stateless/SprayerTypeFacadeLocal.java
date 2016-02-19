/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.SprayerType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author muleta
 */
@Local
public interface SprayerTypeFacadeLocal {

    void create(SprayerType sprayerType);

    void edit(SprayerType sprayerType);

    void remove(SprayerType sprayerType);

    SprayerType find(Object id);

    List<SprayerType> findAll();

    List<SprayerType> findRange(int[] range);

    int count();
    
}
