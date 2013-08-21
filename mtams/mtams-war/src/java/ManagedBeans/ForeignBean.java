/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Forexorder;
import Entities.Itinerary;
import Entities.Traveldocument;
import Entities.Travelerprofile;
import ServiceLayer.TravelProfileHandlerLocal;
import ServiceLayer.clientServer;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;

import javax.faces.bean.SessionScoped;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Future;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Riaan
 */

@ManagedBean(name = "foreignBean")
@SessionScoped
public class ForeignBean implements Serializable
{
    @EJB
    private clientServer csi;
    private TravelProfileHandlerLocal tph;
    
    //======change===change=========change============change=========change====
    //-------------------------------------------------------------------------
    int accountID =1;
    //-------------------------------------------------------------------------
    //======change========change=========change=============change=============
    
    private Travelerprofile travelerP;
    private Traveldocument travelD;
    private Forexorder forX;
    private Forexorder viewForX;
    private Forexorder editForX;
    private Itinerary itinerary;
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
    private int isUsingFC =2;
    private int isUsingCC =2;
    private int isUsingCheq =2;
   
	@Future
    private Date departure;
	@Future
    private Date returnDate;    
    @Pattern(message="Incorrect number entered", regexp="[0-9]{0,}")
    private String ticketNumber;
    @Pattern(message="Incorrect number entered" , regexp="[0-9]{0,20}")
    private String voyagerNum;
    @Pattern(message="Incorrect number entered", regexp="[0-9]{0,}")
    private double travellerCheque;
    @Pattern(message="Incorrect number entered", regexp="[0-9]{0,15}")
    private double foreignCash;
    @Pattern(message="Incorrect type entered", regexp="[0-9]{0,}")
    private double CashPassportCard;
    @Pattern(message="Incorrect type entered", regexp="[a-zA-Z -]{0,}")
    private String type;
    @Pattern(message="Incorrect number entered", regexp="[0-9]{0,}")
    private String number;
    @Pattern(message="Incorrect number entered", regexp="[0-9]{3}")
    private String last3;
    private Date expire;
    @Pattern(message="Incorrect number entered", regexp="[0-9]{0,}")
    private double amount;
	@Future
    private Date dateRequired;
	@Future
    private Date dateForex;
    private String reasonForTravel;       
    private static final Logger logger = Logger.getLogger(ForeignBean.class.getName());      
   
    private int coverOptions;
	
	private Date currentDate = new Date();

    public Date getCurrentDate() {
        return currentDate;
    }
    
    public ForeignBean()
    {
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
        viewForX = csi.findForX(accountID);
        return viewForX;
    }

    public void setViewForX(Forexorder viewForX) {
        this.viewForX = viewForX;
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

    
    public String createForm()
	{
            forX = new Forexorder();            
            
            forX.setDateofdepart(departure);
            forX.setDateofreturn(returnDate);
            forX.setTicketnum(ticketNumber);
            forX.setVoyagernum(voyagerNum);
            forX.setTravelerscheques(travellerCheque);
            forX.setCash(foreignCash);
            forX.setCashpassport(CashPassportCard);
            forX.setCctype(type);
            forX.setCcnumber(number);
            forX.setCclast3(last3);
            forX.setCcexpirydate(expire);
            forX.setCcpaymentamount(amount);
            forX.setDateofrequired(dateRequired);
            forX.setDatewillbeconfirmed(dateForex);
            forX.setReasonfortravel(reasonForTravel);
            
            csi.updateForex(forX, accountID);
            FacesContext.getCurrentInstance().addMessage("submitConfirm", new FacesMessage(FacesMessage.SEVERITY_INFO,"Success","Changes have been saved"));
            return "forexView";
	} 
    
    @PostConstruct
    public void getForm()
    {   
         viewForX = csi.findForX(accountID);
         setDeparture(viewForX.getDateofdepart());
         setReturnDate(viewForX.getDateofreturn());
         setTicketNumber(viewForX.getTicketnum());
         setVoyagerNum(viewForX.getVoyagernum());
         setTravellerCheque(viewForX.getTravelerscheques());
         setForeignCash(viewForX.getCash());
         setCashPassportCard(viewForX.getCashpassport());
         setType(viewForX.getCctype());
         setLast3(viewForX.getCclast3());
         setNumber(viewForX.getCcnumber());
         setExpire(viewForX.getCcexpirydate());
         setAmount(viewForX.getCash());
         setDateRequired(viewForX.getDateofrequired());
         setDateForex(viewForX.getDatewillbeconfirmed());
         setReasonForTravel(viewForX.getReasonfortravel()); 
    }
    
    public String cancel()
    {
        return "forexView";
    }
    
    public String updateForm()
    { 
        editForX = new Forexorder();   
        
        editForX.setDateofdepart(departure);
        editForX.setDateofreturn(returnDate);
        editForX.setTicketnum(ticketNumber);
        editForX.setVoyagernum(voyagerNum);
        editForX.setTravelerscheques(travellerCheque);
        editForX.setCash(foreignCash);
        editForX.setCashpassport(CashPassportCard);
        editForX.setCctype(type);
        editForX.setCcnumber(number);
        editForX.setCclast3(last3);
        editForX.setCcexpirydate(expire);
        editForX.setCcpaymentamount(amount);
        editForX.setDateofrequired(dateRequired);
        editForX.setDatewillbeconfirmed(dateForex);
        editForX.setReasonfortravel(reasonForTravel);
        
        csi.updateForex(editForX, accountID);
        return "forexView";
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
    
    
}
