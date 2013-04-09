/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientPackage;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface ClientManagementLocal
{
    public void registerClient(client newClient);
    public List<client> getAllClients();
    
}