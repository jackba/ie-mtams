/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Session;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Riaan
 */
@Stateless
public class SessionFacade extends AbstractFacade<Session> implements SessionFacadeLocal {
    @PersistenceContext(unitName = "foreignExchange-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SessionFacade() {
        super(Session.class);
    }
    
}
