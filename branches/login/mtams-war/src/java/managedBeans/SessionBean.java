package managedBeans;

import Entities.Accounts;
import ServiceLayer.LoginHandlerLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
;

/**
 *
 * @author Badger
 */
@ManagedBean(name="sessionBean")
@SessionScoped
public class SessionBean implements Serializable{
    private String username;
    private String password;
    private HttpSession session;
    private Accounts user;
    private boolean logError = false;
    
    @EJB
    private LoginHandlerLocal handler;
    
    /**
     * Creates a new instance of LoginBean
     */
    public SessionBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogError() {
        return logError;
    }

    public void setLogError(boolean logError) {
        this.logError = logError;
    }
    
    
    
    public String greeting(){
        
         if(session != null){
            return "Hello " + username + " .Your authority level is: " + handler.getAccountRole(user.getRoleIdrole());
         }else{
             return "You are not logged in or have performed a wrong navigation. Please click on the link to take you to the login page";
         }
    }
    
    public String validate(){
        user = handler.authenticate(this.username, this.password);
        if(user != null){
           if(user.getRoleIdrole() < 20){
               
               session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
               logError = false;
               return "userHome.xhtml";
            }else{
               session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
               logError = false;
               return "adminHome.xhtml";
            } 
        }else{
            logError = true;
            return "login.xhtml";
        }

    }
    
    public String invalidate() {
        //HttpServletRequest request = (HttpServletRequest);
         //session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //HttpSession session = request.getSession(true);
        try{
            session.invalidate();
        }catch (NullPointerException e){
        }finally{
            return "login.xhtml?faces-redirect=true";
        }
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
    }
    
    public boolean renderLogout(){
        if(session == null){
            return false;
         }else{
             return true;
         }
    }
    
    public boolean renderRevLogout(){
        return !renderLogout();
    }
}
