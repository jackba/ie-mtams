/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Account;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface AccountHandlerLocal {
    public void registerNewAccount(Account newAccount);
    public void assignId(Account newAccount);
    public boolean checkUsername(String username);
    public List<Account> getAllAccounts();
}
