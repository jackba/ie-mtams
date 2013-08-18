/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAcess;

import entities.Regions;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aaron
 */
@Local
public interface RegionsFacadeLocal {

    void create(Regions regions);

    void edit(Regions regions);

    void remove(Regions regions);

    Regions find(Object id);

    List<Regions> findAll();

    List<Regions> findRange(int[] range);

    int count();
    
}
