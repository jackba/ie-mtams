/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Quotes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Badger
 */
@Stateless
public class QuotesFacade extends AbstractFacade<Quotes> implements QuotesFacadeLocal {
    @PersistenceContext(unitName = "mtams2.2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuotesFacade() {
        super(Quotes.class);
    }
    
}
