/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Account;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface LoginHandlerLocal {
    public Account authenticate(String username, String password);
    public String getAccountRole(Account acc);
    public void modifyAccount(Account acc);
}
