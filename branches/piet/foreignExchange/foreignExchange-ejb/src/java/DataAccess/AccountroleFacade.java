/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Accountrole;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Riaan
 */
@Stateless
public class AccountroleFacade extends AbstractFacade<Accountrole> implements AccountroleFacadeLocal {
    @PersistenceContext(unitName = "foreignExchange-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountroleFacade() {
        super(Accountrole.class);
    }
    
}
