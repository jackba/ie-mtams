/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Countrylookup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Michelle Thornton
 */
@Stateless
public class CountrylookupFacade extends AbstractFacade<Countrylookup> implements CountrylookupFacadeLocal {
    @PersistenceContext(unitName = "MotivationForm-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountrylookupFacade() {
        super(Countrylookup.class);
    }
    
}
