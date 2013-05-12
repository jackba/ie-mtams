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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "QUOTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quotes.findAll", query = "SELECT q FROM Quotes q"),
    @NamedQuery(name = "Quotes.findByIdquotes", query = "SELECT q FROM Quotes q WHERE q.idquotes = :idquotes"),
    @NamedQuery(name = "Quotes.findByAmended", query = "SELECT q FROM Quotes q WHERE q.amended = :amended"),
    @NamedQuery(name = "Quotes.findByCostcenter", query = "SELECT q FROM Quotes q WHERE q.costcenter = :costcenter"),
    @NamedQuery(name = "Quotes.findByDescription", query = "SELECT q FROM Quotes q WHERE q.description = :description")})
public class Quotes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDQUOTES")
    private Integer idquotes;
    @Column(name = "AMENDED")
    private Integer amended;
    @Size(max = 45)
    @Column(name = "COSTCENTER")
    private String costcenter;
    @Size(max = 45)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quotesIdquotes")
    private Collection<Carquotes> carquotesCollection;
    @OneToMany(mappedBy = "quotesIdquotes")
    private Collection<Attachement> attachementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quotesIdquotes")
    private Collection<Flightquotes> flightquotesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quotesIdquotes")
    private Collection<Application> applicationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quotesIdquotes")
    private Collection<Finalcosting> finalcostingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quotesIdquotes")
    private Collection<Accomodationquotes> accomodationquotesCollection;

    public Quotes() {
    }

    public Quotes(Integer idquotes) {
        this.idquotes = idquotes;
    }

    public Integer getIdquotes() {
        return idquotes;
    }

    public void setIdquotes(Integer idquotes) {
        this.idquotes = idquotes;
    }

    public Integer getAmended() {
        return amended;
    }

    public void setAmended(Integer amended) {
        this.amended = amended;
    }

    public String getCostcenter() {
        return costcenter;
    }

    public void setCostcenter(String costcenter) {
        this.costcenter = costcenter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Carquotes> getCarquotesCollection() {
        return carquotesCollection;
    }

    public void setCarquotesCollection(Collection<Carquotes> carquotesCollection) {
        this.carquotesCollection = carquotesCollection;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @XmlTransient
    public Collection<Flightquotes> getFlightquotesCollection() {
        return flightquotesCollection;
    }

    public void setFlightquotesCollection(Collection<Flightquotes> flightquotesCollection) {
        this.flightquotesCollection = flightquotesCollection;
    }

    @XmlTransient
    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    @XmlTransient
    public Collection<Finalcosting> getFinalcostingCollection() {
        return finalcostingCollection;
    }

    public void setFinalcostingCollection(Collection<Finalcosting> finalcostingCollection) {
        this.finalcostingCollection = finalcostingCollection;
    }

    @XmlTransient
    public Collection<Accomodationquotes> getAccomodationquotesCollection() {
        return accomodationquotesCollection;
    }

    public void setAccomodationquotesCollection(Collection<Accomodationquotes> accomodationquotesCollection) {
        this.accomodationquotesCollection = accomodationquotesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquotes != null ? idquotes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quotes)) {
            return false;
        }
        Quotes other = (Quotes) object;
        if ((this.idquotes == null && other.idquotes != null) || (this.idquotes != null && !this.idquotes.equals(other.idquotes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Quotes[ idquotes=" + idquotes + " ]";
    }
    
}
