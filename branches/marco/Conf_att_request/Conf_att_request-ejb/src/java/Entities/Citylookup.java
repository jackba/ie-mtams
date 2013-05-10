/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco Remane
 */
@Entity
@Table(name = "CITYLOOKUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citylookup.findAll", query = "SELECT c FROM Citylookup c"),
    @NamedQuery(name = "Citylookup.findByIdcitylookup", query = "SELECT c FROM Citylookup c WHERE c.citylookupPK.idcitylookup = :idcitylookup"),
    @NamedQuery(name = "Citylookup.findByRegion", query = "SELECT c FROM Citylookup c WHERE c.region = :region"),
    @NamedQuery(name = "Citylookup.findByCity", query = "SELECT c FROM Citylookup c WHERE c.city = :city"),
    @NamedQuery(name = "Citylookup.findByCountrylookupIdcountrylookup", query = "SELECT c FROM Citylookup c WHERE c.citylookupPK.countrylookupIdcountrylookup = :countrylookupIdcountrylookup")})
public class Citylookup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CitylookupPK citylookupPK;
    @Size(max = 45)
    @Column(name = "REGION")
    private String region;
    @Size(max = 45)
    @Column(name = "CITY")
    private String city;
    @JoinColumn(name = "COUNTRYLOOKUP_IDCOUNTRYLOOKUP", referencedColumnName = "IDCOUNTRYLOOKUP", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Countrylookup countrylookup;

    public Citylookup() {
    }

    public Citylookup(CitylookupPK citylookupPK) {
        this.citylookupPK = citylookupPK;
    }

    public Citylookup(int idcitylookup, int countrylookupIdcountrylookup) {
        this.citylookupPK = new CitylookupPK(idcitylookup, countrylookupIdcountrylookup);
    }

    public CitylookupPK getCitylookupPK() {
        return citylookupPK;
    }

    public void setCitylookupPK(CitylookupPK citylookupPK) {
        this.citylookupPK = citylookupPK;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Countrylookup getCountrylookup() {
        return countrylookup;
    }

    public void setCountrylookup(Countrylookup countrylookup) {
        this.countrylookup = countrylookup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citylookupPK != null ? citylookupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citylookup)) {
            return false;
        }
        Citylookup other = (Citylookup) object;
        if ((this.citylookupPK == null && other.citylookupPK != null) || (this.citylookupPK != null && !this.citylookupPK.equals(other.citylookupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Citylookup[ citylookupPK=" + citylookupPK + " ]";
    }
    
}
