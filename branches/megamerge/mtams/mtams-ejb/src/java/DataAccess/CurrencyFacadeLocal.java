/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Currency;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Badger
 */
@Local
public interface CurrencyFacadeLocal {

    void create(Currency currency);

    void edit(Currency currency);

    void remove(Currency currency);

    Currency find(Object id);

    List<Currency> findAll();

    List<Currency> findRange(int[] range);

    int count();
    
}
