/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Personal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marco Remane
 */
@Stateless
public class PersonalFacade extends AbstractFacade<Personal> implements PersonalFacadeLocal {
    @PersistenceContext(unitName = "Conf_att_request-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalFacade() {
        super(Personal.class);
    }
    
}
