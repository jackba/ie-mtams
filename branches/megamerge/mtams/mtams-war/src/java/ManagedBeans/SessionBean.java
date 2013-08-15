/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Account;
import ServiceLayer.LoginHandlerLocal;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

;

/**
 *
 * @author Badger
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private String username;
    private String password;
    private HttpSession session;
    private Account user;
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

    public boolean checkActive() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userID") != null;
    }

    public boolean checkFirstTime() {
        return (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("isFirst");
    }

    public boolean checkNotFirstTime() {
        return !((Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("isFirst")).booleanValue();
    }

    public String greeting() {
        String userN = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        //String
        if ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false) != null) {
            return "Hello " + userN;
        } else {
            return "You are not logged in or have performed a wrong navigation. Please click on the link to take you to the login page";
        }
    }

    public void addDate() {
        user.setDatelogin(new Date());
        handler.modifyAccount(user);
    }

    private void setSessionVariables() {
        //FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userID", user.getIdaccount());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user.getUsername());
        //session.setAttribute("userID", user.getIdaccount());
//        session.setAttribute("username", user.getUsername());
    }

    public String validate() {
        user = handler.authenticate(this.username, this.password);
        Integer roleNum = handler.getAccountRole(user);
        if (user != null && roleNum != null) {
            
                if (roleNum == 11) {

                    //session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    setSessionVariables();
                    if (user.getDatelogin() == null) {

                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isFirst", true);
                        addDate();
                        return "travelProfileCreate";
                    } else {
                        //addDate();
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isFirst", false);
                        addDate();
                        return "userHome.xhtml";//"viewApplication";//
                    }
                    //logError = false;

                } else if (roleNum == 12) {
                    setSessionVariables();
                    if (user.getDatelogin() == null) {

                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isFirst", true);
                        addDate();
                        return "travelProfileCreate";
                    } else {
                        //addDate();
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isFirst", false);
                        addDate();
                        return "authorizerHome.xhtml";//"viewApplication";//
                    }

                } else if (roleNum == 21) {

                    addDate();
                    // session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    setSessionVariables();
                    //logError = false;
                    return "accountAll";

                } else if (roleNum == 22) {

                    addDate();
                    // session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    setSessionVariables();
                    //logError = false;
                    return "superHome";
                } else {
                    FacesContext.getCurrentInstance().addMessage("loginMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error", "Account has been deactivated. Please contact admin."));
                    return "login";
                }
            } else {
                FacesContext.getCurrentInstance().addMessage("loginMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error", "Incorrect username/password combination"));
                return "login";
            }
        

        }

    

    public String invalidate() {
        //HttpServletRequest request = (HttpServletRequest);
        //session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //HttpSession session = request.getSession(true);
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userID", null);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", null);
            ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        } catch (NullPointerException e) {
        } finally {
            return "login";
        }


    }
}
