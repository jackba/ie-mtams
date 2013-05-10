/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Application;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco Remane
 */
@Local
public interface ApplicationFacadeLocal {

    void create(Application application);

    void edit(Application application);

    void remove(Application application);

    Application find(Object id);

    List<Application> findAll();

    List<Application> findRange(int[] range);

    int count();
    
}
