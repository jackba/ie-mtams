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
    public List<Application> getAppList();
    public void persistApplication(Application app, Quotes quote, List<Accomodationquotes> acc, List<Carquotes> car, List<Flightquotes> flight, Itinerary itin, Travel trav, Travelerprofile prof);
    public Application getApplication(Integer id);
    public List<Accomodationquotes> getAccomodationQuotes(Integer id);
    public List<Carquotes> getCarQuotes(Integer id);
    public List<Flightquotes> getFlightQuotes(Integer id);
    public Itinerary getItinerary(Integer id);
}
