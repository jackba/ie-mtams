/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Riaan
 */

@ManagedBean(name = "foreignBean")
@SessionScoped
public class ForeignBean implements Serializable
{
    //@EJB
    //private clientServer csi;
    
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
    private int ticketNumber;
    private double voyagerNum;
    private String travellerCheque;
    private String foreignCash;
    private String CashPassportCard;
    private String type;
    private int number;
    private int last3;
    private Date expire;
    private double amount;
    private Date dateRequired;
    private Date dateForex;
    private String reasonForTravel;       
    private static final Logger logger = Logger.getLogger(ForeignBean.class.getName());      
   
    public ForeignBean()
    {
    }
    
    /*
    public void save(ActionEvent actionEvent) {  
        //Persist user  
          
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  */
      
      
    public String onFlowProcess(FlowEvent event) {  
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());  
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());  
  
        return event.getNewStep();  
    }  
    
    public String createForm()
	{
		//Staff newStaff = new Staff(userName,password);		
		//csi.registerClient(newStaff);
		return "adminHome";
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

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public double getVoyagerNum() {
        return voyagerNum;
    }

    public void setVoyagerNum(double voyagerNum) {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLast3() {
        return last3;
    }

    public void setLast3(int last3) {
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
    
    
}
