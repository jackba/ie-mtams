/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Rewardsprogram;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface RewardsprogramFacadeLocal {

    void create(Rewardsprogram rewardsprogram);

    void edit(Rewardsprogram rewardsprogram);

    void remove(Rewardsprogram rewardsprogram);

    Rewardsprogram find(Object id);

    List<Rewardsprogram> findAll();

    List<Rewardsprogram> findRange(int[] range);

    int count();
    
}
