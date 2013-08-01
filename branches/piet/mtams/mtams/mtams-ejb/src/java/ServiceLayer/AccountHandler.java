/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.AccountroleFacadeLocal;
import DataAccess.RoleFacadeLocal;
import Entities.Account;
import Entities.Accountrole;
import Entities.Role;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Badger
 */
@Stateless
public class AccountHandler implements AccountHandlerLocal {

    @EJB
    private AccountFacadeLocal accDao;
    @EJB
    private AccountroleFacadeLocal accRoleDao;
    @EJB
    private RoleFacadeLocal roleDao;
    
    @Override
    public void registerNewAccount(Account newAccount, int role){
        
        accDao.create(newAccount);
        
        List<Account> allAccounts = accDao.findAll();
        for(Account each: allAccounts){
            if(each.equals(newAccount))
                newAccount = each;
        }
        
        accRoleDao.create(assignId(newAccount, role));
    }

    @Override
    public Accountrole assignId(Account newAccount, int role) {
        Role getRole = roleDao.find(role);
        Accountrole newAccRole = new Accountrole();
        newAccRole.setAccountid(newAccount);
        newAccRole.setRoleid(getRole);
        
        return newAccRole;
    }

    @Override
    public boolean checkUsername(String username) {
        boolean found = false;
        List<Account> accounts = accDao.findAll();
        
        for(Account each:accounts){
            if(each.getUsername().equalsIgnoreCase(username)){
                found = true;
            }
        }
        
       return found;
    }
    
    @Override
    public List<Account> getAllAccounts(){
        return accDao.findAll();
    }
    


    
}
