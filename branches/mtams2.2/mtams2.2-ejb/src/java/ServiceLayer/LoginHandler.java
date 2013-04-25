/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.RolesFacadeLocal;
import Entities.Account;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Badger
 */
@Stateless
public class LoginHandler implements LoginHandlerLocal {

    @EJB
    private AccountFacadeLocal accDao;
    @EJB
    private RolesFacadeLocal roleDao;
    
    @Override
    public Account authenticate(String username, String password) {
        List<Account> accounts = accDao.findAll();
        
        for(Account each:accounts){
            if(username.equalsIgnoreCase(each.getUsername()) && password.equalsIgnoreCase(each.getPassword())){
                return each;
            }
        }
        return null;
    }
    
        @Override
    public String getAccountRole(Integer id) {
            return roleDao.find(id).getRoleName();
    }
}
