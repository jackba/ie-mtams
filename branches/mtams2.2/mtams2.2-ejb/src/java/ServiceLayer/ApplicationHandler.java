/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccomodationquotesFacadeLocal;
import DataAccess.ApplicationFacadeLocal;
import DataAccess.CarquotesFacadeLocal;
import DataAccess.ConferenceFacadeLocal;
import DataAccess.FlightquotesFacadeLocal;
import DataAccess.ItineraryFacadeLocal;
import DataAccess.QuotesFacadeLocal;
import DataAccess.TravelFacadeLocal;
import Entities.Accomodationquotes;
import Entities.Application;
import Entities.Carquotes;
import Entities.Conference;
import Entities.Flightquotes;
import Entities.Itinerary;
import Entities.Quotes;
import Entities.Travel;
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
    
    @Override
    public List<Application> getAppList(){
        return appDao.findAll();
    }
    
    @Override
    public void persistApplication(Application app, Quotes quote, List<Accomodationquotes> acc, List<Carquotes> car, List<Flightquotes> flight, Itinerary itin, Travel trav){
        Conference con = new Conference();
        confDao.create(con);
        con = confDao.find(con);
        
        trav.setConferenceIdconference(con);
        
        travDao.create(trav);
        
        trav = travDao.find(trav);
        
        itin.setTravelIdtravel(trav);
        
        
        
        app.setTravelIdtravel(trav);
        
        
        
        
    }
}
