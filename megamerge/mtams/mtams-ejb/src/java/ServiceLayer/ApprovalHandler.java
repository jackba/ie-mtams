/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.ApplicationFacadeLocal;
import DataAccess.ApprovalFacadeLocal;
import DataAccess.FinalcostingFacadeLocal;
import DataAccess.QuotesFacadeLocal;
//import DataAccess.QuotesFacadeLocal;
import Entities.Account;
import Entities.Application;
import Entities.Approval;
import Entities.Conference;
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
public class ApprovalHandler implements ApprovalHandlerLocal{
    
        
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
    
    private Account account = new Account();
    private Application app = new Application();
    private Quotes quotes = new Quotes();
    
    private Approval approvalRef;
    
    private Finalcosting fcostingRef;
    

    @Override
    public void persist(Approval approval, Finalcosting finalcosting) {
        
        persistApproval(approval);      
                    
        persistFinalcosting(finalcosting);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
    }

    @Override
    public void persistApproval(Approval approval) {
        // set global references for approval for persistant use 
        approvalRef = approval;
        // set the approval account / application to the curretly logged in account
        daoApproval.create(approval);
        
        // set the final costing to quotes selected
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void persistFinalcosting(Finalcosting finalcosting) {
        // set global references for finalcosting for persistant use 
        fcostingRef = finalcosting;
        // set the approval account / application to the curretly logged in account               
        // set the final costing to quotes selected
        //quotes.setIdquotes(1);
        quotes = daoQuotesFacadeLocal.find(1);
        finalcosting.setQuotesIdquotes(quotes);
        daoFinal.create(finalcosting);       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
               
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFinalcosting(Finalcosting finalcosting, Integer finalcostingID) {
        //Integer fcostingID = null;
        Finalcosting newForm = finalcosting;
        Finalcosting oldForm = null;

        //Start by looking at Application Table. Application -> Travel ID -> ID Conference
//        List<Application> allApp = daoApplication.findAll();
//        for (Application eachApp : allApp) {
//            if (eachApp.getFinalcostingIdfinalcosting().getIdfinalcosting().equals(finalcostingID)) {
//                fcostingID = eachApp.getFinalcostingIdfinalcosting().getIdfinalcosting();
//            }
//        }
        
        //Try and match conferenceID to passed id
        List<Finalcosting> allFcostings = daoFinal.findAll();
        for (Finalcosting eachfcost : allFcostings) {
            if (eachfcost.getIdfinalcosting().equals(finalcostingID)) {
                oldForm = eachfcost;
                //move conferenceID of old conference entry to new entry.
                newForm.setIdfinalcosting(oldForm.getIdfinalcosting());
                daoFinal.edit(newForm);
            }
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Approval> findApprovalbyApplication(Integer id) {
        
        List<Approval> approvals = new ArrayList<Approval>();
        List<Approval> allapprovals = daoApproval.findAll();
        
        for(Approval approval : allapprovals){
            if(approval.getApplicationIdapplication().getIdapplication().equals(id))
                approvals.add(approval);
        }
        return approvals;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Finalcosting findFinalcosting(Integer id) {
        
        List<Finalcosting> finalcostings = daoFinal.findAll();
        for (Finalcosting fcost : finalcostings) {
            if (fcost.getIdfinalcosting().equals(id)) 
                return fcost;
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Approval> findApprovalbyAccount(Integer id) {
        
        List<Approval> approvals = new ArrayList<Approval>();
        List<Approval> allapprovals = daoApproval.findAll();
        
        for(Approval approval : allapprovals){
            if(approval.getAccountIdaccount().getIdaccount().equals(id))
                approvals.add(approval);
        }
        return approvals;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Approval findApproval(Integer id) {
        
        List<Approval> approvals = new ArrayList<Approval>();
        List<Approval> allapprovals = daoApproval.findAll();
            for (Approval approval : allapprovals) {
                if (approval.getIdapproval().equals(id)) 
                    return approval;
            }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }





   


    
    
}
