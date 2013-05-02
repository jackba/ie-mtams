/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Permission;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface PermissionFacadeLocal {

    void create(Permission permission);

    void edit(Permission permission);

    void remove(Permission permission);

    Permission find(Object id);

    List<Permission> findAll();

    List<Permission> findRange(int[] range);

    int count();
    
}
