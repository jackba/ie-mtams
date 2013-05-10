/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Countrylookup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco Remane
 */
@Local
public interface CountrylookupFacadeLocal {

    void create(Countrylookup countrylookup);

    void edit(Countrylookup countrylookup);

    void remove(Countrylookup countrylookup);

    Countrylookup find(Object id);

    List<Countrylookup> findAll();

    List<Countrylookup> findRange(int[] range);

    int count();
    
}
