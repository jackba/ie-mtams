/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.ApplicationFacadeLocal;
import DataAccess.ForexorderFacadeLocal;
import DataAccess.ItineraryFacadeLocal;
import DataAccess.TravelFacadeLocal;
import DataAccess.TraveldocumentFacadeLocal;
import DataAccess.TravelerprofileFacadeLocal;
import Entities.Account;
import Entities.Application;
import Entities.Forexorder;
import Entities.Itinerary;
import Entities.Travel;
import Entities.Traveldocument;
import Entities.Travelerprofile;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Riaan
 */
@Stateless
public class ForexHandler implements ForexHandlerLocal {

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
    public void updateForex(Forexorder forexorder, Integer id ,Integer appid) {
        Integer forexID = null;
        Forexorder forexformNew = forexorder;
        Forexorder forexformOld;
        List<Application> allApp = appf.findAll();
                
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) 
            {                
                if(eachApp.getIdapplication().equals(appid))
                {
                    eachApp.setForexcomplete(1);
                    forexID = eachApp.getForexorderIdforexorder().getIdforexorder();
                }                
            }
        }

        List<Forexorder> allForex = forex.findAll();
        for (Forexorder foundForexForm : allForex) {

            if (foundForexForm.getIdforexorder().equals(forexID)) {

                forexformOld = foundForexForm;
                forexformNew.setIdforexorder(forexformOld.getIdforexorder());
                forex.edit(forexformNew);
            }
        }
    }

    @Override
    public Itinerary findItinerary(Integer id) // passing in the Account ID
    {
        Integer travelId = null;
        Itinerary itinerary = null;

        List<Application> allApp = appf.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                travelId = eachApp.getTravelIdtravel().getIdtravel();
            }
        }
        List<Itinerary> allIti = ifl.findAll();
        for (Itinerary each : allIti) {
            if (each.getTravelIdtravel().getIdtravel().equals(travelId)) {
                itinerary = each;
            }
        }
        return itinerary;
    }

    @Override
    public Travel findTravel(Integer id) // passing in the Account ID
    {
        Integer travelId = null;
        Travel travel = null;

        List<Application> allApp = appf.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                travelId = eachApp.getTravelIdtravel().getIdtravel();
            }
        }

        List<Travel> allTra = tfl.findAll();
        for (Travel each : allTra) {
            if (each.getIdtravel().equals(travelId)) {
                travel = each;
            }
        }
        return travel;
    }

    @Override
    public Forexorder findForX(Integer id , Integer appID) //passing in the AccountID
    {
        Integer forexID = null;
        Forexorder forexform = null;
        List<Application> allApp = appf.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                if(eachApp.getIdapplication().equals(appID))
                {
                    forexID = eachApp.getForexorderIdforexorder().getIdforexorder();
                }                
            }
        }

        List<Forexorder> allForex = forex.findAll();
        for (Forexorder eachFor : allForex) {
            if (eachFor.getIdforexorder().equals(forexID)) {
                forexform = eachFor;
            }
        }
        return forexform;
    }

    @Override
    public Travelerprofile find(Integer id) {
        Account acc = afl.find(id);
        List<Travelerprofile> all = tpf.findAll();
        for (Travelerprofile each : all) {
            if (each.getAccountid().getIdaccount().equals(id)) {
                return each;

            }
        }
        return null;
    }

    @Override
    public Traveldocument findDocument(Integer id) {
        Travelerprofile ttf = tpf.find(id);
        List<Traveldocument> all = tdocf.findAll();
        for (Traveldocument each : all) {
            if (each.getTravlerprofileIdtravlerprofile().getIdtravelerprofile().equals(id)) {
                return each;
            }
        }
        return null;
    }
    /*
     @Override
     public void createForX(Forexorder forerorder, Integer id)
     {
     Integer forexID = null;
     Forexorder forexformNew = forerorder;
     Forexorder forexformOld = null;
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
     forexformOld = eachFor;
     forexformNew.setIdforexorder(forexformOld.getIdforexorder());
     forex.edit(forexformNew);              
     }          
   
         
         
         
         
     //forex.create(forerorder);
     } */
}
