/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Leavelookup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco Remane
 */
@Local
public interface LeavelookupFacadeLocal {

    void create(Leavelookup leavelookup);

    void edit(Leavelookup leavelookup);

    void remove(Leavelookup leavelookup);

    Leavelookup find(Object id);

    List<Leavelookup> findAll();

    List<Leavelookup> findRange(int[] range);

    int count();
    
}
