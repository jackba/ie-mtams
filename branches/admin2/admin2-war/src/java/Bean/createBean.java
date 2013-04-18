/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.Staff;
import business.clientServer;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIData;

/**
 *
 * @author Riaan
 */

@ManagedBean(name = "createBean")
@SessionScoped
public class createBean implements Serializable
{
    @EJB
    private clientServer csi;
    
    private String userName;
    private String password;
    private Long id;
    private UIData dataTable;
	private UIData dataTableN;
	private UIData dataTableDetails;
    
    public createBean(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String createStaff()
	{
		Staff newStaff = new Staff(id,userName,password);		
		csi.registerClient(newStaff);
		return "adminHome";
	}
    
    public List<Staff> getAllStaff()
    {
        return csi.getAllStaff();
    }

    public UIData getDataTable() {
        return dataTable;
    }

    public void setDataTable(UIData dataTable) {
        this.dataTable = dataTable;
    }

    public UIData getDataTableN() {
        return dataTableN;
    }

    public void setDataTableN(UIData dataTableN) {
        this.dataTableN = dataTableN;
    }

    public UIData getDataTableDetails() {
        return dataTableDetails;
    }

    public void setDataTableDetails(UIData dataTableDetails) {
        this.dataTableDetails = dataTableDetails;
    }
    
    
}
