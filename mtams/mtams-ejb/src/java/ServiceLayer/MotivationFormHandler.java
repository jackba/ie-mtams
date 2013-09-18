/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.ApplicationFacadeLocal;
import DataAccess.MotivationFacadeLocal;
import DataAccess.QuotesFacadeLocal;
import DataAccess.FinalcostingFacadeLocal;
import Entities.Application;
import Entities.Finalcosting;
import Entities.Motivation;
import Entities.Quotes;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Michelle Thornton
 */
@Stateless
public class MotivationFormHandler implements MotivationFormHandlerLocal {

    @EJB
    private MotivationFacadeLocal moti;
    @EJB
    private ApplicationFacadeLocal app;
    @EJB
    private QuotesFacadeLocal Qf;
    @EJB
    private FinalcostingFacadeLocal finalC;

    @Override
    public void persist(Motivation motivation) {
        moti.create(motivation);
    }

    @Override
    public void updateMoti(Motivation MotivEdit, Integer id) {
        Integer motiID = null;
        Motivation motiformNew = MotivEdit;
        Motivation motiformOld = null;
        List<Application> allApp = app.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                motiID = eachApp.getMotivationIdmotivation().getIdmotivation();
            }
        }

        List<Motivation> allMoti = moti.findAll();
        for (Motivation eachFor : allMoti) {
            if (eachFor.getIdmotivation().equals(motiID)) {
                motiformOld = eachFor;
            }
            motiformNew.setIdmotivation(motiformOld.getIdmotivation());
            moti.edit(motiformNew);
        }
    }

    public Motivation findMotivation(Integer id) {
        Integer motivationId = null;
        Motivation motiForm = null;
        List<Application> allApp = app.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                motivationId = eachApp.getMotivationIdmotivation().getIdmotivation();
            }
        }

        List<Motivation> allMoti = moti.findAll();
        for (Motivation eachMoti : allMoti) {
            if (eachMoti.getIdmotivation().equals(motivationId)) {
                motiForm = eachMoti;
            }
        }
        return motiForm;
    }

    public Quotes findQuotes(Integer id) {
        Integer quoteId = null;
        Quotes quoteForm = null;
        List<Application> allApp = app.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                quoteId = eachApp.getQuotesIdquotes().getIdquotes();
            }
        }

        List<Quotes> allQuotes = Qf.findAll();
        for (Quotes eachQf : allQuotes) {
            if (eachQf.getIdquotes().equals(quoteId)) {
                quoteForm = eachQf;
            }
        }
        return quoteForm;
    }

    public Finalcosting findFinalCosting(Integer id) {
        Integer finalCId = null;
        Finalcosting finalCForm = null;
        List<Application> allApp = app.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                finalCId = eachApp.getFinalcostingIdfinalcosting().getIdfinalcosting();
            }
        }

        List<Finalcosting> allfinalC = finalC.findAll();
        for (Finalcosting eachfinalC : allfinalC) {
            if (eachfinalC.getIdfinalcosting().equals(finalCId)) {
                finalCForm = eachfinalC;
            }
        }
        return finalCForm;
    }
}
