/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "TRAVELPROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Travelprofile.findAll", query = "SELECT t FROM Travelprofile t"),
    @NamedQuery(name = "Travelprofile.findByIdtravelprofile", query = "SELECT t FROM Travelprofile t WHERE t.travelprofilePK.idtravelprofile = :idtravelprofile"),
    @NamedQuery(name = "Travelprofile.findByAccountsIdaccounts", query = "SELECT t FROM Travelprofile t WHERE t.travelprofilePK.accountsIdaccounts = :accountsIdaccounts"),
    @NamedQuery(name = "Travelprofile.findByGivenname", query = "SELECT t FROM Travelprofile t WHERE t.givenname = :givenname"),
    @NamedQuery(name = "Travelprofile.findByFamilyname", query = "SELECT t FROM Travelprofile t WHERE t.familyname = :familyname")})
public class Travelprofile implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TravelprofilePK travelprofilePK;
    @Size(max = 20)
    @Column(name = "GIVENNAME")
    private String givenname;
    @Size(max = 20)
    @Column(name = "FAMILYNAME")
    private String familyname;

    public Travelprofile() {
    }

    public Travelprofile(TravelprofilePK travelprofilePK) {
        this.travelprofilePK = travelprofilePK;
    }

    public Travelprofile(int idtravelprofile, int accountsIdaccounts) {
        this.travelprofilePK = new TravelprofilePK(idtravelprofile, accountsIdaccounts);
    }

    public TravelprofilePK getTravelprofilePK() {
        return travelprofilePK;
    }

    public void setTravelprofilePK(TravelprofilePK travelprofilePK) {
        this.travelprofilePK = travelprofilePK;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (travelprofilePK != null ? travelprofilePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Travelprofile)) {
            return false;
        }
        Travelprofile other = (Travelprofile) object;
        if ((this.travelprofilePK == null && other.travelprofilePK != null) || (this.travelprofilePK != null && !this.travelprofilePK.equals(other.travelprofilePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Travelprofile[ travelprofilePK=" + travelprofilePK + " ]";
    }
    
}
