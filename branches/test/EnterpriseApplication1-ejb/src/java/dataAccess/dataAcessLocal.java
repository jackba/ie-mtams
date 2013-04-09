/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import clientPackage.client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface dataAcessLocal 
{
    public void insert(client newClient);
    public List<client> findAll();
    
}
