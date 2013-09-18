/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Department;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alexandre Damasio
 */
@Local
public interface DepartmentHandlerLocal {

    public List<Department> getAllDepartments();

    public void createDepartment(Department department);

    public void editDepartment(Department department);

    public void deleteDepartment(Department department);
}
