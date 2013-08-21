/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "REGION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByIdregion", query = "SELECT r FROM Region r WHERE r.idregion = :idregion"),
    @NamedQuery(name = "Region.findByCode", query = "SELECT r FROM Region r WHERE r.code = :code"),
    @NamedQuery(name = "Region.findByUrl", query = "SELECT r FROM Region r WHERE r.url = :url"),
    @NamedQuery(name = "Region.findByName", query = "SELECT r FROM Region r WHERE r.name = :name"),
    @NamedQuery(name = "Region.findByLatitude", query = "SELECT r FROM Region r WHERE r.latitude = :latitude"),
    @NamedQuery(name = "Region.findByLongitude", query = "SELECT r FROM Region r WHERE r.longitude = :longitude"),
    @NamedQuery(name = "Region.findByCities", query = "SELECT r FROM Region r WHERE r.cities = :cities")})
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDREGION")
    private Integer idregion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODE")
    private String code;
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
    @Column(name = "CITIES")
    private int cities;
    @JoinColumn(name = "CODE2", referencedColumnName = "CODE2")
    @ManyToOne(optional = false)
    private Country code2;

    public Region() {
    }

    public Region(Integer idregion) {
        this.idregion = idregion;
    }

    public Region(Integer idregion, String code, String url, String name, double latitude, double longitude, int cities) {
        this.idregion = idregion;
        this.code = code;
        this.url = url;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cities = cities;
    }

    public Integer getIdregion() {
        return idregion;
    }

    public void setIdregion(Integer idregion) {
        this.idregion = idregion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getCities() {
        return cities;
    }

    public void setCities(int cities) {
        this.cities = cities;
    }

    public Country getCode2() {
        return code2;
    }

    public void setCode2(Country code2) {
        this.code2 = code2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregion != null ? idregion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.idregion == null && other.idregion != null) || (this.idregion != null && !this.idregion.equals(other.idregion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Region[ idregion=" + idregion + " ]";
    }
    
}
