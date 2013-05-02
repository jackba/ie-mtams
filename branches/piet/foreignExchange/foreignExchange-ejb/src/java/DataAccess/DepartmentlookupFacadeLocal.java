/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Departmentlookup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface DepartmentlookupFacadeLocal {

    void create(Departmentlookup departmentlookup);

    void edit(Departmentlookup departmentlookup);

    void remove(Departmentlookup departmentlookup);

    Departmentlookup find(Object id);

    List<Departmentlookup> findAll();

    List<Departmentlookup> findRange(int[] range);

    int count();
    
}
