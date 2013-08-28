/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.DepartmentFacadeLocal;
import Entities.Department;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Alexandre Damasio
 */
@Stateless
public class DepartmentHandler implements DepartmentHandlerLocal {
    @EJB
    private DepartmentFacadeLocal departmentDAO;
    @Override
    public void createDepartment(Department department) {
        departmentDAO.create(department);
    }

    @Override
    public void editDepartment(Department department) {
        departmentDAO.edit(department);
    }

    @Override
    public void deleteDepartment(Department department) {        
        departmentDAO.remove(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> allDep = departmentDAO.findAll();
        return allDep;
    }
}