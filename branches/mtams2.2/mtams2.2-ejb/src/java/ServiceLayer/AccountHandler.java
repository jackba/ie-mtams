/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import Entities.Account;
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
    
    @Override
    public void registerNewAccount(Account newAccount){
        assignId(newAccount);
        accDao.create(newAccount);
    }

    @Override
    public void assignId(Account newAccount) {
        List<Account> accounts = accDao.findAll();
        int numId = 1001;
        for(Account each:accounts){
            if(each.getIdAccount().intValue() == numId){
                numId++;
            }
        }
        newAccount.setIdAccount(numId);
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
