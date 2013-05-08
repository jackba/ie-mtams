/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Conference;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aaron
 */
@Stateless
public class ConferenceFacade extends AbstractFacade<Conference> implements ConferenceFacadeLocal {
    @PersistenceContext(unitName = "approval-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConferenceFacade() {
        super(Conference.class);
    }
    
}
