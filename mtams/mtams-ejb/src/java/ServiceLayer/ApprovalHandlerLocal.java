/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;
import Entities.Approval;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aaron
 */
@Local
public interface ApprovalHandlerLocal {

    public void persistApproval(Approval approval);

    public void updateApproval(Approval approval, Integer ApprovalID);

    public Approval findApproval(Integer id);

    public List<Approval> findApprovalbyApplication(Integer id);

    public List<Approval> findApprovalbyAccount(Integer id);
}
