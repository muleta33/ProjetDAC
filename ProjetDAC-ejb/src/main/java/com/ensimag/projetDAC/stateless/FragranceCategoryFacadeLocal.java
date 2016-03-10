/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDAC.entity.FragranceCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author muleta
 */
@Local
public interface FragranceCategoryFacadeLocal {

    void create(FragranceCategory fraganceCategory);

    void edit(FragranceCategory fraganceCategory);

    void remove(FragranceCategory fraganceCategory);

    FragranceCategory find(Object id);

    List<FragranceCategory> findAll();

    List<FragranceCategory> findRange(int[] range);

    int count();
    
}
