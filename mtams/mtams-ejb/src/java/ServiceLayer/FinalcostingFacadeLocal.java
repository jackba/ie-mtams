/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Finalcosting;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Michelle Thornton
 */
@Local
public interface FinalcostingFacadeLocal {

    void create(Finalcosting finalcosting);

    void edit(Finalcosting finalcosting);

    void remove(Finalcosting finalcosting);

    Finalcosting find(Object id);

    List<Finalcosting> findAll();

    List<Finalcosting> findRange(int[] range);

    int count();
    
}
