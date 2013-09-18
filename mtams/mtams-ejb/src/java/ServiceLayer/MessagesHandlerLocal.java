/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Messages;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author aaron
 */
@Local
public interface MessagesHandlerLocal {
    
    public void persist(Messages message);
    public Messages findMessages(Integer id);
    public Messages findMessages(String name);
    public ArrayList<Messages> getMessages();
    public void updateMessages(Messages message, Integer id);
    public void updateMessages(Messages message);
}
