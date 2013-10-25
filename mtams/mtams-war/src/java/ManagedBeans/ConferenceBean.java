/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Entities.Conference;
import Entities.Quotes;
import Entities.Travelerprofile;
import ServiceLayer.ConferenceHandlerLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Marco Remane
 */
@ManagedBean(name = "conference")
@ViewScoped
public class ConferenceBean implements Serializable {

    private static final Logger logger = Logger.getLogger(ConferenceBean.class.getName());
    //Persistence Crap
    @EJB
    private ConferenceHandlerLocal handler;
    private Conference conf;
    private Conference confView;
    private Conference confEdit;
    private Travelerprofile travelerP;
    private Quotes quotes;
    //int accountID = 1;
    private int accountID = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("userID");
    private int appnum = (Integer) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("appID");
    //Section B - Conference Details
    private String confName;
    @Pattern(message = "Incorrect Website Format", regexp = "(((ht|f)tp(s)?://)|www.){1}([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?")
    private String website;
    private String country;
    @Pattern(message = "Incorrect City Name", regexp = "^[a-zA-Z]+$")
    private String city;
    private Integer isPresenting;
    private String paperTitle;
    private String specialReason;
    private String author;
    private Date presentationDate;
    //Section C - Conference Duration
    @Future(message = "Date Must Be In The Future")
    private Date fromDate;
    @Future(message = "Date Must Be In The Future")
    private Date toDate;
    //private Integer diffDays;
    private String coverOptions;
    private String coverDetails;
    //Section D - Funding
    private String fundingOptions;
    private String otherFunding;
    private String fundName;

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public void save() {
        conf = new Conference();

        conf.setConferencename((this.getConfName()));
        conf.setWebpage((this.getWebsite()));
        conf.setCountry((this.getCountry()));
        conf.setCity((this.getCity()));
        conf.setPresenting(this.getIsPresenting());
        conf.setPresentationtitle(this.getPaperTitle());
        conf.setAuthors(this.getAuthor());
        conf.setOtherreasonattendance(this.getSpecialReason());
        conf.setDatemsapresentation(this.getPresentationDate());

        conf.setDatefrom(this.getFromDate());
        conf.setDateto(this.getToDate());
        //conf.setConferenceduration(this.getDiffDays());
        conf.setReplacement(this.getCoverOptions());
        conf.setReplacementarrangments(this.getCoverDetails());

        conf.setFundingsources(this.getFundingOptions());
        conf.setOtherfundingsources(this.getOtherFunding());
        conf.setFundname(this.getFundName());

        handler.updateConference(conf, accountID);
        //handler.persist(conf);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucessfull", this.getConfName() + " Added!"));
    }

    @PostConstruct
    public void view() {
        confView = handler.findConference(appnum);
        if (confView != null) {
            logger.log(Level.INFO, "Conference ID:", confView.getIdconference());

            this.setConfName(confView.getConferencename());
            this.setWebsite(confView.getWebpage());
            this.setCountry(confView.getCountry());
            this.setCity(confView.getCity());
            if(confView.getPresenting() == null){
                this.setIsPresenting(0);
            }else{
                this.setIsPresenting(confView.getPresenting());
            }
            
            this.setPaperTitle(confView.getPresentationtitle());
            this.setAuthor(confView.getAuthors());
            this.setSpecialReason(confView.getOtherreasonattendance());
            this.setPresentationDate(confView.getDatemsapresentation());

            this.setFromDate(confView.getDatefrom());
            this.setToDate(confView.getDateto());
            //this.setDiffDays(confView.getConferenceduration());
            this.setCoverOptions(confView.getReplacement());
            this.setCoverDetails(confView.getReplacementarrangments());

            this.setFundingOptions(confView.getFundingsources());
            this.setOtherFunding(confView.getOtherfundingsources());
            this.setFundName(confView.getFundname());
        }
    }

    public void update() {
        confEdit = new Conference();

        confEdit.setConferencename((this.getConfName()));
        confEdit.setWebpage((this.getWebsite()));
        confEdit.setCountry((this.getCountry()));
        confEdit.setCity((this.getCity()));
        confEdit.setPresenting(this.getIsPresenting());
        confEdit.setPresentationtitle(this.getPaperTitle());
        confEdit.setAuthors(this.getAuthor());
        confEdit.setOtherreasonattendance(this.getSpecialReason());
        confEdit.setDatemsapresentation(this.getPresentationDate());

        confEdit.setDatefrom(this.getFromDate());
        confEdit.setDateto(this.getToDate());
        //confEdit.setConferenceduration(this.getDiffDays());
        confEdit.setReplacement(this.getCoverOptions());
        confEdit.setReplacementarrangments(this.getCoverDetails());

        confEdit.setFundingsources(this.getFundingOptions());
        confEdit.setOtherfundingsources(this.getOtherFunding());
        confEdit.setFundname(this.getFundName());

        handler.updateConference(confEdit, accountID);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sucessfull", "Changes have been saved!"));
    }

    public Quotes getQuotes() {
        quotes = handler.findQuote(accountID);
        return quotes;
    }

    public Travelerprofile getTravelerP() {
        travelerP = handler.findTravelerProfile(accountID);
        return travelerP;
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

    public int getIsPresenting() {
        return isPresenting;
    }

    public void setIsPresenting(int isPresenting) {
        this.isPresenting = isPresenting;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getSpecialReason() {
        return specialReason;
    }

    public void setSpecialReason(String specialReason) {
        this.specialReason = specialReason;
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

    /*    public int getDiffDays() {
     * return diffDays;
     * }
     * 
     * public void setDiffDays(Integer diffDays) {
     * this.diffDays = diffDays;
     * }*/

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

    public String getOtherFunding() {
        return otherFunding;
    }

    public void setOtherFunding(String otherFunding) {
        this.otherFunding = otherFunding;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }
}
