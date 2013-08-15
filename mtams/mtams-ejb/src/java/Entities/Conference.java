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
@Table(name = "CONFERENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conference.findAll", query = "SELECT c FROM Conference c"),
    @NamedQuery(name = "Conference.findByIdconference", query = "SELECT c FROM Conference c WHERE c.idconference = :idconference"),
    @NamedQuery(name = "Conference.findByConferencename", query = "SELECT c FROM Conference c WHERE c.conferencename = :conferencename"),
    @NamedQuery(name = "Conference.findByWebpage", query = "SELECT c FROM Conference c WHERE c.webpage = :webpage"),
    @NamedQuery(name = "Conference.findByCountry", query = "SELECT c FROM Conference c WHERE c.country = :country"),
    @NamedQuery(name = "Conference.findByCity", query = "SELECT c FROM Conference c WHERE c.city = :city"),
    @NamedQuery(name = "Conference.findByPresenting", query = "SELECT c FROM Conference c WHERE c.presenting = :presenting"),
    @NamedQuery(name = "Conference.findByPresentationtitle", query = "SELECT c FROM Conference c WHERE c.presentationtitle = :presentationtitle"),
    @NamedQuery(name = "Conference.findByAuthors", query = "SELECT c FROM Conference c WHERE c.authors = :authors"),
    @NamedQuery(name = "Conference.findByOtherreasonattendance", query = "SELECT c FROM Conference c WHERE c.otherreasonattendance = :otherreasonattendance"),
    @NamedQuery(name = "Conference.findByDatemsapresentation", query = "SELECT c FROM Conference c WHERE c.datemsapresentation = :datemsapresentation"),
    @NamedQuery(name = "Conference.findByConferenceduration", query = "SELECT c FROM Conference c WHERE c.conferenceduration = :conferenceduration"),
    @NamedQuery(name = "Conference.findByDatefrom", query = "SELECT c FROM Conference c WHERE c.datefrom = :datefrom"),
    @NamedQuery(name = "Conference.findByDateto", query = "SELECT c FROM Conference c WHERE c.dateto = :dateto"),
    @NamedQuery(name = "Conference.findByReplacement", query = "SELECT c FROM Conference c WHERE c.replacement = :replacement"),
    @NamedQuery(name = "Conference.findByReplacementarrangments", query = "SELECT c FROM Conference c WHERE c.replacementarrangments = :replacementarrangments"),
    @NamedQuery(name = "Conference.findByFundingsources", query = "SELECT c FROM Conference c WHERE c.fundingsources = :fundingsources"),
    @NamedQuery(name = "Conference.findByOtherfundingsources", query = "SELECT c FROM Conference c WHERE c.otherfundingsources = :otherfundingsources"),
    @NamedQuery(name = "Conference.findByFundname", query = "SELECT c FROM Conference c WHERE c.fundname = :fundname")})
public class Conference implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCONFERENCE")
    private Integer idconference;
    @Size(max = 45)
    @Column(name = "CONFERENCENAME")
    private String conferencename;
    @Size(max = 45)
    @Column(name = "WEBPAGE")
    private String webpage;
    @Size(max = 45)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 45)
    @Column(name = "CITY")
    private String city;
    @Column(name = "PRESENTING")
    private Integer presenting;
    @Size(max = 45)
    @Column(name = "PRESENTATIONTITLE")
    private String presentationtitle;
    @Size(max = 45)
    @Column(name = "AUTHORS")
    private String authors;
    @Size(max = 45)
    @Column(name = "OTHERREASONATTENDANCE")
    private String otherreasonattendance;
    @Column(name = "DATEMSAPRESENTATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemsapresentation;
    @Column(name = "CONFERENCEDURATION")
    private Integer conferenceduration;
    @Column(name = "DATEFROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Column(name = "DATETO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @Size(max = 45)
    @Column(name = "REPLACEMENT")
    private String replacement;
    @Size(max = 45)
    @Column(name = "REPLACEMENTARRANGMENTS")
    private String replacementarrangments;
    @Size(max = 45)
    @Column(name = "FUNDINGSOURCES")
    private String fundingsources;
    @Size(max = 45)
    @Column(name = "OTHERFUNDINGSOURCES")
    private String otherfundingsources;
    @Size(max = 45)
    @Column(name = "FUNDNAME")
    private String fundname;
    @OneToMany(mappedBy = "conferenceIdconference")
    private Collection<Attachement> attachementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conferenceIdconference")
    private Collection<Travel> travelCollection;

    public Conference() {
    }

    public Conference(Integer idconference) {
        this.idconference = idconference;
    }

    public Integer getIdconference() {
        return idconference;
    }

    public void setIdconference(Integer idconference) {
        this.idconference = idconference;
    }

    public String getConferencename() {
        return conferencename;
    }

    public void setConferencename(String conferencename) {
        this.conferencename = conferencename;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
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

    public Integer getPresenting() {
        return presenting;
    }

    public void setPresenting(Integer presenting) {
        this.presenting = presenting;
    }

    public String getPresentationtitle() {
        return presentationtitle;
    }

    public void setPresentationtitle(String presentationtitle) {
        this.presentationtitle = presentationtitle;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getOtherreasonattendance() {
        return otherreasonattendance;
    }

    public void setOtherreasonattendance(String otherreasonattendance) {
        this.otherreasonattendance = otherreasonattendance;
    }

    public Date getDatemsapresentation() {
        return datemsapresentation;
    }

    public void setDatemsapresentation(Date datemsapresentation) {
        this.datemsapresentation = datemsapresentation;
    }

    public Integer getConferenceduration() {
        return conferenceduration;
    }

    public void setConferenceduration(Integer conferenceduration) {
        this.conferenceduration = conferenceduration;
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

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    public String getReplacementarrangments() {
        return replacementarrangments;
    }

    public void setReplacementarrangments(String replacementarrangments) {
        this.replacementarrangments = replacementarrangments;
    }

    public String getFundingsources() {
        return fundingsources;
    }

    public void setFundingsources(String fundingsources) {
        this.fundingsources = fundingsources;
    }

    public String getOtherfundingsources() {
        return otherfundingsources;
    }

    public void setOtherfundingsources(String otherfundingsources) {
        this.otherfundingsources = otherfundingsources;
    }

    public String getFundname() {
        return fundname;
    }

    public void setFundname(String fundname) {
        this.fundname = fundname;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @XmlTransient
    public Collection<Travel> getTravelCollection() {
        return travelCollection;
    }

    public void setTravelCollection(Collection<Travel> travelCollection) {
        this.travelCollection = travelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconference != null ? idconference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conference)) {
            return false;
        }
        Conference other = (Conference) object;
        if ((this.idconference == null && other.idconference != null) || (this.idconference != null && !this.idconference.equals(other.idconference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Conference[ idconference=" + idconference + " ]";
    }
    
}
