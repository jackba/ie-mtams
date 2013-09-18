/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aaron
 */
@Entity
@Table(name = "APPLICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a"),
    @NamedQuery(name = "Application.findByIdapplication", query = "SELECT a FROM Application a WHERE a.idapplication = :idapplication"),
    @NamedQuery(name = "Application.findByDescription", query = "SELECT a FROM Application a WHERE a.description = :description"),
    @NamedQuery(name = "Application.findByDatemodified", query = "SELECT a FROM Application a WHERE a.datemodified = :datemodified")})
public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAPPLICATION")
    private Integer idapplication;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DATEMODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemodified;
    @JoinColumn(name = "TRAVELERPROFILE_IDTRAVELERPROFILE", referencedColumnName = "IDTRAVELERPROFILE")
    @ManyToOne(optional = false)
    private Travelerprofile travelerprofileIdtravelerprofile;
    @JoinColumn(name = "TRAVEL_IDTRAVEL", referencedColumnName = "IDTRAVEL")
    @ManyToOne(optional = false)
    private Travel travelIdtravel;
    @JoinColumn(name = "QUOTES_IDQUOTES", referencedColumnName = "IDQUOTES")
    @ManyToOne(optional = false)
    private Quotes quotesIdquotes;
    @JoinColumn(name = "MOTIVATION_IDMOTIVATION", referencedColumnName = "IDMOTIVATION")
    @ManyToOne(optional = false)
    private Motivation motivationIdmotivation;
    @JoinColumn(name = "FOREXORDER_IDFOREXORDER", referencedColumnName = "IDFOREXORDER")
    @ManyToOne(optional = false)
    private Forexorder forexorderIdforexorder;
    @JoinColumn(name = "FINALCOSTING_IDFINALCOSTING", referencedColumnName = "IDFINALCOSTING")
    @ManyToOne(optional = false)
    private Finalcosting finalcostingIdfinalcosting;
    @JoinColumn(name = "ACCOUNT_IDACCOUNT", referencedColumnName = "IDACCOUNT")
    @ManyToOne(optional = false)
    private Account accountIdaccount;
    @OneToMany(mappedBy = "applicationIdapplication")
    private Collection<Attachement> attachementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationIdapplication")
    private Collection<Approval> approvalCollection;

    public Application() {
    }

    public Application(Integer idapplication) {
        this.idapplication = idapplication;
    }

    public Integer getIdapplication() {
        return idapplication;
    }

    public void setIdapplication(Integer idapplication) {
        this.idapplication = idapplication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(Date datemodified) {
        this.datemodified = datemodified;
    }

    public Travelerprofile getTravelerprofileIdtravelerprofile() {
        return travelerprofileIdtravelerprofile;
    }

    public void setTravelerprofileIdtravelerprofile(Travelerprofile travelerprofileIdtravelerprofile) {
        this.travelerprofileIdtravelerprofile = travelerprofileIdtravelerprofile;
    }

    public Travel getTravelIdtravel() {
        return travelIdtravel;
    }

    public void setTravelIdtravel(Travel travelIdtravel) {
        this.travelIdtravel = travelIdtravel;
    }

    public Quotes getQuotesIdquotes() {
        return quotesIdquotes;
    }

    public void setQuotesIdquotes(Quotes quotesIdquotes) {
        this.quotesIdquotes = quotesIdquotes;
    }

    public Motivation getMotivationIdmotivation() {
        return motivationIdmotivation;
    }

    public void setMotivationIdmotivation(Motivation motivationIdmotivation) {
        this.motivationIdmotivation = motivationIdmotivation;
    }

    public Forexorder getForexorderIdforexorder() {
        return forexorderIdforexorder;
    }

    public void setForexorderIdforexorder(Forexorder forexorderIdforexorder) {
        this.forexorderIdforexorder = forexorderIdforexorder;
    }

    public Finalcosting getFinalcostingIdfinalcosting() {
        return finalcostingIdfinalcosting;
    }

    public void setFinalcostingIdfinalcosting(Finalcosting finalcostingIdfinalcosting) {
        this.finalcostingIdfinalcosting = finalcostingIdfinalcosting;
    }

    public Account getAccountIdaccount() {
        return accountIdaccount;
    }

    public void setAccountIdaccount(Account accountIdaccount) {
        this.accountIdaccount = accountIdaccount;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @XmlTransient
    public Collection<Approval> getApprovalCollection() {
        return approvalCollection;
    }

    public void setApprovalCollection(Collection<Approval> approvalCollection) {
        this.approvalCollection = approvalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idapplication != null ? idapplication.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.idapplication == null && other.idapplication != null) || (this.idapplication != null && !this.idapplication.equals(other.idapplication))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Application[ idapplication=" + idapplication + " ]";
    }
    
}
