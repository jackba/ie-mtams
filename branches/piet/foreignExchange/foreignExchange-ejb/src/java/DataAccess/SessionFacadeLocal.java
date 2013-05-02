/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Session;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface SessionFacadeLocal {

    void create(Session session);

    void edit(Session session);

    void remove(Session session);

    Session find(Object id);

    List<Session> findAll();

    List<Session> findRange(int[] range);

    int count();
    
}
