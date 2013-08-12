/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "COUNTRYLOOKUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countrylookup.findAll", query = "SELECT c FROM Countrylookup c"),
    @NamedQuery(name = "Countrylookup.findByIdcountrylookup", query = "SELECT c FROM Countrylookup c WHERE c.idcountrylookup = :idcountrylookup"),
    @NamedQuery(name = "Countrylookup.findByContinent", query = "SELECT c FROM Countrylookup c WHERE c.continent = :continent"),
    @NamedQuery(name = "Countrylookup.findByCountry", query = "SELECT c FROM Countrylookup c WHERE c.country = :country")})
public class Countrylookup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOUNTRYLOOKUP")
    private Integer idcountrylookup;
    @Size(max = 45)
    @Column(name = "CONTINENT")
    private String continent;
    @Size(max = 45)
    @Column(name = "COUNTRY")
    private String country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countrylookup")
    private List<Citylookup> citylookupList;

    public Countrylookup() {
    }

    public Countrylookup(Integer idcountrylookup) {
        this.idcountrylookup = idcountrylookup;
    }

    public Integer getIdcountrylookup() {
        return idcountrylookup;
    }

    public void setIdcountrylookup(Integer idcountrylookup) {
        this.idcountrylookup = idcountrylookup;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlTransient
    public List<Citylookup> getCitylookupList() {
        return citylookupList;
    }

    public void setCitylookupList(List<Citylookup> citylookupList) {
        this.citylookupList = citylookupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcountrylookup != null ? idcountrylookup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countrylookup)) {
            return false;
        }
        Countrylookup other = (Countrylookup) object;
        if ((this.idcountrylookup == null && other.idcountrylookup != null) || (this.idcountrylookup != null && !this.idcountrylookup.equals(other.idcountrylookup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Countrylookup[ idcountrylookup=" + idcountrylookup + " ]";
    }
    
}
