/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Conference;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface ConferenceFacadeLocal {

    void create(Conference conference);

    void edit(Conference conference);

    void remove(Conference conference);

    Conference find(Object id);

    List<Conference> findAll();

    List<Conference> findRange(int[] range);

    int count();
    
}
