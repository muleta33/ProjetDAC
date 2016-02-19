/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.controller;

import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.UserFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author margotj
 */
@ManagedBean
@SessionScoped
public class UserController {
    @EJB
    private UserFacadeLocal userFacade;
    
    private User user;

    public UserController(User user) {
        this.user = user;
    }
    
    
}
