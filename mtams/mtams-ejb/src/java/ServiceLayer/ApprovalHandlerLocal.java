/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

//import Entities.Account;
//import Entities.Application;
import Entities.Application;
import Entities.Approval;
import Entities.Approvalchain;
import java.util.List;
//import Entities.Quotes;
//import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aaron
 */
@Local
public interface ApprovalHandlerLocal {
    
    //public void persist(Approval approval, Finalcosting finalcosting);
    //public void persistApplication(Application application);
    public void persistApproval(Approval approval);
    //public void persistFinalcosting(Finalcosting finalcosting);
    public String updateApproval(Approval approval);
    public void updateApproval(Approval approval, Integer ApprovalID);
           
    //public void updateFinalcosting(Finalcosting finalcosting, Integer finalcostingID);
    
    public Approval findApproval(Integer id);
    public Approval findApprovalByAccountAndApplication(Integer appID, Integer accID);
    public List<Approval> findApprovalbyApplication(Integer id);
    public List<Approval> findApprovalbyAccount(Integer id);  
    //public Finalcosting findFinalcosting(Integer id);
    //public Application findByApplication(Integer id);
    //public Account findByAccount(Integer id);
    //public Quotes findByQuotes(Integer id);
    
    public List<Application> allApp(Integer id);
    public String returnDepartment(Integer id);
    
    public void persistApprovalChain(Approvalchain apprChain);
    public int returnStage (Integer id);
    public List<Approvalchain> findAppovalby(Integer id);
}
