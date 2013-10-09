/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Forexorder;
import Entities.Itinerary;
import Entities.Travel;
import Entities.Traveldocument;
import Entities.Travelerprofile;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface ForexHandlerLocal {

    public Itinerary findItinerary(Integer id);

    public Travelerprofile find(Integer id);

    public Traveldocument findDocument(Integer id);
    //public void createForX(Forexorder forerorder, Integer id);

    public Forexorder findForX(Integer id , Integer appID);

    public void updateForex(Forexorder forexorder, Integer id ,Integer appid);

    public Travel findTravel(Integer id);
}
