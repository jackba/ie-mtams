/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entity.Travelerprofile;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Riaan
 */
@Local
public interface TravelerprofileFacadeLocal {

    void create(Travelerprofile travelerprofile);

    void edit(Travelerprofile travelerprofile);

    void remove(Travelerprofile travelerprofile);

    Travelerprofile find(Object id);

    List<Travelerprofile> findAll();

    List<Travelerprofile> findRange(int[] range);

    int count();
    
}
