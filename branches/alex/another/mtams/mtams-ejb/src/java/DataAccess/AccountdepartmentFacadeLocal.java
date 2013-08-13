/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Accountdepartment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sparda
 */
@Local
public interface AccountdepartmentFacadeLocal {

    void create(Accountdepartment accountdepartment);

    void edit(Accountdepartment accountdepartment);

    void remove(Accountdepartment accountdepartment);

    Accountdepartment find(Object id);

    List<Accountdepartment> findAll();

    List<Accountdepartment> findRange(int[] range);

    int count();
    
}
