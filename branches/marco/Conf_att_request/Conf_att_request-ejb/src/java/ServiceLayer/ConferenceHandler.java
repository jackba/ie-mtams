/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.ConferenceFacadeLocal;
import DataAccess.TravelerprofileFacadeLocal;
import Entities.Account;
import Entities.Conference;
import Entities.Travelerprofile;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco Remane
 */
@Stateless
public class ConferenceHandler implements ConferenceHandlerLocal {
    @EJB
    private AccountFacadeLocal accountDA;

    @EJB
    private TravelerprofileFacadeLocal travelerDA;
    @EJB
    private ConferenceFacadeLocal dao;

    @Override
    public void persist(Conference conference) {
        dao.create(conference);
    }

    @Override
    public Travelerprofile findTravelerProfile(Integer id) {
        Account acc = accountDA.find(id);
        List<Travelerprofile> all = travelerDA.findAll();
        for (Travelerprofile each : all) {
            if (each.getAccountid().getIdaccount().equals(id)) {
                System.out.println(each.getAircon());
                return each;
            }
        }
        return null;
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
