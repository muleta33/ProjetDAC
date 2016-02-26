/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;


/**
 *
 * @author ensimag
 */
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ensimag
 */
@ManagedBean
public class AuthenticationBean {
 
    public void checkErrors(ComponentSystemEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        if ("true".equals((String)request.getParameter("failed"))) {
            /* GET parameter "failed" has been sent in the HTTP request... */
            context.addMessage(null, new FacesMessage("Login failed!"));
        }
        else if (request.getRequestedSessionId()!=null && !request.isRequestedSessionIdValid()
                    & request.getParameter("logout")==null) {
            /* The user session has timed out (not caused by a logout action)... */
            context.addMessage(null, new FacesMessage("Your session has timed out!"));
        }
        else if (request.getParameter("logout")!=null && request.getParameter("logout").equalsIgnoreCase("true")) {
            context.addMessage(null, new FacesMessage("Logout done."));
        }
    }
 
    public String logout() {
        String page="/login?logout=true&faces-redirect=true";
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
          request.logout();
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed!"));
            page="/login?logout=false&faces-redirect=true";
        }
        return page;
    }
}
