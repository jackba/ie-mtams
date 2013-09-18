/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.AccountdepartmentFacadeLocal;
import DataAccess.ApplicationFacadeLocal;
import DataAccess.ApprovalFacadeLocal;
import DataAccess.ApprovalchainFacadeLocal;
import DataAccess.DepartmentFacadeLocal;
import DataAccess.FinalcostingFacadeLocal;
import DataAccess.QuotesFacadeLocal;
//import DataAccess.QuotesFacadeLocal;
import Entities.Account;
import Entities.Accountdepartment;
import Entities.Application;
import Entities.Approval;
import Entities.Approvalchain;
import Entities.Department;
import Entities.Finalcosting;
import Entities.Quotes;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aaron
 */
@Stateless
public class ApprovalHandler implements ApprovalHandlerLocal {

    @EJB
    private AccountFacadeLocal daoAccount;
    @EJB
    private ApplicationFacadeLocal daoApplication;
    @EJB
    private ApprovalFacadeLocal daoApproval;
    @EJB
    private FinalcostingFacadeLocal daoFinal;
    @EJB
    private QuotesFacadeLocal daoQuotesFacadeLocal;
    @EJB
    private ApprovalchainFacadeLocal apprChainDao;
    private Account account = new Account();
    private Application app = new Application();
    private Quotes quotes = new Quotes();
    private Approval approvalRef;
    private Finalcosting fcostingRef;
    private Accountdepartment ad;
    @EJB
    private AccountdepartmentFacadeLocal adfl;
    @EJB
    private DepartmentFacadeLocal dfl;
    @EJB
    private ApprovalchainFacadeLocal appcfl;

//    @Override
//    public void persist(Approval approval, Finalcosting finalcosting) {
//        
//        persistApproval(approval);      
//                    
//        persistFinalcosting(finalcosting);
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        
//        
//    }
    @Override
    public String returnDepartment(Integer id) {
        Integer departmentID = null; //remove null if null pointer is given in code
        String departmentName = null;
        List<Application> returnApps = new ArrayList<Application>();
        List<Account> accounts = new ArrayList<Account>();

        List<Accountdepartment> listAD = adfl.findAll();
        for (Accountdepartment eachAD : listAD) {
            if (eachAD.getIdaccount().getIdaccount().equals(id)) {
                departmentID = eachAD.getIddepartment().getIddepartment();
            }
        }

        List<Department> listDepart = dfl.findAll();
        for (Department eachDep : listDepart) {
            if (eachDep.getIddepartment().equals(departmentID)) {
                departmentName = eachDep.getDepartment();
            }
        }
        return departmentName;
    }

    @Override
    public List<Application> allApp(Integer id) //schoolAdmin id passed in //Code just for schooladmin
    {
        Integer departmentID = null; //remove null if null pointer is given in code
        String departmentName = null;
        List<Application> returnApps = new ArrayList<Application>();
        List<Account> accounts = new ArrayList<Account>();

        List<Accountdepartment> listAD = adfl.findAll();
        for (Accountdepartment eachAD : listAD) {
            if (eachAD.getIdaccount().getIdaccount().equals(id)) {
                departmentID = eachAD.getIddepartment().getIddepartment();
            }
        }

        List<Department> listDepart = dfl.findAll();
        for (Department eachDep : listDepart) {
            if (eachDep.getIddepartment().equals(departmentID)) {
                departmentName = eachDep.getDepartment();
            }
        }

        String Finance = "Finance";
        String Administration = "Administration";
        String PVC = "PVC";
        String ITS = "ITS";

        //Step 3.0 codde
        List<Approvalchain> listAppChain = appcfl.findAll();
        if (departmentName.equalsIgnoreCase(Finance)) {
        } else if (departmentName.equalsIgnoreCase(Administration)) {
        } else if (departmentName.equalsIgnoreCase(PVC)) {
        } else if (departmentName.equalsIgnoreCase(ITS)) {
        } else {
            for (Approvalchain eachAppc : listAppChain) {
                //This checks schoolAdmin 
                if (eachAppc.getApplicationcomplete() == 1 && eachAppc.getSchooladmincomplete() == 0 && eachAppc.getSchooladmin().getIdaccount().equals(id)) {
                    accounts.add(eachAppc.getAccountid());
                } else //This check HOD
                if (eachAppc.getApplicationcomplete() == 1 && eachAppc.getSchooladmincomplete() == 1 && eachAppc.getHodcomplete() == 0
                        && eachAppc.getHod().getIdaccount().equals(id)) {
                    accounts.add(eachAppc.getAccountid());
                }
            }
        }
        //step 2.0 code
        /*
         for(Accountdepartment eachAd :listAD)
         {
         if(eachAd.getIddepartment().getIddepartment().equals(departmentID))
         {
         accounts.add(eachAd.getIdaccount());
         }            
         }     */


        List<Application> listApp = daoApplication.findAll();
        {
            for (Application eachApp : listApp) {
                Integer accountId = eachApp.getAccountIdaccount().getIdaccount();
                for (Account eachAcc : accounts) {
                    if (eachAcc.getIdaccount().equals(accountId)) {
                        returnApps.add(eachApp);
                    }
                }
            }
        }
        return returnApps;
    }
    //get id and check the department do step 2.0 or 3.0

    //Step 2.0
    //$$ check accountDepartment pass id and return department id (IT) 
    //go throw accountDepartment and return all the add to List<account> where department = department id        
    //go to applicationChain for each schoolAdmin table with id in it check => applicationcomplete == 1 && schooladmincomplete ==0 
    //          add that account to a list<account> accounts
    // List<Approval> approvals = new ArrayList<Approval>();
    //return accounts 
    //Step3.0
    //get the department 
    //go to approvalchain go the the right department role (Finance || PVC || FinalFinance) and check 
    //eg PVC -> check financeComplete == 1 && PVCComplete == 0 
    //long run 
    //check the id against accountDepartment
    //if id is HOD do step 2.0
    //if id is finance step 3.0
    @Override
    public void persistApproval(Approval approval) {
        // set global references for approval for persistant use 
        approvalRef = approval;
        // set the approval account / application to the curretly logged in account
        daoApproval.create(approval);

        // set the final costing to quotes selected

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    //    @Override
    //    public void persistFinalcosting(Finalcosting finalcosting) {
    //        // set global references for finalcosting for persistant use
    //        fcostingRef = finalcosting;
    //        // set the approval account / application to the curretly logged in account
    //        // set the final costing to quotes selected
    //        //quotes.setIdquotes(1);
    //        quotes = daoQuotesFacadeLocal.find(1);
    //        finalcosting.setQuotesIdquotes(quotes);
    //        daoFinal.create(finalcosting);
    //        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //    }
    @Override
    public String updateApproval(Approval approval) {

        List<Approvalchain> chainList = appcfl.findAll();
        Approvalchain chain = null;

        for (Approvalchain each : chainList) {
            if (approval.getApplicationIdapplication().equals(each.getApplicationid())) {
                chain = each;
            }
        }
        
        daoApproval.edit(approval);
        
        String nextAcc = "";
        
        if (chain != null) {
            if (chain.getSchooladmincomplete() != 1) {
                chain.setSchooladmincomplete(1);
                nextAcc = chain.getHod().getUsername();
            } else if (chain.getHodcomplete() != 1) {
                chain.setHodcomplete(1);
                nextAcc = chain.getFinance().getUsername();
            } else if (chain.getFinancecomplete() != 1) {
                chain.setFinancecomplete(1);
                nextAcc = chain.getPvc().getUsername();
            } else if (chain.getPvccomplete() != 1) {
                chain.setPvccomplete(1);
                nextAcc = chain.getFinalfinance().getUsername();
            } else if (chain.getFinalcomplete() != 1) {
                chain.setFinalcomplete(1);
                nextAcc = chain.getApplicationid().getAccountIdaccount().getUsername();
            }
        }


        return nextAcc;
    }

    @Override
    public void updateApproval(Approval approval, Integer ApprovalID) {
        //Integer approvalID = null;
        Approval newForm = approval;
        Approval oldForm = null;

        //Start by looking at Application Table. Application -> Travel ID -> ID Conference
//        List<Approval> allApprovlas = daoApproval.findAll();
//        for (Application eachApproval : allApp) {
//            if (eachApproval.getIdapplication().getIdaccount().equals(id)) {
//                approvalID = eachApproval.getFinalcostingIdfinalcosting().getIdfinalcosting();
//            }
//        }

        //Try and match conferenceID to passed id
        List<Approval> allapprovals = daoApproval.findAll();
        for (Approval eachapproval : allapprovals) {
            if (eachapproval.getIdapproval().equals(ApprovalID)) {
                oldForm = eachapproval;
                //move conferenceID of old conference entry to new entry.
                newForm.setIdapproval(oldForm.getIdapproval());
                daoApproval.edit(newForm);
            }
        }

    }

//    @Override
//    public void updateFinalcosting(Finalcosting finalcosting, Integer finalcostingID) {
//        //Integer fcostingID = null;
//        Finalcosting newForm = finalcosting;
//        Finalcosting oldForm = null;
//
//        //Start by looking at Application Table. Application -> Travel ID -> ID Conference
////        List<Application> allApp = daoApplication.findAll();
////        for (Application eachApp : allApp) {
////            if (eachApp.getFinalcostingIdfinalcosting().getIdfinalcosting().equals(finalcostingID)) {
////                fcostingID = eachApp.getFinalcostingIdfinalcosting().getIdfinalcosting();
////            }
////        }
//        
//        //Try and match conferenceID to passed id
//        List<Finalcosting> allFcostings = daoFinal.findAll();
//        for (Finalcosting eachfcost : allFcostings) {
//            if (eachfcost.getIdfinalcosting().equals(finalcostingID)) {
//                oldForm = eachfcost;
//                //move conferenceID of old conference entry to new entry.
//                newForm.setIdfinalcosting(oldForm.getIdfinalcosting());
//                daoFinal.edit(newForm);
//            }
//        }
//        
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public List<Approval> findApprovalbyApplication(Integer id) {

        List<Approval> approvals = new ArrayList<Approval>();
        List<Approval> allapprovals = daoApproval.findAll();

        for (Approval approval : allapprovals) {
            if (approval.getApplicationIdapplication().getIdapplication().equals(id)) {
                approvals.add(approval);
            }
        }
        return approvals;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public Finalcosting findFinalcosting(Integer id) {
//        
//        List<Finalcosting> finalcostings = daoFinal.findAll();
//        for (Finalcosting fcost : finalcostings) {
//            if (fcost.getIdfinalcosting().equals(id)) 
//                return fcost;
//        }
//        return null;
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public List<Approval> findApprovalbyAccount(Integer id) {

        List<Approval> approvals = new ArrayList<Approval>();
        List<Approval> allapprovals = daoApproval.findAll();

        for (Approval approval : allapprovals) {
            if (approval.getAccountIdaccount().getIdaccount().equals(id)) {
                approvals.add(approval);
            }
        }
        return approvals;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Approval findApprovalByAccountAndApplication(Integer appID, Integer accID) {
        List<Approval> approvals = new ArrayList<Approval>();
        List<Approval> allapprovals = daoApproval.findAll();

        for (Approval approval : allapprovals) {
            if (approval.getApplicationIdapplication().getIdapplication().equals(appID)) {
                approvals.add(approval);
            }
        }

        for (Approval approval : approvals) {
            if (approval.getAccountIdaccount().getIdaccount().equals(accID)) {
                return approval;
            }
        }
        return null;
    }

    @Override
    public Approval findApproval(Integer id) {

        List<Approval> approvals = new ArrayList<Approval>();
        List<Approval> allapprovals = daoApproval.findAll();
        for (Approval approval : allapprovals) {
            if (approval.getIdapproval().equals(id)) {
                return approval;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void persistApprovalChain(Approvalchain apprChain) {
        apprChainDao.create(apprChain);
    }
}
