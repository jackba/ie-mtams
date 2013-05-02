/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Quotes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface QuotesFacadeLocal {

    void create(Quotes quotes);

    void edit(Quotes quotes);

    void remove(Quotes quotes);

    Quotes find(Object id);

    List<Quotes> findAll();

    List<Quotes> findRange(int[] range);

    int count();
    
}
