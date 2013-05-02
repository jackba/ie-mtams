/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Citylookup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Michelle Thornton
 */
@Stateless
public class CitylookupFacade extends AbstractFacade<Citylookup> implements CitylookupFacadeLocal {
    @PersistenceContext(unitName = "MotivationForm-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitylookupFacade() {
        super(Citylookup.class);
    }
    
}
