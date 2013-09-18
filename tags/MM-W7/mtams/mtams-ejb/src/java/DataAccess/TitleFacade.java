/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Title;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aaron
 */
@Stateless
public class TitleFacade extends AbstractFacade<Title> implements TitleFacadeLocal {
    @PersistenceContext(unitName = "mtams-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TitleFacade() {
        super(Title.class);
    }
    
}
