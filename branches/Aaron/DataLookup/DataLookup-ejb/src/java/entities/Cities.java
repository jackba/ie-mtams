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
@Table(name = "CITIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c"),
    @NamedQuery(name = "Cities.findById", query = "SELECT c FROM Cities c WHERE c.id = :id"),
    @NamedQuery(name = "Cities.findByCountry", query = "SELECT c FROM Cities c WHERE c.country = :country"),
    @NamedQuery(name = "Cities.findByRegion", query = "SELECT c FROM Cities c WHERE c.region = :region"),
    @NamedQuery(name = "Cities.findByUrl", query = "SELECT c FROM Cities c WHERE c.url = :url"),
    @NamedQuery(name = "Cities.findByName", query = "SELECT c FROM Cities c WHERE c.name = :name"),
    @NamedQuery(name = "Cities.findByLatitude", query = "SELECT c FROM Cities c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Cities.findByLongitude", query = "SELECT c FROM Cities c WHERE c.longitude = :longitude")})
public class Cities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "COUNTRY")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "REGION")
    private String region;
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

    public Cities() {
    }

    public Cities(Integer id) {
        this.id = id;
    }

    public Cities(Integer id, String country, String region, String url, String name, double latitude, double longitude) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.url = url;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cities)) {
            return false;
        }
        Cities other = (Cities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cities[ id=" + id + " ]";
    }
    
}
