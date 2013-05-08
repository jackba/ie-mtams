/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Travel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aaron
 */
@Stateless
public class TravelFacade extends AbstractFacade<Travel> implements TravelFacadeLocal {
    @PersistenceContext(unitName = "approval-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TravelFacade() {
        super(Travel.class);
    }
    
}
