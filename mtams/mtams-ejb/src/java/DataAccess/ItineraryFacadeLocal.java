/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Itinerary;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface ItineraryFacadeLocal {

    void create(Itinerary itinerary);

    void edit(Itinerary itinerary);

    void remove(Itinerary itinerary);

    Itinerary find(Object id);

    List<Itinerary> findAll();

    List<Itinerary> findRange(int[] range);

    int count();
    
}
