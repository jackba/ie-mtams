/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Carquotes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface CarquotesFacadeLocal {

    void create(Carquotes carquotes);

    void edit(Carquotes carquotes);

    void remove(Carquotes carquotes);

    Carquotes find(Object id);

    List<Carquotes> findAll();

    List<Carquotes> findRange(int[] range);

    int count();
    
}
