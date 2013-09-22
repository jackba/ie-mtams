/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
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
 * @author Riaan
 */
@Entity
@Table(name = "COUNTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findByCode2", query = "SELECT c FROM Country c WHERE c.code2 = :code2"),
    @NamedQuery(name = "Country.findByCode3", query = "SELECT c FROM Country c WHERE c.code3 = :code3"),
    @NamedQuery(name = "Country.findByUrl", query = "SELECT c FROM Country c WHERE c.url = :url"),
    @NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name = :name"),
    @NamedQuery(name = "Country.findByLatitude", query = "SELECT c FROM Country c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Country.findByLongitude", query = "SELECT c FROM Country c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "Country.findByRegions", query = "SELECT c FROM Country c WHERE c.regions = :regions")})
public class Country implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code2")
    private Collection<Region> regionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code2")
    private Collection<Currency> currencyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code2")
    private Collection<City> cityCollection;

    public Country() {
    }

    public Country(String code2) {
        this.code2 = code2;
    }

    public Country(String code2, String code3, String url, String name, double latitude, double longitude, int regions) {
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

    @XmlTransient
    public Collection<Region> getRegionCollection() {
        return regionCollection;
    }

    public void setRegionCollection(Collection<Region> regionCollection) {
        this.regionCollection = regionCollection;
    }

    @XmlTransient
    public Collection<Currency> getCurrencyCollection() {
        return currencyCollection;
    }

    public void setCurrencyCollection(Collection<Currency> currencyCollection) {
        this.currencyCollection = currencyCollection;
    }

    @XmlTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
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
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.code2 == null && other.code2 != null) || (this.code2 != null && !this.code2.equals(other.code2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Country[ code2=" + code2 + " ]";
    }
    
}
