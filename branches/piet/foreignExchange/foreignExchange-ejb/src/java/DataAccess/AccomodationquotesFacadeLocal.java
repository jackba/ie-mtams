/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Accomodationquotes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface AccomodationquotesFacadeLocal {

    void create(Accomodationquotes accomodationquotes);

    void edit(Accomodationquotes accomodationquotes);

    void remove(Accomodationquotes accomodationquotes);

    Accomodationquotes find(Object id);

    List<Accomodationquotes> findAll();

    List<Accomodationquotes> findRange(int[] range);

    int count();
    
}
