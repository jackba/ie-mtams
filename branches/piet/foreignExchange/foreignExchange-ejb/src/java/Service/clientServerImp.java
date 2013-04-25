/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataAccess.AccountFacadeLocal;
import DataAccess.TraveldocumentFacadeLocal;
import DataAccess.TravelerprofileFacadeLocal;
import Entity.Account;
import Entity.Traveldocument;
import Entity.Travelerprofile;
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
    private AccountFacadeLocal afl;
    @EJB
    private TravelerprofileFacadeLocal tpf;
    @EJB
    private TraveldocumentFacadeLocal tdocf;
    
    
     @Override
     public Travelerprofile find(Integer id)
     {
        Account acc = afl.find(id);
        List<Travelerprofile> all = tpf.findAll();
        for(Travelerprofile each : all){
            if(each.getAccountid().getIdaccount().equals(id)){
                return each;
                
            }
        }
        return null;
     }
     
     @Override
     public Traveldocument findDocument(Integer id)
     {
         Travelerprofile ttf = tpf.find(id);
         List<Traveldocument> all = tdocf.findAll();
         for(Traveldocument each : all)
         {
             if(each.getTravlerprofileIdtravlerprofile().getIdtravelerprofile().equals(id))
                 return each;
         }
         return null;
     }
}
