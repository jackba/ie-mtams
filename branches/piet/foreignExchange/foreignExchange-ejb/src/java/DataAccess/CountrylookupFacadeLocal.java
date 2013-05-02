/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Countrylookup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
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
