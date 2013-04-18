/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DataAccess.StaffFacadeLocal;
import Entity.Staff;
import java.util.List;
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
    private StaffFacadeLocal dao;
    
    @Override
    public void registerClient(Staff newStaff)
    {
	dao.create(newStaff);
    }
    
    @Override
    public List<Staff> getAllStaff()
    {
        return dao.findAll();
    }
}
