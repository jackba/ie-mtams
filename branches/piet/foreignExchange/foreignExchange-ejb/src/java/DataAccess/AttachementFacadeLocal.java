/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Attachement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
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
