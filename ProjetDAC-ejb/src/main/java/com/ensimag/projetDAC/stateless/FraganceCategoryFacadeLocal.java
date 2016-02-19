/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.FraganceCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author muleta
 */
@Local
public interface FraganceCategoryFacadeLocal {

    void create(FraganceCategory fraganceCategory);

    void edit(FraganceCategory fraganceCategory);

    void remove(FraganceCategory fraganceCategory);

    FraganceCategory find(Object id);

    List<FraganceCategory> findAll();

    List<FraganceCategory> findRange(int[] range);

    int count();
    
}
