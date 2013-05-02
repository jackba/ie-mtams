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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michelle Thornton
 */
@Entity
@Table(name = "FINALCOSTING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finalcosting.findAll", query = "SELECT f FROM Finalcosting f"),
    @NamedQuery(name = "Finalcosting.findByIdfinalcosting", query = "SELECT f FROM Finalcosting f WHERE f.idfinalcosting = :idfinalcosting"),
    @NamedQuery(name = "Finalcosting.findByAirfarebudget", query = "SELECT f FROM Finalcosting f WHERE f.airfarebudget = :airfarebudget"),
    @NamedQuery(name = "Finalcosting.findByAirfarecost", query = "SELECT f FROM Finalcosting f WHERE f.airfarecost = :airfarecost"),
    @NamedQuery(name = "Finalcosting.findByCarrentalbudget", query = "SELECT f FROM Finalcosting f WHERE f.carrentalbudget = :carrentalbudget"),
    @NamedQuery(name = "Finalcosting.findByCarrentalcost", query = "SELECT f FROM Finalcosting f WHERE f.carrentalcost = :carrentalcost"),
    @NamedQuery(name = "Finalcosting.findByAccommodationbudget", query = "SELECT f FROM Finalcosting f WHERE f.accommodationbudget = :accommodationbudget"),
    @NamedQuery(name = "Finalcosting.findByAccommodationcost", query = "SELECT f FROM Finalcosting f WHERE f.accommodationcost = :accommodationcost")})
public class Finalcosting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFINALCOSTING")
    private Integer idfinalcosting;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AIRFAREBUDGET")
    private Double airfarebudget;
    @Column(name = "AIRFARECOST")
    private Double airfarecost;
    @Column(name = "CARRENTALBUDGET")
    private Double carrentalbudget;
    @Column(name = "CARRENTALCOST")
    private Double carrentalcost;
    @Column(name = "ACCOMMODATIONBUDGET")
    private Double accommodationbudget;
    @Column(name = "ACCOMMODATIONCOST")
    private Double accommodationcost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "finalcostingIdfinalcosting")
    private Collection<Application> applicationCollection;
    @JoinColumn(name = "QUOTES_IDQUOTES", referencedColumnName = "IDQUOTES")
    @ManyToOne(optional = false)
    private Quotes quotesIdquotes;
    @OneToMany(mappedBy = "finalcostingIdfinalcosting")
    private Collection<Attachement> attachementCollection;

    public Finalcosting() {
    }

    public Finalcosting(Integer idfinalcosting) {
        this.idfinalcosting = idfinalcosting;
    }

    public Integer getIdfinalcosting() {
        return idfinalcosting;
    }

    public void setIdfinalcosting(Integer idfinalcosting) {
        this.idfinalcosting = idfinalcosting;
    }

    public Double getAirfarebudget() {
        return airfarebudget;
    }

    public void setAirfarebudget(Double airfarebudget) {
        this.airfarebudget = airfarebudget;
    }

    public Double getAirfarecost() {
        return airfarecost;
    }

    public void setAirfarecost(Double airfarecost) {
        this.airfarecost = airfarecost;
    }

    public Double getCarrentalbudget() {
        return carrentalbudget;
    }

    public void setCarrentalbudget(Double carrentalbudget) {
        this.carrentalbudget = carrentalbudget;
    }

    public Double getCarrentalcost() {
        return carrentalcost;
    }

    public void setCarrentalcost(Double carrentalcost) {
        this.carrentalcost = carrentalcost;
    }

    public Double getAccommodationbudget() {
        return accommodationbudget;
    }

    public void setAccommodationbudget(Double accommodationbudget) {
        this.accommodationbudget = accommodationbudget;
    }

    public Double getAccommodationcost() {
        return accommodationcost;
    }

    public void setAccommodationcost(Double accommodationcost) {
        this.accommodationcost = accommodationcost;
    }

    @XmlTransient
    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    public Quotes getQuotesIdquotes() {
        return quotesIdquotes;
    }

    public void setQuotesIdquotes(Quotes quotesIdquotes) {
        this.quotesIdquotes = quotesIdquotes;
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
        hash += (idfinalcosting != null ? idfinalcosting.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finalcosting)) {
            return false;
        }
        Finalcosting other = (Finalcosting) object;
        if ((this.idfinalcosting == null && other.idfinalcosting != null) || (this.idfinalcosting != null && !this.idfinalcosting.equals(other.idfinalcosting))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Finalcosting[ idfinalcosting=" + idfinalcosting + " ]";
    }
    
}
