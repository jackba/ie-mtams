/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import Entities.Role;
import javax.ejb.Local;

/**
 *
 * @author Sparda
 */
@Local
public interface RoleHandlerLocal {
    public void createNewRole(Role newRole);
}
