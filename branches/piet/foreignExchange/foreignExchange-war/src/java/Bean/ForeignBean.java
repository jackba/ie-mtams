/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.Forexorder;
import Entity.Itinerary;
import Entity.Traveldocument;
import Entity.Travelerprofile;
import Service.clientServer;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Pattern;
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
    
    //======change===change=========change============change=========change====
    //-------------------------------------------------------------------------
    int accountID =1;
    //-------------------------------------------------------------------------
    //======change========change=========change=============change=============
    
    private Travelerprofile travelerP;
    private Traveldocument travelD;
    private Forexorder forX;
    private Forexorder viewForX;
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
   
    private Date departure;
    private Date returnDate;    
    @Pattern(message="Invalid numbers only", regexp="[0-9]{0,}")
    private String ticketNumber;
    @Pattern(message="Invalid numbers only" , regexp="[0-9]{0,20}")
    private String voyagerNum;
    private String travellerCheque;
    @Pattern(message="Invalid numbers only", regexp="[0-9]{0,}")
    private String foreignCash;
    private String CashPassportCard;
    @Pattern(message="Invalid type", regexp="[A-Za-z]{0,}")
    private String type;
    @Pattern(message="Invalid numbers only", regexp="[0-9]{0,}")
    private String number;
    @Pattern(message="Invalid Numbers only", regexp="[0-9]{0,3}")
    private String last3;
    private Date expire;
    @Pattern(message="Invalid Numbers only", regexp="[0-9]{0,}")
    private String amount;
    private Date dateRequired;
    private Date dateForex;
    private String reasonForTravel;       
    private static final Logger logger = Logger.getLogger(ForeignBean.class.getName());      
   
    public ForeignBean()
    {
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
            
            forX.setDateofreturn(returnDate);
            forX.setTicketnum(ticketNumber);
            forX.setVoyagernum(voyagerNum);
            forX.setTravelerscheques(travellerCheque);
            forX.setCash(foreignCash);
            forX.setCashpassport(CashPassportCard);
            forX.setCctype(type);
            forX.setCclast3(last3);
            forX.setCcexpirydate(expire);
            forX.setCcpaymentamount(amount);
            forX.setDateofrequired(dateRequired);
            forX.setDatewillbeconfirmed(dateForex);
            forX.setReasonfortravel(reasonForTravel);
            
            csi.createForX(forX);
            return "welcomePrimefaces";
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

    public String getVoyagerNum() {
        return voyagerNum;
    }

    public void setVoyagerNum(String voyagerNum) {
        this.voyagerNum = voyagerNum;
    }

    public String getTravellerCheque() {
        return travellerCheque;
    }

    public void setTravellerCheque(String travellerCheque) {
        this.travellerCheque = travellerCheque;
    }

    public String getForeignCash() {
        return foreignCash;
    }

    public void setForeignCash(String foreignCash) {
        this.foreignCash = foreignCash;
    }

    public String getCashPassportCard() {
        return CashPassportCard;
    }

    public void setCashPassportCard(String CashPassportCard) {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
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
    
    
}
