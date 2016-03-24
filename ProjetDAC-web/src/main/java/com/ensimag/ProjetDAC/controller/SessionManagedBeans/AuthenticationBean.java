/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.ProjetDAC.controller.SessionManagedBeans;


/**
 *
 * @author ensimag
 */
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.UserFacadeLocal;
import java.security.Principal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ensimag
 */
@ManagedBean
public class AuthenticationBean {
    
    @EJB
    private UserFacadeLocal userFacade;
    
    private User currentUser = null;
 
    public void checkErrors(ComponentSystemEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        if ("true".equals((String)request.getParameter("failed"))) {
            /* GET parameter "failed" has been sent in the HTTP request... */
            context.addMessage(null, new FacesMessage("Info", "Echec. Vérifiez votre login et/ou mot de passe"));
        }
        else if (request.getRequestedSessionId()!=null && !request.isRequestedSessionIdValid()
                    & request.getParameter("logout")==null) {
            /* The user session has timed out (not caused by a logout action)... */
            context.addMessage(null, new FacesMessage("Info", "Votre session a expiré !"));
        }
        else if (request.getParameter("logout")!=null && request.getParameter("logout").equalsIgnoreCase("true")) {
            context.addMessage(null, new FacesMessage("Info", "Déconnexion réussie."));
        }
        String version = FacesContext.class.getPackage().getImplementationVersion();
    }
    
    public User getCurrentUser() {
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if ((currentUser == null) && (principal != null))
            currentUser = userFacade.find(principal.getName());
        return currentUser;
    }
 
    public String logout() {
        String page="/index?faces-redirect=true";
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
            HttpSession session = request.getSession(false);
            if (session != null)
                session.invalidate();
            context.addMessage("message", new FacesMessage("Info", "Déconnexion réussie."));
        } catch (ServletException e) {
            context.addMessage("message", new FacesMessage("Info", "Echec de la déconnexion !"));
        }
        return page;
    }
}
