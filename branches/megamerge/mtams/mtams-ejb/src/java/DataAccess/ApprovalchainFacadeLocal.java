/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Approvalchain;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface ApprovalchainFacadeLocal {

    void create(Approvalchain approvalchain);

    void edit(Approvalchain approvalchain);

    void remove(Approvalchain approvalchain);

    Approvalchain find(Object id);

    List<Approvalchain> findAll();

    List<Approvalchain> findRange(int[] range);

    int count();
    
}
