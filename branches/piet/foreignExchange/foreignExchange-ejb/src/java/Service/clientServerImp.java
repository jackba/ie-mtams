/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataAccess.AccountFacadeLocal;
import DataAccess.ApplicationFacadeLocal;
import DataAccess.ForexorderFacadeLocal;
import DataAccess.ItineraryFacadeLocal;
import DataAccess.TravelFacadeLocal;
import DataAccess.TraveldocumentFacadeLocal;
import DataAccess.TravelerprofileFacadeLocal;
import Entity.Account;
import Entity.Application;
import Entity.Forexorder;
import Entity.Itinerary;
import Entity.Travel;
import Entity.Traveldocument;
import Entity.Travelerprofile;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Riaan
 */
@Stateless
public class clientServerImp implements clientServer
{
    @EJB    
    private AccountFacadeLocal afl;
    @EJB
    private TravelerprofileFacadeLocal tpf;
    @EJB
    private TraveldocumentFacadeLocal tdocf;
    @EJB
    private ForexorderFacadeLocal forex;
    @EJB
    private ApplicationFacadeLocal appf;
    @EJB
    private ItineraryFacadeLocal ifl;
    @EJB
    private TravelFacadeLocal tfl;
    
    
    @Override
    public Itinerary findItinerary(Integer id) // passing in the Account ID
    {
        Integer travelId = null;
        Itinerary itinerary = null;
        
        List<Application> allApp = appf.findAll();
        for(Application eachApp : allApp)
        {
            if(eachApp.getAccountIdaccount().getIdaccount().equals(id))
            {  
                travelId = eachApp.getTravelIdtravel().getIdtravel();
            }
        }
        List<Itinerary> allIti = ifl.findAll();
        for(Itinerary each : allIti)
        {
            if(each.getTravelIdtravel().getIdtravel().equals(travelId))
            {
                itinerary = each; 
            }
        }
        return itinerary;
    }
    
    @Override
    public Forexorder findForX(Integer id) //passing in the AccountID
    {
        Integer forexID = null;
        Forexorder forexform = null;
        List<Application> allApp = appf.findAll();
        for(Application eachApp : allApp)
        {
            if(eachApp.getAccountIdaccount().getIdaccount().equals(id))
            {  
                forexID = eachApp.getForexorderIdforexorder().getIdforexorder();
            }
        }
        
        List<Forexorder> allForex = forex.findAll();
        for(Forexorder eachFor : allForex)
        {
            if(eachFor.getIdforexorder().equals(forexID))
                forexform = eachFor;
        }
        return forexform;
    }
    
     @Override
     public Travelerprofile find(Integer id)
     {
        Account acc = afl.find(id);
        List<Travelerprofile> all = tpf.findAll();
        for(Travelerprofile each : all)
        {
            if(each.getAccountid().getIdaccount().equals(id))
            {
                return each;
                
            }
        }
        return null;
     }
     
     @Override
     public Traveldocument findDocument(Integer id)
     {
         Travelerprofile ttf = tpf.find(id);
         List<Traveldocument> all = tdocf.findAll();
         for(Traveldocument each : all)
         {
             if(each.getTravlerprofileIdtravlerprofile().getIdtravelerprofile().equals(id))
                 return each;
         }
         return null;
     }
     
     
     
     @Override
     public void createForX(Forexorder forerorder)
     {
         forex.create(forerorder);
     }
}
