/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Accomodationquotes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Riaan
 */
@Stateless
public class AccomodationquotesFacade extends AbstractFacade<Accomodationquotes> implements AccomodationquotesFacadeLocal {
    @PersistenceContext(unitName = "foreignExchange-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccomodationquotesFacade() {
        super(Accomodationquotes.class);
    }
    
}
