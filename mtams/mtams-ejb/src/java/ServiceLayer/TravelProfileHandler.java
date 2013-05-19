/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccountFacadeLocal;
import DataAccess.RewardsprogramFacadeLocal;
import DataAccess.TraveldocumentFacadeLocal;
import DataAccess.TravelerprofileFacadeLocal;
import Entities.Account;
import Entities.Rewardsprogram;
import Entities.Traveldocument;
import Entities.Travelerprofile;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sparda
 */
@Stateless
public class TravelProfileHandler implements TravelProfileHandlerLocal {
    @EJB
    private TravelerprofileFacadeLocal dao;
    @EJB
    private TraveldocumentFacadeLocal daoPassport;
    @EJB
    private RewardsprogramFacadeLocal daoReward;
    @EJB
    private AccountFacadeLocal accountRef;
    
    //private Account alex = new Account();
    private Travelerprofile profileRef;
    @Override
    public void persist(Integer id, Travelerprofile profile, Traveldocument passport) {
        //Create Refrence OBJ of Travelers Profile for use in persistReward()
        profileRef = profile;
        //Create Dummy Account ID
        //alex.setIdaccount(4);
        Account acc = accountRef.find(id);
        profile.setAccountid(acc);
        //Create Travellers Profile        
        dao.create(profile);
        //Create TravelDocument
        passport.setTravlerprofileIdtravlerprofile(profile);//Establish Correct FK Reference to Travellers Profile
        daoPassport.create(passport);        
        
    }
    @Override
    public void persistReward(Rewardsprogram reward){
        reward.setTravelerprofileIdtravelerprofile(profileRef);
        daoReward.create(reward);
    }
    
    @Override
     public Travelerprofile findTravelProf(Integer id)
     {
        
        List<Travelerprofile> all = dao.findAll();
        for(Travelerprofile each : all){
            if(each.getAccountid().getIdaccount().equals(id)){
                return each;
                
            }
        }
        return null;
     }
    @Override
    public Traveldocument findTravelDoc(Integer id)
     {        
        List<Traveldocument> all = daoPassport.findAll();
        for(Traveldocument each : all){
            if(each.getTravlerprofileIdtravlerprofile().getIdtravelerprofile().equals(id)){
                return each;
                
            }
        }
        return null;
     }
             
    @Override
    public List<Rewardsprogram> findRewards(Integer id)
     {        
        List<Rewardsprogram> rewards = new ArrayList<Rewardsprogram>();
        List<Rewardsprogram> all = daoReward.findAll();
        
        for(Rewardsprogram each : all){
            if(each.getTravelerprofileIdtravelerprofile().getIdtravelerprofile().equals(id)){
                rewards.add(each);
                
            }
        }
        return rewards;
     }     
}
