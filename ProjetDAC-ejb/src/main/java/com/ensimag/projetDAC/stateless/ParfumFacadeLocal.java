/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.stateless;

import com.ensimag.projetDac.entity.Parfum;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author muleta
 */
@Local
public interface ParfumFacadeLocal {

    void create(Parfum parfum);

    void edit(Parfum parfum);

    void remove(Parfum parfum);

    Parfum find(Object id);

    List<Parfum> findAll();

    List<Parfum> findRange(int[] range);

    int count();
    
}
