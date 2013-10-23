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
import DataAccess.StageFacadeLocal;
import Entities.Account;
import Entities.Accountdepartment;
import Entities.Accountrole;
import Entities.Application;
import Entities.Department;

import Entities.Role;
import Entities.Stage;
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
    @EJB
    private StageFacadeLocal stageDao;    
    
    private Department dept;
    private int accID;
    private int accDeptID;
    private List<Account> adminList = new ArrayList<Account>();
    private int callCount = 0;
    private Account account;   
    private List<Account> allActiveAcc;
    private List<Account> allInactiveAcc;

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
        Department depart = null;
        
        List<Accountdepartment> listAD = accDepDao.findAll();
        for(Accountdepartment each : listAD)
        {
            if(each.getIdaccount().getIdaccount().equals(accountID))
            {
                departmentId = each.getIddepartment().getIddepartment();
            }
        }
        List<Department> listD = deptsDao.findAll();
        for(Department each : listD)
        {
            if(each.getIddepartment().equals(departmentId))
                depart = each;
        }
        int accountId = newAccount.getIdaccount();

        accRoleDao.create(assignId(newAccount, role));
        
        Accountdepartment accDept = new Accountdepartment();
        accDept.setIdaccount(newAccount);
        accDept.setIddepartment(depart);
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
    public List<Account> getAllDepartmentAccounts(Integer id){
        Integer departmentID = null; //remove null if null pointer is given in code
        String departmentName = null;
        List<Account> listAcc = new ArrayList<Account>();
        
        List<Accountdepartment> listAD = accDepDao.findAll();
        
        for (Accountdepartment eachAD : listAD) {
            if (eachAD.getIdaccount().getIdaccount().equals(id)) {
                departmentID = eachAD.getIddepartment().getIddepartment();
            }            
        }
        
        for(Accountdepartment eachAD : listAD)
        {
            if(eachAD.getIddepartment().getIddepartment().equals(departmentID)){
                listAcc.add(eachAD.getIdaccount());
            }
        }   
        
        return listAcc;
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
    public Account findSpecificAccount(String userName){
        List<Account> accList = accDao.findAll();
        for(Account each : accList){
            if(each.getUsername().equalsIgnoreCase(userName)){
                account = each;
            }
        }
        return account;
    }

    @Override
    public List<Account> getAllActiveAccounts(String userName) {
        allActiveAcc = new ArrayList<Account>();
        
        List<Accountrole> allAccRole = accRoleDao.findAll();
        for(Accountrole each: allAccRole){
            if(each.getRoleid().getIdroles() < 900 && !(each.getAccountid().getUsername().equalsIgnoreCase(userName))){
                allActiveAcc.add(each.getAccountid());
            }
        }
        return allActiveAcc;        
    }

    @Override
    public List<Account> getAllInactiveAccounts(String userName) {
        allInactiveAcc = new ArrayList<Account>();
        
        List<Accountrole> allAccRole = accRoleDao.findAll();
        for(Accountrole each: allAccRole){
            if(each.getRoleid().getIdroles() > 900 && !(each.getAccountid().getUsername().equalsIgnoreCase(userName))){
                allInactiveAcc.add(each.getAccountid());
            }
        }
        return allInactiveAcc;
    }
    
    @Override
    public List<Stage> getAllStages() {
        List<Stage> allstages = stageDao.findAll();
        
        return allstages;
    }
}
