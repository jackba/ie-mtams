/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aaron
 */
@Entity
@Table(name = "ATTACHEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attachement.findAll", query = "SELECT a FROM Attachement a"),
    @NamedQuery(name = "Attachement.findByIdattachement", query = "SELECT a FROM Attachement a WHERE a.idattachement = :idattachement"),
    @NamedQuery(name = "Attachement.findByDescription", query = "SELECT a FROM Attachement a WHERE a.description = :description"),
    @NamedQuery(name = "Attachement.findByDocumentlocation", query = "SELECT a FROM Attachement a WHERE a.documentlocation = :documentlocation")})
public class Attachement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDATTACHEMENT")
    private Integer idattachement;
    @Size(max = 45)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 45)
    @Column(name = "DOCUMENTLOCATION")
    private String documentlocation;
    @JoinColumn(name = "TRAVELERPROFILE_IDTRAVELERPROFILE", referencedColumnName = "IDTRAVELERPROFILE")
    @ManyToOne
    private Travelerprofile travelerprofileIdtravelerprofile;
    @JoinColumn(name = "TRAVELDOCUMENT_IDTRAVELDOCUMENTS", referencedColumnName = "IDTRAVELDOCUMENTS")
    @ManyToOne
    private Traveldocument traveldocumentIdtraveldocuments;
    @JoinColumn(name = "TRAVEL_IDTRAVEL", referencedColumnName = "IDTRAVEL")
    @ManyToOne
    private Travel travelIdtravel;
    @JoinColumn(name = "ACCOMODATIONQUOTES_IDACCOMODATIONQUOTES", referencedColumnName = "IDACCOMODATIONQUOTES")
    @ManyToOne
    private Accomodationquotes accomodationquotesIdaccomodationquotes;
    @JoinColumn(name = "APPLICATION_IDAPPLICATION", referencedColumnName = "IDAPPLICATION")
    @ManyToOne
    private Application applicationIdapplication;
    @JoinColumn(name = "APPROVAL_IDAPPROVAL", referencedColumnName = "IDAPPROVAL")
    @ManyToOne
    private Approval approvalIdapproval;
    @JoinColumn(name = "CARQUOTES_IDCARQUOTES", referencedColumnName = "IDCARQUOTES")
    @ManyToOne
    private Carquotes carquotesIdcarquotes;
    @JoinColumn(name = "CONFERENCE_IDCONFERENCE", referencedColumnName = "IDCONFERENCE")
    @ManyToOne
    private Conference conferenceIdconference;
    @JoinColumn(name = "FINALCOSTING_IDFINALCOSTING", referencedColumnName = "IDFINALCOSTING")
    @ManyToOne
    private Finalcosting finalcostingIdfinalcosting;
    @JoinColumn(name = "FLIGHTQUOTES_IDFLIGHTQUOTES", referencedColumnName = "IDFLIGHTQUOTES")
    @ManyToOne
    private Flightquotes flightquotesIdflightquotes;
    @JoinColumn(name = "FOREXORDER_IDFOREXORDER", referencedColumnName = "IDFOREXORDER")
    @ManyToOne
    private Forexorder forexorderIdforexorder;
    @JoinColumn(name = "ITINERARY_IDITINERARY", referencedColumnName = "IDITINERARY")
    @ManyToOne
    private Itinerary itineraryIditinerary;
    @JoinColumn(name = "MOTIVATION_IDMOTIVATION", referencedColumnName = "IDMOTIVATION")
    @ManyToOne
    private Motivation motivationIdmotivation;
    @JoinColumn(name = "QUOTES_IDQUOTES", referencedColumnName = "IDQUOTES")
    @ManyToOne
    private Quotes quotesIdquotes;
    @JoinColumn(name = "REWARDSPROGRAM_IDREWARDSPROGRAM", referencedColumnName = "IDREWARDSPROGRAM")
    @ManyToOne
    private Rewardsprogram rewardsprogramIdrewardsprogram;

    public Attachement() {
    }

    public Attachement(Integer idattachement) {
        this.idattachement = idattachement;
    }

    public Integer getIdattachement() {
        return idattachement;
    }

    public void setIdattachement(Integer idattachement) {
        this.idattachement = idattachement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentlocation() {
        return documentlocation;
    }

    public void setDocumentlocation(String documentlocation) {
        this.documentlocation = documentlocation;
    }

    public Travelerprofile getTravelerprofileIdtravelerprofile() {
        return travelerprofileIdtravelerprofile;
    }

    public void setTravelerprofileIdtravelerprofile(Travelerprofile travelerprofileIdtravelerprofile) {
        this.travelerprofileIdtravelerprofile = travelerprofileIdtravelerprofile;
    }

    public Traveldocument getTraveldocumentIdtraveldocuments() {
        return traveldocumentIdtraveldocuments;
    }

    public void setTraveldocumentIdtraveldocuments(Traveldocument traveldocumentIdtraveldocuments) {
        this.traveldocumentIdtraveldocuments = traveldocumentIdtraveldocuments;
    }

    public Travel getTravelIdtravel() {
        return travelIdtravel;
    }

    public void setTravelIdtravel(Travel travelIdtravel) {
        this.travelIdtravel = travelIdtravel;
    }

    public Accomodationquotes getAccomodationquotesIdaccomodationquotes() {
        return accomodationquotesIdaccomodationquotes;
    }

    public void setAccomodationquotesIdaccomodationquotes(Accomodationquotes accomodationquotesIdaccomodationquotes) {
        this.accomodationquotesIdaccomodationquotes = accomodationquotesIdaccomodationquotes;
    }

    public Application getApplicationIdapplication() {
        return applicationIdapplication;
    }

    public void setApplicationIdapplication(Application applicationIdapplication) {
        this.applicationIdapplication = applicationIdapplication;
    }

    public Approval getApprovalIdapproval() {
        return approvalIdapproval;
    }

    public void setApprovalIdapproval(Approval approvalIdapproval) {
        this.approvalIdapproval = approvalIdapproval;
    }

    public Carquotes getCarquotesIdcarquotes() {
        return carquotesIdcarquotes;
    }

    public void setCarquotesIdcarquotes(Carquotes carquotesIdcarquotes) {
        this.carquotesIdcarquotes = carquotesIdcarquotes;
    }

    public Conference getConferenceIdconference() {
        return conferenceIdconference;
    }

    public void setConferenceIdconference(Conference conferenceIdconference) {
        this.conferenceIdconference = conferenceIdconference;
    }

    public Finalcosting getFinalcostingIdfinalcosting() {
        return finalcostingIdfinalcosting;
    }

    public void setFinalcostingIdfinalcosting(Finalcosting finalcostingIdfinalcosting) {
        this.finalcostingIdfinalcosting = finalcostingIdfinalcosting;
    }

    public Flightquotes getFlightquotesIdflightquotes() {
        return flightquotesIdflightquotes;
    }

    public void setFlightquotesIdflightquotes(Flightquotes flightquotesIdflightquotes) {
        this.flightquotesIdflightquotes = flightquotesIdflightquotes;
    }

    public Forexorder getForexorderIdforexorder() {
        return forexorderIdforexorder;
    }

    public void setForexorderIdforexorder(Forexorder forexorderIdforexorder) {
        this.forexorderIdforexorder = forexorderIdforexorder;
    }

    public Itinerary getItineraryIditinerary() {
        return itineraryIditinerary;
    }

    public void setItineraryIditinerary(Itinerary itineraryIditinerary) {
        this.itineraryIditinerary = itineraryIditinerary;
    }

    public Motivation getMotivationIdmotivation() {
        return motivationIdmotivation;
    }

    public void setMotivationIdmotivation(Motivation motivationIdmotivation) {
        this.motivationIdmotivation = motivationIdmotivation;
    }

    public Quotes getQuotesIdquotes() {
        return quotesIdquotes;
    }

    public void setQuotesIdquotes(Quotes quotesIdquotes) {
        this.quotesIdquotes = quotesIdquotes;
    }

    public Rewardsprogram getRewardsprogramIdrewardsprogram() {
        return rewardsprogramIdrewardsprogram;
    }

    public void setRewardsprogramIdrewardsprogram(Rewardsprogram rewardsprogramIdrewardsprogram) {
        this.rewardsprogramIdrewardsprogram = rewardsprogramIdrewardsprogram;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idattachement != null ? idattachement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attachement)) {
            return false;
        }
        Attachement other = (Attachement) object;
        if ((this.idattachement == null && other.idattachement != null) || (this.idattachement != null && !this.idattachement.equals(other.idattachement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Attachement[ idattachement=" + idattachement + " ]";
    }
    
}
