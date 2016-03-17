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
            context.addMessage(null, new FacesMessage("Info", "Login failed!"));
        }
        else if (request.getRequestedSessionId()!=null && !request.isRequestedSessionIdValid()
                    & request.getParameter("logout")==null) {
            /* The user session has timed out (not caused by a logout action)... */
            context.addMessage(null, new FacesMessage("Info", "Your session has timed out!"));
        }
        else if (request.getParameter("logout")!=null && request.getParameter("logout").equalsIgnoreCase("true")) {
            context.addMessage(null, new FacesMessage("Info", "Logout done."));
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
        String page="/login?logout=true&faces-redirect=true";
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
            HttpSession session = request.getSession(false);
            if (session != null)
                session.invalidate();
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Info", "Logout failed!"));
            page="/login?logout=false&faces-redirect=true";
        }
        return page;
    }
}
