/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientPackage;

import dataAccess.dataAcess;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Riaan
 */
@Stateless
public class ClientManagementImp implements ClientManagementRemote , ClientManagementLocal
{
    @EJB
    private dataAcess dao;
    
    public void registerClient(client newClient)
    {
        dao.insert(newClient);
        throw new IllegalArgumentException("Client side register");
    }
    
    public List<client> getAllClients()
    {
        //List<client> tempList = new ArrayList<client>();
        //tempList.add(new client(" id , firstName" , "surname"));
        //return tempList;
        
        return dao.findAll();
    }
}
