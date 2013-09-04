/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Account;
import ServiceLayer.AccountHandlerLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import org.primefaces.component.api.UIData;

/**
 *
 * @author Alexandre Damasio
 */
@Named(value = "editAdminBean")
@SessionScoped
public class SuperAdminEditAdminBean implements Serializable {
    private String adminName;
    private String adminPassword;
    private String department;
    private int accID;
    
    private UIData dataTable;
    private List<Account> adminAccList;
    private Account selectedAcc;
    
    @EJB
    private AccountHandlerLocal handler;

    /**
     * Creates a new instance of SuperAdminEditAdminBean
     */
    public SuperAdminEditAdminBean(){
        
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

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public UIData getDataTable() {
        return dataTable;
    }

    public void setDataTable(UIData dataTable) {
        this.dataTable = dataTable;
    }

    public List<Account> getAdminAccList() {
        return adminAccList = handler.getAllAdmins();
    } 

    public Account getSelectedAcc() {
        return selectedAcc;
    }

    public void setSelectedAcc(Account selectedAcc) {
        this.selectedAcc = selectedAcc;
    } 
    
    public String editAdmin(){
        setAdminName(selectedAcc.getUsername());
        setAccID(selectedAcc.getIdaccount());
        return "editAdmin.xhtml";        
    }
    public String editAdminPersist(){        
        Account accRef = new Account();
        accRef.setUsername(getAdminName());
        accRef.setPassword(getAdminPassword());
        accRef.setIdaccount(accID);
        
        handler.editAdminPersist(accRef);
        return "editAdminSelect.xhtml";
    }
}
