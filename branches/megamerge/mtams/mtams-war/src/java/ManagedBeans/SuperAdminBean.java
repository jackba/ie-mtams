/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Account;
import ServiceLayer.AccountHandlerLocal;
import ServiceLayer.RoleHandlerLocal;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Alexandre Manuel Damasio
 */
@Named(value = "superAdminBean")
@ConversationScoped
public class SuperAdminBean implements Serializable {

    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z0-9]{0,}")
    private String adminName;
    private String adminPassword;
    private String department;
    private int roleID;
    private String role;
    private String roleDescription;
    
    @EJB
    private AccountHandlerLocal handler;
    @EJB
    private RoleHandlerLocal handler1;

    public SuperAdminBean() {
    }
    public String goToHome(){
        return "./superHome.xhtml";
    }
    public String goToCreateAdmin(){
        return "./createAdmin.xhtml";
    }
    public String goToEditAdmin(){
        return "./editAdminSelect.xhtml";
    }
    public String goToCreateRole(){
        return "./createRole.xhtml";
    }
    public String goToDeactivateAccount(){
        return "./deactivateAccount.xhtml";
    }
    public String createAdmin() {
        if (handler.checkUsername(getAdminName())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Input Error", "Username already exists"));
            return null;
        } else {
            Account newAccount = new Account();
            newAccount.setUsername(getAdminName());
            newAccount.setPassword(getAdminPassword());            

            handler.registerNewAccountDiv(newAccount, 21, getDepartment());
            FacesContext.getCurrentInstance().addMessage("superHomeTop", new FacesMessage(FacesMessage.SEVERITY_INFO,"Success.","Administrator Account Created"));
            return "./superHome.xhtml";
        }
    }

    public String createRole() {
        
        return "./superHome.xhtml";
    }

    public String deactivateAccount() {

        return "./superHome.xhtml";
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public AccountHandlerLocal getHandler() {
        return handler;
    }

    public void setHandler(AccountHandlerLocal handler) {
        this.handler = handler;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
