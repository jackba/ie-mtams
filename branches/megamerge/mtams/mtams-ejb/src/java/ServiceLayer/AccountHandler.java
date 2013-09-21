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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
    
    
    private Department dept;
    private int accID;
    private int accDeptID;
    private List<Account> adminList = new ArrayList<Account>();
    private int callCount = 0;
    private int financeID;
    private int PVCID;
    private int finalFinanceID;

    @Override
    public void registerNewAccount(Account newAccount, int role ,int departmentRole,int accountID) {

        accDao.create(newAccount);

        List<Account> allAccounts = accDao.findAll();
        for (Account each : allAccounts) {
            if (each.equals(newAccount)) {
                newAccount = each;
            }
        }
        int departmentId = 0;
        
        List<Accountdepartment> listAD = new ArrayList<Accountdepartment>();
        for(Accountdepartment each : listAD)
        {
            if(each.getIdaccount().getIdaccount().equals(accountID))
            {
                departmentId = each.getDepartmentrole();
            }
        }
        List<Department> listD = new ArrayList<Department>();
        for(Department each : listD)
        {
            if(each.getIddepartment().equals(departmentId))
                dept = each;
        }
        int accountId = newAccount.getIdaccount();

        accRoleDao.create(assignId(newAccount, role));
        
        Accountdepartment accDept = new Accountdepartment();
        accDept.setIdaccount(newAccount);
        accDept.setIddepartment(dept);
        accDept.setDepartmentrole(departmentRole);
        
        accDepDao.create(accDept);
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
                dept = each;
            }
        }
        accID = newAccount.getIdaccount();
        accRoleDao.create(assignId(newAccount, role));


        Accountdepartment accDeptRef = new Accountdepartment();
        accDeptRef.setIdaccount(newAccount);
        accDeptRef.setIddepartment(dept);
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

        for (Account each : accounts) {
            if (each.getUsername().equalsIgnoreCase(username)) {
                found = true;
            }
        }

        return found;
    }

    @Override
    public List<Account> getAllAccounts(String userName) {        
        List<Account> allAccounts = accDao.findAll();
        Iterator iter = allAccounts.iterator();
        
        while(iter.hasNext()){
            Account accRef = (Account)iter.next();
            if(accRef.getUsername().equalsIgnoreCase(userName)){
                iter.remove();
            }
        }
        return allAccounts;
        //return accDao.findAll();
    }

    @Override
    public void deactivateAccount(Account selAcc) {
        List<Accountrole> accRoleList = accRoleDao.findAll();

        for (Accountrole each : accRoleList) {
            if (each.getAccountid().equals(selAcc)) {

                each.setRoleid(roleDao.find((each.getRoleid().getIdroles() + 900)));
                accRoleDao.edit(each);
            }
        }
    }
    
    @Override
    public void reactivateAccount(Account selAcc) {
        List<Accountrole> accRoleList = accRoleDao.findAll();

        for (Accountrole each : accRoleList) {
            if (each.getAccountid().equals(selAcc)) {

                each.setRoleid(roleDao.find((each.getRoleid().getIdroles() - 900)));
                accRoleDao.edit(each);
            }
        }
    }

    @Override
    public List<Account> getAllAdmins() {
        List<Account> allAccList = accDao.findAll();
        List<Accountrole> allAccRoleList = accRoleDao.findAll();
        List<Integer> accIDList = new ArrayList<Integer>();

        if (!adminList.isEmpty()) {
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
    public void editAdminPersist(Account admin) {
        accDao.edit(admin);
    }

    @Override
    public Account getAccount(Integer id) {
        return accDao.find(id);
    }
    
    @Override
    public int findFinanceAccountID(){
        List<Account> accList = accDao.findAll();
        for(Account each : accList){
            if(each.getUsername().equalsIgnoreCase("Finance")){
                financeID = each.getIdaccount();
            }
        }
        return financeID;
    }
    
    @Override
    public int findPVCAccountID(){
        List<Account> accList = accDao.findAll();
        for(Account each : accList){
            if(each.getUsername().equalsIgnoreCase("PVC")){
                PVCID = each.getIdaccount();
            }
        }
        return PVCID;
    }
    
    @Override
    public int findFinalFinanceAccountID(){
        List<Account> accList = accDao.findAll();
        for(Account each : accList){
            if(each.getUsername().equalsIgnoreCase("FinalFinance")){
                finalFinanceID = each.getIdaccount();
            }
        }
        return finalFinanceID;
    }
}
