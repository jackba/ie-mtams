/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Accomodationquotes;
import Entities.Application;
import Entities.Carquotes;
import Entities.Currency;
import Entities.Flightquotes;
import Entities.Forexorder;
import Entities.Itinerary;
import Entities.Travel;
import Entities.Traveldocument;
import Entities.Travelerprofile;
import ServiceLayer.TravelProfileHandlerLocal;
import ServiceLayer.ForexHandlerLocal;
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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;

import javax.faces.bean.SessionScoped;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Future;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Riaan
 */
@ManagedBean(name = "foreignBean")
@SessionScoped
public class ForeignBean implements Serializable {

    @EJB
    private ForexHandlerLocal csi;
    private TravelProfileHandlerLocal tph;
    //======change===change=========change============change=========change====
    //-------------------------------------------------------------------------
    private Integer accountID = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("userID");
    //private Integer accountID = 3;
    int appnum = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("appID");
    //-------------------------------------------------------------------------
    //======change========change=========change=============change=============
    private Travelerprofile travelerP;
    private Traveldocument travelD;
    //private Forexorder forX;
    private Forexorder viewForX;
    private Forexorder editForX;
    private Itinerary itinerary;
    private Application appref;
    private Travel travel;
    private String CompanyNameRegNum;
    private String passengerName;
    private String physicalAddress;
    private int telNum;
    private int faxNum;
    private int IDnum;
    private String Nationality;
    private int passportNum;
    private String companyName;
    private String Distination;
    private String ccCur;
    private String fcCur;
    private String cheqCur;
    private int isPresenting;
    private int isUsingFC = 2;
    private int isUsingCC = 2;
    private int isUsingCheq = 2;
    @Future
    private Date departure;
    @Future
    private Date returnDate;
    //@Pattern(message = "Incorrect number entered", regexp = "[A-z0-9 -.]{0,}")
    private String ticketNumber;
    //@Pattern(message = "Incorrect number entered", regexp = "[A-z0-9 -.]{0,}")
    private String voyagerNum;
    //@Pattern(message="Incorrect number entered", regexp="[0-9]{0,}")
    private double travellerCheque;
    //@Pattern(message="Incorrect number entered", regexp="[0-9]{0,}")
    private double foreignCash;
    //@Pattern(message="Incorrect type entered", regexp="[0-9]{0,}")
    private double CashPassportCard;
    @Pattern(message = "Incorrect type entered", regexp = "[a-zA-Z -]{0,}")
    private String type;
    @Pattern(message = "Incorrect number entered", regexp = "[0-9]{0,}")
    private String number;
    @Pattern(message = "Incorrect number entered", regexp = "[0-9]{3}")
    private String last3;
    private Date expire;
    //@Pattern(message="Incorrect number entered", regexp="[0-9]{0,}")
    private double amount;
    private Date dateRequired;
    private Date dateForex;
    private String reasonForTravel;
    private static final Logger logger = Logger.getLogger(ForeignBean.class.getName());
    private int coverOptions;
    private Date currentDate = new Date();
    private Currency aCurrencySelection;
    private Currency aCurrencySelection2;
    private Currency aCurrencySelection3;
    /* PDF Variables */
    private Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private Font mediumFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

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
        String fileName = (this.travelerP.getFamilyname()
                + this.travelerP.getIdtravelerprofile()
                + "ForexForm");
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
        document.add(new Paragraph("MTAMS - Forex Form", bigFont));
        document.add(new Paragraph("Personal", mediumFont));
        newLine(document);

        /**
         * Personal Details
         */
        PdfPTable table = new PdfPTable(2); // 2 columns.

        ArrayList<PdfPCell> cellList = new ArrayList<PdfPCell>();
        cellList.add(new PdfPCell(new Phrase("Passenger (Full Name):")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getFamilyname() + " " + this.travelerP.getFirstname())));
        cellList.add(new PdfPCell(new Phrase("Home Address Line 1:")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getHomeaddress1())));
        cellList.add(new PdfPCell(new Phrase("Home Address Line 2:")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getHomeaddress2())));
        cellList.add(new PdfPCell(new Phrase("City:")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getCity())));
        cellList.add(new PdfPCell(new Phrase("Country:")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getCountry())));
        cellList.add(new PdfPCell(new Phrase("Postal Code:")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getPostalcode())));
        cellList.add(new PdfPCell(new Phrase("Telephone Number:")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getMobilephone())));
        cellList.add(new PdfPCell(new Phrase("Fax:")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getBusinessfax())));
        cellList.add(new PdfPCell(new Phrase("I.D:")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getIdnumber())));


        cellList.add(new PdfPCell(new Phrase("Nationality Of Passport:")));
        cellList.add(new PdfPCell(new Phrase(this.travelD.getCountry())));
        cellList.add(new PdfPCell(new Phrase("Passport Number:")));
        cellList.add(new PdfPCell(new Phrase(this.travelD.getPassportnumber())));
        cellList.add(new PdfPCell(new Phrase("Company Contact:")));
        cellList.add(new PdfPCell(new Phrase(this.travelerP.getBusinessphone())));
        cellList.add(new PdfPCell(new Phrase("Destination:")));
        cellList.add(new PdfPCell(new Phrase(this.itinerary.getDestinationCity())));
        cellList.add(new PdfPCell(new Phrase("Date of Departure:")));
        cellList.add(new PdfPCell(new Phrase("")));
        //cellList.add(new PdfPCell(new Phrase(this.itinerary.getDatefrom().toString())));

        cellList.add(new PdfPCell(new Phrase("Date of Return:")));
        cellList.add(new PdfPCell(new Phrase("")));
        //cellList.add(new PdfPCell(new Phrase(this.itinerary.getDateto().toString())));
        cellList.add(new PdfPCell(new Phrase("Ticket Number/ Reference Number:")));
        cellList.add(new PdfPCell(new Phrase(this.viewForX.getTicketnum())));
        cellList.add(new PdfPCell(new Phrase("Voyager Number:")));
        cellList.add(new PdfPCell(new Phrase(this.viewForX.getVoyagernum())));

        for (int i = 0; i < cellList.size(); i++) {
            if (i % 2 == 0) {
                cellList.get(i).setBorder(Rectangle.NO_BORDER);
            }
            table.addCell(cellList.get(i));
        }
        document.add(table);

        /**
         * Forex Breakdown
         */
        table = new PdfPTable(2);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Forex Breakdown", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("Travellers Cheques:")));
        cellList.add(new PdfPCell(new Phrase(this.viewForX.getCurrencycheque()
                + " "
                + this.viewForX.getTravelerscheques())));

        cellList.add(new PdfPCell(new Phrase("Foreign Cash:")));
        cellList.add(new PdfPCell(new Phrase(this.viewForX.getCurrencycash()
                + " "
                + this.viewForX.getCash())));

        cellList.add(new PdfPCell(new Phrase("CC Type (VISA, DINERS, ETC):")));
        cellList.add(new PdfPCell(new Phrase(this.viewForX.getCctype())));

        cellList.add(new PdfPCell(new Phrase("Number:")));
        cellList.add(new PdfPCell(new Phrase("Please fill in here")));
        cellList.add(new PdfPCell(new Phrase("Last 3 digits:")));
        cellList.add(new PdfPCell(new Phrase("Please fill in here")));
        cellList.add(new PdfPCell(new Phrase("Expiry Date:")));
        
        cellList.add(new PdfPCell(new Phrase("Please fill in here")));
        //cellList.add(new PdfPCell(new Phrase(this.viewForX.getCcexpirydate().toString())));

        cellList.add(new PdfPCell(new Phrase("Amount:")));
        cellList.add(new PdfPCell(new Phrase(this.viewForX.getCurrencycc()
                + " "
                + this.viewForX.getCcpaymentamount())));

        for (int i = 0; i < cellList.size(); i++) {
            if (i % 2 == 0) {
                cellList.get(i).setBorder(Rectangle.NO_BORDER);
            }
            table.addCell(cellList.get(i));
        }

        document.add(table);

        /**
         * Delivery Information
         */
        table = new PdfPTable(2);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Delivery Information", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("Delivery - Date and Time:")));
        cellList.add(new PdfPCell(new Phrase(this.viewForX.getDateofrequired().toString())));
        cellList.add(new PdfPCell(new Phrase("Date and Time: Will be confirmed by Forex Consultant:")));
        cellList.add(new PdfPCell(new Phrase(this.viewForX.getDatewillbeconfirmed().toString())));

        for (int i = 0; i < cellList.size(); i++) {
            if (i % 2 == 0) {
                cellList.get(i).setBorder(Rectangle.NO_BORDER);
            }
            table.addCell(cellList.get(i));
        }

        document.add(table);

        /**
         * Additional Information
         */
        table = new PdfPTable(2);
        cellList = new ArrayList<PdfPCell>();
        newLine(document);
        document.add(new Paragraph("Additional Information", mediumFont));
        newLine(document);
        cellList.add(new PdfPCell(new Phrase("Reason for trael:")));
        cellList.add(new PdfPCell(new Phrase(this.viewForX.getReasonfortravel())));

        for (int i = 0; i < cellList.size(); i++) {
            if (i % 2 == 0) {
                cellList.get(i).setBorder(Rectangle.NO_BORDER);
            }
            table.addCell(cellList.get(i));
        }

        document.add(table);
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public ForeignBean() {
    }

    public int getIsPresenting() {
        return isPresenting;
    }

    public void setIsPresenting(int isPresenting) {
        this.isPresenting = isPresenting;
    }

    public int getIsUsingCheq() {
        return isUsingCheq;
    }

    public void setIsUsingCheq(int isUsingCheq) {
        this.isUsingCheq = isUsingCheq;
    }

    public int getIsUsingFC() {
        return isUsingFC;
    }

    public void setIsUsingFC(int isUsingFC) {
        this.isUsingFC = isUsingFC;
    }

    public int getIsUsingCC() {
        return isUsingCC;
    }

    public void setIsUsingCC(int isUsingCC) {
        this.isUsingCC = isUsingCC;
    }

    public Forexorder getViewForX() {
        viewForX = csi.findForX(accountID, appnum);
        return viewForX;
    }

    public void setViewForX(Forexorder viewForX) {
        this.viewForX = viewForX;
    }

    public Travel getTravel() {
        travel = csi.findTravel(accountID);
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Itinerary getItinerary() {
        itinerary = csi.findItinerary(accountID);
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Travelerprofile getTravelerP() {
        travelerP = csi.find(accountID);
        return travelerP;
    }

    public void setTravelerP(Travelerprofile travelerP) {
        this.travelerP = travelerP;
    }

    public Traveldocument getTravelD() {
        int tID = travelerP.getIdtravelerprofile();
        travelD = csi.findDocument(tID);
        return travelD;
    }

    public void setTravelD(Traveldocument travelD) {
        this.travelD = travelD;
    }

    public String onFlowProcess(FlowEvent event) {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());

        return event.getNewStep();
    }

    public String createForm() {
        Forexorder forX = new Forexorder();

        //forX.setDateofdepart(departure);
        //forX.setDateofreturn(returnDate);
        forX.setTicketnum(ticketNumber);
        forX.setVoyagernum(voyagerNum);
        forX.setCurrencycheque(cheqCur);
        forX.setTravelerscheques(travellerCheque);
        forX.setCurrencycash(fcCur);
        forX.setCash(foreignCash);
        //forX.setCashpassport(CashPassportCard);
        forX.setCctype(type);
        //forX.setCcnumber(number);
        //forX.setCclast3(last3);
        forX.setCcexpirydate(expire);
        forX.setCurrencycc(ccCur);
        forX.setCcpaymentamount(amount);
        forX.setDateofrequired(dateRequired);
        forX.setDatewillbeconfirmed(dateForex);
        forX.setReasonfortravel(reasonForTravel);

        csi.updateForex(forX, accountID, appnum);
        FacesContext.getCurrentInstance().addMessage("appHomeTop", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Changes have been saved"));
        return "/applicationHome.xhtml";
    }

    @PostConstruct
    public void getForm() {
        viewForX = csi.findForX(accountID, appnum);
        //setDeparture(viewForX.getDateofdepart());
        //setReturnDate(viewForX.getDateofreturn());
        setTicketNumber(viewForX.getTicketnum());
        setVoyagerNum(viewForX.getVoyagernum());
//           setTravellerCheque(viewForX.getTravelerscheques());
//           setForeignCash(viewForX.getCash());
        //setCashPassportCard(viewForX.getCashpassport());
        setType(viewForX.getCctype());
        setLast3(viewForX.getCclast3());
        setNumber(viewForX.getCcnumber());
        setExpire(viewForX.getCcexpirydate());
//           setAmount(viewForX.getCash());
        setDateRequired(viewForX.getDateofrequired());
        setDateForex(viewForX.getDatewillbeconfirmed());
        setReasonForTravel(viewForX.getReasonfortravel());
        setFcCur(viewForX.getCurrencycash());
        setCcCur(viewForX.getCurrencycc());
        setCheqCur(viewForX.getCurrencycheque());

    }

    public String cancel() {
        return "/forexView.xhtml";
    }

    public String toAppHome() {
        return "/applicationHome.xhtml";
    }

    public String updateForm() {
        editForX = new Forexorder();

        //editForX.setDateofdepart(departure);
        //editForX.setDateofreturn(returnDate);
        editForX.setTicketnum(ticketNumber);
        editForX.setVoyagernum(voyagerNum);
        editForX.setCurrencycheque(cheqCur);
        editForX.setTravelerscheques(travellerCheque);
        editForX.setCurrencycash(fcCur);
        editForX.setCash(foreignCash);
        //editForX.setCashpassport(CashPassportCard);
        editForX.setCctype(type);
        //editForX.setCcnumber(number);
        //editForX.setCclast3(last3);
        editForX.setCcexpirydate(expire);
        editForX.setCurrencycc(ccCur);
        editForX.setCcpaymentamount(amount);
        editForX.setDateofrequired(dateRequired);
        editForX.setDatewillbeconfirmed(dateForex);
        editForX.setReasonfortravel(reasonForTravel);

        csi.updateForex(editForX, accountID, appnum);
        FacesContext.getCurrentInstance().addMessage("submitConfirm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Changes have been saved"));
        return "/applicationHome.xhtml";
    }

    public String goEdit() {
        //loadValues();
        //initialize();
        return "/forexEdit.xhtml";
    }

    public Forexorder getEditForX() {
        return editForX;
    }

    public void setEditForX(Forexorder editForX) {
        this.editForX = editForX;
    }

    public String getCompanyNameRegNum() {
        return CompanyNameRegNum;
    }

    public void setCompanyNameRegNum(String CompanyNameRegNum) {
        this.CompanyNameRegNum = CompanyNameRegNum;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getTelNum() {
        return telNum;
    }

    public void setTelNum(int telNum) {
        this.telNum = telNum;
    }

    public int getFaxNum() {
        return faxNum;
    }

    public void setFaxNum(int faxNum) {
        this.faxNum = faxNum;
    }

    public int getIDnum() {
        return IDnum;
    }

    public void setIDnum(int IDnum) {
        this.IDnum = IDnum;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public int getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(int passportNum) {
        this.passportNum = passportNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDistination() {
        return Distination;
    }

    public void setDistination(String Distination) {
        this.Distination = Distination;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getCoverOptions() {
        return coverOptions;
    }

    public void setCoverOptions(int coverOptions) {
        this.coverOptions = coverOptions;
    }

    public String getVoyagerNum() {
        return voyagerNum;
    }

    public void setVoyagerNum(String voyagerNum) {
        this.voyagerNum = voyagerNum;
    }

    public double getTravellerCheque() {
        return travellerCheque;
    }

    public void setTravellerCheque(double travellerCheque) {
        this.travellerCheque = travellerCheque;
    }

    public double getForeignCash() {
        return foreignCash;
    }

    public void setForeignCash(double foreignCash) {
        this.foreignCash = foreignCash;
    }

    public double getCashPassportCard() {
        return CashPassportCard;
    }

    public void setCashPassportCard(double CashPassportCard) {
        this.CashPassportCard = CashPassportCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLast3() {
        return last3;
    }

    public void setLast3(String last3) {
        this.last3 = last3;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDateRequired(Date dateRequired) {
        this.dateRequired = dateRequired;
    }

    public Date getDateForex() {
        return dateForex;
    }

    public void setDateForex(Date dateForex) {
        this.dateForex = dateForex;
    }

    public String getReasonForTravel() {
        return reasonForTravel;
    }

    public void setReasonForTravel(String reasonForTravel) {
        this.reasonForTravel = reasonForTravel;
    }

    public String getCcCur() {
        return ccCur;
    }

    public void setCcCur(String ccCur) {
        this.ccCur = ccCur;
    }

    public String getFcCur() {
        return fcCur;
    }

    public void setFcCur(String fcCur) {
        this.fcCur = fcCur;
    }

    public String getCheqCur() {
        return cheqCur;
    }

    public void setCheqCur(String cheqCur) {
        this.cheqCur = cheqCur;
    }

    public Currency getaCurrencySelection() {
        return aCurrencySelection;
    }

    public void setaCurrencySelection(Currency aCurrencySelection) {
        this.aCurrencySelection = aCurrencySelection;
    }

    public String CurSel() {
//        logger.log(Level.INFO, "CurSel");
        logger.log(Level.INFO, "selectedCurrencyString : {0}", cheqCur);
        cheqCur = aCurrencySelection.getCurrencycode3();
        RequestContext.getCurrentInstance().execute("dlgcurrency.hide()");
//        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        return "currency";
    }

    public Currency getaCurrencySelection2() {
        return aCurrencySelection2;
    }

    public void setaCurrencySelection2(Currency aCurrencySelection2) {
        this.aCurrencySelection2 = aCurrencySelection2;
    }

    public String CurSel2() {
//        logger.log(Level.INFO, "CurSel");
        logger.log(Level.INFO, "selectedCurrencyString2 : {0}", fcCur);
        fcCur = aCurrencySelection2.getCurrencycode3();
        RequestContext.getCurrentInstance().execute("dlgcurrency2.hide()");
//        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        return "currency2";
    }

    public Currency getaCurrencySelection3() {
        return aCurrencySelection3;
    }

    public void setaCurrencySelection3(Currency aCurrencySelection3) {
        this.aCurrencySelection3 = aCurrencySelection3;
    }

    public String CurSel3() {
//        logger.log(Level.INFO, "CurSel");
        logger.log(Level.INFO, "selectedCurrencyString3 : {0}", ccCur);
        ccCur = aCurrencySelection3.getCurrencycode3();
        RequestContext.getCurrentInstance().execute("dlgcurrency3.hide()");
//        logger.log(Level.INFO, "selectedCurrencyString : {0}", selectedCurrencyString);
        return "currency3";
    }
}