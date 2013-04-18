/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Accounts;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface LoginHandlerLocal {
    public Accounts authenticate(String username, String password);
    public String getAccountRole(Integer id);
}
