/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Accomodationquotes;
import Entities.Application;
import Entities.Carquotes;
import Entities.Flightquotes;
import Entities.Itinerary;
import Entities.Quotes;
import Entities.Travel;
import Entities.Travelerprofile;
import ServiceLayer.ApplicationHandlerLocal;
import ServiceLayer.TravelProfileHandlerLocal;
//import java.awt.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.*;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Badger
 */
@Named(value = "appBean")
@ConversationScoped
public class ApplicationBean implements Serializable {

    @EJB
    private TravelProfileHandlerLocal travelProfileHandler;
    @EJB
    private ApplicationHandlerLocal appHandler;
    
    private static final Logger logger = Logger.getLogger(ApplicationBean.class.getName());
    
    private List<Application> allApps;
    private Application selectedApp;
    
    private Integer accountID = (Integer)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userID");
    private Travelerprofile profileRef;//travelProfileHandler.findTravelProf(accountID);
    
    private Date modifiedDate;
    @Future
    private Date departureDate;
    @Future
    private Date returnDate;
    private String description;
    private Travel newTravel;
    private Itinerary tempItin;
    @Future
    private Date tempDate;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String tempDest;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String tempLeaveType;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String tempTravelDay;
    
    private String costCentre;
    private Quotes newQuote;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String fQFrom;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String fQTo;
    @Future
    private Date fQDate;
    private String fQTime;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String fQFlight1;
    @Pattern(message = "Incorrect Number", regexp = "[0-9]{0,10}")
    private String fQCost1;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String fQFlight2;
    @Pattern(message = "Incorrect Number", regexp = "[0-9]{0,10}")
    private String fQCost2;
    private List<Flightquotes> flightQuotes;
    private Flightquotes newFlight;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String cQFrom;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String cQTo;
    @Future
    private Date cQDateCollected;
    @Future
    private Date cQDateReturned;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String cQHire1;
    @Pattern(message = "Incorrect Number", regexp = "[0-9]{0,10}")
    private String cQCost1;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String cQHire2;
    @Pattern(message = "Incorrect Number", regexp = "[0-9]{0,10}")
    private String cQCost2;
    private List<Carquotes> carQuotes;
    private Carquotes newCar;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String hQLocation;
    @Future
    private Date hQDateIn;
    @Future
    private Date hQDateOut;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String hQHotel1;
    @Pattern(message = "Incorrect Number", regexp = "[0-9]{0,10}")
    private String hQCost1;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z']{0,}")
    private String hQHotel2;
    @Pattern(message = "Incorrect Number", regexp = "[0-9]{0,10}")
    private String hQCost2;
    private List<Accomodationquotes> accQuotes;
    private Accomodationquotes newAcc;
    private List<Itinerary> hops = new ArrayList<Itinerary>();
    private UIData hopTable;
    private UIForm form;
    private UIPanel panel;
    private UIInput input = new UIInput();
    
    private int idNum = 0;
    private List<Flightquotes> flights;
    private List<Accomodationquotes> hotels;
    private List<Carquotes> cars;
    private Application appRef;
    private Travel travelRef;
    private Itinerary itinRef;
    private Quotes quoteRef;
    
    private String reasonForTravel;
    private Application newApplication;

    /**
     * Creates a new instance of ApplicationBean
     */
    public ApplicationBean() {
    }

    @PostConstruct
    public void initialize() {
//        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

//        Application tempApp = new Application();
//        tempApp.setDescription("going somewhere");
//        tempApp.setDatemodified(new Date());
//        
//        allApps.add(tempApp);
        
        
        profileRef = travelProfileHandler.findTravelProf(accountID);
        //loadValues();
        
        appRef = appHandler.getApplication(selectedApp.getIdapplication());//selectedApp;
        
        quoteRef = appRef.getQuotesIdquotes();
        hotels = appHandler.getAccomodationQuotes(quoteRef.getIdquotes());
        cars = appHandler.getCarQuotes(quoteRef.getIdquotes());
        flights = appHandler.getFlightQuotes(quoteRef.getIdquotes());
        travelRef = appRef.getTravelIdtravel();
        itinRef = appHandler.getItinerary(travelRef.getIdtravel());
        
        description = appRef.getDescription();
        
        setDepartureDate(travelRef.getDatedeparture());
        setReturnDate(travelRef.getDatereturn());
        setReasonForTravel(travelRef.getDescription());
        
        setTempDate(itinRef.getDate());
        setTempDest(itinRef.getDestination());
        setTempLeaveType(itinRef.getLeavetype());
        setTempTravelDay(itinRef.getTravelday());
        
        setCostCentre(quoteRef.getCostcenter());
    }

    public String createApplication() {
        modifiedDate = new Date();
        newApplication = new Application();

        newApplication.setDatemodified(modifiedDate);
        newApplication.setDescription(description);
        newApplication.setTravelerprofileIdtravelerprofile(profileRef);
        //newApplication.setAccountIdaccount(accountID);

        newTravel = new Travel();
        newTravel.setDatedeparture(departureDate);
        newTravel.setDatereturn(returnDate);
        newTravel.setDescription(reasonForTravel);

        newQuote = new Quotes();
        newQuote.setCostcenter(costCentre);

        accQuotes = new ArrayList<Accomodationquotes>();
        newAcc = new Accomodationquotes();

        newAcc.setAccomodationprovider(hQHotel1);
        newAcc.setQuotecost(hQCost1);
        newAcc.setCity(hQLocation);
        newAcc.setDatecheckin(hQDateIn);
        newAcc.setDatecheckout(hQDateOut);

        accQuotes.add(newAcc);

        newAcc = new Accomodationquotes();

        newAcc.setAccomodationprovider(hQHotel2);
        newAcc.setQuotecost(hQCost2);
        newAcc.setCity(hQLocation);
        newAcc.setDatecheckin(hQDateIn);
        newAcc.setDatecheckout(hQDateOut);

        accQuotes.add(newAcc);

        carQuotes = new ArrayList<Carquotes>();
        newCar = new Carquotes();

        newCar.setDatecollect(cQDateCollected);
        newCar.setDatereturn(cQDateReturned);
        newCar.setProvider(cQHire1);
        newCar.setQuotecost(cQCost1);

        carQuotes.add(newCar);

        newCar = new Carquotes();

        newCar.setDatecollect(cQDateCollected);
        newCar.setDatereturn(cQDateReturned);
        newCar.setProvider(cQHire2);
        newCar.setQuotecost(cQCost2);

        carQuotes.add(newCar);

        flightQuotes = new ArrayList<Flightquotes>();
        newFlight = new Flightquotes();

        newFlight.setFlightfrom(fQFrom);
        newFlight.setFlightto(fQTo);
        newFlight.setDatedeparture(fQDate);
        newFlight.setQuotesource(fQFlight1);
        newFlight.setQuotecost(fQCost1);

        flightQuotes.add(newFlight);

        newFlight = new Flightquotes();

        newFlight.setFlightfrom(fQFrom);
        newFlight.setFlightto(fQTo);
        newFlight.setDatedeparture(fQDate);
        newFlight.setQuotesource(fQFlight2);
        newFlight.setQuotecost(fQCost2);

        flightQuotes.add(newFlight);

        tempItin = new Itinerary();
        tempItin.setDate(getTempDate());
        tempItin.setDestination(getTempDest());
        tempItin.setLeavetype(getTempLeaveType());
        tempItin.setTravelday(getTempTravelDay());

        appHandler.persistApplication(newApplication, newQuote, accQuotes, carQuotes, flightQuotes, tempItin, newTravel, profileRef);
        FacesContext.getCurrentInstance().addMessage("userTop", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Application Created"));
        return "userHome";
    }

    public String onFlowProcess(FlowEvent event) {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());


        return event.getNewStep();
    }

    public String reinit() {
        tempItin.setDate(getTempDate());
        tempItin.setDestination(getTempDest());
        tempItin.setLeavetype(getTempLeaveType());
        tempItin.setTravelday(getTempTravelDay());
        hops.add(tempItin);
        tempItin = new Itinerary();

        createNewRow();

        return null;
    }

    private void createNewRow() {
        //List<Object> row = new ArrayList<Object>();

        input.setRendererType("text");
        input.setRendered(true);
        input.setId("element" + ++idNum);
        panel.getChildren().add(input);
        input = new UIInput();
        //uiInput.

    }

    public String viewThis(){
        //loadValues();
        return "/viewApplication.xhtml";
    }
    
    public String goEdit(){
        loadValues();
        return "editApplication";
    }
    
    public String update(){
        quoteRef = appRef.getQuotesIdquotes();
        hotels = appHandler.getAccomodationQuotes(quoteRef.getIdquotes());
        cars = appHandler.getCarQuotes(quoteRef.getIdquotes());
        flights = appHandler.getFlightQuotes(quoteRef.getIdquotes());
        travelRef = appRef.getTravelIdtravel();
        itinRef = appHandler.getItinerary(travelRef.getIdtravel());
        
        appRef.setDescription(description);
        
        travelRef.setDatedeparture(departureDate);
        travelRef.setDatereturn(returnDate);
        travelRef.setDescription(reasonForTravel);
        
        itinRef.setDate(tempDate);
        itinRef.setDestination(tempDest);
        itinRef.setLeavetype(tempLeaveType);
        itinRef.setTravelday(tempTravelDay);
        
        quoteRef.setCostcenter(costCentre);
        
        appHandler.persistApplicationEdit(appRef, quoteRef, itinRef, travelRef);
        FacesContext.getCurrentInstance().addMessage("submitAppConfirm", new FacesMessage(FacesMessage.SEVERITY_INFO,"Success","Changes have been saved"));
        return "/viewApplication.xhtml";
    }
    //dada
    
    public void loadValues(){
        
        profileRef = travelProfileHandler.findTravelProf(accountID);
        //loadValues();
        Integer id = 9;
        appRef = appHandler.getApplication(id);//selectedApp;
        
        quoteRef = appRef.getQuotesIdquotes();
        
        travelRef = appRef.getTravelIdtravel();
        itinRef = appHandler.getItinerary(travelRef.getIdtravel());
        
        description = appRef.getDescription();
        
        setDepartureDate(travelRef.getDatedeparture());
        setReturnDate(travelRef.getDatereturn());
        setReasonForTravel(travelRef.getDescription());
        
        setTempDate(itinRef.getDate());
        setTempDest(itinRef.getDestination());
        setTempLeaveType(itinRef.getLeavetype());
        setTempTravelDay(itinRef.getTravelday());
        
        setCostCentre(quoteRef.getCostcenter());

    }

    public Travelerprofile getProfileRef() {

        return profileRef;
    }

    public void setProfileRef(Travelerprofile profileRef) {
        this.profileRef = profileRef;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReasonForTravel() {
        return reasonForTravel;
    }

    public void setReasonForTravel(String reasonForTravel) {
        this.reasonForTravel = reasonForTravel;
    }

    public List<Itinerary> getHops() {
        return hops;
    }

    public void setHops(List<Itinerary> hops) {
        this.hops = hops;
    }

    public Itinerary getTempItin() {
        return tempItin;
    }

    public void setTempItin(Itinerary tempItin) {
        this.tempItin = tempItin;
    }

    public UIData getHopTable() {
        return hopTable;
    }

    public void setHopTable(UIData hopTable) {
        this.hopTable = hopTable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Application> getAllApps() {
        allApps = appHandler.getAppList(accountID);
        return allApps;
    }

    public void setAllApps(List<Application> allApps) {
        this.allApps = allApps;
    }

    public Application getSelectedApp() {
        return selectedApp;
    }

    public void setSelectedApp(Application selectedApp) {
        this.selectedApp = selectedApp;
    }

    public Date getTempDate() {
        return tempDate;
    }

    public void setTempDate(Date tempDate) {
        this.tempDate = tempDate;
    }

    public String getTempDest() {
        return tempDest;
    }

    public void setTempDest(String tempDest) {
        this.tempDest = tempDest;
    }

    public String getTempLeaveType() {
        return tempLeaveType;
    }

    public void setTempLeaveType(String tempLeaveType) {
        this.tempLeaveType = tempLeaveType;
    }

    public String getTempTravelDay() {
        return tempTravelDay;
    }

    public void setTempTravelDay(String tempTravelDay) {
        this.tempTravelDay = tempTravelDay;
    }

    public UIForm getForm() {
        return form;
    }

    public void setForm(UIForm form) {
        this.form = form;
    }

    public UIPanel getPanel() {
        return panel;
    }

    public void setPanel(UIPanel panel) {
        this.panel = panel;
    }

    public String getfQFrom() {
        return fQFrom;
    }

    public void setfQFrom(String fQFrom) {
        this.fQFrom = fQFrom;
    }

    public String getfQTo() {
        return fQTo;
    }

    public void setfQTo(String fQTo) {
        this.fQTo = fQTo;
    }

    public Date getfQDate() {
        return fQDate;
    }

    public void setfQDate(Date fQDate) {
        this.fQDate = fQDate;
    }

    public String getfQTime() {
        return fQTime;
    }

    public void setfQTime(String fQTime) {
        this.fQTime = fQTime;
    }

    public String getfQFlight1() {
        return fQFlight1;
    }

    public void setfQFlight1(String fQFlight1) {
        this.fQFlight1 = fQFlight1;
    }

    public String getfQCost1() {
        return fQCost1;
    }

    public void setfQCost1(String fQCost1) {
        this.fQCost1 = fQCost1;
    }

    public String getfQFlight2() {
        return fQFlight2;
    }

    public void setfQFlight2(String fQFlight2) {
        this.fQFlight2 = fQFlight2;
    }

    public String getfQCost2() {
        return fQCost2;
    }

    public void setfQCost2(String fQCost2) {
        this.fQCost2 = fQCost2;
    }

    public String getCostCentre() {
        return costCentre;
    }

    public void setCostCentre(String costCentre) {
        this.costCentre = costCentre;
    }

    public String getcQFrom() {
        return cQFrom;
    }

    public void setcQFrom(String cQFrom) {
        this.cQFrom = cQFrom;
    }

    public String getcQTo() {
        return cQTo;
    }

    public void setcQTo(String cQTo) {
        this.cQTo = cQTo;
    }

    public Date getcQDateCollected() {
        return cQDateCollected;
    }

    public void setcQDateCollected(Date cQDateCollected) {
        this.cQDateCollected = cQDateCollected;
    }

    public Date getcQDateReturned() {
        return cQDateReturned;
    }

    public void setcQDateReturned(Date cQDateReturned) {
        this.cQDateReturned = cQDateReturned;
    }

    public String getcQHire1() {
        return cQHire1;
    }

    public void setcQHire1(String cQHire1) {
        this.cQHire1 = cQHire1;
    }

    public String getcQCost1() {
        return cQCost1;
    }

    public void setcQCost1(String cQCost1) {
        this.cQCost1 = cQCost1;
    }

    public String getcQHire2() {
        return cQHire2;
    }

    public void setcQHire2(String cQHire2) {
        this.cQHire2 = cQHire2;
    }

    public String getcQCost2() {
        return cQCost2;
    }

    public void setcQCost2(String cQCost2) {
        this.cQCost2 = cQCost2;
    }

    public String gethQLocation() {
        return hQLocation;
    }

    public void sethQLocation(String hQLocation) {
        this.hQLocation = hQLocation;
    }

    public Date gethQDateIn() {
        return hQDateIn;
    }

    public void sethQDateIn(Date hQDateIn) {
        this.hQDateIn = hQDateIn;
    }

    public Date gethQDateOut() {
        return hQDateOut;
    }

    public void sethQDateOut(Date hQDateOut) {
        this.hQDateOut = hQDateOut;
    }

    public String gethQHotel1() {
        return hQHotel1;
    }

    public void sethQHotel1(String hQHotel1) {
        this.hQHotel1 = hQHotel1;
    }

    public String gethQCost1() {
        return hQCost1;
    }

    public void sethQCost1(String hQCost1) {
        this.hQCost1 = hQCost1;
    }

    public String gethQHotel2() {
        return hQHotel2;
    }

    public void sethQHotel2(String hQHotel2) {
        this.hQHotel2 = hQHotel2;
    }

    public String gethQCost2() {
        return hQCost2;
    }

    public void sethQCost2(String hQCost2) {
        this.hQCost2 = hQCost2;
    }

    public List<Flightquotes> getFlights() {
        //flights = appHandler.getFlightQuotes(quoteRef.getIdquotes());
        return flights;
    }

    public void setFlights(List<Flightquotes> flights) {
        this.flights = flights;
    }

    public List<Accomodationquotes> getHotels() {
        //hotels = appHandler.getAccomodationQuotes(quoteRef.getIdquotes());
        return hotels;
    }

    public void setHotels(List<Accomodationquotes> hotels) {
        this.hotels = hotels;
    }

    public List<Carquotes> getCars() {
        //cars = appHandler.getCarQuotes(quoteRef.getIdquotes());
        return cars;
    }

    public void setCars(List<Carquotes> cars) {
        this.cars = cars;
    }

    public Application getAppRef() {
        //appRef = appHandler.getApplication(5);
        //description = appRef.getDescription();
        return appRef;
    }

    public void setAppRef(Application appRef) {
        this.appRef = appRef;
    }
//dada
    public Travel getTravelRef() {
        //travelRef = appRef.getTravelIdtravel();
        return travelRef;
    }

    public void setTravelRef(Travel travelRef) {
        this.travelRef = travelRef;
    }

    public Itinerary getItinRef() {
        //itinRef = appHandler.getItinerary(travelRef.getIdtravel());
        return itinRef;
    }

    public void setItinRef(Itinerary itinRef) {
        this.itinRef = itinRef;
    }

    public Quotes getQuoteRef() {
        //quoteRef = appRef.getQuotesIdquotes();
        return quoteRef;
    }

    public void setQuoteRef(Quotes quoteRef) {
        this.quoteRef = quoteRef;
    }
    
    
}
