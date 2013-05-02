/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Title;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface TitleFacadeLocal {

    void create(Title title);

    void edit(Title title);

    void remove(Title title);

    Title find(Object id);

    List<Title> findAll();

    List<Title> findRange(int[] range);

    int count();
    
}
