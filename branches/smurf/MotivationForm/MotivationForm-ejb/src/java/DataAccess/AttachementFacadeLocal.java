/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Attachement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Michelle Thornton
 */
@Local
public interface AttachementFacadeLocal {

    void create(Attachement attachement);

    void edit(Attachement attachement);

    void remove(Attachement attachement);

    Attachement find(Object id);

    List<Attachement> findAll();

    List<Attachement> findRange(int[] range);

    int count();
    
}
