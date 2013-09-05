/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.RoleFacadeLocal;
import Entities.Role;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sparda
 */
@Stateless
public class RoleHandler implements RoleHandlerLocal {
    @EJB
    private RoleFacadeLocal roledao;
            
    @Override
    public void createNewRole(Role newRole) {
        
    }
}
