/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.AccountdepartmentFacadeLocal;
import DataAccess.DepartmentFacadeLocal;
import Entities.Account;
import Entities.Accountdepartment;
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
    @EJB
    private AccountdepartmentFacadeLocal accDeptDAO;
    @EJB
    private AccountFacadeLocal accDAO;
    
    private int sAdminID;
    private int deptID;
    private Account accRef;
    private Department deptRef;
    
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

    @Override
    public boolean checkDepartmentName(String deptName) {
        boolean found = false;
        List<Department> departments = departmentDAO.findAll();

        for (Department each : departments) {
            if (each.getDepartment().equalsIgnoreCase(deptName)) {
                found = true;
            }
        }

        return found;
    }

    @Override
    public Account getAdministratorAccID(Account acc, int role) {        
        List<Accountdepartment> allAccDept = accDeptDAO.findAll();
        for(Accountdepartment each: allAccDept){
            if(each.getIdaccount().equals(acc)){
                deptRef = each.getIddepartment();
                
                for(Accountdepartment eachDept: allAccDept){
                    if(eachDept.getIddepartment().equals(deptRef) && eachDept.getDepartmentrole() == role){
                        accRef = eachDept.getIdaccount();                        
                    }
                }
            }
        }
        return accRef;
    }
}