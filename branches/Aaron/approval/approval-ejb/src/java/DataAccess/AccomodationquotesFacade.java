/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Accomodationquotes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aaron
 */
@Stateless
public class AccomodationquotesFacade extends AbstractFacade<Accomodationquotes> implements AccomodationquotesFacadeLocal {
    @PersistenceContext(unitName = "approval-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccomodationquotesFacade() {
        super(Accomodationquotes.class);
    }
    
}
