/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Account;
import Entities.Accountrole;
import Entities.Stage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface AccountHandlerLocal {

    public void registerNewAccount(Account newAccount, int role , int departmentRole, int accountID);

    public void registerNewAccountDiv(Account newAccount, int role, String department);

    public Accountrole assignId(Account newAccount, int role);

    public boolean checkUsername(String username);

    public void deactivateAccount(Account selAcc);
    
    public void reactivateAccount(Account selAcc);

    public List<Account> getAllAccounts(String userName);

    public List<Account> getAllAdmins();

    public void editAdminPersist(Account admin);

    public Account getAccount(Integer id);
    
    public Account findSpecificAccount(String userName); 
    
    public List<Account> getAllActiveAccounts(String userName);
    
    public List<Account> getAllInactiveAccounts(String userName);
    
    public List<Account> getAllDepartmentAccounts(Integer id);
    
    public List<Stage> getAllStages();
}
