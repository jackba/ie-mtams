/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.Staff;
import business.clientServer;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Riaan
 */

@ManagedBean(name = "createBean")
@EJB
public class createBean 
{
    private clientServer csi;
    
    private String userName;
    private String password;
    private Long id;

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
    
}
