/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Roles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface RolesFacadeLocal {

    void create(Roles roles);

    void edit(Roles roles);

    void remove(Roles roles);

    Roles find(Object id);

    List<Roles> findAll();

    List<Roles> findRange(int[] range);

    int count();
    
}
