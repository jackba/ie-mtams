/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Accomodationquotes;
import Entities.Account;
import Entities.Application;
import Entities.Approval;
import Entities.Approvalchain;
import Entities.Carquotes;
import Entities.City;
import Entities.Country;
import Entities.Currency;
import Entities.Flightquotes;
import Entities.Itinerary;
import Entities.Quotes;
import Entities.Region;
import Entities.Travel;
import Entities.Travelerprofile;
import ServiceLayer.AccountHandlerLocal;
import ServiceLayer.ApplicationHandlerLocal;
import ServiceLayer.ApprovalHandlerLocal;
import ServiceLayer.DataLookUpHandlerLocal;
import ServiceLayer.DepartmentHandlerLocal;
import ServiceLayer.TravelProfileHandlerLocal;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.awt.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.component.*;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Badger
 */
@Named(value = "appBean")
@SessionScoped
public class ApplicationBean implements Serializable {

    @EJB
    private TravelProfileHandlerLocal travelProfileHandler;
    @EJB
    private ApplicationHandlerLocal appHandler;
    @EJB
    private ApprovalHandlerLocal apprHandler;
    @EJB
    private AccountHandlerLocal accHandler;
    @EJB
    private DepartmentHandlerLocal deptHandler;
    @EJB
    private DataLookUpHandlerLocal daoDataLookUp;
    private static final Logger logger = Logger.getLogger(ApplicationBean.class.getName());
    private List<Application> allApps;
    private Application selectedApp;
    /////////////////////NEW SESSION RETRIEVAL CODE///////////////////////
    private Integer accountID = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("userID");//.getSessionMap().get("userID");
    private Travelerprofile profileRef;// = travelProfileHandler.findTravelProf(accountID);
    private Date modifiedDate;
    @Future(message = "Date must be in Future")
    private Date departureDate;
    @Future(message = "Date must be in Future")
    private Date returnDate;
    private String description;
    private Travel newTravel;
    private Itinerary tempItin;
    @Future(message = "Date must be in Future")
    private Date tempDate;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String tempDest;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String tempLeaveType;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String tempTravelDay;
    ////////////////////////////////
    @Future(message = "Date must be in Future")
    private Date tempDate2;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String tempDest2;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String tempLeaveType2;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String tempTravelDay2;
    ////////////////////////////////////
    @Future(message = "Date must be in Future")
    private Date tempDate3;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String tempDest3;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String tempLeaveType3;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String tempTravelDay3;
    ///////////QUOTES//////////////
    private String costCentre;
    private String currency;
    private Currency aCurrencySelection;
    private Quotes newQuote;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String fQFrom;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String fQTo;
    @Future
    private Date fQDate;
    private Date fQTime;
    @Pattern(message = "Incorrect Entry", regexp = "[0-9a-zA-Z' ]{0,}")
    private String fQFlight1;
    @Pattern(message = "Incorrect Number", regexp = "[0-9.', ]{0,10}")
    private String fQCost1;
    @Pattern(message = "Incorrect Entry", regexp = "[0-9a-zA-Z' ]{0,}")
    private String fQFlight2;
    @Pattern(message = "Incorrect Number", regexp = "[0-9.', ]{0,10}")
    private String fQCost2;
    private List<Flightquotes> flightQuotes;
    private Flightquotes newFlight;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String cQFrom;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String cQTo;
    @Future
    private Date cQDateCollected;
    @Future
    private Date cQDateReturned;
    @Pattern(message = "Incorrect Entry", regexp = "[0-9a-zA-Z' ]{0,}")
    private String cQHire1;
    @Pattern(message = "Incorrect Number", regexp = "[0-9.', ]{0,10}")
    private String cQCost1;
    @Pattern(message = "Incorrect Entry", regexp = "[0-9a-zA-Z' ]{0,}")
    private String cQHire2;
    @Pattern(message = "Incorrect Number", regexp = "[0-9.', ]{0,10}")
    private String cQCost2;
    private List<Carquotes> carQuotes;
    private Carquotes newCar;
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String hQLocation;
    @Future(message = "Date must be in Future")
    private Date hQDateIn;
    @Future(message = "Date must be in Future")
    private Date hQDateOut;
    @Pattern(message = "Incorrect Entry", regexp = "[0-9a-zA-Z' ]{0,}")
    private String hQHotel1;
    @Pattern(message = "Incorrect Number", regexp = "[0-9.', ]{0,10}")
    private String hQCost1;
    @Pattern(message = "Incorrect Entry", regexp = "[0-9a-zA-Z'. ]{0,}")
    private String hQHotel2;
    @Pattern(message = "Incorrect Number", regexp = "[0-9.', ]{0,10}")
    private String hQCost2;
    private List<Accomodationquotes> accQuotes;
    private Accomodationquotes newAcc;
    private List<Itinerary> hops = new ArrayList<Itinerary>();
    ///////////////////////DYNAMIC FORM
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
    private Date currentDate = new Date();
    private String reasonForTravel;
    private Application newApplication;
    ////////BOBSKI VARIABLES
    private boolean applicationReady;
    // ALEX VARIABLES FOR ADVANCED APPROVAL PROCESS
    private int appComplete = 1;
    //School Admin
    private Account schoolAdmin;
    private int schoolAdminComplete;
    private Approval schoolAdminApprFK;
    //HOD
    private Account HOD;
    private int HODComplete;
    private Approval HODApprFK;
    //Finance
    private Account finance;
    private int financeComplete;
    private Approval financeApprFK;
    //PVC
    private Account PVC;
    private int PVCComplete;
    private Approval PVCApprFK;
    //Final Finance
    private Account finalFinance;
    private int finalComplete;
    private Approval finalApprFK;
    private Approvalchain apprChainRef;
    //Country Region City
    private int countryCount;
    private int regionCount;
    private int cityCount;
    private List<Country> countryList;
    private List<Region> regionList;
    private List<City> cityList;
    private List<Country> countryFilteredList;
    private List<Region> regionFilteredList;
    private List<City> cityFilteredList;
    private Country CountrySelectionRef;
    private Country countryRef;
    private Region RegionySelectionRef;
    private City CitySelectionRef;
    private String countryString;
    private String regionyString;
    private String cityString;
    /* PDF Variables */
    private Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private Font mediumFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    /**
     * Creates a new instance of ApplicationBean
     */
    public ApplicationBean() {
    }

    public void generatePDF() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4.rotate());
        document.setPageSize(PageSize.A4);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);


        document.open();

        /* Add MTAMS LOGO */
        String url = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/img/logo.PNG");
        Image image = Image.getInstance(url);
        document.add(image);

        document.addTitle("MTAMS - Application");
        document.add(new Paragraph("Report generated by: " + System.getProperty("user.name") + ", " + new Date()));

        /* Add PDF Content */
        pdfContent(document);
        document.close();

        /* Ouput PDF as attachment */
        String fileName = (this.profileRef.getFamilyname()
                + this.profileRef.getIdtravelerprofile()
                + "ApplicationDetails");
        HttpServletResponse response = ((HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse());

        /* MIME */
        response.setContentType("application/pdf");
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
        response.setContentLength(baos.size());

        ServletOutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
        out.close();
        FacesContext.getCurrentInstance().responseComplete();
        System.out.println("File Generated");
    }

    public void newLine(Document document) throws DocumentException {
        document.add(new Phrase(""));
    }

    public void pdfContent(Document document) throws DocumentException {
        SimpleDateFormat df = new SimpleDateFormat("EEE d MMMM, yyyy", Locale.getDefault());
        document.add(new Paragraph("MTAMS - Application Details", bigFont));
        document.add(new Paragraph("Personal", mediumFont));
        newLine(document);

        /**
         * Personal Details
         */
        PdfPTable table = new PdfPTable(2); // 2 columns.

        ArrayList<PdfPCell> cellList = new ArrayList<PdfPCell>();
        cellList.add(new PdfPCell(new Phrase("Staff ID:")));
        cellList.add(new PdfPCell(new Phrase(this.profileRef.getStaffid())));
        cellList.add(new PdfPCell(new Phrase("Title:")));
        cellList.add(new PdfPCell(new Phrase(this.profileRef.getTitle())));
        cellList.add(new PdfPCell(new Phrase("Surname:")));
        cellList.add(new PdfPCell(new Phrase(this.profileRef.getFamilyname())));
        cellList.add(new PdfPCell(new Phrase("First Name:")));
        cellList.add(new PdfPCell(new Phrase(this.profileRef.getFirstname())));

        for (int i = 0; i < cellList.size(); i++) {
            if (i % 2 == 0) {
                cellList.get(i).setBorder(Rectangle.NO_BORDER);
            }
            table.addCell(cellList.get(i));
        }
        document.add(table);

        /**
         * Travel Details
         */
        table = new PdfPTable(2);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Travel", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("Application Name:")));
        cellList.add(new PdfPCell(new Phrase(this.appRef.getDescription())));
        cellList.add(new PdfPCell(new Phrase("Date of Initial Departure:")));
        cellList.add(new PdfPCell(new Phrase(df.format(this.travelRef.getDatedeparture()))));

        cellList.add(new PdfPCell(new Phrase("Date of Final Return:")));
        cellList.add(new PdfPCell(new Phrase(df.format(this.travelRef.getDatereturn()))));

        cellList.add(new PdfPCell(new Phrase("Purpose of Travel:")));
        cellList.add(new PdfPCell(new Phrase(this.travelRef.getDescription())));

        for (int i = 0; i < cellList.size(); i++) {
            if (i % 2 == 0) {
                cellList.get(i).setBorder(Rectangle.NO_BORDER);
            }
            table.addCell(cellList.get(i));
        }

        document.add(table);

        /**
         * Itinerary Details
         */
        table = new PdfPTable(4);
        table.setWidthPercentage(90f);
        table.setHeaderRows(1);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Itinerary", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("Date", bold)));
        cellList.add(new PdfPCell(new Phrase("Destination", bold)));
        cellList.add(new PdfPCell(new Phrase("Leave Type", bold)));
        cellList.add(new PdfPCell(new Phrase("Travel Day/ Work Day", bold)));


        for (Itinerary i : hops) {
            cellList.add(new PdfPCell(new Phrase(df.format(i.getDate()))));
            cellList.add(new PdfPCell(new Phrase(i.getDestinationCity())));
            cellList.add(new PdfPCell(new Phrase(i.getLeavetype())));
            cellList.add(new PdfPCell(new Phrase(i.getTravelday())));
        }

        for (int i = 0; i < cellList.size(); i++) {
            table.addCell(cellList.get(i));
        }
        document.add(table);

        /**
         * Quote CostCenter
         */
        table = new PdfPTable(2);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Quotes", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("Cost Center:")));
        cellList.add(new PdfPCell(new Phrase(this.quoteRef.getCostcenter())));

        for (int i = 0; i < cellList.size(); i++) {
            if (i % 2 == 0) {
                cellList.get(i).setBorder(Rectangle.NO_BORDER);
            }
            table.addCell(cellList.get(i));
        }

        document.add(table);

        /**
         * Flight Quotes
         */
        table = new PdfPTable(4);
        table.setWidthPercentage(90f);
        table.setHeaderRows(1);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Flight Quotes", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("From", bold)));
        cellList.add(new PdfPCell(new Phrase("To", bold)));
        cellList.add(new PdfPCell(new Phrase("Airline", bold)));
        cellList.add(new PdfPCell(new Phrase("Cost Quoted", bold)));


        for (Flightquotes f : flights) {
            cellList.add(new PdfPCell(new Phrase(f.getFlightfromCity())));
            cellList.add(new PdfPCell(new Phrase(f.getFlighttoCity())));
            cellList.add(new PdfPCell(new Phrase(f.getQuotesource())));
            cellList.add(new PdfPCell(new Phrase(f.getCurrency() + " " + f.getQuotecost().toString())));
        }

        for (int i = 0; i < cellList.size(); i++) {
            table.addCell(cellList.get(i));
        }
        document.add(table);

        /**
         * Car Quotes
         */
        table = new PdfPTable(4);
        table.setWidthPercentage(90f);
        table.setHeaderRows(1);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Flight Quotes", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("Collect Date", bold)));
        cellList.add(new PdfPCell(new Phrase("Return Date", bold)));
        cellList.add(new PdfPCell(new Phrase("Rental Company", bold)));
        cellList.add(new PdfPCell(new Phrase("Cost Quoted", bold)));


        for (Carquotes c : cars) {
            cellList.add(new PdfPCell(new Phrase(df.format(c.getDatecollect()))));
            cellList.add(new PdfPCell(new Phrase(df.format(c.getDatereturn()))));
            cellList.add(new PdfPCell(new Phrase(c.getProvider())));
            cellList.add(new PdfPCell(new Phrase(c.getCurrency() + " " + c.getQuotecost().toString())));
        }

        for (int i = 0; i < cellList.size(); i++) {
            table.addCell(cellList.get(i));
        }
        document.add(table);

        /**
         * Accommodation Quotes
         */
        table = new PdfPTable(5);
        table.setWidthPercentage(90f);
        table.setHeaderRows(1);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Accomodation Quotes", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("Location", bold)));
        cellList.add(new PdfPCell(new Phrase("Checkin Date", bold)));
        cellList.add(new PdfPCell(new Phrase("Checkout Date", bold)));
        cellList.add(new PdfPCell(new Phrase("Hotel", bold)));
        cellList.add(new PdfPCell(new Phrase("Cost Quoted", bold)));


        for (Accomodationquotes a : hotels) {
            cellList.add(new PdfPCell(new Phrase(a.getCity())));
            cellList.add(new PdfPCell(new Phrase(df.format(a.getDatecheckin()))));
            cellList.add(new PdfPCell(new Phrase(df.format(a.getDatecheckout()))));
            cellList.add(new PdfPCell(new Phrase(a.getAccomodationprovider())));
            cellList.add(new PdfPCell(new Phrase(a.getCurrency() + " " + a.getQuotecost().toString())));
        }

        for (int i = 0; i < cellList.size(); i++) {
            table.addCell(cellList.get(i));
        }
        document.add(table);
    }

    //@PostConstruct
    public void initialize() {
        //accountID = (Integer)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userID");
//        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

//        Application tempApp = new Application();
//        tempApp.setDescription("going somewhere");
//        tempApp.setDatemodified(new Date());
//        
//        allApps.add(tempApp);


        profileRef = travelProfileHandler.findTravelProf(accountID);
        //loadValues();

        int appnum = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("appID");
        appRef = appHandler.getApplication(appnum);//selectedApp;

        quoteRef = appRef.getQuotesIdquotes();
        hotels = appHandler.getAccomodationQuotes(quoteRef.getIdquotes());
        cars = appHandler.getCarQuotes(quoteRef.getIdquotes());
        flights = appHandler.getFlightQuotes(quoteRef.getIdquotes());
        travelRef = appRef.getTravelIdtravel();
        hops = appHandler.getItinerary(travelRef.getIdtravel());

        description = appRef.getDescription();

        setDepartureDate(travelRef.getDatedeparture());
        setReturnDate(travelRef.getDatereturn());
        setReasonForTravel(travelRef.getDescription());

//        setTempDate(itinRef.getDate());
//        setTempDest(itinRef.getDestinationCity());
//        setTempLeaveType(itinRef.getLeavetype());
//        setTempTravelDay(itinRef.getTravelday());

        setCostCentre(quoteRef.getCostcenter());
    }

    public String createApplication() {
        modifiedDate = new Date();
        newApplication = new Application();
        profileRef = travelProfileHandler.findTravelProf(accountID);

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
        newAcc.setCurrency(currency);
        newAcc.setAccomodationprovider(hQHotel1);
        newAcc.setQuotecost(Double.parseDouble(hQCost1));
        newAcc.setCity(hQLocation);
        newAcc.setDatecheckin(hQDateIn);
        newAcc.setDatecheckout(hQDateOut);

        newAcc.setSelected(0);
        accQuotes.add(newAcc);

        newAcc = new Accomodationquotes();
        newAcc.setCurrency(currency);

        newAcc.setAccomodationprovider(hQHotel2);
        newAcc.setQuotecost(Double.parseDouble(hQCost2));
        newAcc.setCity(hQLocation);
        newAcc.setDatecheckin(hQDateIn);
        newAcc.setDatecheckout(hQDateOut);
        newAcc.setSelected(0);

        accQuotes.add(newAcc);

        carQuotes = new ArrayList<Carquotes>();
        newCar = new Carquotes();
        newCar.setCurrency(currency);
        newCar.setDatecollect(cQDateCollected);
        newCar.setDatereturn(cQDateReturned);
        newCar.setProvider(cQHire1);
        newCar.setQuotecost(Double.parseDouble(cQCost1));
        newCar.setSelected(0);
        carQuotes.add(newCar);

        newCar = new Carquotes();
        newCar.setCurrency(currency);

        newCar.setDatecollect(cQDateCollected);
        newCar.setDatereturn(cQDateReturned);
        newCar.setProvider(cQHire2);
        newCar.setQuotecost(Double.parseDouble(cQCost2));
        newCar.setSelected(0);
        carQuotes.add(newCar);

        flightQuotes = new ArrayList<Flightquotes>();
        newFlight = new Flightquotes();
        newFlight.setCurrency(currency);
        newFlight.setFlightfromCity(fQFrom);
        newFlight.setFlighttoCity(fQTo);
        newFlight.setDatedeparture(fQDate);
        newFlight.setQuotesource(fQFlight1);
        newFlight.setQuotecost(Double.parseDouble(fQCost1));
        newFlight.setSelected(0);
        flightQuotes.add(newFlight);

        newFlight = new Flightquotes();
        newFlight.setCurrency(currency);

        newFlight.setFlightfromCity(fQFrom);
        newFlight.setFlighttoCity(fQTo);
        newFlight.setDatedeparture(fQDate);
        newFlight.setQuotesource(fQFlight2);
        newFlight.setQuotecost(Double.parseDouble(fQCost2));
        newFlight.setSelected(0);
        flightQuotes.add(newFlight);

        tempItin = new Itinerary();
        tempItin.setDate(getTempDate());
        tempItin.setDestinationCity(getTempDest());
        tempItin.setLeavetype(getTempLeaveType());
        tempItin.setTravelday(getTempTravelDay());
        hops.add(tempItin);
        
        tempItin = new Itinerary();
        tempItin.setDate(getTempDate2());
        tempItin.setDestinationCity(getTempDest2());
        tempItin.setLeavetype(getTempLeaveType2());
        tempItin.setTravelday(getTempTravelDay2());
        hops.add(tempItin);

        appRef = appHandler.persistApplication(newApplication, newQuote, accQuotes, carQuotes, flightQuotes, hops, newTravel, profileRef);

        //ALEX CODE FOR ADVANCED APPROVAL SYSTEM
        Account accRef = accHandler.getAccount(accountID);
        Approval appr1 = new Approval();
        Approval appr2 = new Approval();
        Approval appr3 = new Approval();
        Approval appr4 = new Approval();
        Approval appr5 = new Approval();


        appr1.setAccountIdaccount(deptHandler.getAdministratorAccID(accRef, 1));
        appr1.setApplicationIdapplication(appRef);
        appr2.setAccountIdaccount(deptHandler.getAdministratorAccID(accRef, 2));
        appr2.setApplicationIdapplication(appRef);
        appr3.setAccountIdaccount(accHandler.findSpecificAccount("Finance"));
        appr3.setApplicationIdapplication(appRef);
        appr4.setAccountIdaccount(accHandler.findSpecificAccount("PVC"));
        appr4.setApplicationIdapplication(appRef);
        appr5.setAccountIdaccount(accHandler.findSpecificAccount("FinalFinance"));
        appr5.setApplicationIdapplication(appRef);

        apprHandler.persistApproval(appr1);
        apprHandler.persistApproval(appr2);
        apprHandler.persistApproval(appr3);
        apprHandler.persistApproval(appr4);
        apprHandler.persistApproval(appr5);

        List<Approval> approvals = apprHandler.findApprovalbyApplication(appRef.getIdapplication());

        for (int i = 0; i < approvals.size(); i++) {
            if (i == 0) {
                appr1 = approvals.get(i);
            } else if (i == 1) {
                appr2 = approvals.get(i);
            } else if (i == 2) {
                appr3 = approvals.get(i);
            } else if (i == 3) {
                appr4 = approvals.get(i);
            } else if (i == 4) {
                appr5 = approvals.get(i);
            }
        }


        appComplete = 0;
        //School Admin

        schoolAdmin = deptHandler.getAdministratorAccID(accRef, 1);
        if(schoolAdmin.getIdaccount() != accountID){
            schoolAdminComplete = 0;
        }else{
            schoolAdminComplete = 1;
        }
        
        schoolAdminApprFK = appr1;
        //HOD
        HOD = deptHandler.getAdministratorAccID(accRef, 2);
        if(HOD.getIdaccount() != accountID){
            HODComplete = 0;
        }else{
            HODComplete = 1;
        }
        
        HODApprFK = appr2;
        //Finance
        finance = accHandler.findSpecificAccount("Finance");
        financeComplete = 0;
        financeApprFK = appr3;
        //PVC
        PVC = accHandler.findSpecificAccount("PVC");
        PVCComplete = 0;
        PVCApprFK = appr4;
        //FinalFinance
        finalFinance = accHandler.findSpecificAccount("FinalFinance");
        finalComplete = 0;
        finalApprFK = appr5;

        apprChainRef = new Approvalchain();

        apprChainRef.setAccountid(accHandler.getAccount(accountID));
        apprChainRef.setApplicationcomplete(appComplete);
        apprChainRef.setApplicationid(appRef);
        //School Admin
        apprChainRef.setSchooladmin(schoolAdmin);
        apprChainRef.setSchooladmincomplete(schoolAdminComplete);
        apprChainRef.setSchooladminapproved(schoolAdminApprFK);
        //HOD
        apprChainRef.setHod(HOD);
        apprChainRef.setHodcomplete(HODComplete);
        apprChainRef.setHodapproved(HODApprFK);
        //Finance
        apprChainRef.setFinance(finance);
        apprChainRef.setFinancecomplete(financeComplete);
        apprChainRef.setFinanceapproved(finalApprFK);
        //PVC
        apprChainRef.setPvc(PVC);
        apprChainRef.setPvccomplete(PVCComplete);
        apprChainRef.setPvcapproved(PVCApprFK);
        //FinalFinance
        apprChainRef.setFinalfinance(finalFinance);
        apprChainRef.setFinalcomplete(finalComplete);
        apprChainRef.setFinalapproved(finalApprFK);

        apprHandler.persistApprovalChain(apprChainRef);

        FacesContext.getCurrentInstance().addMessage("userTop", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Application Created"));
        return "applicationHome";
    }

    public String onFlowProcess(FlowEvent event) {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());


        return event.getNewStep();
    }

    public String reinit() {
        idNum++;

        return null;
    }

    private void createNewRow() {
        //List<Object> row = new ArrayList<Object>();
        //org.primefaces.component.row.Row row = 
        org.primefaces.component.calendar.Calendar cal = new org.primefaces.component.calendar.Calendar();
        cal.setId("element" + ++idNum);
        cal.setRequired(true);
        cal.setMindate(departureDate);
        //row.getChildren().add(cal);

        input.setRendererType("text");
        input.setRendered(true);
        input.setId("element" + ++idNum);
        panel.getChildren().add(input);
        input = new UIInput();
        //uiInput.

    }

    public String viewThis() {
        loadValues();
        return "/applicationView.xhtml";
    }

    public String goApplicationHome() {
        return "/applicationHome.xhtml";
    }

    public String goEdit() {
        //loadValues();
        initialize();
        return "applicationEdit";
    }

    public String update() {
        quoteRef = appRef.getQuotesIdquotes();
        hotels = appHandler.getAccomodationQuotes(quoteRef.getIdquotes());
        cars = appHandler.getCarQuotes(quoteRef.getIdquotes());
        flights = appHandler.getFlightQuotes(quoteRef.getIdquotes());
        travelRef = appRef.getTravelIdtravel();
        hops = appHandler.getItinerary(travelRef.getIdtravel());

        appRef.setDescription(description);

        travelRef.setDatedeparture(departureDate);
        travelRef.setDatereturn(returnDate);
        travelRef.setDescription(reasonForTravel);

        itinRef.setDate(tempDate);
        itinRef.setDestinationCity(tempDest);
        itinRef.setLeavetype(tempLeaveType);
        itinRef.setTravelday(tempTravelDay);

        quoteRef.setCostcenter(costCentre);

        appHandler.persistApplicationEdit(appRef, quoteRef, itinRef, travelRef);
        FacesContext.getCurrentInstance().addMessage("submitAppConfirm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Changes have been saved"));
        return "/applicationView.xhtml";
    }
    //dada
    //@PostConstruct

    public void loadValues() {
        //hops = new ArrayList<Itinerary>();
        profileRef = travelProfileHandler.findTravelProf(accountID);
        //loadValues();
        //Integer id = 12;
        //appRef = appHandler.getApplication(id);//selectedApp;

        quoteRef = appRef.getQuotesIdquotes();

        travelRef = appRef.getTravelIdtravel();
        hops = appHandler.getItinerary(travelRef.getIdtravel());

        description = appRef.getDescription();

        setDepartureDate(travelRef.getDatedeparture());
        setReturnDate(travelRef.getDatereturn());
        setReasonForTravel(travelRef.getDescription());

//        hopssetTempDate(itinRef.getDate());
//        setTempDest(itinRef.getDestinationCity());
//        setTempLeaveType(itinRef.getLeavetype());
//        setTempTravelDay(itinRef.getTravelday());

        setCostCentre(quoteRef.getCostcenter());

    }

    public Travelerprofile getProfileRef() {
        profileRef = travelProfileHandler.findTravelProf(accountID);
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

    public Date getfQTime() {
        return fQTime;
    }

    public void setfQTime(Date fQTime) {
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
        Integer appnum = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("appID");
        if (appnum != null) {
            appRef = appHandler.getApplication(appnum);
        }
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

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isApplicationReady() {
        applicationReady = !appHandler.getApplicationReady(appRef.getIdapplication());
        return applicationReady;
    }

    public void setApplicationReady(boolean applicationReady) {
        this.applicationReady = applicationReady;
    }

    public Currency getaCurrencySelection() {
        return aCurrencySelection;
    }

    public void setaCurrencySelection(Currency aCurrencySelection) {
        this.aCurrencySelection = aCurrencySelection;
    }

    public int getCountryCount() {
        return countryCount;
    }

    public void setCountryCount(int countryCount) {
        this.countryCount = countryCount;
    }

    public int getRegionCount() {
        return regionCount;
    }

    public void setRegionCount(int regionCount) {
        this.regionCount = regionCount;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<Country> getCountryFilteredList() {
        return countryFilteredList;
    }

    public void setCountryFilteredList(List<Country> countryFilteredList) {
        this.countryFilteredList = countryFilteredList;
    }

    public List<Region> getRegionFilteredList() {
        return regionFilteredList;
    }

    public void setRegionFilteredList(List<Region> regionFilteredList) {
        this.regionFilteredList = regionFilteredList;
    }

    public List<City> getCityFilteredList() {
        return cityFilteredList;
    }

    public void setCityFilteredList(List<City> cityFilteredList) {
        this.cityFilteredList = cityFilteredList;
    }

    public Country getCountryRef() {
        return countryRef;
    }

    public void setCountryRef(Country countryRef) {
        this.countryRef = countryRef;
    }

    public Region getRegionySelectionRef() {
        return RegionySelectionRef;
    }

    public void setRegionySelectionRef(Region RegionySelectionRef) {
        this.RegionySelectionRef = RegionySelectionRef;
    }

    public City getCitySelectionRef() {
        return CitySelectionRef;
    }

    public void setCitySelectionRef(City CitySelectionRef) {
        this.CitySelectionRef = CitySelectionRef;
    }

    public String getCountryString() {
        return countryString;
    }

    public void setCountryString(String countryString) {
        this.countryString = countryString;
    }

    public String getRegionyString() {
        return regionyString;
    }

    public void setRegionyString(String regionyString) {
        this.regionyString = regionyString;
    }

    public String getCityString() {
        return cityString;
    }

    public void setCityString(String cityString) {
        this.cityString = cityString;
    }

    public Country getCountrySelectionRef() {
        return CountrySelectionRef;
    }

    public void setCountrySelectionRef(Country CountrySelectionRef) {
        this.CountrySelectionRef = CountrySelectionRef;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public Date getTempDate2() {
        return tempDate2;
    }

    public void setTempDate2(Date tempDate2) {
        this.tempDate2 = tempDate2;
    }

    public String getTempDest2() {
        return tempDest2;
    }

    public void setTempDest2(String tempDest2) {
        this.tempDest2 = tempDest2;
    }

    public String getTempLeaveType2() {
        return tempLeaveType2;
    }

    public void setTempLeaveType2(String tempLeaveType2) {
        this.tempLeaveType2 = tempLeaveType2;
    }

    public String getTempTravelDay2() {
        return tempTravelDay2;
    }

    public void setTempTravelDay2(String tempTravelDay2) {
        this.tempTravelDay2 = tempTravelDay2;
    }

    public Date getTempDate3() {
        return tempDate3;
    }

    public void setTempDate3(Date tempDate3) {
        this.tempDate3 = tempDate3;
    }

    public String getTempDest3() {
        return tempDest3;
    }

    public void setTempDest3(String tempDest3) {
        this.tempDest3 = tempDest3;
    }

    public String getTempLeaveType3() {
        return tempLeaveType3;
    }

    public void setTempLeaveType3(String tempLeaveType3) {
        this.tempLeaveType3 = tempLeaveType3;
    }

    public String getTempTravelDay3() {
        return tempTravelDay3;
    }

    public void setTempTravelDay3(String tempTravelDay3) {
        this.tempTravelDay3 = tempTravelDay3;
    }
    
    

    public String CurSel() {
//        logger.log(Level.INFO, "CurSel");
        logger.log(Level.INFO, "selectedCurrencyString : {0}", currency);
        currency = aCurrencySelection.getCurrencycode3();
        RequestContext.getCurrentInstance().execute("dlgcurrency.hide()");
//        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        return "currency";
    }

    public String CRCSel() {
        logger.log(Level.INFO, "CountrySelectionRef : {0}", this.getCountrySelectionRef());
        //this.setCountryString(CountrySelectionRef.getName());
        logger.log(Level.INFO, "CountryString : {0}", this.getCountryString());
        logger.log(Level.INFO, "1 getRegionySelectionRef : {0}", getRegionySelectionRef());
        if (this.getCountrySelectionRef() != null) {
            if (getRegionList().isEmpty()) {
                setRegionList(daoDataLookUp.allRegions(this.getCountrySelectionRef()));
                logger.log(Level.INFO, "getRegionList : {0}", this.getRegionList());
                // that it is not the same country
                // don't need to rebuild the regions list if we allready have it
            } else if (!(getRegionList().get(0).getCode2().getCode2().equalsIgnoreCase(this.getCountrySelectionRef().getCode2()))) {
                setRegionList(daoDataLookUp.allRegions(this.getCountrySelectionRef()));
                logger.log(Level.INFO, "getRegionList : {0}", this.getRegionList());
            }
            logger.log(Level.INFO, "2 getRegionySelectionRef : {0}", getRegionySelectionRef());
            if (this.getRegionySelectionRef() != null) {
                logger.log(Level.INFO, "3 getRegionySelectionRef : {0}", getRegionySelectionRef());
                this.setRegionyString(this.getRegionySelectionRef().getName());
            }

        }

        return "CRC test";
    }

    public String CoutrySel() {
        logger.log(Level.INFO, "CountrySelectionRef : {0}", this.getCountrySelectionRef());
        this.setCountryString(CountrySelectionRef.getName());
        this.setRegionySelectionRef(null);
        this.setRegionyString("");
        logger.log(Level.INFO, "CountryString : {0}", this.getCountryString());
        setRegionList(daoDataLookUp.allRegions(this.getCountrySelectionRef()));
        logger.log(Level.INFO, "getRegionList : {0}", this.getRegionList());


        logger.log(Level.INFO, "this.setRegionyString(); : {0}", this.getRegionyString());

        return "RegSel test";

    }

    public String RegSel() {

        if (this.getCountrySelectionRef() != null) {

//            this.setRegionyString(this.getRegionySelectionRef().getName());
            if (this.getRegionySelectionRef() != null) {
                logger.log(Level.INFO, "3 getRegionySelectionRef : {0}", getRegionySelectionRef());
                this.setRegionyString(this.getRegionySelectionRef().getName());
                logger.log(Level.INFO, " getRegionyString : {0}", getRegionyString());
                setCityList(daoDataLookUp.getCities(RegionySelectionRef, CountrySelectionRef));
            }
        }

        return "RegSel test";

    }

    public String CitySel() {
        RequestContext.getCurrentInstance().execute("dlgCountry.hide()");
        this.setCityString(this.getCitySelectionRef().getName());
        if(idNum == 0){
            this.setTempDest(this.getCitySelectionRef().getName());
        }else{
            this.setTempDest2(this.getCitySelectionRef().getName());
        }
        return this.getCitySelectionRef().getName();

    }

    public String sendApproval() {
        apprHandler.beginApproval(appRef.getIdapplication());
        return "./userHome.xhtml?faces-redirect=true";
    }

    public String goCreateForex() {
        return "forexCreate";
    }

    public String goViewForex() {
        return "forexView";
    }

    public String goCreateMotivation() {
        return "motivational";
    }

    public String goViewMotivation() {
        return "motivationalView";
    }

    public String goConference() {
        return "conferenceCreate";
    }

    public String goCreateFC() {
        return "finalCostingCreate";
    }

    public String goViewFC() {
        return "finalCostingView";
    }
}
