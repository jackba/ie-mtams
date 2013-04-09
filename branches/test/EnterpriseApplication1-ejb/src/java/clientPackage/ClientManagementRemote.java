/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientPackage;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Riaan
 */
@Remote
public interface ClientManagementRemote 
{
    public void registerClient(client newClient);
    public List<client> getAllClients();
    
}
