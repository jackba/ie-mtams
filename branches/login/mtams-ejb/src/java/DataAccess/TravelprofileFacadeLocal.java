/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Travelprofile;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface TravelprofileFacadeLocal {

    void create(Travelprofile travelprofile);

    void edit(Travelprofile travelprofile);

    void remove(Travelprofile travelprofile);

    Travelprofile find(Object id);

    List<Travelprofile> findAll();

    List<Travelprofile> findRange(int[] range);

    int count();
    
}
