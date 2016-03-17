/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Perfume;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author muleta
 */
@Local
public interface PerfumeFacadeLocal {

    void create(Perfume perfume);

    void edit(Perfume perfume);

    void remove(Perfume perfume);

    Perfume find(Object id);

    List<Perfume> findByName(String name);
    
    public List<Perfume> findBySelection();
    
    List<Perfume> findAll();

    List<Perfume> findRange(int[] range);

    int count();
    
}
