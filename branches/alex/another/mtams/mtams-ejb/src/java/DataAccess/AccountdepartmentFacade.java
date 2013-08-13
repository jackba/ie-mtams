/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Accountdepartment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sparda
 */
@Stateless
public class AccountdepartmentFacade extends AbstractFacade<Accountdepartment> implements AccountdepartmentFacadeLocal {
    @PersistenceContext(unitName = "mtams-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountdepartmentFacade() {
        super(Accountdepartment.class);
    }
    
}
