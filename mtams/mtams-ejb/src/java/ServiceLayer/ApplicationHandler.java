/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccomodationquotesFacadeLocal;
import DataAccess.ApplicationFacadeLocal;
import DataAccess.ApprovalchainFacadeLocal;
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
import Entities.Approvalchain;
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
    private ApprovalchainFacadeLocal apprchainDao;
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
    public List<Application> getAppList(Integer id) {
        List<Application> apps = new ArrayList<Application>();
        List<Application> allApps = appDao.findAll();
        List<Approvalchain> chain = apprchainDao.findAll();

        for (Application each : allApps) {
            if (each.getAccountIdaccount().getIdaccount().equals(id)) {
                for(Approvalchain every : chain){
                    if(every.getApplicationid().equals(each) && every.getApplicationcomplete() == 0){
                        apps.add(each);
                    }
                }
                
            }
        }

        return apps;
    }

    @Override
    public List<Application> getAllAppList(Integer id) {
        return appDao.findAll();
    }

    @Override
    public Application getApplication(Integer id) {
        return appDao.find(id);
    }

    @Override
    public List<Accomodationquotes> getAccomodationQuotes(Integer id) {
        List<Accomodationquotes> all = accDao.findAll();
        List<Accomodationquotes> q = new ArrayList<Accomodationquotes>();

        for (Accomodationquotes each : all) {
            if (each.getQuotesIdquotes().getIdquotes().equals(id)) {
                q.add(each);
            }
        }

        return q;
    }

    @Override
    public List<Carquotes> getCarQuotes(Integer id) {
        List<Carquotes> all = carDao.findAll();
        List<Carquotes> q = new ArrayList<Carquotes>();

        for (Carquotes each : all) {
            if (each.getQuotesIdquotes().getIdquotes().equals(id)) {
                q.add(each);
            }
        }

        return q;

    }

    @Override
    public List<Flightquotes> getFlightQuotes(Integer id) {
        List<Flightquotes> all = flightDao.findAll();
        List<Flightquotes> q = new ArrayList<Flightquotes>();

        for (Flightquotes each : all) {
            if (each.getQuotesIdquotes().getIdquotes().equals(id)) {
                q.add(each);
            }
        }

        return q;
        //return flightDao.findAll();
    }

    @Override
    public List<Itinerary> getItinerary(Integer id) {
        List<Itinerary> list = itinDao.findAll();
        List<Itinerary> temp = new ArrayList<Itinerary>();
        for (Itinerary each : list) {
            if (each.getTravelIdtravel().getIdtravel().equals(id)) {
                temp.add(each);
            }
        }
        return temp;
    }

    @Override
    public Application persistApplication(Application app, Quotes quote, List<Accomodationquotes> acc, List<Carquotes> car, List<Flightquotes> flight, List<Itinerary> itin, Travel trav, Travelerprofile prof) {
        Conference con = new Conference();
        confDao.create(con);

        quoteDao.create(quote);

        List<Quotes> q = quoteDao.findAll();
        for (Quotes each : q) {
            if (each.equals(quote)) {
                quote = each;
            }
        }

        Finalcosting fin = new Finalcosting();
        fin.setQuotesIdquotes(quote);

        Forexorder fx = new Forexorder();
        forDao.create(fx);

        Motivation mot = new Motivation();
        motDao.create(mot);

        List<Motivation> m = motDao.findAll();
        for (Motivation each : m) {
            if (each.equals(mot)) {
                mot = each;
            }
        }

        List<Forexorder> x = forDao.findAll();
        for (Forexorder each : x) {
            if (each.equals(fx)) {
                fx = each;
            }
        }

        finDao.create(fin);
        List<Finalcosting> f = finDao.findAll();

        for (Finalcosting each : f) {
            if (each.equals(fin)) {
                fin = each;
            }
        }

        List<Conference> c = confDao.findAll();
        for (Conference each : c) {
            if (each.equals(con)) {
                con = each;
            }
        }
        //con = confDao.find(con.getIdconference());

        trav.setConferenceIdconference(con);

        travDao.create(trav);

        List<Travel> l = travDao.findAll();
        for (Travel each : l) {
            if (each.equals(trav)) {
                trav = each;
            }
        }

        for(Itinerary each: itin){
            each.setTravelIdtravel(trav);
            itinDao.create(each);
        }
        
        
        //quote = quoteDao.find(quote.getIdquotes());

        for (Accomodationquotes each : acc) {
            each.setQuotesIdquotes(quote);
            accDao.create(each);
        }

        for (Carquotes each : car) {
            each.setQuotesIdquotes(quote);
            carDao.create(each);
        }

        for (Flightquotes each : flight) {
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

        List<Application> allApps = appDao.findAll();
        Application returned = null;
        int max = 0;
        for (Application each : allApps) {
            if (each.getIdapplication().intValue() >= max) {
                returned = each;
            }
        }
        return returned;
        
    }

    @Override
    public void persistApplicationEdit(Application app, Quotes quote, Itinerary itin, Travel trav) {
        quoteDao.edit(quote);
        travDao.edit(trav);
        itinDao.edit(itin);
        appDao.edit(app);
    }

    @Override
    public void selectQuotes(Accomodationquotes acc, Carquotes car, Flightquotes flg) {
        accDao.edit(acc);
        carDao.edit(car);
        flightDao.edit(flg);
    }

    @Override
    public boolean getApplicationReady(Integer id) {
        Application app = appDao.find(id);
        
        if(app != null && app.getMotivationcomplete() == 1){
            return true;
        }else{
            return false;
        }
    }
    
    
}
