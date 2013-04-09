/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManageBean;

import clientPackage.ClientManagementRemote;
import clientPackage.client;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "registerEmp")
@RequestScoped
public class RegisterEmployeeBean 
{
    @EJB
    private ClientManagementRemote clientMan;
    
    private int id= 1;
    private String name="riaan";
    private String surname = "vorster";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String createClient()
    {
        client newClient = new client(id , "name" , "surname");
        clientMan.registerClient(newClient);
        throw new IllegalArgumentException("create error");
        //return "clientAdded";
    }
    
    public List<client> getAllCleint()
    {
        return clientMan.getAllClients();
    }
}
