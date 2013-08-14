/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.AccountdepartmentFacadeLocal;
import DataAccess.AccountroleFacadeLocal;
import DataAccess.DepartmentFacadeLocal;

import DataAccess.RoleFacadeLocal;
import Entities.Account;
import Entities.Accountdepartment;
import Entities.Accountrole;
import Entities.Department;

import Entities.Role;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Badger
 */
@Stateless
public class AccountHandler implements AccountHandlerLocal {

    @EJB
    private AccountFacadeLocal accDao;
    @EJB
    private AccountroleFacadeLocal accRoleDao;
    @EJB
    private RoleFacadeLocal roleDao;
	@EJB
    private AccountdepartmentFacadeLocal accDepDao;
    @EJB
    private DepartmentFacadeLocal deptsDao;
    
	private int deptID;
    private int accID;
    private int accDeptID;
    private List<Account> adminList = new ArrayList<Account>();
    private int callCount = 0;
	
    @Override
    public void registerNewAccount(Account newAccount, int role){
        
        accDao.create(newAccount);
        
        List<Account> allAccounts = accDao.findAll();
        for(Account each: allAccounts){
            if(each.equals(newAccount))
                newAccount = each;
        }
        
        accRoleDao.create(assignId(newAccount, role));
    }

	@Override
    public void registerNewAccountDiv(Account newAccount, int role, String department) {

        accDao.create(newAccount);

        List<Account> allAccounts = accDao.findAll();
        for (Account each : allAccounts) {
            if (each.equals(newAccount)) {
                newAccount = each;
            }
        }
        List<Department> allDepartments = deptsDao.findAll();
        for (Department each : allDepartments) {
            if (each.getDepartment().equalsIgnoreCase(department)) {
                deptID = each.getIddepartment();
            }
        }
        accID = newAccount.getIdaccount();
        accRoleDao.create(assignId(newAccount, role));

        List<Accountdepartment> allAccDepts = accDepDao.findAll();

        accDeptID = allAccDepts.size() + 1;


        Accountdepartment accDeptRef = new Accountdepartment(accDeptID, accID, deptID);
        accDepDao.create(accDeptRef);
    }
	
    @Override
    public Accountrole assignId(Account newAccount, int role) {
        Role getRole = roleDao.find(role);
        Accountrole newAccRole = new Accountrole();
        newAccRole.setAccountid(newAccount);
        newAccRole.setRoleid(getRole);
        
        return newAccRole;
    }

    @Override
    public boolean checkUsername(String username) {
        boolean found = false;
        List<Account> accounts = accDao.findAll();
        
        for(Account each:accounts){
            if(each.getUsername().equalsIgnoreCase(username)){
                found = true;
            }
        }
        
       return found;
    }
    
    @Override
    public List<Account> getAllAccounts(){
        return accDao.findAll();
    }
    
	    @Override
    public void deactivateAccount(Account selAcc) {
        List<Accountrole> accRoleList = accRoleDao.findAll();
        for (Accountrole each : accRoleList) {
            if (each.getAccountid().equals(selAcc)) {
                each.setRoleid(roleDao.find(99));
                accRoleDao.edit(each);
            }
        }
    }
	
	@Override
    public List<Account> getAllAdmins() {
        List<Account> allAccList = accDao.findAll();
        List<Accountrole> allAccRoleList = accRoleDao.findAll();
        List<Integer> accIDList = new ArrayList<Integer>();

        if(!adminList.isEmpty()){
            adminList.clear();
        }
        
        for (Accountrole each : allAccRoleList) {
            if (each.getRoleid().getIdroles() == 21) {
                adminList.add(each.getAccountid());
            }
        }
        return adminList;
    }
	
	@Override
    public void editAdminPersist(Account admin){
        accDao.edit(admin);
    }
	
	@Override
    public Account getAccount(Integer id) {
        return accDao.find(id);
    }


    
}
