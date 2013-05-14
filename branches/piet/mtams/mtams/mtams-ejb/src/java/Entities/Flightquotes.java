/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "FLIGHTQUOTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flightquotes.findAll", query = "SELECT f FROM Flightquotes f"),
    @NamedQuery(name = "Flightquotes.findByIdflightquotes", query = "SELECT f FROM Flightquotes f WHERE f.idflightquotes = :idflightquotes"),
    @NamedQuery(name = "Flightquotes.findByFlightnumber", query = "SELECT f FROM Flightquotes f WHERE f.flightnumber = :flightnumber"),
    @NamedQuery(name = "Flightquotes.findByFlightfrom", query = "SELECT f FROM Flightquotes f WHERE f.flightfrom = :flightfrom"),
    @NamedQuery(name = "Flightquotes.findByFlightto", query = "SELECT f FROM Flightquotes f WHERE f.flightto = :flightto"),
    @NamedQuery(name = "Flightquotes.findByDatedeparture", query = "SELECT f FROM Flightquotes f WHERE f.datedeparture = :datedeparture"),
    @NamedQuery(name = "Flightquotes.findByDatearrival", query = "SELECT f FROM Flightquotes f WHERE f.datearrival = :datearrival"),
    @NamedQuery(name = "Flightquotes.findByQuotesourcedescription", query = "SELECT f FROM Flightquotes f WHERE f.quotesourcedescription = :quotesourcedescription"),
    @NamedQuery(name = "Flightquotes.findByQuotesource", query = "SELECT f FROM Flightquotes f WHERE f.quotesource = :quotesource"),
    @NamedQuery(name = "Flightquotes.findByQuotecost", query = "SELECT f FROM Flightquotes f WHERE f.quotecost = :quotecost")})
public class Flightquotes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFLIGHTQUOTES")
    private Integer idflightquotes;
    @Size(max = 45)
    @Column(name = "FLIGHTNUMBER")
    private String flightnumber;
    @Size(max = 45)
    @Column(name = "FLIGHTFROM")
    private String flightfrom;
    @Size(max = 45)
    @Column(name = "FLIGHTTO")
    private String flightto;
    @Column(name = "DATEDEPARTURE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedeparture;
    @Column(name = "DATEARRIVAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datearrival;
    @Size(max = 45)
    @Column(name = "QUOTESOURCEDESCRIPTION")
    private String quotesourcedescription;
    @Size(max = 45)
    @Column(name = "QUOTESOURCE")
    private String quotesource;
    @Size(max = 45)
    @Column(name = "QUOTECOST")
    private String quotecost;
    @OneToMany(mappedBy = "flightquotesIdflightquotes")
    private List<Attachement> attachementList;
    @JoinColumn(name = "QUOTES_IDQUOTES", referencedColumnName = "IDQUOTES")
    @ManyToOne(optional = false)
    private Quotes quotesIdquotes;

    public Flightquotes() {
    }

    public Flightquotes(Integer idflightquotes) {
        this.idflightquotes = idflightquotes;
    }

    public Integer getIdflightquotes() {
        return idflightquotes;
    }

    public void setIdflightquotes(Integer idflightquotes) {
        this.idflightquotes = idflightquotes;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getFlightfrom() {
        return flightfrom;
    }

    public void setFlightfrom(String flightfrom) {
        this.flightfrom = flightfrom;
    }

    public String getFlightto() {
        return flightto;
    }

    public void setFlightto(String flightto) {
        this.flightto = flightto;
    }

    public Date getDatedeparture() {
        return datedeparture;
    }

    public void setDatedeparture(Date datedeparture) {
        this.datedeparture = datedeparture;
    }

    public Date getDatearrival() {
        return datearrival;
    }

    public void setDatearrival(Date datearrival) {
        this.datearrival = datearrival;
    }

    public String getQuotesourcedescription() {
        return quotesourcedescription;
    }

    public void setQuotesourcedescription(String quotesourcedescription) {
        this.quotesourcedescription = quotesourcedescription;
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
    public List<Attachement> getAttachementList() {
        return attachementList;
    }

    public void setAttachementList(List<Attachement> attachementList) {
        this.attachementList = attachementList;
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
        hash += (idflightquotes != null ? idflightquotes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flightquotes)) {
            return false;
        }
        Flightquotes other = (Flightquotes) object;
        if ((this.idflightquotes == null && other.idflightquotes != null) || (this.idflightquotes != null && !this.idflightquotes.equals(other.idflightquotes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Flightquotes[ idflightquotes=" + idflightquotes + " ]";
    }
    
}
