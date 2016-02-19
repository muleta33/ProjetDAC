/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Fragance;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author muleta
 */
@Local
public interface FraganceFacadeLocal {

    void create(Fragance fragance);

    void edit(Fragance fragance);

    void remove(Fragance fragance);

    Fragance find(Object id);

    List<Fragance> findAll();

    List<Fragance> findRange(int[] range);

    int count();
    
}
