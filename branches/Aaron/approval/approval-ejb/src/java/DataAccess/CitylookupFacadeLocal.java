/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Citylookup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aaron
 */
@Local
public interface CitylookupFacadeLocal {

    void create(Citylookup citylookup);

    void edit(Citylookup citylookup);

    void remove(Citylookup citylookup);

    Citylookup find(Object id);

    List<Citylookup> findAll();

    List<Citylookup> findRange(int[] range);

    int count();
    
}
