/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Forexorder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Michelle Thornton
 */
@Local
public interface ForexorderFacadeLocal {

    void create(Forexorder forexorder);

    void edit(Forexorder forexorder);

    void remove(Forexorder forexorder);

    Forexorder find(Object id);

    List<Forexorder> findAll();

    List<Forexorder> findRange(int[] range);

    int count();
    
}
