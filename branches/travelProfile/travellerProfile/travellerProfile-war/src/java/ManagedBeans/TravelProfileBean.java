/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Sparda
 */
@ManagedBean(name = "travel")
@ViewScoped
public class TravelProfileBean {
    private static final Logger logger = Logger.getLogger(TravelProfileBean.class.getName());
    private String department; 
    private String position;
    private String travelBooker;
    private String firstName;
    private String surname;
    private String middleName;
    private String title;
    private String idNo;
    private String busAddress;
    private String busPhone;
    private String busFax;
    private String homeAddress;
    private String mobilePhone; 
    private String homePhone;
    private String email;
    private String spouseName;
    private String spouseContactNo;
    private String spouseEmail;
    private String docName;
    private String docContactNo;
    private String docEmail;
    private String knownMedConditions;
    
    private String passportNo;
    private String country;
    private String dateOfIssue;
    private String expiryDate;
    private String validVisas;
    
    private String seat;
    private String airPosition;
    private String classDomestic;
    private String classInternational;
    private String specialMealReq;
    private String airAdditionalReq;
    private String memOne;
    private String memTwo;
    private String memThree;
    private String airTypeStatus1;
    private String airTypeStatus2;
    private String airTypeStatus3;
    private String cardNum1;
    private String cardNum2;
    private String cardNum3;
    
    //private TravellerProfile profile = new TravellerProfile();
    public TravelProfileBean() {
        
    }

    /*public TravellerProfile getProfile() {
        return profile;
    }

    public void setProfile(TravellerProfile profile) {
        this.profile = profile;
    }*/
    
    public void save(ActionEvent actionEvent) {  
        //Persist user          
        //FacesMessage msg = new FacesMessage("Successful", "Welcome :" + .getFirstname());  
        //FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public String onFlowProcess(FlowEvent event) {  
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());  
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());  
            
        return event.getNewStep();  
          
    } 

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTravelBooker() {
        return travelBooker;
    }

    public void setTravelBooker(String travelBooker) {
        this.travelBooker = travelBooker;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getBusAddress() {
        return busAddress;
    }

    public void setBusAddress(String busAddress) {
        this.busAddress = busAddress;
    }

    public String getBusPhone() {
        return busPhone;
    }

    public void setBusPhone(String busPhone) {
        this.busPhone = busPhone;
    }

    public String getBusFax() {
        return busFax;
    }

    public void setBusFax(String busFax) {
        this.busFax = busFax;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseContactNo() {
        return spouseContactNo;
    }

    public void setSpouseContactNo(String spouseContactNo) {
        this.spouseContactNo = spouseContactNo;
    }

    public String getSpouseEmail() {
        return spouseEmail;
    }

    public void setSpouseEmail(String spouseEmail) {
        this.spouseEmail = spouseEmail;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocContactNo() {
        return docContactNo;
    }

    public void setDocContactNo(String docContactNo) {
        this.docContactNo = docContactNo;
    }

    public String getDocEmail() {
        return docEmail;
    }

    public void setDocEmail(String docEmail) {
        this.docEmail = docEmail;
    }

    public String getKnownMedConditions() {
        return knownMedConditions;
    }

    public void setKnownMedConditions(String knownMedConditions) {
        this.knownMedConditions = knownMedConditions;
    }
     
    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getValidVisas() {
        return validVisas;
    }

    public void setValidVisas(String validVisas) {
        this.validVisas = validVisas;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getAirPosition() {
        return airPosition;
    }

    public void setAirPosition(String airPosition) {
        this.airPosition = airPosition;
    }

    public String getClassDomestic() {
        return classDomestic;
    }

    public void setClassDomestic(String classDomestic) {
        this.classDomestic = classDomestic;
    }

    public String getClassInternational() {
        return classInternational;
    }

    public void setClassInternational(String classInternational) {
        this.classInternational = classInternational;
    }
    
    public String getSpecialMealReq() {
        return specialMealReq;
    }

    public void setSpecialMealReq(String specialMealReq) {
        this.specialMealReq = specialMealReq;
    }

    public String getAirAdditionalReq() {
        return airAdditionalReq;
    }

    public void setAirAdditionalReq(String airAdditionalReq) {
        this.airAdditionalReq = airAdditionalReq;
    }

    public String getMemOne() {
        return memOne;
    }

    public void setMemOne(String memOne) {
        this.memOne = memOne;
    }

    public String getMemTwo() {
        return memTwo;
    }

    public void setMemTwo(String memTwo) {
        this.memTwo = memTwo;
    }

    public String getMemThree() {
        return memThree;
    }

    public void setMemThree(String memThree) {
        this.memThree = memThree;
    }
    
    public String getAirTypeStatus1() {
        return airTypeStatus1;
    }

    public void setAirTypeStatus1(String airTypeStatus1) {
        this.airTypeStatus1 = airTypeStatus1;
    }

    public String getAirTypeStatus2() {
        return airTypeStatus2;
    }

    public void setAirTypeStatus2(String airTypeStatus2) {
        this.airTypeStatus2 = airTypeStatus2;
    }

    public String getAirTypeStatus3() {
        return airTypeStatus3;
    }

    public void setAirTypeStatus3(String airTypeStatus3) {
        this.airTypeStatus3 = airTypeStatus3;
    }

    public String getCardNum1() {
        return cardNum1;
    }

    public void setCardNum1(String cardNum1) {
        this.cardNum1 = cardNum1;
    }

    public String getCardNum2() {
        return cardNum2;
    }

    public void setCardNum2(String cardNum2) {
        this.cardNum2 = cardNum2;
    }

    public String getCardNum3() {
        return cardNum3;
    }

    public void setCardNum3(String cardNum3) {
        this.cardNum3 = cardNum3;
    }        
}
