/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Entity.Staff;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface clientServer 
{
    public void registerClient(Staff newStaff);
}
