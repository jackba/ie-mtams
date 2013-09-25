/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DataAccess.ApplicationFacadeLocal;
import DataAccess.ConferenceFacadeLocal;
import DataAccess.QuotesFacadeLocal;
import DataAccess.TravelerprofileFacadeLocal;
import Entities.Application;
import Entities.Conference;
import Entities.Quotes;
import Entities.Travelerprofile;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco Remane
 */
@Stateless
public class ConferenceHandler implements ConferenceHandlerLocal {

    @EJB
    private QuotesFacadeLocal quotesDA;
    @EJB
    private ApplicationFacadeLocal applicationDA;
    @EJB
    private TravelerprofileFacadeLocal travelerDA;
    @EJB
    private ConferenceFacadeLocal conferenceDA;

    @Override
    public void persist(Conference conference) {
        conferenceDA.create(conference);
    }

    @Override
    public Travelerprofile findTravelerProfile(Integer id) {
        List<Travelerprofile> all = travelerDA.findAll();
        for (Travelerprofile each : all) {
            if (each.getAccountid().getIdaccount().equals(id)) {
                return each;
            }
        }
        return null;
    }

    @Override
    public Conference findConference(Integer id) {
        Integer conferenceID = null;
        Conference conferenceForm = null;
        //Start by looking at Application Table. Application -> Travel ID -> ID Conference
        List<Application> allApp = applicationDA.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                conferenceID = eachApp.getTravelIdtravel().getConferenceIdconference().getIdconference();
            }
        }

        //Try and match conferenceID to passed id
        List<Conference> allConferences = conferenceDA.findAll();
        for (Conference eachConf : allConferences) {
            if (eachConf.getIdconference().equals(conferenceID)) {
                conferenceForm = eachConf;
            }
        }
        return conferenceForm;
    }

    @Override
    public void updateConference(Conference c, Integer id) {
        Integer conferenceID = null;
        Conference newForm = c;
        Conference oldForm = null;

        //Start by looking at Application Table. Application -> Travel ID -> ID Conference
        List<Application> allApp = applicationDA.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                conferenceID = eachApp.getTravelIdtravel().getConferenceIdconference().getIdconference();
            }
        }

        //Try and match conferenceID to passed id
        List<Conference> allConferences = conferenceDA.findAll();
        for (Conference eachConf : allConferences) {
            if (eachConf.getIdconference().equals(conferenceID)) {
                oldForm = eachConf;
                //move conferenceID of old conference entry to new entry.
                newForm.setIdconference(oldForm.getIdconference());
                conferenceDA.edit(newForm);
            }
        }
    }

    @Override
    public Quotes findQuote(Integer id) {
        Integer quotesID = null;
        Quotes quoteObject = null;

        //Start by looking at Application Table. Application -> Quote ID
        List<Application> allApp = applicationDA.findAll();
        for (Application eachApp : allApp) {
            if (eachApp.getAccountIdaccount().getIdaccount().equals(id)) {
                quotesID = eachApp.getQuotesIdquotes().getIdquotes();
            }
        }

        //Try and match quotesID to passed id
        List<Quotes> allQuotes = quotesDA.findAll();
        for (Quotes eachQuote : allQuotes) {
            if (eachQuote.getIdquotes().equals(quotesID)) {
                quoteObject = eachQuote;
            }
        }
        return quoteObject;
    }
}
