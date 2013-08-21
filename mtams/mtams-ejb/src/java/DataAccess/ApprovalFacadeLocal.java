/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Approval;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aaron
 */
@Local
public interface ApprovalFacadeLocal {

    void create(Approval approval);

    void edit(Approval approval);

    void remove(Approval approval);

    Approval find(Object id);

    List<Approval> findAll();

    List<Approval> findRange(int[] range);

    int count();
    
}
