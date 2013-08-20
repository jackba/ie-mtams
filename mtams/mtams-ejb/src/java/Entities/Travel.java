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
@Table(name = "TRAVEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Travel.findAll", query = "SELECT t FROM Travel t"),
    @NamedQuery(name = "Travel.findByIdtravel", query = "SELECT t FROM Travel t WHERE t.idtravel = :idtravel"),
    @NamedQuery(name = "Travel.findByDatedeparture", query = "SELECT t FROM Travel t WHERE t.datedeparture = :datedeparture"),
    @NamedQuery(name = "Travel.findByDatereturn", query = "SELECT t FROM Travel t WHERE t.datereturn = :datereturn"),
    @NamedQuery(name = "Travel.findByDescription", query = "SELECT t FROM Travel t WHERE t.description = :description")})
public class Travel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTRAVEL")
    private Integer idtravel;
    @Column(name = "DATEDEPARTURE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedeparture;
    @Column(name = "DATERETURN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datereturn;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travelIdtravel")
    private Collection<Itinerary> itineraryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travelIdtravel")
    private Collection<Application> applicationCollection;
    @OneToMany(mappedBy = "travelIdtravel")
    private Collection<Attachement> attachementCollection;
    @JoinColumn(name = "CONFERENCE_IDCONFERENCE", referencedColumnName = "IDCONFERENCE")
    @ManyToOne(optional = false)
    private Conference conferenceIdconference;

    public Travel() {
    }

    public Travel(Integer idtravel) {
        this.idtravel = idtravel;
    }

    public Integer getIdtravel() {
        return idtravel;
    }

    public void setIdtravel(Integer idtravel) {
        this.idtravel = idtravel;
    }

    public Date getDatedeparture() {
        return datedeparture;
    }

    public void setDatedeparture(Date datedeparture) {
        this.datedeparture = datedeparture;
    }

    public Date getDatereturn() {
        return datereturn;
    }

    public void setDatereturn(Date datereturn) {
        this.datereturn = datereturn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Itinerary> getItineraryCollection() {
        return itineraryCollection;
    }

    public void setItineraryCollection(Collection<Itinerary> itineraryCollection) {
        this.itineraryCollection = itineraryCollection;
    }

    @XmlTransient
    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    public Conference getConferenceIdconference() {
        return conferenceIdconference;
    }

    public void setConferenceIdconference(Conference conferenceIdconference) {
        this.conferenceIdconference = conferenceIdconference;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtravel != null ? idtravel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Travel)) {
            return false;
        }
        Travel other = (Travel) object;
        if ((this.idtravel == null && other.idtravel != null) || (this.idtravel != null && !this.idtravel.equals(other.idtravel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Travel[ idtravel=" + idtravel + " ]";
    }
    
}
