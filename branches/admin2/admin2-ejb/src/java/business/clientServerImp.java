/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DataAccess.AbstractFacade;
import Entity.Staff;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Riaan
 */
@Stateless
public class clientServerImp implements clientServer
{
    @EJB
    
    private AbstractFacade dao;
    
    @Override
    public void registerClient(Staff newStaff)
    {
	dao.create(newStaff);
    }
}
