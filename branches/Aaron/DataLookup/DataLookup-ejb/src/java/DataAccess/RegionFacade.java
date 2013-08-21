/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Region;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aaron
 */
@Stateless
public class RegionFacade extends AbstractFacade<Region> implements RegionFacadeLocal {
    @PersistenceContext(unitName = "DataLookup-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionFacade() {
        super(Region.class);
    }
    
}
