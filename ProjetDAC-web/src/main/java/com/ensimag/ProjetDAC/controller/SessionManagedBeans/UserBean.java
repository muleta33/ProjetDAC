/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;

import com.ensimag.projetDAC.entity.Role;
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.UserFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author muleta
 */
@Named(value = "userBean")
@RequestScoped
public class UserBean {
    
    @EJB
    private UserFacadeLocal userFacade;
    
    private String userName;

    /**
     * Get the value of userName
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

 
    private String userFirstName;

    /**
     * Get the value of userFirstName
     *
     * @return the value of userFirstName
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * Set the value of userFirstName
     *
     * @param userFirstName new value of userFirstName
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    
    private String userEmail;

    /**
     * Get the value of userEmail
     *
     * @return the value of userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Set the value of userEmail
     *
     * @param userEmail new value of userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    
    private String userPassword;

    /**
     * Get the value of userPassword
     *
     * @return the value of userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Set the value of userPassword
     *
     * @param userPassword new value of userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }
    
    public String saveUser() {
        char[] pass = userPassword.toCharArray();
        User newUser = new User(userEmail, userName, userFirstName, pass, Role.ROLE.USER);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        try {
            userFacade.create(newUser);
        } catch (javax.ejb.EJBException e) {
            context.addMessage("message", new FacesMessage("Erreur", "Cet email ne peut pas servir de login"));
            return "signup.xhtml?faces-redirect=true";
        }
        context.addMessage("message", new FacesMessage("Info", "Votre compte a été créé avec succès"));
        return "index.xhtml?faces-redirect=true";
    }
    
}
