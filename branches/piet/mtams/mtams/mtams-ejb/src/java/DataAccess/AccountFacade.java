/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Badger
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {
    @PersistenceContext(unitName = "mtams-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    
}
