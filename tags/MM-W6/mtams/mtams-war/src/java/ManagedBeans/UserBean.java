/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Entities.Account;
import Entities.Application;
import Entities.Approval;
import javax.inject.Named;
import Entities.Rewardsprogram;
import Entities.Traveldocument;
import Entities.Travelerprofile;
import ServiceLayer.AccountHandlerLocal;
import ServiceLayer.ApplicationHandlerLocal;
import ServiceLayer.ApprovalHandlerLocal;
import ServiceLayer.LoginHandlerLocal;
import ServiceLayer.TravelProfileHandlerLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.component.UIData;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Badger
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    //======change===change=========change============change=========change====

    private Integer accountID = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("userID");
    //======change========change=========change=============change=============
    private static final Logger logger = Logger.getLogger(ManagedBeans.UserBean.class.getName());
    @EJB
    private ApplicationHandlerLocal appHandler;
    private List<Application> allApps;
    private List<Application> approvalApps;
    @EJB
    private ApprovalHandlerLocal apprHandler;
    @EJB
    private AccountHandlerLocal accHandler;
    @EJB
    private LoginHandlerLocal logHandler;
    private List<Approval> allApproved;
    private Application selectedApp;
    private String department;
    @Pattern(message = "Incorrect ID", regexp = "[0-9a-zA-Z ]{8}")
    private String staffID;
    private String position;
    @Pattern(message = "Incorrect Name", regexp = "[a-zA-Z ]+${0,}")
    private String travelBooker;
    @Pattern(message = "Incorrect Name", regexp = "[a-zA-Z]{0,}")
    private String firstName;
    @Pattern(message = "Incorrect Name", regexp = "[a-zA-Z]{0,}")
    private String surname;
    @Pattern(message = "Incorrect Name", regexp = "([a-zA-Z]{0,})?")
    private String middleName;
    private String title;
    @Pattern(message = "Incorrect ID", regexp = "[0-9]{13,15}")
    private String idNo;
    private String busAddress;
    @Pattern(message = "Incorrect Number", regexp = "[+0-9]{10,16}")
    private String busPhone;
    @Pattern(message = "Incorrect Number", regexp = "([+0-9]{10,16})?")
    private String busFax;
    private String homeAddress;
    private String homeAddress2;
    private String city;
    private String countryH;
    private String province;
    private String postalCode;
    @Pattern(message = "Incorrect Number", regexp = "[+0-9]{10,16}")
    private String mobilePhone;
    @Pattern(message = "Incorrect Number", regexp = "([+0-9]{10,16})?")
    private String homePhone;
    @Pattern(message = "Incorrect E-mail format", regexp = "^[_a-z0-9A-Z-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")
    private String email;
    @Pattern(message = "Incorrect Name", regexp = "([a-zA-Z]{0,})?")
    private String spouseName;
    @Pattern(message = "Incorrect Number", regexp = "([+0-9]{10,16})?")
    private String spouseContactNo;
    @Pattern(message = "Incorrect E-mail format", regexp = "(^[_a-z0-9A-Z-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$)?")
    private String spouseEmail;
    @Pattern(message = "Incorrect Name", regexp = "([a-zA-Z]{0,})?")
    private String docName;
    @Pattern(message = "Incorrect Number", regexp = "[+0-9]{10,16}")
    private String docContactNo;
    @Pattern(message = "Incorrect E-mail format", regexp = "^[_a-z0-9A-Z-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")
    private String docEmail;
    private String knownMedConditions;
    @Pattern(message = "Incorrect Passport ID", regexp = "[0-9a-zA-Z]{8,10}")
    private String passportNo;
    private String country;
    @Past(message = "Date must be further into the past")
    private Date dateOfIssue;
    @Future(message = "Date needs to be further into the future")
    private Date expiryDate;
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
    private String airType1;
    private String airType2;
    private String airType3;
    private String status1;
    private String status2;
    private String status3;
    @Pattern(message = "Incorrect Card Number", regexp = "[0-9]{0,15}")
    private String cardNum1;
    @Pattern(message = "Incorrect Card Number", regexp = "[0-9]{0,15}")
    private String cardNum2;
    @Pattern(message = "Incorrect Card Number", regexp = "[0-9]{0,15}")
    private String cardNum3;
    private String carCompPref1;
    private String carCompPref2;
    private String carGroup;
    private String transmissionType;
    private String aircon;
    private String carAdditionalReq;
    private String hotelPreference;
    private String freqGuestNo;
    private String smoking;
    private String hotelAdditionalReq;
    private UIData dataTable;
    private Travelerprofile profile;
    private Travelerprofile profileRef;
    private Travelerprofile profileEditRef;
    private Traveldocument passport;
    private Traveldocument passportRef;
    private Traveldocument passportEditRef;
    private Rewardsprogram reward1;
    private Rewardsprogram reward2;
    private Rewardsprogram reward3;
    @EJB
    private TravelProfileHandlerLocal handler;
    private Date currentDate = new Date();

    public Date getCurrentDate() {
        return currentDate;
    }

    public UserBean() {
    }

    public List<Application> getApprovalApps() {
        approvalApps = appHandler.getAllAppList(accountID);
        return approvalApps;
    }

    public void setApprovalApps(List<Application> approvalApps) {
        this.approvalApps = approvalApps;
    }

    public List<Application> getAllApps() {
        allApps = appHandler.getAppList(accountID);

        return allApps;
    }

    public void setAllApps(List<Application> allApps) {
        this.allApps = allApps;
    }

    public List<Approval> getAllApproved() {
        allApproved = apprHandler.findApprovalbyAccount(accountID);
        return allApproved;
    }

    public void setAllApproved(List<Approval> allApproved) {
        this.allApproved = allApproved;
    }

    public String goToProfile() {
        return "travelProfileCreate";
    }

    public String viewProfile() {

        return "travelProfileView";
    }

    public String goNewApp() {
        return "applicationCreate";
    }

    public String editProfile() {
        getProfile();
        return "travelProfileEdit";
    }

    public String save() {


        //Pesonal Details
        profile = new Travelerprofile();

        //Pesonal Details        

        profile.setDepartment(department);
        profile.setStaffid(staffID);
        profile.setPosition(position);
        profile.setTravelbooker(travelBooker);
        profile.setFirstname(firstName);
        profile.setFamilyname(surname);
        profile.setMiddlename(middleName);
        profile.setTitle(title);
        profile.setIdnumber(idNo);
        profile.setBusinessaddress("144 Peter Rd, Johannesburg, Guateng, South Africa");
        profile.setBusinessphone(busPhone);
        profile.setBusinessfax(busFax);
        profile.setHomeaddress1(homeAddress);
        profile.setHomeaddress2(homeAddress2);
        profile.setCity(city);
        profile.setCountry("South Africa");
        profile.setProvince(province);
        profile.setPostalcode(postalCode);
        profile.setMobilephone(mobilePhone);
        profile.setHomephone(homePhone);
        profile.setHomeemail(email);
        profile.setSpousename(spouseName);
        profile.setSpousecontactnumber(spouseContactNo);
        profile.setSpouseemail(spouseEmail);
        profile.setDoctorsname(docName);
        profile.setDoctorsconctactnumber(docContactNo);
        profile.setDoctorsemail(docEmail);
        profile.setKnownmedicalconditions(knownMedConditions);
        //Airline
        profile.setSeatingposition(seat);
        profile.setSeatinglocation(airPosition);
        profile.setClassdomestic(classDomestic);
        profile.setClassinternational(classInternational);
        profile.setMealrequirements(specialMealReq);
        profile.setAiradditionalrequirements(airAdditionalReq);
        //Car & Hotel
        profile.setCarpreference1(carCompPref1);
        profile.setCarpreference2(carCompPref2);
        profile.setCargroup(carGroup);
        profile.setManualautomatic(transmissionType);
        profile.setAircon(aircon);
        profile.setCaradditionalrequirements(carAdditionalReq);
        profile.setHotelprefrence(hotelPreference);
        profile.setFrequentguestnum(freqGuestNo);
        profile.setSmoking(smoking);
        profile.setHoteladditionalrequirements(hotelAdditionalReq);

        //Passport & Visa
        passport = new Traveldocument();

        passport.setPassportnumber(passportNo);
        passport.setCountry(country);
        passport.setDateofissue(dateOfIssue);
        passport.setExpirydate(expiryDate);
        passport.setValidvisa(validVisas);
        handler.persist(accountID, profile, passport);

        //Rewards Program (Airline)
        reward1 = new Rewardsprogram();
        reward2 = new Rewardsprogram();
        reward3 = new Rewardsprogram();

        /*if(!memOne.isEmpty() && !airType1.isEmpty() && !status1.isEmpty() && !cardNum1.isEmpty()){
         reward1.setMembershiptype(memOne);
         reward1.setProvider(airType1);
         reward1.setDescription(status1);
         reward1.setMembershipnumber(cardNum1);
         handler.persistReward(reward1);
         }
         if(!memTwo.isEmpty() && !airType2.isEmpty() && !status2.isEmpty() && !cardNum2.isEmpty()){
         reward2.setMembershiptype(memTwo);
         reward2.setProvider(airType2);
         reward2.setDescription(status2);
         reward2.setMembershipnumber(cardNum2);
         handler.persistReward(reward2);
         }
         if(!memThree.isEmpty() && !airType3.isEmpty() && !status3.isEmpty() && !cardNum3.isEmpty()){
         reward3.setMembershiptype(memThree);
         reward3.setProvider(airType3);
         reward3.setDescription(status3);
         reward3.setMembershipnumber(cardNum3);
         handler.persistReward(reward3);
         }*/
        Account user = accHandler.getAccount(accountID);
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).setAttribute("isFirst", false);
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isFirst", false);
        user.setDatelogin(new Date());
        logHandler.modifyAccount(user);
        FacesContext.getCurrentInstance().addMessage("userTop", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Travel Profile active"));
        return "userHome";
    }

    public void update() {
        profileEditRef.setDepartment(department);
        profileEditRef.setStaffid(staffID);
        profileEditRef.setPosition(position);
        profileEditRef.setTravelbooker(travelBooker);
        profileEditRef.setFirstname(firstName);

        profileEditRef.setFamilyname(surname);
        profileEditRef.setMiddlename(middleName);
        profileEditRef.setTitle(title);
        profileEditRef.setIdnumber(idNo);

        profileEditRef.setBusinessaddress(busAddress);
        profileEditRef.setBusinessphone(busPhone);
        profileEditRef.setBusinessfax(busFax);

        profileEditRef.setHomeaddress1(homeAddress);
        profileEditRef.setHomephone(homePhone);
        profileEditRef.setHomeemail(email);
        profileEditRef.setMobilephone(mobilePhone);
        profileEditRef.setSpousename(spouseName);
        profileEditRef.setSpousecontactnumber(spouseContactNo);
        profileEditRef.setSpouseemail(spouseEmail);

        profileEditRef.setDoctorsname(docName);
        profileEditRef.setDoctorsconctactnumber(docContactNo);
        profileEditRef.setDoctorsemail(docEmail);
        profileEditRef.setKnownmedicalconditions(knownMedConditions);

        //Airline

        profileEditRef.setSeatingposition(seat);
        profileEditRef.setSeatinglocation(airPosition);
        profileEditRef.setClassdomestic(classDomestic);
        profileEditRef.setClassinternational(classInternational);
        profileEditRef.setMealrequirements(specialMealReq);
        profileEditRef.setAiradditionalrequirements(airAdditionalReq);

        //Hotel&Car

        profileEditRef.setManualautomatic(transmissionType);
        profileEditRef.setAircon(aircon);
        profileEditRef.setCarpreference1(carCompPref1);
        profileEditRef.setCarpreference2(carCompPref2);
        profileEditRef.setCargroup(carGroup);
        profileEditRef.setCaradditionalrequirements(carAdditionalReq);
        profileEditRef.setHotelprefrence(hotelPreference);
        profileEditRef.setFrequentguestnum(freqGuestNo);
        profileEditRef.setHoteladditionalrequirements(hotelAdditionalReq);
        profileEditRef.setSmoking(smoking);

        //Passport

        passportEditRef.setPassportnumber(passportNo);
        passportEditRef.setCountry(country);
        passportEditRef.setDateofissue(dateOfIssue);
        passportEditRef.setExpirydate(expiryDate);
        passportEditRef.setValidvisa(validVisas);

        handler.persistProfileEdit(profileEditRef, accountID);
        FacesContext.getCurrentInstance().addMessage("submitConfirm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Changes have been saved"));
    }

    private void getProfile() {

        logger.log(Level.INFO, "user id", accountID);

        Travelerprofile ref = handler.findTravelProf(accountID);
        Traveldocument pRef = handler.findTravelDoc(ref.getIdtravelerprofile());
        setDepartment(ref.getDepartment());
        setStaffID(ref.getStaffid());
        setPosition(ref.getPosition());
        setTravelBooker(ref.getTravelbooker());
        setFirstName(ref.getFirstname());
        setSurname(ref.getFamilyname());

        setMiddleName(ref.getMiddlename());
        setTitle(ref.getTitle());
        setIdNo(ref.getIdnumber());

        setBusAddress(ref.getBusinessaddress());
        setBusPhone(ref.getBusinessphone());
        setBusFax(ref.getBusinessfax());

        setHomeAddress(ref.getHomeaddress1());
        setHomePhone(ref.getHomephone());
        setMobilePhone(ref.getMobilephone());
        setEmail(ref.getHomeemail());
        setSpouseName(ref.getSpousename());
        setSpouseContactNo(ref.getSpousecontactnumber());
        setSpouseEmail(ref.getSpouseemail());

        setDocName(ref.getDoctorsname());
        setDocContactNo(ref.getDoctorsconctactnumber());
        setDocEmail(ref.getDoctorsemail());
        setKnownMedConditions(ref.getKnownmedicalconditions());

        //Passport
        if (pRef != null) {
            setPassportNo(pRef.getPassportnumber());
            setCountry(pRef.getCountry());
            setDateOfIssue(pRef.getDateofissue());
            setExpiryDate(pRef.getExpirydate());
            setValidVisas(pRef.getValidvisa());
        }
        //Airline Details
        setSeat(ref.getSeatingposition());
        setAirPosition(ref.getSeatinglocation());
        setClassDomestic(ref.getClassdomestic());
        setClassInternational(ref.getClassinternational());
        setSpecialMealReq(ref.getMealrequirements());
        setAirAdditionalReq(ref.getAiradditionalrequirements());

        //Car and Hotel
        setTransmissionType(ref.getManualautomatic());
        setAircon(ref.getAircon());
        setCarCompPref1(ref.getCarpreference1());
        setCarCompPref2(ref.getCarpreference2());
        setCarGroup(ref.getCargroup());
        setCarAdditionalReq(ref.getCaradditionalrequirements());
        setHotelPreference(ref.getHotelprefrence());
        setFreqGuestNo(ref.getFrequentguestnum());
        setHotelAdditionalReq(ref.getHoteladditionalrequirements());
        setSmoking(ref.getSmoking());

        passportEditRef = pRef;
        profileEditRef = ref;
    }

    public Traveldocument getPassportRef() {
        int profileID = profileRef.getIdtravelerprofile();
        passportRef = handler.findTravelDoc(profileID);
        return passportRef;
    }

    public void setPassportRef(Traveldocument passportRef) {
        this.passportRef = passportRef;
    }

    public Travelerprofile getProfileRef() {
        logger.log(Level.INFO, "account", accountID);
        profileRef = handler.findTravelProf(accountID);
        return profileRef;
    }

    public void setProfileRef(Travelerprofile profileRef) {
        this.profileRef = profileRef;
    }

    public String onFlowProcess(FlowEvent event) {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());


        return event.getNewStep();
    }

    public List<Rewardsprogram> getAllRewards() {
        return handler.findRewards(profileRef.getIdtravelerprofile());
    }

    public UIData getDataTable() {
        return dataTable;
    }

    public void setDataTable(UIData dataTable) {
        this.dataTable = dataTable;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
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

    public String getHomeAddress2() {
        return homeAddress2;
    }

    public void setHomeAddress2(String homeAddress2) {
        this.homeAddress2 = homeAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryH() {
        return countryH;
    }

    public void setCountryH(String countryH) {
        this.countryH = countryH;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
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

    public String getAirType1() {
        return airType1;
    }

    public void setAirType1(String airType1) {
        this.airType1 = airType1;
    }

    public String getAirType2() {
        return airType2;
    }

    public void setAirType2(String airType2) {
        this.airType2 = airType2;
    }

    public String getAirType3() {
        return airType3;
    }

    public void setAirType3(String airType3) {
        this.airType3 = airType3;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getStatus3() {
        return status3;
    }

    public void setStatus3(String status3) {
        this.status3 = status3;
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

    public String getCarCompPref1() {
        return carCompPref1;
    }

    public void setCarCompPref1(String carCompPref1) {
        this.carCompPref1 = carCompPref1;
    }

    public String getCarCompPref2() {
        return carCompPref2;
    }

    public void setCarCompPref2(String carCompPref2) {
        this.carCompPref2 = carCompPref2;
    }

    public String getCarGroup() {
        return carGroup;
    }

    public void setCarGroup(String carGroup) {
        this.carGroup = carGroup;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getAircon() {
        return aircon;
    }

    public void setAircon(String aircon) {
        this.aircon = aircon;
    }

    public String getCarAdditionalReq() {
        return carAdditionalReq;
    }

    public void setCarAdditionalReq(String carAdditionalReq) {
        this.carAdditionalReq = carAdditionalReq;
    }

    public String getHotelPreference() {
        return hotelPreference;
    }

    public void setHotelPreference(String hotelPreference) {
        this.hotelPreference = hotelPreference;
    }

    public String getFreqGuestNo() {
        return freqGuestNo;
    }

    public void setFreqGuestNo(String freqGuestNo) {
        this.freqGuestNo = freqGuestNo;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getHotelAdditionalReq() {
        return hotelAdditionalReq;
    }

    public void setHotelAdditionalReq(String hotelAdditionalReq) {
        this.hotelAdditionalReq = hotelAdditionalReq;
    }

    public Application getSelectedApp() {
        return selectedApp;
    }

    public void setSelectedApp(Application selectedApp) {
        this.selectedApp = selectedApp;
    }

    public void view() {
        try {
            ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).setAttribute("appID", selectedApp.getIdapplication());
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("appID", selectedApp.getIdapplication());
            //return "./applicationApproval.xhtml";

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/applicationHome.xhtml");
            //FacesContext.getCurrentInstance().addMessage("userTop", new FacesMessage(FacesMessage.SEVERITY_INFO,"Success",(selectedApp.getIdapplication() + "Selected")));
        } catch (IOException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String viewHome() {
        return "/applicationHome.xhtml";
    }

    public void display() {
        try {
            ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).setAttribute("appID", selectedApp.getIdapplication());
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("appID", selectedApp.getIdapplication());
            //return "./applicationApproval.xhtml";

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/applicationApproval.xhtml");
            //FacesContext.getCurrentInstance().addMessage("userTop", new FacesMessage(FacesMessage.SEVERITY_INFO,"Success",(selectedApp.getIdapplication() + "Selected")));
        } catch (IOException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String goHome() {
        return "userHome";
    }

    public String goAuthHome() {
        return "authorizerHome";
    }
}