/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Forexorder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aaron
 */
@Stateless
public class ForexorderFacade extends AbstractFacade<Forexorder> implements ForexorderFacadeLocal {
    @PersistenceContext(unitName = "approval-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ForexorderFacade() {
        super(Forexorder.class);
    }
    
}
