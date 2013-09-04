/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Accomodationquotes;
import Entities.Account;
import Entities.Application;
import Entities.Approval;
import Entities.Carquotes;
import Entities.Currency;
import Entities.Finalcosting;
import Entities.Flightquotes;
import Entities.Itinerary;
import Entities.Quotes;
import Entities.Travel;
import Entities.Travelerprofile;
import ServiceLayer.AccountHandlerLocal;
import ServiceLayer.ApplicationHandlerLocal;
import ServiceLayer.ApprovalHandlerLocal;
import ServiceLayer.DataLookUpHandlerLocal;
import ServiceLayer.FinalCostingHandlerLocal;
import ServiceLayer.TravelProfileHandlerLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author aaron
 */
@Named(value = "finalCBean")
@SessionScoped
public class FinalCostingBean implements Serializable {
    ////////////////

    //private Integer accountID = 3;
    private Integer accountID = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("userID");
    //private Integer appnum = 1;
    private Integer appnum;
    // /////////////////////
    @EJB
    private TravelProfileHandlerLocal travelProfileHandler;
    @EJB
    private ApplicationHandlerLocal appHandler;
    @EJB
    private ApprovalHandlerLocal approvalHandler;
    @EJB
    private FinalCostingHandlerLocal finalHandler;
    @EJB
    private AccountHandlerLocal accHandler;
    @EJB
    private DataLookUpHandlerLocal daoDataLookUp;
//    @EJB
//    private FlightquotesFacadeLocal flightquotesFLHandler;
    // logger object for use in this class
    private static final Logger logger = Logger.getLogger(ApplicationBean.class.getName());
    // 
    // My vars used in this app
    // final costing table
    //
    @Pattern(message = "Input in field is incorrect, */' and numeric digits are not accepted", regexp = "[a-zA-Z -]{0,}")
    private String Name;
    @Pattern(message = "Input in field is incorrect, */' and numeric digits are not accepted", regexp = "[a-zA-Z -]{0,}")
    private String administrativeunit;
    // @Pattern(message="Incorrect number entered", regexp="[0-9]{0,}|^$")
    private int absencebussiness;
    //@Pattern(message="Incorrect number entered", regexp="[0-9]{0,}|^$")
    private int absenceprivate;
    @Pattern(message = "Input is incorrect, */' and numeric digits are not accepted", regexp = "[a-zA-Z -]{0,}")
    private String countries;
    @Pattern(message = "Input is incorrect, */' and numeric digits are not accepted", regexp = "[a-zA-Z -]{0,}")
    private String cities;
    private String Currency;
    private double AirfareBudget;
    private double AirfareCost;
    private double CarRentalBudget;
    private double CarRentalCost;
    private double AccommodationBudget;
    private double AccommodationCost;
    private int accommodatedays;
    private double perdiembudget;
    private double perdiemcost;
    private int perdiemdays;
    private double conferencebudget;
    private double conferencecost;
    private double visabudget;
    private double visacost;
    private double otherbudget;
    private double othercost;
    private String otherdiscription;
    private double approvedbudget;
    //@Pattern(message = "test", regexp = "")
    private double approvedcost;
    private int fromoz;
    private int checks;
    @Pattern(message = "Input in field is incorrect, */' and numeric digits are not accepted", regexp = "[a-zA-Z -]{0,}|^$")
    private String ozname;
    //http://stackoverflow.com/questions/16225015/bean-validation-multiple-regex-patterns-for-1-field
    // empty string match
    // "|^$" http://stackoverflow.com/a/17595879/619760
//    @Pattern.List({
//        @Pattern(message = "incorrect number", regexp = "[0-9]{10,16}"),
//        @Pattern(message = "or it needs to be empty", regexp = "^$")
//    })
    @Pattern(message = "incorrect number", regexp = "[0-9]{10,16}|^$")
    private String oztel;
    @Pattern(message = "Incorrect e-mail format", regexp = "^[_a-z0-9A-Z-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$|^$")
    private String ozemail;
    //
    // authorisation table
    //
    @Pattern(message = "Input in field is incorrect, */' and numeric digits are not accepted", regexp = "[a-zA-Z -]{0,}")
    private String fromsection;
    private int sectionid;
    private int sectionapproved;
    @Pattern(message = "Input in field is incorrect, */' and numeric digits are not accepted", regexp = "[a-zA-Z -]{0,}|^$")
    private String Notes;
    private Date DateStamp;
    //private List<Application> allApps;
    //private Application selectedApp;
    //
    // Reference variables to reference application objects 
    //
    private Finalcosting fCostRef;
    private Finalcosting newFinalCosting;
    private Approval aprrovalRef;
    private Approval newApproval;
    private Account accountRef;
    private Travelerprofile profileRef;// = travelProfileHandler.findTravelProf(accountID);
    private Application appRef;
    private Travel travelRef;
    private Itinerary itinRef;
    private Quotes quoteRef;
    private Flightquotes flightSelected;
    private Accomodationquotes accomodationSelected;
    private Carquotes carSelected;
    private List<Flightquotes> flights;
    private List<Accomodationquotes> hotels;
    private List<Carquotes> cars;
    

    /**
     * Creates a new instance of FinalCostingBean
     */
    public FinalCostingBean() {
        logger.log(Level.INFO, "Constructor");
        logger.log(Level.INFO, "test : {0}", accountID);
        //logger.log(Level.INFO, "test : {0}", appnum);

    }

    @PostConstruct
    public void initialize() {
        logger.log(Level.INFO, "initialize");
        appnum = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("appID");
        logger.log(Level.INFO, "accountID : {0}, appnum: {1}", new Object[]{accountID, appnum});
        //logger.log(Level.INFO, "test : {0}", appnum);        

        accountRef = accHandler.getAccount(accountID);
        profileRef = travelProfileHandler.findTravelProf(accountID);


        appRef = appHandler.getApplication(appnum);//selectedApp;

        quoteRef = appRef.getQuotesIdquotes();
        hotels = appHandler.getAccomodationQuotes(quoteRef.getIdquotes());
        cars = appHandler.getCarQuotes(quoteRef.getIdquotes());
        flights = appHandler.getFlightQuotes(quoteRef.getIdquotes());

        travelRef = appRef.getTravelIdtravel();
        itinRef = appHandler.getItinerary(travelRef.getIdtravel());

        //fCostRef = finalHandler.findFinalcosting(1);
        fCostRef = finalHandler.findFinalcosting(appRef.getFinalcostingIdfinalcosting().getIdfinalcosting());
        //aprrovalRef = approvalHandler.findApproval(appRef. appnum)findApprovalbyApplication(appnum);


        if (fCostRef.getAdministrativeunit() == null) {
            setAdministrativeunit(profileRef.getDepartment());
        } else {
            setAdministrativeunit(fCostRef.getAdministrativeunit());
        }

        if (fCostRef.getCountries() == null) {
            setCountries(itinRef.getDestinationCountry());
        } else {
            setCountries(fCostRef.getCountries());
        }

        if (fCostRef.getCitys() == null) {
            setCities(itinRef.getDestinationCity());
        } else {
            setCities(fCostRef.getCitys());
        }

        if (fCostRef.getName() == null) {
            setName(profileRef.getFirstname() + " " + profileRef.getFamilyname());
        } else {
            setName(fCostRef.getName());
        }

        // 
        // authorisation table
        //
        logger.log(Level.INFO, "dateStamp : {0}", DateStamp);
        Date today = new Date();
        if (DateStamp == null) {
            setDateStamp(today);
        }
        logger.log(Level.INFO, "after dateStamp : {0}", DateStamp);

//        logger.log(Level.INFO, "AirfareCost : {0}", AirfareCost);
        flightSelected = findflightSelected();
        logger.log(Level.INFO, "flightSelected : {0}", flightSelected);
        if (flightSelected == null) {
            setAirfareCost(((fCostRef.getAirfarecost() == null) ? 0 : fCostRef.getAirfarecost()));
//            logger.log(Level.INFO, "flightSelected == null : {0}", flightSelected);
        } else {
            setAirfareCost(flightSelected.getQuotecost());
//            logger.log(Level.INFO, "flightSelected.getQuotecost() : {0}", flightSelected.getQuotecost());
//            logger.log(Level.INFO, "AirfareCost : {0}", AirfareCost);
        }
//        logger.log(Level.INFO, "flightSelected : {0}", flightSelected.toString());
        logger.log(Level.INFO, "AirfareCost : {0}", AirfareCost);

        carSelected = findcarSelected();
        logger.log(Level.INFO, "carSelected : {0}", carSelected);
        if (carSelected == null) {
            setCarRentalCost(((fCostRef.getCarrentalcost() == null) ? 0 : fCostRef.getCarrentalcost()));
        } else {
            setCarRentalCost(carSelected.getQuotecost());
        }
        logger.log(Level.INFO, "CarRentalCost : {0}", CarRentalCost);

        accomodationSelected = findaccomodationSelected();
        logger.log(Level.INFO, "accomodationSelected : {0}", accomodationSelected);
        if (accomodationSelected == null) {
            setAccommodationCost(((fCostRef.getAccommodationcost() == null) ? 0 : fCostRef.getAccommodationcost()));
        } else {
            setAccommodationCost(accomodationSelected.getQuotecost());
        }
        logger.log(Level.INFO, "AccommodationCost : {0}", AccommodationCost);


        logger.log(Level.INFO, "fCostRef.getCurrency( : {0}", fCostRef.getCurrency());
        if (fCostRef.getCurrency() == null) {
            Currency aCurrencyRef;

            //private Currency aCurrencySelection;
            aCurrencyRef = daoDataLookUp.getCurrency("ZAR");
            logger.log(Level.INFO, "aCurrencyRef : {0}", aCurrencyRef.toString());
            setCurrency(aCurrencyRef.getCurrencycode3());
        } else {
            setCurrency(fCostRef.getCurrency());
        }
        logger.log(Level.INFO, "Currency : {0}", Currency);
        
        //setCurrency(((fCostRef.getCurrency() == null) ? "" : fCostRef.getCurrency()));

        //boolean test = (fCostRef.getAccommodatedays() == null);
        //int test2 = ((fCostRef.getAbsencebussiness() == null) ? 0 : 1);

        setAbsencebussiness(((fCostRef.getAbsencebussiness() == null) ? 0 : fCostRef.getAbsencebussiness()));
        setAbsenceprivate(((fCostRef.getAbsenceprivate() == null) ? 0 : fCostRef.getAbsenceprivate()));
        //setAccommodatedays(((fCostRef.getAccommodatedays() == null) ? 0 : fCostRef.getAccommodatedays()));
        setAccommodatedays(fCostRef.getAccommodatedays());

        setAccommodationBudget(((fCostRef.getAccommodationbudget() == null) ? 0 : fCostRef.getAccommodationbudget()));

//      setAdministrativeunit(((fCostRef.getAdministrativeunit() == null) ? 0 : fCostRef.getAdministrativeunit()));
        setAirfareBudget(((fCostRef.getAirfarebudget() == null) ? 0 : fCostRef.getAirfarebudget()));

        setCarRentalBudget(((fCostRef.getCarrentalbudget() == null) ? 0 : fCostRef.getCarrentalbudget()));


        setChecks(((fCostRef.getChecks() == null) ? 0 : fCostRef.getChecks()));
        //setCities(((fCostRef.getCitys() == null) ? 0 : fCostRef.getCitys()));
        setConferencebudget(((fCostRef.getConferencebudget() == null) ? 0 : fCostRef.getConferencebudget()));
        setConferencecost(((fCostRef.getConferencecost() == null) ? 0 : fCostRef.getConferencecost()));
        //setCountries(((fCostRef.getCountries() == null) ? 0 : fCostRef.getCountries()));

        setFromoz(((fCostRef.getFromoz() == null) ? 0 : fCostRef.getFromoz()));
        //setName(((fCostRef.getName() == null) ? 0 : fCostRef.getName()));
        setOtherbudget(((fCostRef.getOtherbudget() == null) ? 0 : fCostRef.getOtherbudget()));
        setOthercost(((fCostRef.getOthercost() == null) ? 0 : fCostRef.getOthercost()));
        setOtherdiscription(((fCostRef.getOtherdiscription() == null) ? "" : fCostRef.getOtherdiscription()));
        setOzemail(((fCostRef.getOzemail() == null) ? "" : fCostRef.getOzemail()));
        setOzname(((fCostRef.getOzname() == null) ? "" : fCostRef.getOzname()));
        setOztel(((fCostRef.getOztel() == null) ? "" : fCostRef.getOztel()));
        setPerdiembudget(((fCostRef.getPerdiembudget() == null) ? 0 : fCostRef.getPerdiembudget()));
        setPerdiemcost(((fCostRef.getPerdiemcost() == null) ? 0 : fCostRef.getPerdiemcost()));
        //setPerdiemdays(((fCostRef.getPerdiemdays() == null) ? 0 : fCostRef.getPerdiemdays()));
        setPerdiemdays(fCostRef.getPerdiemdays());
        //setQuotesIdquotes(((fCostRef.getQuotesIdquotes() == null) ? 0 : fCostRef.getQuotesIdquotes()));
        setVisabudget(((fCostRef.getVisabudget() == null) ? 0 : fCostRef.getVisabudget()));
        setVisacost(((fCostRef.getVisacost() == null) ? 0 : fCostRef.getVisacost()));

        setApprovedbudget(((fCostRef.getApprovedbudget() == null) ? 0 : fCostRef.getApprovedbudget()));
        setApprovedcost(((fCostRef.getApprovedcost() == null) ? 0 : fCostRef.getApprovedcost()));


        setFromsection("Final Costing");

        logger.log(Level.INFO, "bflightSelected : {0}", flightSelected.toString());
        logger.log(Level.INFO, "bAirfareCost : {0}", AirfareCost);

        logger.log(Level.INFO, "dateStamp : {0}", DateStamp);

        logger.log(Level.INFO, "Itineary : {0}", itinRef.toString());
        logger.log(Level.INFO, "DestinationCity : {0}", itinRef.getDestinationCity());
        logger.log(Level.INFO, "getCities() : {0}", getCities());
        logger.log(Level.INFO, "Department : {0}", profileRef.getDepartment());

        logger.log(Level.INFO, "acount : {0}", accountID);
        logger.log(Level.INFO, "application : {0}", appnum);
    }

    private Flightquotes findflightSelected() {
        logger.log(Level.INFO, "findflightSelected : {0}", flights.toString());
        for (Flightquotes FQ : flights) {
            if (FQ.getSelected() == 1) {
                return FQ;
            }
        }
        return null;
    }

    private Carquotes findcarSelected() {
        for (Carquotes CQ : cars) {
            if (CQ.getSelected() == 1) {
                return CQ;
            }
        }
        return null;
    }

    private Accomodationquotes findaccomodationSelected() {
        for (Accomodationquotes AQ : hotels) {
            if (AQ.getSelected() == 1) {
                return AQ;
            }
        }
        return null;
    }

    public void budgetCalc() {
        approvedbudget = calcTotalBudget();
    }

    public void costCalc() {
        approvedcost = calcTotalCost();
    }

    private double calcTotalBudget() {
        return AccommodationBudget + AirfareBudget + CarRentalBudget + conferencebudget + otherbudget + perdiembudget + visabudget;
    }

    private double calcTotalCost() {
        return AccommodationCost + AirfareCost + CarRentalCost + conferencecost + othercost + perdiemcost + visacost;
    }

    public String createFinalCosting() {
        //profileRef = travelProfileHandler.findTravelProf(accountID);
        logger.log(Level.INFO, "createFinalCosting : {0}", "start");

        newFinalCosting = new Finalcosting();
        // items in alphabetic listing
        logger.log(Level.INFO, "newFinalCosting : {0}", "start");
        logger.log(Level.INFO, "newFinalCosting : {0}", newFinalCosting.toString());
        
        newFinalCosting.setAbsencebussiness(absencebussiness);
        newFinalCosting.setAbsenceprivate(absenceprivate);
        newFinalCosting.setAccommodatedays(accommodatedays);
        newFinalCosting.setAccommodationbudget(AccommodationBudget);
        newFinalCosting.setAccommodationcost(AccommodationCost);
        newFinalCosting.setAdministrativeunit(administrativeunit);
        newFinalCosting.setAirfarebudget(AirfareBudget);
        newFinalCosting.setAirfarecost(AirfareCost);
        //newFinalCosting.setApplicationCollection(null);
        newFinalCosting.setApprovedbudget(calcTotalBudget());
        newFinalCosting.setApprovedcost(calcTotalCost());
        newFinalCosting.setCarrentalbudget(CarRentalBudget);
        newFinalCosting.setCarrentalcost(CarRentalCost);
        newFinalCosting.setChecks(checks);
        newFinalCosting.setCitys(cities);
        newFinalCosting.setConferencebudget(conferencebudget);
        newFinalCosting.setConferencecost(conferencecost);
        newFinalCosting.setCountries(countries);
        newFinalCosting.setCurrency(Currency);
        newFinalCosting.setFromoz(fromoz);
        newFinalCosting.setName(Name);
        newFinalCosting.setOtherbudget(otherbudget);
        newFinalCosting.setOthercost(othercost);
        newFinalCosting.setOtherdiscription(otherdiscription);
        newFinalCosting.setOzemail(ozemail);
        newFinalCosting.setOzname(ozname);
        newFinalCosting.setOztel(oztel);
        newFinalCosting.setPerdiembudget(perdiembudget);
        newFinalCosting.setPerdiemcost(perdiemcost);
        newFinalCosting.setPerdiemdays(perdiemdays);
        newFinalCosting.setQuotesIdquotes(quoteRef);
        newFinalCosting.setVisabudget(visabudget);
        newFinalCosting.setVisacost(visacost);
        logger.log(Level.INFO, "newFinalCosting : {0}", "end");
        logger.log(Level.INFO, "newFinalCosting : {0}", newFinalCosting.toString());

        finalHandler.persistFinalcosting(newFinalCosting);


        newApproval = new Approval();

        newApproval.setApplicationIdapplication(appRef);
        newApproval.setAccountIdaccount(accountRef);
        newApproval.setDate(DateStamp);
        newApproval.setNotes(Notes);
        newApproval.setFromsection("Final Costing");
        newApproval.setSectionid(sectionid);

        approvalHandler.persistApproval(newApproval);

        FacesContext.getCurrentInstance().addMessage("submitConfirm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Final Costing Created and Authorised"));
        return "finalCostingView";
    }

    public void update() {
        logger.log(Level.INFO, "loadValues");

//        accountRef = accHandler.getAccount(accountID);
//        
//        profileRef = travelProfileHandler.findTravelProf(accountID);        
//
//        appRef = appHandler.getApplication(appnum);//selectedApp;
//        
//        fCostRef = finalHandler.findFinalcosting(appRef.getFinalcostingIdfinalcosting().getIdfinalcosting());

        newFinalCosting = new Finalcosting();
        // items in alphabetic listing
        newFinalCosting.setAbsencebussiness(absencebussiness);
        newFinalCosting.setAbsenceprivate(absenceprivate);
        newFinalCosting.setAccommodatedays(accommodatedays);
        newFinalCosting.setAccommodationbudget(AccommodationBudget);
        newFinalCosting.setAccommodationcost(AccommodationCost);
        newFinalCosting.setAdministrativeunit(administrativeunit);
        newFinalCosting.setAirfarebudget(AirfareBudget);
        newFinalCosting.setAirfarecost(AirfareCost);
        //newFinalCosting.setApplicationCollection(null);
        newFinalCosting.setApprovedbudget(approvedbudget);
        newFinalCosting.setApprovedcost(approvedcost);
        newFinalCosting.setCarrentalbudget(CarRentalBudget);
        newFinalCosting.setCarrentalcost(CarRentalCost);
        newFinalCosting.setChecks(checks);
        newFinalCosting.setCitys(cities);
        newFinalCosting.setConferencebudget(conferencebudget);
        newFinalCosting.setConferencecost(conferencecost);
        newFinalCosting.setCountries(countries);
        newFinalCosting.setCurrency(Currency);
        newFinalCosting.setFromoz(fromoz);
        newFinalCosting.setName(Name);
        newFinalCosting.setOtherbudget(otherbudget);
        newFinalCosting.setOthercost(othercost);
        newFinalCosting.setOtherdiscription(otherdiscription);
        newFinalCosting.setOzemail(ozemail);
        newFinalCosting.setOzname(ozname);
        newFinalCosting.setOztel(oztel);
        newFinalCosting.setPerdiembudget(perdiembudget);
        newFinalCosting.setPerdiemcost(perdiemcost);
        newFinalCosting.setPerdiemdays(perdiemdays);
        newFinalCosting.setQuotesIdquotes(quoteRef);
        newFinalCosting.setVisabudget(visabudget);
        newFinalCosting.setVisacost(visacost);

        finalHandler.persistFinalcosting(newFinalCosting);


        newApproval = new Approval();

        newApproval.setApplicationIdapplication(appRef);
        newApproval.setAccountIdaccount(accountRef);
        newApproval.setDate(DateStamp);
        newApproval.setNotes(Notes);
        newApproval.setFromsection("Final Costing");
        newApproval.setSectionid(sectionid);

        approvalHandler.persistApproval(newApproval);


    }

    // Used for the tab wizzard <p:wizard
    public String onFlowProcess(FlowEvent event) {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());

//        logger.log(Level.INFO, "getDepartment : {0}", profileRef.getDepartment());
//        logger.log(Level.INFO, "currency : {0}", Currency);

        if (event.getOldStep().equalsIgnoreCase("authotabCosting")) {
            budgetCalc();
            costCalc();
        }


        return event.getNewStep();
    }

    /////////////////////////////////
    //
    // Auto generated setters && getters.
    //
    ///////////////////////////////
    public Flightquotes getFlightSelected() {
        return flightSelected;
    }

    public void setFlightSelected(Flightquotes flightSelected) {
        this.flightSelected = flightSelected;
    }

    public Accomodationquotes getAccomodationSelected() {
        return accomodationSelected;
    }

    public void setAccomodationSelected(Accomodationquotes accomodationSelected) {
        this.accomodationSelected = accomodationSelected;
    }

    public Carquotes getCarSelected() {
        return carSelected;
    }

    public void setCarSelected(Carquotes carSelected) {
        this.carSelected = carSelected;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public Integer getAppnum() {
        return appnum;
    }

    public void setAppnum(Integer appnum) {
        this.appnum = appnum;
    }

    public TravelProfileHandlerLocal getTravelProfileHandler() {
        return travelProfileHandler;
    }

    public void setTravelProfileHandler(TravelProfileHandlerLocal travelProfileHandler) {
        this.travelProfileHandler = travelProfileHandler;
    }

    public ApplicationHandlerLocal getAppHandler() {
        return appHandler;
    }

    public void setAppHandler(ApplicationHandlerLocal appHandler) {
        this.appHandler = appHandler;
    }

    public ApprovalHandlerLocal getApprovalHandler() {
        return approvalHandler;
    }

    public void setApprovalHandler(ApprovalHandlerLocal approvalHandler) {
        this.approvalHandler = approvalHandler;
    }

    public AccountHandlerLocal getAccHandler() {
        return accHandler;
    }

    public void setAccHandler(AccountHandlerLocal accHandler) {
        this.accHandler = accHandler;
    }

    public int getAbsencebussiness() {
        return absencebussiness;
    }

    public void setAbsencebussiness(int absencebussiness) {
        this.absencebussiness = absencebussiness;
    }

    public int getAbsenceprivate() {
        return absenceprivate;
    }

    public void setAbsenceprivate(int absenceprivate) {
        this.absenceprivate = absenceprivate;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public int getChecks() {
        return checks;
    }

    public void setChecks(int checks) {
        this.checks = checks;
    }

    public double getAirfareBudget() {
        return AirfareBudget;
    }

    public void setAirfareBudget(double AirfareBudget) {
        this.AirfareBudget = AirfareBudget;
    }

    public double getAirfareCost() {
        return AirfareCost;
    }

    public void setAirfareCost(double AirfareCost) {
        this.AirfareCost = AirfareCost;
    }

    public double getCarRentalBudget() {
        return CarRentalBudget;
    }

    public void setCarRentalBudget(double CarRentalBudget) {
        this.CarRentalBudget = CarRentalBudget;
    }

    public double getCarRentalCost() {
        return CarRentalCost;
    }

    public void setCarRentalCost(double CarRentalCost) {
        this.CarRentalCost = CarRentalCost;
    }

    public double getAccommodationBudget() {
        return AccommodationBudget;
    }

    public void setAccommodationBudget(double AccommodationBudget) {
        this.AccommodationBudget = AccommodationBudget;
    }

    public double getAccommodationCost() {
        return AccommodationCost;
    }

    public void setAccommodationCost(double AccommodationCost) {
        this.AccommodationCost = AccommodationCost;
    }

    public int getAccommodatedays() {
        return accommodatedays;
    }

    public void setAccommodatedays(int accommodatedays) {
        this.accommodatedays = accommodatedays;
    }

    public double getPerdiembudget() {
        return perdiembudget;
    }

    public void setPerdiembudget(double perdiembudget) {
        this.perdiembudget = perdiembudget;
    }

    public double getPerdiemcost() {
        return perdiemcost;
    }

    public void setPerdiemcost(double perdiemcost) {
        this.perdiemcost = perdiemcost;
    }

    public int getPerdiemdays() {
        return perdiemdays;
    }

    public void setPerdiemdays(int perdiemdays) {
        this.perdiemdays = perdiemdays;
    }

    public double getConferencebudget() {
        return conferencebudget;
    }

    public void setConferencebudget(double conferencebudget) {
        this.conferencebudget = conferencebudget;
    }

    public double getConferencecost() {
        return conferencecost;
    }

    public void setConferencecost(double conferencecost) {
        this.conferencecost = conferencecost;
    }

    public double getVisabudget() {
        return visabudget;
    }

    public void setVisabudget(double visabudget) {
        this.visabudget = visabudget;
    }

    public double getVisacost() {
        return visacost;
    }

    public void setVisacost(double visacost) {
        this.visacost = visacost;
    }

    public double getOtherbudget() {
        return otherbudget;
    }

    public void setOtherbudget(double otherbudget) {
        this.otherbudget = otherbudget;
    }

    public double getOthercost() {
        return othercost;
    }

    public void setOthercost(double othercost) {
        this.othercost = othercost;
    }

    public String getOtherdiscription() {
        return otherdiscription;
    }

    public void setOtherdiscription(String otherdiscription) {
        this.otherdiscription = otherdiscription;
    }

    public double getApprovedbudget() {
        return approvedbudget;
    }

    public void setApprovedbudget(double approvedbudget) {
        this.approvedbudget = approvedbudget;
    }

    public double getApprovedcost() {
        return approvedcost;
    }

    public void setApprovedcost(double approvedcost) {
        this.approvedcost = approvedcost;
    }

    public int getFromoz() {
        return fromoz;
    }

    public void setFromoz(int fromoz) {
        this.fromoz = fromoz;
    }

    public String getOzname() {
        return ozname;
    }

    public void setOzname(String ozname) {
        this.ozname = ozname;
    }

    public String getOztel() {
        return oztel;
    }

    public void setOztel(String oztel) {
        this.oztel = oztel;
    }

    public String getOzemail() {
        return ozemail;
    }

    public void setOzemail(String ozemail) {
        this.ozemail = ozemail;
    }

    public Travelerprofile getProfileRef() {
        return profileRef;
    }

    public void setProfileRef(Travelerprofile profileRef) {
        this.profileRef = profileRef;
    }

    public Application getAppRef() {
        return appRef;
    }

    public void setAppRef(Application appRef) {
        this.appRef = appRef;
    }

    public Travel getTravelRef() {
        return travelRef;
    }

    public void setTravelRef(Travel travelRef) {
        this.travelRef = travelRef;
    }

    public Itinerary getItinRef() {
        return itinRef;
    }

    public void setItinRef(Itinerary itinRef) {
        this.itinRef = itinRef;
    }

    public Quotes getQuoteRef() {
        return quoteRef;
    }

    public void setQuoteRef(Quotes quoteRef) {
        this.quoteRef = quoteRef;
    }

    public List<Flightquotes> getFlights() {
        return flights;
    }

    public void setFlights(List<Flightquotes> flights) {
        this.flights = flights;
    }

    public List<Accomodationquotes> getHotels() {
        return hotels;
    }

    public void setHotels(List<Accomodationquotes> hotels) {
        this.hotels = hotels;
    }

    public List<Carquotes> getCars() {
        return cars;
    }

    public void setCars(List<Carquotes> cars) {
        this.cars = cars;
    }

    public String getFromsection() {
        return fromsection;
    }

    public void setFromsection(String fromsection) {
        this.fromsection = fromsection;
    }

    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }

    public int getSectionapproved() {
        return sectionapproved;
    }

    public void setSectionapproved(int sectionapproved) {
        this.sectionapproved = sectionapproved;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public Date getDateStamp() {
        return DateStamp;
    }

    public void setDateStamp(Date DateStamp) {
        this.DateStamp = DateStamp;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAdministrativeunit() {
        return administrativeunit;
    }

    public void setAdministrativeunit(String administrativeunit) {
        this.administrativeunit = administrativeunit;
    }

    public FinalCostingHandlerLocal getFinalHandler() {
        return finalHandler;
    }

    public void setFinalHandler(FinalCostingHandlerLocal finalHandler) {
        this.finalHandler = finalHandler;
    }

    public Finalcosting getfCostRef() {
        return fCostRef;
    }

    public void setfCostRef(Finalcosting fCostRef) {
        this.fCostRef = fCostRef;
    }

    public Finalcosting getNewFinalCosting() {
        return newFinalCosting;
    }

    public void setNewFinalCosting(Finalcosting newFinalCosting) {
        this.newFinalCosting = newFinalCosting;
    }
}
