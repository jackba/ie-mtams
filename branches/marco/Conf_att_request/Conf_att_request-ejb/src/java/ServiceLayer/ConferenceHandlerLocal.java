/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Conference;
import Entities.Travelerprofile;
import javax.ejb.Local;

/**
 *
 * @author Marco Remane
 */
@Local
public interface ConferenceHandlerLocal {
    public void persist(Conference conference);
    public Travelerprofile findTravelerProfile(Integer id);
    public Conference findForX(Integer id);
    public void updateConf(Conference c, Integer id);
}
