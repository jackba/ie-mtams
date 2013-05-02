/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Michelle Thornton
 */
@Entity
@Table(name = "ACCOMODATIONQUOTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accomodationquotes.findAll", query = "SELECT a FROM Accomodationquotes a"),
    @NamedQuery(name = "Accomodationquotes.findByIdaccomodationquotes", query = "SELECT a FROM Accomodationquotes a WHERE a.idaccomodationquotes = :idaccomodationquotes"),
    @NamedQuery(name = "Accomodationquotes.findByDatecheckin", query = "SELECT a FROM Accomodationquotes a WHERE a.datecheckin = :datecheckin"),
    @NamedQuery(name = "Accomodationquotes.findByDatecheckout", query = "SELECT a FROM Accomodationquotes a WHERE a.datecheckout = :datecheckout"),
    @NamedQuery(name = "Accomodationquotes.findByCountry", query = "SELECT a FROM Accomodationquotes a WHERE a.country = :country"),
    @NamedQuery(name = "Accomodationquotes.findByCity", query = "SELECT a FROM Accomodationquotes a WHERE a.city = :city"),
    @NamedQuery(name = "Accomodationquotes.findByDiscritption", query = "SELECT a FROM Accomodationquotes a WHERE a.discritption = :discritption"),
    @NamedQuery(name = "Accomodationquotes.findByAccomodationprovider", query = "SELECT a FROM Accomodationquotes a WHERE a.accomodationprovider = :accomodationprovider"),
    @NamedQuery(name = "Accomodationquotes.findByQuotesource", query = "SELECT a FROM Accomodationquotes a WHERE a.quotesource = :quotesource"),
    @NamedQuery(name = "Accomodationquotes.findByQuotecost", query = "SELECT a FROM Accomodationquotes a WHERE a.quotecost = :quotecost")})
public class Accomodationquotes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACCOMODATIONQUOTES")
    private Integer idaccomodationquotes;
    @Column(name = "DATECHECKIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecheckin;
    @Column(name = "DATECHECKOUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecheckout;
    @Size(max = 45)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 45)
    @Column(name = "CITY")
    private String city;
    @Size(max = 45)
    @Column(name = "DISCRITPTION")
    private String discritption;
    @Size(max = 45)
    @Column(name = "ACCOMODATIONPROVIDER")
    private String accomodationprovider;
    @Size(max = 45)
    @Column(name = "QUOTESOURCE")
    private String quotesource;
    @Size(max = 45)
    @Column(name = "QUOTECOST")
    private String quotecost;
    @OneToMany(mappedBy = "accomodationquotesIdaccomodationquotes")
    private Collection<Attachement> attachementCollection;
    @JoinColumn(name = "QUOTES_IDQUOTES", referencedColumnName = "IDQUOTES")
    @ManyToOne(optional = false)
    private Quotes quotesIdquotes;

    public Accomodationquotes() {
    }

    public Accomodationquotes(Integer idaccomodationquotes) {
        this.idaccomodationquotes = idaccomodationquotes;
    }

    public Integer getIdaccomodationquotes() {
        return idaccomodationquotes;
    }

    public void setIdaccomodationquotes(Integer idaccomodationquotes) {
        this.idaccomodationquotes = idaccomodationquotes;
    }

    public Date getDatecheckin() {
        return datecheckin;
    }

    public void setDatecheckin(Date datecheckin) {
        this.datecheckin = datecheckin;
    }

    public Date getDatecheckout() {
        return datecheckout;
    }

    public void setDatecheckout(Date datecheckout) {
        this.datecheckout = datecheckout;
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

    public String getDiscritption() {
        return discritption;
    }

    public void setDiscritption(String discritption) {
        this.discritption = discritption;
    }

    public String getAccomodationprovider() {
        return accomodationprovider;
    }

    public void setAccomodationprovider(String accomodationprovider) {
        this.accomodationprovider = accomodationprovider;
    }

    public String getQuotesource() {
        return quotesource;
    }

    public void setQuotesource(String quotesource) {
        this.quotesource = quotesource;
    }

    public String getQuotecost() {
        return quotecost;
    }

    public void setQuotecost(String quotecost) {
        this.quotecost = quotecost;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    public Quotes getQuotesIdquotes() {
        return quotesIdquotes;
    }

    public void setQuotesIdquotes(Quotes quotesIdquotes) {
        this.quotesIdquotes = quotesIdquotes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccomodationquotes != null ? idaccomodationquotes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accomodationquotes)) {
            return false;
        }
        Accomodationquotes other = (Accomodationquotes) object;
        if ((this.idaccomodationquotes == null && other.idaccomodationquotes != null) || (this.idaccomodationquotes != null && !this.idaccomodationquotes.equals(other.idaccomodationquotes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Accomodationquotes[ idaccomodationquotes=" + idaccomodationquotes + " ]";
    }
    
}
