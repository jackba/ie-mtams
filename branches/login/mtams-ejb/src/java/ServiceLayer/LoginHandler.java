/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountsFacadeLocal;
import DataAccess.RolesFacadeLocal;
import Entities.Accounts;
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
    private AccountsFacadeLocal accDao;
    @EJB
    private RolesFacadeLocal roleDao;
    
    @Override
    public Accounts authenticate(String username, String password) {
        List<Accounts> accounts = accDao.findAll();
        
        for(Accounts each:accounts){
            if(username.equalsIgnoreCase(each.getUsername()) && password.equalsIgnoreCase(each.getPassword())){
                return each;
            }
        }
        return null;
    }

    @Override
    public String getAccountRole(Integer id) {
       return roleDao.find(id).getRole();
    }

}
