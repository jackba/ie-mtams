/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Flightquotes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Riaan
 */
@Stateless
public class FlightquotesFacade extends AbstractFacade<Flightquotes> implements FlightquotesFacadeLocal {
    @PersistenceContext(unitName = "foreignExchange-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FlightquotesFacade() {
        super(Flightquotes.class);
    }
    
}
