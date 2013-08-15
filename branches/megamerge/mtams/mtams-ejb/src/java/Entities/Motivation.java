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
@Table(name = "MOTIVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivation.findAll", query = "SELECT m FROM Motivation m"),
    @NamedQuery(name = "Motivation.findByIdmotivation", query = "SELECT m FROM Motivation m WHERE m.idmotivation = :idmotivation"),
    @NamedQuery(name = "Motivation.findBySupplier", query = "SELECT m FROM Motivation m WHERE m.supplier = :supplier"),
    @NamedQuery(name = "Motivation.findByAmount", query = "SELECT m FROM Motivation m WHERE m.amount = :amount"),
    @NamedQuery(name = "Motivation.findByCostcenter", query = "SELECT m FROM Motivation m WHERE m.costcenter = :costcenter"),
    @NamedQuery(name = "Motivation.findByMotivation", query = "SELECT m FROM Motivation m WHERE m.motivation = :motivation"),
    @NamedQuery(name = "Motivation.findByBudget", query = "SELECT m FROM Motivation m WHERE m.budget = :budget"),
    @NamedQuery(name = "Motivation.findByRecommended", query = "SELECT m FROM Motivation m WHERE m.recommended = :recommended"),
    @NamedQuery(name = "Motivation.findByRequestedby", query = "SELECT m FROM Motivation m WHERE m.requestedby = :requestedby")})
public class Motivation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMOTIVATION")
    private Integer idmotivation;
    @Size(max = 45)
    @Column(name = "SUPPLIER")
    private String supplier;
    @Size(max = 45)
    @Column(name = "AMOUNT")
    private String amount;
    @Size(max = 45)
    @Column(name = "COSTCENTER")
    private String costcenter;
    @Size(max = 255)
    @Column(name = "MOTIVATION")
    private String motivation;
    @Column(name = "BUDGET")
    private Integer budget;
    @Size(max = 45)
    @Column(name = "RECOMMENDED")
    private String recommended;
    @Size(max = 45)
    @Column(name = "REQUESTEDBY")
    private String requestedby;
    @OneToMany(mappedBy = "motivationIdmotivation")
    private Collection<Attachement> attachementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motivationIdmotivation")
    private Collection<Application> applicationCollection;

    public Motivation() {
    }

    public Motivation(Integer idmotivation) {
        this.idmotivation = idmotivation;
    }

    public Integer getIdmotivation() {
        return idmotivation;
    }

    public void setIdmotivation(Integer idmotivation) {
        this.idmotivation = idmotivation;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCostcenter() {
        return costcenter;
    }

    public void setCostcenter(String costcenter) {
        this.costcenter = costcenter;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getRequestedby() {
        return requestedby;
    }

    public void setRequestedby(String requestedby) {
        this.requestedby = requestedby;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @XmlTransient
    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmotivation != null ? idmotivation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivation)) {
            return false;
        }
        Motivation other = (Motivation) object;
        if ((this.idmotivation == null && other.idmotivation != null) || (this.idmotivation != null && !this.idmotivation.equals(other.idmotivation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Motivation[ idmotivation=" + idmotivation + " ]";
    }
    
}
