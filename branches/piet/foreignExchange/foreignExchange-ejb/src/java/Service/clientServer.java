/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Account;
import Entity.Traveldocument;
import Entity.Travelerprofile;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface clientServer 
{
    public Travelerprofile find(Integer id);
    public Traveldocument findDocument(Integer id);
}
