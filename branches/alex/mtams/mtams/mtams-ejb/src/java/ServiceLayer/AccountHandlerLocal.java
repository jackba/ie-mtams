/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Account;
import Entities.Accountrole;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface AccountHandlerLocal {
    public void registerNewAccount(Account newAccount,int role);
    public void registerNewAccountDiv(Account newAccount,int role, String department);
    public Accountrole assignId(Account newAccount, int role);
    public boolean checkUsername(String username);
    public void deactivateAccount(Account selAcc);
    public List<Account> getAllAccounts();

}
