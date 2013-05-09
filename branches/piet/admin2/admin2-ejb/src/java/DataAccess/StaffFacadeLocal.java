/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Staff;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface StaffFacadeLocal {

    void create(Staff staff);

    void edit(Staff staff);

    void remove(Staff staff);

    Staff find(Object id);

    List<Staff> findAll();

    List<Staff> findRange(int[] range);

    int count();
    
}
