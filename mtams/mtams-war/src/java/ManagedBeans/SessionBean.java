/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Account;
import ServiceLayer.LoginHandlerLocal;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
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
    private Integer roleNum;
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
        session();
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userID") != null;
    }
    
    public boolean checkMenuActive(){
        session();
        boolean value = (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userID") != null) && checkNotFirstTime();
        return value;
    }

    public boolean checkFirstTime() {
        session();
        return (Boolean) session.getAttribute("isFirst");
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("isFirst");
    }

    public boolean checkNotFirstTime() {
        session();
        return !(Boolean) session.getAttribute("isFirst");
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("isFirst")).booleanValue();
    }

    public String greeting() {
        session();
        String userN = (String) session.getAttribute("username");
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        //String
        if ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false) != null) {
            return "Hello " + userN;
        } else {
            return "You are not logged in or have performed a wrong navigation. Please click on the link to take you to the login page";
        }
    }

    public String getRole() {
        session();
        int userRoleNumber = (Integer) session.getAttribute("userRole");
        String userRoleName;
        switch (userRoleNumber) {
            case 11:
                userRoleName = "Applicant";
                break;
            case 12:
                userRoleName = "Authorizer";
                break;
            case 21:
                userRoleName = "Admin";
                break;
            case 22:
                userRoleName = "Super Admin";
                break;
            default:
                userRoleName = "Role Name";
                break;
        }
        return userRoleName;
    }
    
    public String homePage() {
        session();
        int userRoleNumber = (Integer) session.getAttribute("userRole");
        String userRolePage;
        switch (userRoleNumber) {
            case 11:
                userRolePage = "userHome";
                break;
            case 12:
                userRolePage = "userHome";
                break;
            case 21:
                userRolePage = "accountAll";
                break;
            case 22:
                userRolePage = "superHome";
                break;
            default:
                userRolePage = "test";
                break;
        }
        return userRolePage;
    }

    public String getName() {
        return (String) session.getAttribute("username");
    }

    public void session() {
        FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(false);
    }

    public void addDate() {
        user.setDatelogin(new Date());
        handler.modifyAccount(user);
    }

    private void setSessionVariables() {
        //FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(true);

        session.setAttribute("userID", user.getIdaccount());
        session.setAttribute("userRole", roleNum);
        session.setAttribute("username", user.getUsername());
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userID", user.getIdaccount());
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userRole", roleNum);
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user.getUsername());
        //session.setAttribute("userID", user.getIdaccount());
//        session.setAttribute("username", user.getUsername());
    }

    public String validate() {
        user = handler.authenticate(this.username, this.password);
        roleNum = handler.getAccountRole(user);
        if (user != null && roleNum != null) {

            if (roleNum == 11) {

                //session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                //setSessionVariables();
                if (user.getDatelogin() == null) {
                    setSessionVariables();
                    session.setAttribute("isFirst", true);
                    //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isFirst", true);
                    //addDate();
                    return "./travelProfileCreate.xhtml?faces-redirect=true";
                } else {
                    //addDate();
                    setSessionVariables();
                    //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isFirst", false);
                    session.setAttribute("isFirst", false);
                    addDate();
                    return "./userHome.xhtml?faces-redirect=true";//"viewApplication";//
                }
                //logError = false;

            } else if (roleNum == 12) {
                //setSessionVariables();
                if (user.getDatelogin() == null) {
                    setSessionVariables();
                    session.setAttribute("isFirst", true);
                    //addDate();
                    return "./travelProfileCreate.xhtml?faces-redirect=true";
                } else {
                    //addDate();
                    setSessionVariables();
                    session.setAttribute("isFirst", false);
                    addDate();
                    return "./userHome.xhtml?faces-redirect=true";//"viewApplication";//
                }

            } else if (roleNum == 21) {

                addDate();
                // session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                setSessionVariables();
                //logError = false;
                return "accountAll?faces-redirect=true";

            } else if (roleNum == 22) {

                addDate();
                // session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                setSessionVariables();
                //logError = false;
                return "superHome?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error", "Account has been deactivated. Please contact admin."));
                return "login";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error", "Incorrect username/password combination"));
            return "login";
        }


    }

    public String invalidate() {
        //HttpServletRequest request = (HttpServletRequest);
        //session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //HttpSession session = request.getSession(true);
        try {
            session.setAttribute("userID", null);
            session.setAttribute("username", null);
//            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userID", null);
//            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", null);
            ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        } catch (NullPointerException e) {
        } finally {
            return "login?faces-redirect=true";
        }
    }
}
