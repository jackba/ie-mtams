/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.MessagesFacadeLocal;
import Entities.Messages;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aaron
 */
@Stateless
public class MessagesHandler implements MessagesHandlerLocal {

    @EJB
    private MessagesFacadeLocal daoMessages;
//    @EJB
//    private MessagesHandler d;

    @Override
    public void persist(Messages message) {
        daoMessages.create(message);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Messages findMessages(Integer id) {
        //int[] t = new int[id.intValue()];
        return (Messages) daoMessages.findRange((new int[id.intValue()]));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMessages(Messages message, Integer id) {
        daoMessages.edit(message);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void updateMessages(Messages message) {
        daoMessages.edit(message);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Messages> getMessages() {
        return new ArrayList<Messages>(daoMessages.findAll());
    }
}
