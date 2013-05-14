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
@Table(name = "TRAVELDOCUMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traveldocument.findAll", query = "SELECT t FROM Traveldocument t"),
    @NamedQuery(name = "Traveldocument.findByIdtraveldocuments", query = "SELECT t FROM Traveldocument t WHERE t.idtraveldocuments = :idtraveldocuments"),
    @NamedQuery(name = "Traveldocument.findByPassportnumber", query = "SELECT t FROM Traveldocument t WHERE t.passportnumber = :passportnumber"),
    @NamedQuery(name = "Traveldocument.findByCountry", query = "SELECT t FROM Traveldocument t WHERE t.country = :country"),
    @NamedQuery(name = "Traveldocument.findByDateofissue", query = "SELECT t FROM Traveldocument t WHERE t.dateofissue = :dateofissue"),
    @NamedQuery(name = "Traveldocument.findByExpirydate", query = "SELECT t FROM Traveldocument t WHERE t.expirydate = :expirydate"),
    @NamedQuery(name = "Traveldocument.findByValidvisa", query = "SELECT t FROM Traveldocument t WHERE t.validvisa = :validvisa")})
public class Traveldocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTRAVELDOCUMENTS")
    private Integer idtraveldocuments;
    @Size(max = 12)
    @Column(name = "PASSPORTNUMBER")
    private String passportnumber;
    @Size(max = 45)
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "DATEOFISSUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofissue;
    @Column(name = "EXPIRYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirydate;
    @Size(max = 45)
    @Column(name = "VALIDVISA")
    private String validvisa;
    @OneToMany(mappedBy = "traveldocumentIdtraveldocuments")
    private List<Attachement> attachementList;
    @JoinColumn(name = "TRAVLERPROFILE_IDTRAVLERPROFILE", referencedColumnName = "IDTRAVELERPROFILE")
    @ManyToOne(optional = false)
    private Travelerprofile travlerprofileIdtravlerprofile;

    public Traveldocument() {
    }

    public Traveldocument(Integer idtraveldocuments) {
        this.idtraveldocuments = idtraveldocuments;
    }

    public Integer getIdtraveldocuments() {
        return idtraveldocuments;
    }

    public void setIdtraveldocuments(Integer idtraveldocuments) {
        this.idtraveldocuments = idtraveldocuments;
    }

    public String getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateofissue() {
        return dateofissue;
    }

    public void setDateofissue(Date dateofissue) {
        this.dateofissue = dateofissue;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public String getValidvisa() {
        return validvisa;
    }

    public void setValidvisa(String validvisa) {
        this.validvisa = validvisa;
    }

    @XmlTransient
    public List<Attachement> getAttachementList() {
        return attachementList;
    }

    public void setAttachementList(List<Attachement> attachementList) {
        this.attachementList = attachementList;
    }

    public Travelerprofile getTravlerprofileIdtravlerprofile() {
        return travlerprofileIdtravlerprofile;
    }

    public void setTravlerprofileIdtravlerprofile(Travelerprofile travlerprofileIdtravlerprofile) {
        this.travlerprofileIdtravlerprofile = travlerprofileIdtravlerprofile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtraveldocuments != null ? idtraveldocuments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traveldocument)) {
            return false;
        }
        Traveldocument other = (Traveldocument) object;
        if ((this.idtraveldocuments == null && other.idtraveldocuments != null) || (this.idtraveldocuments != null && !this.idtraveldocuments.equals(other.idtraveldocuments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Traveldocument[ idtraveldocuments=" + idtraveldocuments + " ]";
    }
    
}
