/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.AccountroleFacadeLocal;
import Entities.Account;
import Entities.Accountrole;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Badger
 */
@Stateful
public class LoginHandler implements LoginHandlerLocal {

    @EJB
    private AccountFacadeLocal accDao;
    @EJB
    private AccountroleFacadeLocal accRoleDao;

    @Override
    public Account authenticate(String username, String password) {
        List<Account> accounts = accDao.findAll();

        for (Account each : accounts) {
            if (username.equals(each.getUsername()) && password.equals(each.getPassword())){
                return each;
            }
        }
        return null;
    }

    @Override
    public Integer getAccountRole(Account acc) {
        List<Accountrole> all = accRoleDao.findAll();
        for (Accountrole each : all) {
            if (each.getAccountid().equals(acc)) {
                return each.getRoleid().getIdroles();
            }
        }
        return null;
    }

    @Override
    public void modifyAccount(Account acc) {
        accDao.edit(acc);
    }

    @Override
    public String getSalt(String username) {

        List<Account> all = accDao.findAll();

        for (Account each : all) {
            if (each.getUsername().equalsIgnoreCase(username)) {
                return each.getSalt();
            }
        }

        return null;
    }
}
