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
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;
import org.primefaces.component.api.UIData;

/**
 *
 * @author Badger
 */
@Named(value = "adminBean")
@ConversationScoped
public class AdminBean implements Serializable {
    
	@Pattern(message="Incorrect username entered", regexp="[a-zA-Z0-9]{0,}")
    private String username;
    private String password;
    private int role = 11;
    private int departmentRole;
    private List<Account> allAccounts;
    private Account selectedAcc;
    private UIData dataTable;
    private UIData dataTableDetails;
    
    @EJB
    private AccountHandlerLocal handler;
    /**
     * Creates a new instance of AdminBean
     */
    
    //======change===change=========change============change=========change====
    //-------------------------------------------------------------------------
    private Integer accountID = 1;//(Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("userID");
    //-------------------------------------------------------------------------
    //======change========change=========change=============change=============
            
    public AdminBean() {
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getdepartmentRole() {
        return departmentRole;
    }

    public void setdepartmentRole(int departmentRole) {
        this.departmentRole = departmentRole;
    }

    public List<Account> getAllAccounts() {
        String userName = (String) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("username");
        
        return handler.getAllAccounts(userName);
    }

    public void setAllAccounts(List<Account> allAccounts) {        
        this.allAccounts = allAccounts;
    }

    public Account getSelectedAcc() {
        return selectedAcc;
    }

    public void setSelectedAcc(Account selectedAcc) {
        this.selectedAcc = selectedAcc;
    }
    
    public UIData getDataTable() {
        return dataTable;
    }

    public void setDataTable(UIData dataTable) {
        this.dataTable = dataTable;
    }

    public UIData getDataTableDetails() {
        return dataTableDetails;
    }

    public void setDataTableDetails(UIData dataTableDetails) {
        this.dataTableDetails = dataTableDetails;
    }
    
    public String goHome(){
        return "./accountAll.xhtml";
    }
    
    public String goCreate(){
        return "./accountCreate.xhtml";
    }
    
    public String goViewAll(){
        return "accountAll";
    }
    
    public String createAccount(){
        if(handler.checkUsername(getUsername())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Input Error","Username already exists"));
            return null;
        }else{
            Account newAccount = new Account();
            newAccount.setUsername(getUsername());
            newAccount.setPassword(getPassword());

            handler.registerNewAccount(newAccount,getRole(),getdepartmentRole(),accountID);
            
            return "accountAll";
        }        
    }
    
    public String deactivateAccount() {
        handler.deactivateAccount(selectedAcc);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success.", "Account has been Deactivated"));
        return null;
    }

    public String reactivateAccount() {
        handler.reactivateAccount(selectedAcc);
        return null;
    }
}
