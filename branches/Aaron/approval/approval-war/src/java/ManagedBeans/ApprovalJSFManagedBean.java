/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

//import Entities.Account;
import Entities.Account;
import Entities.Application;
import Entities.Approval;
import Entities.Finalcosting;
import Entities.Quotes;
import ServiceLayer.ApprovalHandlerLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author aaron
 */
@ManagedBean(name = "authorisation")
@SessionScoped
public class ApprovalJSFManagedBean implements Serializable {

    @EJB
    private ApprovalHandlerLocal approvalHandler;
    //======change===change=========change============change=========change====
    //-------------------------------------------------------------------------
    private int accountIDhack = 1;
    private int approvalIDhack = 1;
    private int applicationIDhack = 1;
    private int quoteIDhack = 1;
    //-------------------------------------------------------------------------
    //======change========change=========change=============change=============
    private static final Logger logger = Logger.getLogger(ApprovalJSFManagedBean.class.getName());
    
    private Approval approval;
    // instance variables for approval
    private int idapproval;
    private String fromsection;
    private int sectionid;
    private int sectionapproved;
    private String Notes;
    private Date DateStamp;
    private int ApplicationID;
    private int AccountID;
    
    private Finalcosting Fcosting;
    // instance variables for finalcosting
    private int IDFinalcosting;
    private String Name;
    private String administrativeunit;
    private int absencebussiness;
    private int absenceprivate;
    private String countries;
    private String citys;
    private int checks;
    private double AirfareBudget;
    private double AirfareCost;
    private double CarRentalBudget;
    private double CarRentalCost;
    private double AccomodationBudget;
    private double AccomodationCost;
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
    private double approvedcost;
    private int fromoz;
    
    private String ozname;
    @Pattern(message="Invalid Number", regexp="[0-9]{10,16}")
    private String oztel;
    @Pattern(message="Incorrect E-mail format", regexp="^[_a-z0-9A-Z-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")
    private String ozemail;
    //private Quotes quotesRef; 
    private Approval approvalRef;
    private Finalcosting fcostingRef;
    /*
     private int QuotesID;
    
    
     private UIData dataTable;

     private Account accountRef;// = new Account(accountIDhack);
     private Application applicationRef;// = new Application(applicationIDhack);    
     
    
     
     //private Account accountEntity;
    
     // special form element handlers
     private List<Integer> approvalChecks;
    
    
    

    
    
     */

    /**
     * Creates a new instance of ApprovalJSFManagedBean
     */
    public ApprovalJSFManagedBean() {
    }

    @PostConstruct
    private void setSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    public void save() {

        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"getting there",null));

        approval = new Approval();
        //approval.setIdapproval(idapproval);
        approval.setNotes(Notes);
        approval.setDate(DateStamp);
        approval.setSectionapproved(sectionapproved);
        approval.setFromsection(fromsection);
        // need to fix for app intergration
        //approval.setAccountIdaccount(accountRef);
        //approval.setApplicationIdapplication(applicationRef);
        approvalHandler.persistApproval(approval);


        Fcosting = new Finalcosting();

        //Fcosting.setIdfinalcosting(IDFinalcosting);
        Fcosting.setName(Name);
        Fcosting.setAdministrativeunit(administrativeunit);
        Fcosting.setAbsencebussiness(absencebussiness);
        Fcosting.setAbsenceprivate(absenceprivate);
        Fcosting.setCountries(countries);
        Fcosting.setCitys(citys);
        Fcosting.setChecks(checks);


        Fcosting.setAccommodationbudget(AccomodationBudget);
        Fcosting.setAccommodationcost(AccomodationCost);
        Fcosting.setAccommodatedays(accommodatedays);
        Fcosting.setAirfarebudget(AirfareBudget);
        Fcosting.setAirfarecost(AirfareCost);
        Fcosting.setCarrentalbudget(CarRentalBudget);
        Fcosting.setCarrentalcost(CarRentalCost);
        Fcosting.setPerdiembudget(perdiembudget);
        Fcosting.setPerdiemcost(perdiemcost);
        Fcosting.setPerdiemdays(perdiemdays);
        Fcosting.setConferencebudget(conferencebudget);
        Fcosting.setConferencecost(conferencecost);
        Fcosting.setVisabudget(visabudget);
        Fcosting.setVisacost(visacost);
        Fcosting.setOtherbudget(otherbudget);
        Fcosting.setOthercost(othercost);
        Fcosting.setOtherdiscription(otherdiscription);
        Fcosting.setApprovedbudget(approvedbudget);
        Fcosting.setApprovedcost(approvedcost);

        Fcosting.setFromoz(fromoz);
        Fcosting.setOzname(ozname);
        Fcosting.setOztel(oztel);
        Fcosting.setOzemail(ozemail);
        // need to fix for app intergration
        //quotesRef = new Quotes(quoteIDhack);
        //Fcosting.setQuotesIdquotes(quotesRef);


        approvalHandler.persistFinalcosting(Fcosting);

        //Fcosting.setQuotesIdquotes(QuotesID);
        //FacesContext.getCurrentInstance().addMessage("submitConfirm", new FacesMessage(FacesMessage.SEVERITY_INFO,"Success","Changes have been saved"));
    }

    public String goHome() {
        return "authorisation";
    }

    public String editauthorisation() {
        //need to change this to edit once I build edit
        return "viewAuthorisation";
    }

    public String viewauthorisation() {
        return "viewAuthorisation";
    }
    /*
     public List<Integer> getApprovalChecklist() {
     return approvalChecks;
     }

     public void setApprovalChecks(List<Integer> approvalChecks) {
     this.approvalChecks = approvalChecks;
     }
     */

    // probably don't need this might get rid of it
    public String onFlowProcess(FlowEvent event) {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());

        return event.getNewStep();
    }

//    public UIData getDataTable() {
//        return dataTable;
//    }
//
//    public void setDataTable(UIData dataTable) {
//        this.dataTable = dataTable;
//    }    
//    
    // getters and setters from here
    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
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

    public int getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(int ApplicationID) {
        this.ApplicationID = ApplicationID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public Finalcosting getFcosting() {
        return Fcosting;
    }

    public void setFcosting(Finalcosting Fcosting) {
        this.Fcosting = Fcosting;
    }

    public int getIDFinalcosting() {
        return IDFinalcosting;
    }

    public void setIDFinalcosting(int IDFinalcosting) {
        this.IDFinalcosting = IDFinalcosting;
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

    public String getCitys() {
        return citys;
    }

    public void setCitys(String citys) {
        this.citys = citys;
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

    public double getAccomodationBudget() {
        return AccomodationBudget;
    }

    public void setAccomodationBudget(double AccomodationBudget) {
        this.AccomodationBudget = AccomodationBudget;
    }

    public double getAccomodationCost() {
        return AccomodationCost;
    }

    public void setAccomodationCost(double AccomodationCost) {
        this.AccomodationCost = AccomodationCost;
    }

    public int getAccommodatedays() {
        return accommodatedays;
    }

    public void setAccommodatedays(int accommodatedays) {
        this.accommodatedays = accommodatedays;
    }

    public Double getPerdiembudget() {
        return perdiembudget;
    }

    public void setPerdiembudget(Double perdiembudget) {
        this.perdiembudget = perdiembudget;
    }

    public Double getPerdiemcost() {
        return perdiemcost;
    }

    public void setPerdiemcost(Double perdiemcost) {
        this.perdiemcost = perdiemcost;
    }

    public int getPerdiemdays() {
        return perdiemdays;
    }

    public void setPerdiemdays(int perdiemdays) {
        this.perdiemdays = perdiemdays;
    }

    public Double getConferencebudget() {
        return conferencebudget;
    }

    public void setConferencebudget(Double conferencebudget) {
        this.conferencebudget = conferencebudget;
    }

    public Double getConferencecost() {
        return conferencecost;
    }

    public void setConferencecost(Double conferencecost) {
        this.conferencecost = conferencecost;
    }

    public Double getVisabudget() {
        return visabudget;
    }

    public void setVisabudget(Double visabudget) {
        this.visabudget = visabudget;
    }

    public Double getVisacost() {
        return visacost;
    }

    public void setVisacost(Double visacost) {
        this.visacost = visacost;
    }

    public Double getOtherbudget() {
        return otherbudget;
    }

    public void setOtherbudget(Double otherbudget) {
        this.otherbudget = otherbudget;
    }

    public Double getOthercost() {
        return othercost;
    }

    public void setOthercost(Double othercost) {
        this.othercost = othercost;
    }

    public String getOtherdiscription() {
        return otherdiscription;
    }

    public void setOtherdiscription(String otherdiscription) {
        this.otherdiscription = otherdiscription;
    }

    public Double getApprovedbudget() {
        return approvedbudget;
    }

    public void setApprovedbudget(Double approvedbudget) {
        this.approvedbudget = approvedbudget;
    }

    public Double getApprovedcost() {
        return approvedcost;
    }

    public void setApprovedcost(Double approvedcost) {
        this.approvedcost = approvedcost;
    }

    public Integer getFromoz() {
        return fromoz;
    }

    public void setFromoz(Integer fromoz) {
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

    public Approval getApprovalRef() {
        approvalRef = approvalHandler.findApproval(approvalIDhack);
        return approvalRef;
    }

    public void setApprovalRef(Approval approvalRef) {

        this.approvalRef = approvalRef;
    }

    public Finalcosting getFcostingRef() {
        fcostingRef = approvalHandler.findFinalcosting(accountIDhack);
        return fcostingRef;
    }

    public void setFcostingRef(Finalcosting fcostingRef) {
        this.fcostingRef = fcostingRef;
    }

    /*
     public int getQuotesID() {
     return QuotesID;
     }

     public void setQuotesID(int QuotesID) {
     this.QuotesID = QuotesID;
     }

     public Account getAccountRef() {
     return accountRef;
     }

     public void setAccountRef(Account accountRef) {
     this.accountRef = accountRef;
     }

     public Application getApplicationRef() {
     return applicationRef;
     }

     public void setApplicationRef(Application applicationRef) {
     this.applicationRef = applicationRef;
     }

     public Quotes getQuotesRef() {
     return quotesRef;
     }

     public void setQuotesRef(Quotes quotesRef) {
     this.quotesRef = quotesRef;
     }


     */
    public ApprovalHandlerLocal getApprovalHandler() {
        return approvalHandler;
    }

    public void setApprovalHandler(ApprovalHandlerLocal approvalHandler) {
        this.approvalHandler = approvalHandler;
    }

    public int getApprovalID() {
        return approvalIDhack;
    }

    public void setApprovalID(int approvalID) {
        this.approvalIDhack = approvalID;
    }

    public Integer getIdapproval() {
        return idapproval;
    }

    public void setIdapproval(Integer idapproval) {
        this.idapproval = idapproval;
    }

    public String getFromsection() {
        return fromsection;
    }

    public void setFromsection(String fromsection) {
        this.fromsection = fromsection;
    }

    public Integer getSectionid() {
        return sectionid;
    }

    public void setSectionid(Integer sectionid) {
        this.sectionid = sectionid;
    }

    public Integer getSectionapproved() {
        return sectionapproved;
    }

    public void setSectionapproved(Integer sectionapproved) {
        this.sectionapproved = sectionapproved;
    }
}
