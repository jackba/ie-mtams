/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michelle Thornton
 */
@Entity
@Table(name = "REWARDSPROGRAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rewardsprogram.findAll", query = "SELECT r FROM Rewardsprogram r"),
    @NamedQuery(name = "Rewardsprogram.findByIdrewardsprogram", query = "SELECT r FROM Rewardsprogram r WHERE r.idrewardsprogram = :idrewardsprogram"),
    @NamedQuery(name = "Rewardsprogram.findByDescription", query = "SELECT r FROM Rewardsprogram r WHERE r.description = :description"),
    @NamedQuery(name = "Rewardsprogram.findByMembershiptype", query = "SELECT r FROM Rewardsprogram r WHERE r.membershiptype = :membershiptype"),
    @NamedQuery(name = "Rewardsprogram.findByProvider", query = "SELECT r FROM Rewardsprogram r WHERE r.provider = :provider"),
    @NamedQuery(name = "Rewardsprogram.findByMembershipnumber", query = "SELECT r FROM Rewardsprogram r WHERE r.membershipnumber = :membershipnumber")})
public class Rewardsprogram implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDREWARDSPROGRAM")
    private Integer idrewardsprogram;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 45)
    @Column(name = "MEMBERSHIPTYPE")
    private String membershiptype;
    @Size(max = 45)
    @Column(name = "PROVIDER")
    private String provider;
    @Size(max = 45)
    @Column(name = "MEMBERSHIPNUMBER")
    private String membershipnumber;
    @JoinColumn(name = "TRAVELERPROFILE_IDTRAVELERPROFILE", referencedColumnName = "IDTRAVELERPROFILE")
    @ManyToOne(optional = false)
    private Travelerprofile travelerprofileIdtravelerprofile;
    @OneToMany(mappedBy = "rewardsprogramIdrewardsprogram")
    private Collection<Attachement> attachementCollection;

    public Rewardsprogram() {
    }

    public Rewardsprogram(Integer idrewardsprogram) {
        this.idrewardsprogram = idrewardsprogram;
    }

    public Integer getIdrewardsprogram() {
        return idrewardsprogram;
    }

    public void setIdrewardsprogram(Integer idrewardsprogram) {
        this.idrewardsprogram = idrewardsprogram;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMembershiptype() {
        return membershiptype;
    }

    public void setMembershiptype(String membershiptype) {
        this.membershiptype = membershiptype;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getMembershipnumber() {
        return membershipnumber;
    }

    public void setMembershipnumber(String membershipnumber) {
        this.membershipnumber = membershipnumber;
    }

    public Travelerprofile getTravelerprofileIdtravelerprofile() {
        return travelerprofileIdtravelerprofile;
    }

    public void setTravelerprofileIdtravelerprofile(Travelerprofile travelerprofileIdtravelerprofile) {
        this.travelerprofileIdtravelerprofile = travelerprofileIdtravelerprofile;
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
        hash += (idrewardsprogram != null ? idrewardsprogram.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rewardsprogram)) {
            return false;
        }
        Rewardsprogram other = (Rewardsprogram) object;
        if ((this.idrewardsprogram == null && other.idrewardsprogram != null) || (this.idrewardsprogram != null && !this.idrewardsprogram.equals(other.idrewardsprogram))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Rewardsprogram[ idrewardsprogram=" + idrewardsprogram + " ]";
    }
    
}
