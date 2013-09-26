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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aaron
 */
@Stateless
public class FinalCostingHandler implements FinalCostingHandlerLocal {

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
    private Quotes quotes = new Quotes();
    private Finalcosting fcostingRef;
    private static final Logger logger = Logger.getLogger(DataLookUpHandler.class.getName());

    @Override
    public void persistFinalcosting(Finalcosting finalcosting) {

        finalDao.create(finalcosting);

    }

    @Override
    public void updateFinalcosting(Finalcosting finalcosting, Integer finalcostingID) {

        Finalcosting newForm = finalcosting;
        Finalcosting oldForm = null;
        List<Finalcosting> allFcostings = finalDao.findAll();
        for (Finalcosting eachfcost : allFcostings) {
            logger.log(Level.INFO, "eachfcost.getIdfinalcosting(): {0}", eachfcost.getIdfinalcosting());
            if (eachfcost.getIdfinalcosting().equals(finalcostingID)) {
                oldForm = eachfcost;
                logger.log(Level.INFO, "oldForm: {0}", oldForm.getIdfinalcosting());
                //move conferenceID of old conference entry to new entry.
                newForm.setIdfinalcosting(oldForm.getIdfinalcosting());
                logger.log(Level.INFO, "newForm: {0}", newForm.getIdfinalcosting());
                finalDao.edit(newForm);
            }
        }

    }

    @Override
    public Finalcosting findFinalcosting(Integer id) {

        List<Finalcosting> finalcostings = finalDao.findAll();
        for (Finalcosting fcost : finalcostings) {
            if (fcost.getIdfinalcosting().equals(id)) {
                return fcost;
            }
        }
        return null;

    }

    public void getSelectedQuotes(int quoteID) {
    }
}
