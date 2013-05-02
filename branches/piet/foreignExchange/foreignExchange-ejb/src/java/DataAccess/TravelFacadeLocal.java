/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Travel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface TravelFacadeLocal {

    void create(Travel travel);

    void edit(Travel travel);

    void remove(Travel travel);

    Travel find(Object id);

    List<Travel> findAll();

    List<Travel> findRange(int[] range);

    int count();
    
}
