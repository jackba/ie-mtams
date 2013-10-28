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
import Entities.Flightquotes;
import Entities.Itinerary;
import Entities.Quotes;
import Entities.Travel;
import Entities.Travelerprofile;
import ServiceLayer.AccountHandlerLocal;
import ServiceLayer.ApplicationHandlerLocal;
import ServiceLayer.ApprovalHandlerLocal;
import ServiceLayer.TravelProfileHandlerLocal;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Robert Bwana
 */
@Named(value = "approvalBean")
@ConversationScoped
public class ApprovalBean implements Serializable {

    @EJB
    private TravelProfileHandlerLocal travelProfileHandler;
    @EJB
    private ApplicationHandlerLocal appHandler;
    @EJB
    private ApprovalHandlerLocal approvalHandler;
    @EJB
    private AccountHandlerLocal accHandler;
    private static final Logger logger = Logger.getLogger(ApplicationBean.class.getName());
    private List<Application> allApps;
    private Application selectedApp;
    private Integer accountID = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("userID");
    private Travelerprofile profileRef;// = travelProfileHandler.findTravelProf(accountID);
    private Account accRef;
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
    ///////////SELECTED/////////////
    private Accomodationquotes selectedAccQte;
    private Carquotes selectedCarQte;
    private Flightquotes selectedFlgQte;
    private String reasonForTravel;
    private Application newApplication;
    //--------APPROVAL-------------//
    @Pattern(message = "Incorrect Entry", regexp = "[a-zA-Z' ]{0,}")
    private String approvalName;
    private String approvalComment;
    private int approved = 2;
    ///////VARIABLES FOR NEW APPROVAL PROCESS/////////
    @Inject
    private MailGF mail;
    private List<Approval> approvals;
    /* PDF Variables */
    private Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private Font mediumFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private int isPDF = 2;

    public int getIsPDF() {
        return isPDF;
    }

    public void setIsPDF(int isPDF) {
        this.isPDF = isPDF;
    }

    public ApprovalBean() {
        //initialize();
    }

    public void generatePDF() throws DocumentException, IOException {
        if (this.getIsPDF() == 1) {
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
                    + "Approval");
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
            //cellList.add(new PdfPCell(new Phrase(df.format(i.getDate()))));
            cellList.add(new PdfPCell(new Phrase("BLANK")));
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


        Flightquotes f = selectedFlgQte;
        cellList.add(new PdfPCell(new Phrase(f.getFlightfromCity())));
        cellList.add(new PdfPCell(new Phrase(f.getFlighttoCity())));
        cellList.add(new PdfPCell(new Phrase(f.getQuotesource())));
        cellList.add(new PdfPCell(new Phrase(f.getCurrency() + " " + f.getQuotecost().toString())));

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


        Carquotes c = selectedCarQte;
        cellList.add(new PdfPCell(new Phrase(df.format(c.getDatecollect()))));
        cellList.add(new PdfPCell(new Phrase(df.format(c.getDatereturn()))));
        cellList.add(new PdfPCell(new Phrase(c.getProvider())));
        cellList.add(new PdfPCell(new Phrase(c.getCurrency() + " " + c.getQuotecost().toString())));

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


        Accomodationquotes a = selectedAccQte;
        cellList.add(new PdfPCell(new Phrase(a.getCity())));
        cellList.add(new PdfPCell(new Phrase(df.format(a.getDatecheckin()))));
        cellList.add(new PdfPCell(new Phrase(df.format(a.getDatecheckout()))));
        cellList.add(new PdfPCell(new Phrase(a.getAccomodationprovider())));
        cellList.add(new PdfPCell(new Phrase(a.getCurrency() + " " + a.getQuotecost().toString())));

        for (int i = 0; i < cellList.size(); i++) {
            table.addCell(cellList.get(i));
        }
        document.add(table);

        /**
         * Approval Section
         */
        newLine(document);
        table = new PdfPTable(2);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Approval", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("Approved:")));
        cellList.add(new PdfPCell(new Phrase(this.getApproved() == 1 ? "YES" : "NO")));
        cellList.add(new PdfPCell(new Phrase("Authorizer Name:")));
        cellList.add(new PdfPCell(new Phrase(this.getApprovalName())));

        cellList.add(new PdfPCell(new Phrase("Authorizer Comments:")));
        cellList.add(new PdfPCell(new Phrase(this.getApprovalComment())));

        for (int i = 0; i < cellList.size(); i++) {
            if (i % 2 == 0) {
                cellList.get(i).setBorder(Rectangle.NO_BORDER);
            }
            table.addCell(cellList.get(i));
        }

        document.add(table);

    }

    @PostConstruct
    public void initialize() {
        //accountID = (Integer)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userID");

//        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

//        Application tempApp = new Application();
//        tempApp.setDescription("going somewhere");
//        tempApp.setDatemodified(new Date());
//        
//        allApps.add(tempApp);

        accRef = accHandler.getAccount(accountID);
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

    public String viewThis() {
        //loadValues();
        return "/viewApplication.xhtml";
    }

    public String approve() {
//        logger.log(Level.INFO, "selectedAccQte : {0}", selectedAccQte);
//        logger.log(Level.INFO, "selectedCarQte : {0}", selectedCarQte);
//        logger.log(Level.INFO, "selectedFlgQte : {0}", selectedFlgQte);
        if (selectedAccQte != null && selectedCarQte != null && selectedFlgQte != null) {
            String next = "";
//            approvals = approvalHandler.findApprovalbyApplication(appRef.getIdapplication());
//            logger.log(Level.INFO, "appRef.getIdapplication() : {0}", appRef.getIdapplication());

            Approval appr = approvalHandler.findApprovalByAccountAndApplication(appRef.getIdapplication(), accountID);
//            logger.log(Level.INFO, "appr : {0}", appr);
//            appr.setAccountIdaccount(accRef);
//            appr.setApplicationIdapplication(appRef);
            if (appr != null) {
                appr.setDate(new Date());
                appr.setSectionid(approved);
                appr.setFromsection(approvalName);
                appr.setNotes(approvalComment);
                next = approvalHandler.updateApproval(appr);
                mail.test();
            }


            selectedAccQte.setSelected(1);
            selectedCarQte.setSelected(1);
            selectedFlgQte.setSelected(1);
            appHandler.selectQuotes(selectedAccQte, selectedCarQte, selectedFlgQte);

            try {
                generatePDF();
            } catch (DocumentException exception) {
                System.out.println(exception.getStackTrace());
            } catch (IOException exception) {
                System.out.println(exception.getStackTrace());
            }
            return "authorizerHome.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage("approvalTop", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Please ensure each type of quote has been selected"));
            return "applicationApproval.xhtml";
        }


    }

    //dada
    //@PostConstruct
    public void loadValues() {

        profileRef = travelProfileHandler.findTravelProf(accountID);
        //loadValues();
        Integer id = 12;
        appRef = appHandler.getApplication(id);//selectedApp;

        quoteRef = appRef.getQuotesIdquotes();

        travelRef = appRef.getTravelIdtravel();
        hops = appHandler.getItinerary(travelRef.getIdtravel());

        description = appRef.getDescription();

        setDepartureDate(travelRef.getDatedeparture());
        setReturnDate(travelRef.getDatereturn());
        setReasonForTravel(travelRef.getDescription());

        setTempDate(itinRef.getDate());
        setTempDest(itinRef.getDestinationCity());
        setTempLeaveType(itinRef.getLeavetype());
        setTempTravelDay(itinRef.getTravelday());

        setCostCentre(quoteRef.getCostcenter());

    }

    public String goHome() {
        return "authorizerHome.xhtml";
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

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public Accomodationquotes getSelectedAccQte() {
        return selectedAccQte;
    }

    public void setSelectedAccQte(Accomodationquotes selectedAccQte) {
        this.selectedAccQte = selectedAccQte;
    }

    public Carquotes getSelectedCarQte() {
        return selectedCarQte;
    }

    public void setSelectedCarQte(Carquotes selectedCarQte) {
        this.selectedCarQte = selectedCarQte;
    }

    public Flightquotes getSelectedFlgQte() {
        return selectedFlgQte;
    }

    public void setSelectedFlgQte(Flightquotes selectedFlgQte) {
        this.selectedFlgQte = selectedFlgQte;
    }
}
