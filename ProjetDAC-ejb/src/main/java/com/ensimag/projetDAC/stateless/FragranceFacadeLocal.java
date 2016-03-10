/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.Fragrance;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author muleta
 */
@Local
public interface FragranceFacadeLocal {

    void create(Fragrance fragance);

    void edit(Fragrance fragance);

    void remove(Fragrance fragance);

    Fragrance find(Object id);

    List<Fragrance> findAll();
    
    List<Fragrance> findByCategory(String name);

    List<Fragrance> findRange(int[] range);

    int count();
    
}
