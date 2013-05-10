/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Account;
import Entity.Forexorder;
import Entity.Itinerary;
import Entity.Traveldocument;
import Entity.Travelerprofile;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface clientServer 
{
    public Itinerary findItinerary(Integer id);
    public Travelerprofile find(Integer id);
    public Traveldocument findDocument(Integer id);
    //public void createForX(Forexorder forerorder, Integer id);
    public Forexorder findForX(Integer id);
    public void updateForex(Forexorder forexorder, Integer id);
}
