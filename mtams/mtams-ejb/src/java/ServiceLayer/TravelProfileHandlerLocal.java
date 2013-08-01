/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Rewardsprogram;
import Entities.Traveldocument;
import Entities.Travelerprofile;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sparda
 */
@Local
public interface TravelProfileHandlerLocal {

    public void persist(Integer id, Travelerprofile profile, Traveldocument passport);
    public void persistProfileEdit(Travelerprofile profile, int accountID);
    public void persistReward(Rewardsprogram reward);
    public Travelerprofile findTravelProf(Integer id);
    public Traveldocument findTravelDoc(Integer id);
    public List<Rewardsprogram> findRewards(Integer id);
    
}
