/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Personal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco Remane
 */
@Local
public interface PersonalFacadeLocal {

    void create(Personal personal);

    void edit(Personal personal);

    void remove(Personal personal);

    Personal find(Object id);

    List<Personal> findAll();

    List<Personal> findRange(int[] range);

    int count();
    
}
