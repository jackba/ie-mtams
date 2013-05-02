/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Itinerary;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Michelle Thornton
 */
@Stateless
public class ItineraryFacade extends AbstractFacade<Itinerary> implements ItineraryFacadeLocal {
    @PersistenceContext(unitName = "MotivationForm-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItineraryFacade() {
        super(Itinerary.class);
    }
    
}
