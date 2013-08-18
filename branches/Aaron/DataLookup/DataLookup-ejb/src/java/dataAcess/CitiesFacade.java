/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAcess;

import entities.Cities;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aaron
 */
@Stateless
public class CitiesFacade extends AbstractFacade<Cities> implements CitiesFacadeLocal {
    @PersistenceContext(unitName = "DataLookup-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitiesFacade() {
        super(Cities.class);
    }
    
}
