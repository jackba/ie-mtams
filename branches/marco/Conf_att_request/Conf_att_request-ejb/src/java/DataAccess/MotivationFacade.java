/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Motivation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marco Remane
 */
@Stateless
public class MotivationFacade extends AbstractFacade<Motivation> implements MotivationFacadeLocal {
    @PersistenceContext(unitName = "Conf_att_request-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotivationFacade() {
        super(Motivation.class);
    }
    
}
