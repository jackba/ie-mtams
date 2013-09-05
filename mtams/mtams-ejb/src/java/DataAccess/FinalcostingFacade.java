/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Finalcosting;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aaron
 */
@Stateless
public class FinalcostingFacade extends AbstractFacade<Finalcosting> implements FinalcostingFacadeLocal {
    @PersistenceContext(unitName = "mtams-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FinalcostingFacade() {
        super(Finalcosting.class);
    }
    
}
