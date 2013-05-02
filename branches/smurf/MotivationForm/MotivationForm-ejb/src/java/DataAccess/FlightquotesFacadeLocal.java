/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Flightquotes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Michelle Thornton
 */
@Local
public interface FlightquotesFacadeLocal {

    void create(Flightquotes flightquotes);

    void edit(Flightquotes flightquotes);

    void remove(Flightquotes flightquotes);

    Flightquotes find(Object id);

    List<Flightquotes> findAll();

    List<Flightquotes> findRange(int[] range);

    int count();
    
}
