/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManageBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Riaan
 */
@ManagedBean(name = "client")
@RequestScoped
public class UserBean 
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
