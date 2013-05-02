/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Application;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Michelle Thornton
 */
@Stateless
public class ApplicationFacade extends AbstractFacade<Application> implements ApplicationFacadeLocal {
    @PersistenceContext(unitName = "MotivationForm-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApplicationFacade() {
        super(Application.class);
    }
    
}
