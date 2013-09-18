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
            if (eachfcost.getIdfinalcosting().equals(finalcostingID)) {
                oldForm = eachfcost;
                //move conferenceID of old conference entry to new entry.
                newForm.setIdfinalcosting(oldForm.getIdfinalcosting());
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
