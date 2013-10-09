/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Accomodationquotes;
import Entities.Application;
import Entities.Carquotes;
import Entities.Flightquotes;
import Entities.Itinerary;
import Entities.Quotes;
import Entities.Travel;
import Entities.Travelerprofile;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface ApplicationHandlerLocal {

    public List<Application> getAppList(Integer id);

    public List<Application> getAllAppList(Integer id);

    public Application persistApplication(Application app, Quotes quote, List<Accomodationquotes> acc, List<Carquotes> car, List<Flightquotes> flight, Itinerary itin, Travel trav, Travelerprofile prof);

    public void selectQuotes(Accomodationquotes acc, Carquotes car, Flightquotes flg);

    public Application getApplication(Integer id);

    public List<Accomodationquotes> getAccomodationQuotes(Integer id);

    public List<Carquotes> getCarQuotes(Integer id);

    public List<Flightquotes> getFlightQuotes(Integer id);

    public Itinerary getItinerary(Integer id);

    public void persistApplicationEdit(Application app, Quotes quote, Itinerary itin, Travel trav);
    
    public boolean getApplicationReady(Integer id);
}
