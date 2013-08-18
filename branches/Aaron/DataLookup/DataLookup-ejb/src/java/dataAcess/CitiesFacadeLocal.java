/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAcess;

import entities.Cities;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aaron
 */
@Local
public interface CitiesFacadeLocal {

    void create(Cities cities);

    void edit(Cities cities);

    void remove(Cities cities);

    Cities find(Object id);

    List<Cities> findAll();

    List<Cities> findRange(int[] range);

    int count();
    
}
