/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Stage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface StageFacadeLocal {

    void create(Stage stage);

    void edit(Stage stage);

    void remove(Stage stage);

    Stage find(Object id);

    List<Stage> findAll();

    List<Stage> findRange(int[] range);

    int count();
    
}
