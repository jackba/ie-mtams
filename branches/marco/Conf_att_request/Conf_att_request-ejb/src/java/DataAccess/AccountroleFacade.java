/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Accountrole;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marco Remane
 */
@Stateless
public class AccountroleFacade extends AbstractFacade<Accountrole> implements AccountroleFacadeLocal {
    @PersistenceContext(unitName = "Conf_att_request-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountroleFacade() {
        super(Accountrole.class);
    }
    
}
