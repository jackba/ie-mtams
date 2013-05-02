/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Motivation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Michelle Thornton
 */
@Local
public interface MotivationFacadeLocal {

    void create(Motivation motivation);

    void edit(Motivation motivation);

    void remove(Motivation motivation);

    Motivation find(Object id);

    List<Motivation> findAll();

    List<Motivation> findRange(int[] range);

    int count();
    
}
