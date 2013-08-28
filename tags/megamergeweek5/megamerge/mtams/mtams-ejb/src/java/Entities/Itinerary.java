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
@Table(name = "ITINERARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itinerary.findAll", query = "SELECT i FROM Itinerary i"),
    @NamedQuery(name = "Itinerary.findByIditinerary", query = "SELECT i FROM Itinerary i WHERE i.iditinerary = :iditinerary"),
    @NamedQuery(name = "Itinerary.findByDate", query = "SELECT i FROM Itinerary i WHERE i.date = :date"),
    @NamedQuery(name = "Itinerary.findByDatefrom", query = "SELECT i FROM Itinerary i WHERE i.datefrom = :datefrom"),
    @NamedQuery(name = "Itinerary.findByDateto", query = "SELECT i FROM Itinerary i WHERE i.dateto = :dateto"),
    @NamedQuery(name = "Itinerary.findByLeavetype", query = "SELECT i FROM Itinerary i WHERE i.leavetype = :leavetype"),
    @NamedQuery(name = "Itinerary.findByLeavedescription", query = "SELECT i FROM Itinerary i WHERE i.leavedescription = :leavedescription"),
    @NamedQuery(name = "Itinerary.findByTravelday", query = "SELECT i FROM Itinerary i WHERE i.travelday = :travelday"),
    @NamedQuery(name = "Itinerary.findByDestinationCity", query = "SELECT i FROM Itinerary i WHERE i.destinationCity = :destinationCity"),
    @NamedQuery(name = "Itinerary.findByDestinationCountry", query = "SELECT i FROM Itinerary i WHERE i.destinationCountry = :destinationCountry")})
public class Itinerary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDITINERARY")
    private Integer iditinerary;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "DATEFROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Column(name = "DATETO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @Size(max = 45)
    @Column(name = "LEAVETYPE")
    private String leavetype;
    @Size(max = 45)
    @Column(name = "LEAVEDESCRIPTION")
    private String leavedescription;
    @Size(max = 45)
    @Column(name = "TRAVELDAY")
    private String travelday;
    @Size(max = 45)
    @Column(name = "DESTINATION_CITY")
    private String destinationCity;
    @Size(max = 45)
    @Column(name = "DESTINATION_COUNTRY")
    private String destinationCountry;
    @JoinColumn(name = "TRAVEL_IDTRAVEL", referencedColumnName = "IDTRAVEL")
    @ManyToOne(optional = false)
    private Travel travelIdtravel;
    @OneToMany(mappedBy = "itineraryIditinerary")
    private Collection<Attachement> attachementCollection;

    public Itinerary() {
    }

    public Itinerary(Integer iditinerary) {
        this.iditinerary = iditinerary;
    }

    public Integer getIditinerary() {
        return iditinerary;
    }

    public void setIditinerary(Integer iditinerary) {
        this.iditinerary = iditinerary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getLeavedescription() {
        return leavedescription;
    }

    public void setLeavedescription(String leavedescription) {
        this.leavedescription = leavedescription;
    }

    public String getTravelday() {
        return travelday;
    }

    public void setTravelday(String travelday) {
        this.travelday = travelday;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public Travel getTravelIdtravel() {
        return travelIdtravel;
    }

    public void setTravelIdtravel(Travel travelIdtravel) {
        this.travelIdtravel = travelIdtravel;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditinerary != null ? iditinerary.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itinerary)) {
            return false;
        }
        Itinerary other = (Itinerary) object;
        if ((this.iditinerary == null && other.iditinerary != null) || (this.iditinerary != null && !this.iditinerary.equals(other.iditinerary))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Itinerary[ iditinerary=" + iditinerary + " ]";
    }
    
}
