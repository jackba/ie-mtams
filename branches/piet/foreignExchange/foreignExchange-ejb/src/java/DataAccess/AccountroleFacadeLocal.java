/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Accountrole;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface AccountroleFacadeLocal {

    void create(Accountrole accountrole);

    void edit(Accountrole accountrole);

    void remove(Accountrole accountrole);

    Accountrole find(Object id);

    List<Accountrole> findAll();

    List<Accountrole> findRange(int[] range);

    int count();
    
}
