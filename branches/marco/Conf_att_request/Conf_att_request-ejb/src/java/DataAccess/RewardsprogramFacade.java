/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Rewardsprogram;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marco Remane
 */
@Stateless
public class RewardsprogramFacade extends AbstractFacade<Rewardsprogram> implements RewardsprogramFacadeLocal {
    @PersistenceContext(unitName = "Conf_att_request-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RewardsprogramFacade() {
        super(Rewardsprogram.class);
    }
    
}
