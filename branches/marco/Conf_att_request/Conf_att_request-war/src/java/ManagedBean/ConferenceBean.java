/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Entities.Conference;
import Entities.Travelerprofile;
import ServiceLayer.ConferenceHandlerLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Marco Remane
 */
@ManagedBean(name = "conference")
@ViewScoped
public class ConferenceBean implements Serializable {

    @EJB
    private ConferenceHandlerLocal handler;
                    
    int accountID = 1;
    
    private Conference conf;
    private Conference confView;
    private Conference confEdit;
    private Travelerprofile travelerP;
    
    private static final Logger logger = Logger.getLogger(ConferenceBean.class.getName());
    //Section A - Personal Details
    private String schoolUnit;
    private String staffNum;
    private String title;
    private String firstName;
    private String lastName;
    //Section B - ConferenceBean Details
    private String confName;
    private String website;
    private String country;
    private String city;
    private int paperOption;
    private String yesReason;
    private String noReason;
    private String author;
    private Date presentationDate;
    //Section C - ConferenceBean Duration
    private Date fromDate;
    private Date toDate;
    private int diffDays;
    private String coverOptions;
    private String coverDetails;
    //Section D - Funding
    private String fundingOptions;
    private String otherSources;
    private String costCentre;
    private String fundName;

    public String onFlowProcess(FlowEvent event) {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());
        return event.getNewStep();
    }

    public void save() {
        FacesMessage msg;
        msg = new FacesMessage("Sucessfull", "Welcome " + this.getFirstName() + "" + this.getLastName());
        FacesContext.getCurrentInstance().addMessage(null, msg);

        conf = new Conference();

        conf.setConferencename((this.getConfName()));
        conf.setWebpage((this.getWebsite()));
        conf.setCountry((this.getCountry()));
        conf.setCity((this.getCity()));
        conf.setPresenting(this.getPaperOption());
        conf.setPresentationtitle(this.getYesReason());
        conf.setAuthors(this.getAuthor());
        conf.setOtherreasonattendance(this.getNoReason());
        conf.setDatemsapresentation(this.getPresentationDate());

        conf.setDatefrom(this.getFromDate());
        conf.setDateto(this.getToDate());
        conf.setConferenceduration(this.getDiffDays());
        conf.setReplacement(this.getCoverOptions());
        conf.setReplacementarrangments(this.getCoverDetails());

        handler.persist(conf);

    }
    
    public Travelerprofile getTravelerP() {
        travelerP = handler.findTravelerProfile(accountID);
        return travelerP;
    }

    public void setTravelerP(Travelerprofile travelerP) {
        this.travelerP = travelerP;
    }


    public String getSchoolUnit() {
        return schoolUnit;
    }

    public void setSchoolUnit(String schoolUnit) {
        this.schoolUnit = schoolUnit;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(String staffNum) {
        this.staffNum = staffNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPaperOption() {
        return paperOption;
    }

    public void setPaperOption(int paperOption) {
        this.paperOption = paperOption;
    }

    public String getYesReason() {
        return yesReason;
    }

    public void setYesReason(String yesReason) {
        this.yesReason = yesReason;
    }

    public String getNoReason() {
        return noReason;
    }

    public void setNoReason(String noReason) {
        this.noReason = noReason;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPresentationDate() {
        return presentationDate;
    }

    public void setPresentationDate(Date presentationDate) {
        this.presentationDate = presentationDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getDiffDays() {
        return diffDays;
    }

    public void setDiffDays(int diffDays) {
        this.diffDays = diffDays;
    }

    public String getCoverOptions() {
        return coverOptions;
    }

    public void setCoverOptions(String coverOptions) {
        this.coverOptions = coverOptions;
    }

    public String getCoverDetails() {
        return coverDetails;
    }

    public void setCoverDetails(String coverDetails) {
        this.coverDetails = coverDetails;
    }

    public String getFundingOptions() {
        return fundingOptions;
    }

    public void setFundingOptions(String fundingOptions) {
        this.fundingOptions = fundingOptions;
    }

    public String getOtherSources() {
        return otherSources;
    }

    public void setOtherSources(String otherSources) {
        this.otherSources = otherSources;
    }

    public String getCostCentre() {
        return costCentre;
    }

    public void setCostCentre(String costCentre) {
        this.costCentre = costCentre;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }
}
