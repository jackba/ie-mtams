/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Travelerprofile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Badger
 */
@Stateless
public class TravelerprofileFacade extends AbstractFacade<Travelerprofile> implements TravelerprofileFacadeLocal {
    @PersistenceContext(unitName = "mtams2.2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TravelerprofileFacade() {
        super(Travelerprofile.class);
    }
    
}
