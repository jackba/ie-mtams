/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aaron
 */
@Entity
@Table(name = "COUNTRIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c"),
    @NamedQuery(name = "Countries.findByCode2", query = "SELECT c FROM Countries c WHERE c.code2 = :code2"),
    @NamedQuery(name = "Countries.findByCode3", query = "SELECT c FROM Countries c WHERE c.code3 = :code3"),
    @NamedQuery(name = "Countries.findByUrl", query = "SELECT c FROM Countries c WHERE c.url = :url"),
    @NamedQuery(name = "Countries.findByName", query = "SELECT c FROM Countries c WHERE c.name = :name"),
    @NamedQuery(name = "Countries.findByLatitude", query = "SELECT c FROM Countries c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Countries.findByLongitude", query = "SELECT c FROM Countries c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "Countries.findByRegions", query = "SELECT c FROM Countries c WHERE c.regions = :regions")})
public class Countries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODE2")
    private String code2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODE3")
    private String code3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LATITUDE")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUDE")
    private double longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REGIONS")
    private int regions;

    public Countries() {
    }

    public Countries(String code2) {
        this.code2 = code2;
    }

    public Countries(String code2, String code3, String url, String name, double latitude, double longitude, int regions) {
        this.code2 = code2;
        this.code3 = code3;
        this.url = url;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.regions = regions;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getRegions() {
        return regions;
    }

    public void setRegions(int regions) {
        this.regions = regions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code2 != null ? code2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.code2 == null && other.code2 != null) || (this.code2 != null && !this.code2.equals(other.code2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Countries[ code2=" + code2 + " ]";
    }
    
}
