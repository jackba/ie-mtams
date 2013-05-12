/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccomodationquotesFacadeLocal;
import DataAccess.ApplicationFacadeLocal;
import DataAccess.CarquotesFacadeLocal;
import DataAccess.ConferenceFacadeLocal;
import DataAccess.FinalcostingFacadeLocal;
import DataAccess.FlightquotesFacadeLocal;
import DataAccess.ForexorderFacadeLocal;
import DataAccess.ItineraryFacadeLocal;
import DataAccess.MotivationFacadeLocal;
import DataAccess.QuotesFacadeLocal;
import DataAccess.TravelFacadeLocal;
import Entities.Accomodationquotes;
import Entities.Application;
import Entities.Carquotes;
import Entities.Conference;
import Entities.Finalcosting;
import Entities.Flightquotes;
import Entities.Forexorder;
import Entities.Itinerary;
import Entities.Motivation;
import Entities.Quotes;
import Entities.Travel;
import Entities.Travelerprofile;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Badger
 */
@Stateless
public class ApplicationHandler implements ApplicationHandlerLocal {

    @EJB
    private ApplicationFacadeLocal appDao;
    @EJB
    private AccomodationquotesFacadeLocal accDao;
    @EJB
    private CarquotesFacadeLocal carDao;
    @EJB
    private FlightquotesFacadeLocal flightDao;
    @EJB
    private ItineraryFacadeLocal itinDao;
    @EJB
    private QuotesFacadeLocal quoteDao;
    @EJB
    private TravelFacadeLocal travDao;
    @EJB
    private ConferenceFacadeLocal confDao;
    @EJB
    private FinalcostingFacadeLocal finDao;
    @EJB
    private ForexorderFacadeLocal forDao;
    @EJB
    private MotivationFacadeLocal motDao;
    
    
    @Override
    public List<Application> getAppList(){
        return appDao.findAll();
    }
    
    @Override
    public Application getApplication(Integer id){
        return appDao.find(id);
    }
    
    @Override
    public List<Accomodationquotes> getAccomodationQuotes(Integer id){
        List<Accomodationquotes> all = accDao.findAll();
        List<Accomodationquotes> q = new ArrayList<Accomodationquotes>();
        
        for(Accomodationquotes each: all){
            if(each.getQuotesIdquotes().getIdquotes().equals(id))
                q.add(each);
        }
        
        return q;
    }
    
    @Override
    public List<Carquotes> getCarQuotes(Integer id){
        List<Carquotes> all = carDao.findAll();
        List<Carquotes> q = new ArrayList<Carquotes>();
        
        for(Carquotes each: all){
            if(each.getQuotesIdquotes().getIdquotes().equals(id))
                q.add(each);
        }
        
        return q;
        
    }
    
    @Override
    public List<Flightquotes> getFlightQuotes(Integer id){
        List<Flightquotes> all = flightDao.findAll();
        List<Flightquotes> q = new ArrayList<Flightquotes>();
        
        for(Flightquotes each: all){
            if(each.getQuotesIdquotes().getIdquotes().equals(id))
                q.add(each);
        }
        
        return q;
        //return flightDao.findAll();
    }
    
    @Override
    public Itinerary getItinerary(Integer id){
        List<Itinerary> list = itinDao.findAll();
        for(Itinerary each: list){
            if(each.getTravelIdtravel().getIdtravel().equals(id))
                return each;
        }
        return null;
    }
    
    @Override
    public void persistApplication(Application app, Quotes quote, List<Accomodationquotes> acc, List<Carquotes> car, List<Flightquotes> flight, Itinerary itin, Travel trav, Travelerprofile prof){
        Conference con = new Conference();
        confDao.create(con);
        
        quoteDao.create(quote);
        
        List<Quotes> q = quoteDao.findAll();
        for(Quotes each:q){
            if(each.equals(quote))
                quote = each;
        }
        
        Finalcosting fin = new Finalcosting();
        fin.setQuotesIdquotes(quote);
        
        Forexorder fx = new Forexorder();
        forDao.create(fx);
        
        Motivation mot = new Motivation();
        motDao.create(mot);
        
        List<Motivation> m = motDao.findAll();
        for(Motivation each:m){
            if(each.equals(mot))
                mot = each;
        }
        
        List<Forexorder> x = forDao.findAll();
        for(Forexorder each: x){
            if(each.equals(fx))
                fx = each;
        }
        
        finDao.create(fin);
        List<Finalcosting> f = finDao.findAll();
        
        for(Finalcosting each: f){
            if(each.equals(fin))
                fin = each;
        }
        
        List<Conference> c = confDao.findAll();
        for(Conference each:c){
            if(each.equals(con)){
                con = each;
            }
        }
        //con = confDao.find(con.getIdconference());
        
        trav.setConferenceIdconference(con);
        
        travDao.create(trav);
        
        List<Travel> l = travDao.findAll();
        for(Travel each:l){
            if(each.equals(trav))
                trav = each;
        }
        
        
        itin.setTravelIdtravel(trav);
        
        itinDao.create(itin);
        //quote = quoteDao.find(quote.getIdquotes());
        
        for(Accomodationquotes each:acc){
            each.setQuotesIdquotes(quote);
            accDao.create(each);
        }
        
        for(Carquotes each:car){
            each.setQuotesIdquotes(quote);
            carDao.create(each);
        }
        
        for(Flightquotes each: flight){
            each.setQuotesIdquotes(quote);
            flightDao.create(each);
        }
        
        
        app.setQuotesIdquotes(quote);
        app.setTravelIdtravel(trav);
        app.setFinalcostingIdfinalcosting(fin);
        app.setForexorderIdforexorder(fx);
        app.setMotivationIdmotivation(mot);
        app.setAccountIdaccount(prof.getAccountid());
        appDao.create(app);
        
    }
}
