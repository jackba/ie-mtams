/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.City;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aaron
 */
@Local
public interface CityFacadeLocal {

    void create(City city);

    void edit(City city);

    void remove(City city);

    City find(Object id);

    List<City> findAll();

    List<City> findRange(int[] range);

    int count();
    
}
