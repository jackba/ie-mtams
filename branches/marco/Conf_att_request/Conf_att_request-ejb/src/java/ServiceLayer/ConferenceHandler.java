/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.ConferenceFacadeLocal;
import Entities.Conference;
import Entities.Travelerprofile;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco Remane
 */
@Stateless
public class ConferenceHandler implements ConferenceHandlerLocal {
    
    @EJB
    private ConferenceFacadeLocal dao;
    
    @Override
    public void persist(Conference conference) {
        dao.create(conference);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Travelerprofile find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conference findForX(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateConf(Conference c, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
