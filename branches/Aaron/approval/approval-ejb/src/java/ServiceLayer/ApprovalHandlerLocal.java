/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

//import Entities.Account;
//import Entities.Application;
import Entities.Finalcosting;
import Entities.Approval;
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
    
    public void persist(Approval approval, Finalcosting finalcosting);
    //public void persistApplication(Application application);
    public void persistApproval(Approval approval);
    public void persistFinalcosting(Finalcosting finalcosting);
    
    public Approval findApproval(Integer id);
    public List<Approval> findApprovalbyApplication(Integer id);
    public List<Approval> findApprovalbyAccount(Integer id);  
    public Finalcosting findFinalcosting(Integer id);
    //public Application findByApplication(Integer id);
    //public Account findByAccount(Integer id);
    //public Quotes findByQuotes(Integer id);
    
    
}
