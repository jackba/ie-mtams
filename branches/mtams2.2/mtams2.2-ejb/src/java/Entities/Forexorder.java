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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "FOREXORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forexorder.findAll", query = "SELECT f FROM Forexorder f"),
    @NamedQuery(name = "Forexorder.findByIdforexorder", query = "SELECT f FROM Forexorder f WHERE f.idforexorder = :idforexorder"),
    @NamedQuery(name = "Forexorder.findByDateofdelivery", query = "SELECT f FROM Forexorder f WHERE f.dateofdelivery = :dateofdelivery"),
    @NamedQuery(name = "Forexorder.findByCurrency", query = "SELECT f FROM Forexorder f WHERE f.currency = :currency"),
    @NamedQuery(name = "Forexorder.findByTravelerscheques", query = "SELECT f FROM Forexorder f WHERE f.travelerscheques = :travelerscheques"),
    @NamedQuery(name = "Forexorder.findByCash", query = "SELECT f FROM Forexorder f WHERE f.cash = :cash"),
    @NamedQuery(name = "Forexorder.findByCashpassport", query = "SELECT f FROM Forexorder f WHERE f.cashpassport = :cashpassport"),
    @NamedQuery(name = "Forexorder.findByCctype", query = "SELECT f FROM Forexorder f WHERE f.cctype = :cctype"),
    @NamedQuery(name = "Forexorder.findByCcnumber", query = "SELECT f FROM Forexorder f WHERE f.ccnumber = :ccnumber"),
    @NamedQuery(name = "Forexorder.findByCcexpirydate", query = "SELECT f FROM Forexorder f WHERE f.ccexpirydate = :ccexpirydate"),
    @NamedQuery(name = "Forexorder.findByCcpaymentamount", query = "SELECT f FROM Forexorder f WHERE f.ccpaymentamount = :ccpaymentamount"),
    @NamedQuery(name = "Forexorder.findByFlightnumber", query = "SELECT f FROM Forexorder f WHERE f.flightnumber = :flightnumber"),
    @NamedQuery(name = "Forexorder.findByCompanyname", query = "SELECT f FROM Forexorder f WHERE f.companyname = :companyname"),
    @NamedQuery(name = "Forexorder.findByCompanyregistration", query = "SELECT f FROM Forexorder f WHERE f.companyregistration = :companyregistration")})
public class Forexorder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFOREXORDER")
    private Integer idforexorder;
    @Column(name = "DATEOFDELIVERY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofdelivery;
    @Size(max = 45)
    @Column(name = "CURRENCY")
    private String currency;
    @Size(max = 45)
    @Column(name = "TRAVELERSCHEQUES")
    private String travelerscheques;
    @Size(max = 45)
    @Column(name = "CASH")
    private String cash;
    @Size(max = 45)
    @Column(name = "CASHPASSPORT")
    private String cashpassport;
    @Size(max = 45)
    @Column(name = "CCTYPE")
    private String cctype;
    @Size(max = 45)
    @Column(name = "CCNUMBER")
    private String ccnumber;
    @Column(name = "CCEXPIRYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccexpirydate;
    @Size(max = 45)
    @Column(name = "CCPAYMENTAMOUNT")
    private String ccpaymentamount;
    @Size(max = 45)
    @Column(name = "FLIGHTNUMBER")
    private String flightnumber;
    @Size(max = 45)
    @Column(name = "COMPANYNAME")
    private String companyname;
    @Size(max = 45)
    @Column(name = "COMPANYREGISTRATION")
    private String companyregistration;
    @OneToMany(mappedBy = "forexorderIdforexorder")
    private Collection<Attachement> attachementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forexorderIdforexorder")
    private Collection<Application> applicationCollection;

    public Forexorder() {
    }

    public Forexorder(Integer idforexorder) {
        this.idforexorder = idforexorder;
    }

    public Integer getIdforexorder() {
        return idforexorder;
    }

    public void setIdforexorder(Integer idforexorder) {
        this.idforexorder = idforexorder;
    }

    public Date getDateofdelivery() {
        return dateofdelivery;
    }

    public void setDateofdelivery(Date dateofdelivery) {
        this.dateofdelivery = dateofdelivery;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTravelerscheques() {
        return travelerscheques;
    }

    public void setTravelerscheques(String travelerscheques) {
        this.travelerscheques = travelerscheques;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getCashpassport() {
        return cashpassport;
    }

    public void setCashpassport(String cashpassport) {
        this.cashpassport = cashpassport;
    }

    public String getCctype() {
        return cctype;
    }

    public void setCctype(String cctype) {
        this.cctype = cctype;
    }

    public String getCcnumber() {
        return ccnumber;
    }

    public void setCcnumber(String ccnumber) {
        this.ccnumber = ccnumber;
    }

    public Date getCcexpirydate() {
        return ccexpirydate;
    }

    public void setCcexpirydate(Date ccexpirydate) {
        this.ccexpirydate = ccexpirydate;
    }

    public String getCcpaymentamount() {
        return ccpaymentamount;
    }

    public void setCcpaymentamount(String ccpaymentamount) {
        this.ccpaymentamount = ccpaymentamount;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyregistration() {
        return companyregistration;
    }

    public void setCompanyregistration(String companyregistration) {
        this.companyregistration = companyregistration;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @XmlTransient
    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idforexorder != null ? idforexorder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forexorder)) {
            return false;
        }
        Forexorder other = (Forexorder) object;
        if ((this.idforexorder == null && other.idforexorder != null) || (this.idforexorder != null && !this.idforexorder.equals(other.idforexorder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Forexorder[ idforexorder=" + idforexorder + " ]";
    }
    
}
