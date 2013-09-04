/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.AccomodationquotesFacadeLocal;
import DataAccess.CarquotesFacadeLocal;
import DataAccess.FinalcostingFacadeLocal;
import DataAccess.FlightquotesFacadeLocal;
import DataAccess.QuotesFacadeLocal;
import Entities.Finalcosting;
import Entities.Quotes;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aaron
 */
@Stateless
public class FinalCostingHandler implements FinalCostingHandlerLocal {
    
//     @EJB
//    private AccountFacadeLocal daoAccount;
//    @EJB
//    private ApplicationFacadeLocal daoApplication;    
    @EJB
    private FinalcostingFacadeLocal finalDao;
    @EJB
    private AccomodationquotesFacadeLocal accDao;
    @EJB
    private CarquotesFacadeLocal carDao;
    @EJB
    private FlightquotesFacadeLocal flightDao;
    @EJB
    private QuotesFacadeLocal quoteDao;
    
//    private Account account = new Account();
//    private Application app = new Application();
    private Quotes quotes = new Quotes();
    
    
    
    private Finalcosting fcostingRef;

    @Override
    public void persistFinalcosting(Finalcosting finalcosting) {
        // set global references for finalcosting for persistant use 
        //fcostingRef = finalcosting;
        // set the approval account / application to the curretly logged in account               
        // set the final costing to quotes selected
        //quotes.setIdquotes(1);
        //quotes = daoQuotesFacadeLocal.find(1);
        //finalcosting.setQuotesIdquotes(quotes);
        finalDao.create(finalcosting);       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @Override
//    public void persistQuoteFinalcosting(Finalcosting finalcosting, Quotes quote) {
//        // set global references for finalcosting for persistant use 
//        //fcostingRef = finalcosting;
//        // set the approval account / application to the curretly logged in account               
//        // set the final costing to quotes selected
//        //quotes.setIdquotes(1);
//        //quotes = daoQuotesFacadeLocal.find(1);
//        finalcosting.setQuotesIdquotes(quote);
//        
//        finalDao.create(finalcosting);       
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void updateFinalcosting(Finalcosting finalcosting, Integer finalcostingID) {
        //Integer fcostingID = null;
        Finalcosting newForm = finalcosting;
        Finalcosting oldForm = null;

        //Start by looking at Application Table. Application -> Travel ID -> ID Conference
//        List<Application> allApp = daoApplication.findAll();
//        for (Application eachApp : allApp) {
//            if (eachApp.getFinalcostingIdfinalcosting().getIdfinalcosting().equals(finalcostingID)) {
//                fcostingID = eachApp.getFinalcostingIdfinalcosting().getIdfinalcosting();
//            }
//        }
        
        //Try and match conferenceID to passed id
        List<Finalcosting> allFcostings = finalDao.findAll();
        for (Finalcosting eachfcost : allFcostings) {
            if (eachfcost.getIdfinalcosting().equals(finalcostingID)) {
                oldForm = eachfcost;
                //move conferenceID of old conference entry to new entry.
                newForm.setIdfinalcosting(oldForm.getIdfinalcosting());
                finalDao.edit(newForm);
            }
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Finalcosting findFinalcosting(Integer id) {
        
        List<Finalcosting> finalcostings = finalDao.findAll();
        for (Finalcosting fcost : finalcostings) {
            if (fcost.getIdfinalcosting().equals(id)) 
                return fcost;
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public void getSelectedQuotes(Quotes quote) {
//        String QuoteType = "";
//        int t = 0;
//        new Map<Object, Object>
//                
//        
//        
//    }
    
    public void getSelectedQuotes(int quoteID) {
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
