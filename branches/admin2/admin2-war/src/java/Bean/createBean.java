/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.Staff;
import business.clientServer;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

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
    
    public createBean(){
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
		Staff newStaff = new Staff(1l,userName,password);
		
		csi.registerClient(newStaff);
		return "adminHome";
	}
    
}
