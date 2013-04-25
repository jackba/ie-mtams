/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Traveldocument;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface TraveldocumentFacadeLocal {

    void create(Traveldocument traveldocument);

    void edit(Traveldocument traveldocument);

    void remove(Traveldocument traveldocument);

    Traveldocument find(Object id);

    List<Traveldocument> findAll();

    List<Traveldocument> findRange(int[] range);

    int count();
    
}
