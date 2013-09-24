/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Account;
import Entities.Department;
import ServiceLayer.AccountHandlerLocal;
import ServiceLayer.DepartmentHandlerLocal;
import ServiceLayer.RoleHandlerLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;
import org.primefaces.component.api.UIData;

/**
 *
 * @author Alexandre Manuel Damasio
 */
@Named(value = "superAdminBean")
@SessionScoped
public class SuperAdminBean implements Serializable {

    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z0-9]{0,}")
    private String adminName;
    private String adminPassword;
    private String department;
    private int roleID;
    private String role;
    private String roleDescription;
    //Department Handler Details
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z ]{0,}")
    private String departmentName;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z ]{0,}")
    private String departmentEditName;
    private int departmentID;
    private Department selectedDepartment;
    private Department departmentRef;
    private UIData dataTable;
    private List<Department> allDepartments = new ArrayList<Department>();
    @EJB
    private AccountHandlerLocal handler;
    @EJB
    private RoleHandlerLocal handler1;
    @EJB
    private DepartmentHandlerLocal departmentHandler;

    public SuperAdminBean() {
    }

    public String goToHome() {
        return "./superHome.xhtml";
    }

    public String goToCreateAdmin() {
        return "./createAdmin.xhtml";
    }

    public String goToEditAdmin() {
        return "./editAdminSelect.xhtml";
    }

    public String goToCreateRole() {
        return "./createRole.xhtml";
    }

    public String goToDeactivateAccount() {
        return "./deactivateAccount.xhtml";
    }

    public String goToDepartmentHandler() {
        return "./departmentHandler.xhtml";
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
            FacesContext.getCurrentInstance().addMessage("superHomeTop", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success.", "Administrator Account Created"));
            return "./superHome.xhtml";
        }
    }

    public String createRole() {

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentEditName() {
        return departmentEditName;
    }

    public void setDepartmentEditName(String departmentEditName) {
        this.departmentEditName = departmentEditName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public Department getSelectedDepartment() {
        return selectedDepartment;
    }

    public void setSelectedDepartment(Department selectedDepartment) {
        this.selectedDepartment = selectedDepartment;
    }

    public UIData getDataTable() {
        return dataTable;
    }

    public void setDataTable(UIData dataTable) {
        this.dataTable = dataTable;
    }

    public void createDepartment() {
        if (departmentHandler.checkDepartmentName(getAdminName())) {
            FacesContext.getCurrentInstance().addMessage("createM", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Input Error", "Department already exists"));

        } else {
            departmentRef = new Department();
            departmentRef.setDepartment(departmentName);
            departmentHandler.createDepartment(departmentRef);
            FacesContext.getCurrentInstance().addMessage("departmentHandlerMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success.", "Department Created"));
        }
    }

    public void load() {
        departmentRef = selectedDepartment;
    }

    public void editDepartment() {
        if (departmentHandler.checkDepartmentName(getAdminName())) {
            FacesContext.getCurrentInstance().addMessage("editM", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Input Error", "Department already exists"));

        } else {
            selectedDepartment.setDepartment(getDepartmentEditName());
            departmentHandler.editDepartment(selectedDepartment);
            FacesContext.getCurrentInstance().addMessage("departmentHandlerMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success.", "Department Edited"));
        }
    }

    public void deleteDepartment() {
        departmentHandler.deleteDepartment(selectedDepartment);
        FacesContext.getCurrentInstance().addMessage("departmentHandlerMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success.", "Department Deleted"));

    }

    public List<Department> getAllDepartments() {
        return allDepartments = departmentHandler.getAllDepartments();
    }

    public void setAllDepartments(List<Department> allDepartments) {
        this.allDepartments = allDepartments;
    }
}
