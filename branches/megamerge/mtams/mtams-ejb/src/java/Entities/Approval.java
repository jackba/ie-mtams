/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riaan
 */
@Entity
@Table(name = "APPROVAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Approval.findAll", query = "SELECT a FROM Approval a"),
    @NamedQuery(name = "Approval.findByIdapproval", query = "SELECT a FROM Approval a WHERE a.idapproval = :idapproval"),
    @NamedQuery(name = "Approval.findByFromsection", query = "SELECT a FROM Approval a WHERE a.fromsection = :fromsection"),
    @NamedQuery(name = "Approval.findBySectionid", query = "SELECT a FROM Approval a WHERE a.sectionid = :sectionid"),
    @NamedQuery(name = "Approval.findBySectionapproved", query = "SELECT a FROM Approval a WHERE a.sectionapproved = :sectionapproved"),
    @NamedQuery(name = "Approval.findByNotes", query = "SELECT a FROM Approval a WHERE a.notes = :notes"),
    @NamedQuery(name = "Approval.findByDate", query = "SELECT a FROM Approval a WHERE a.date = :date")})
public class Approval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAPPROVAL")
    private Integer idapproval;
    @Size(max = 30)
    @Column(name = "FROMSECTION")
    private String fromsection;
    @Column(name = "SECTIONID")
    private Integer sectionid;
    @Column(name = "SECTIONAPPROVED")
    private Integer sectionapproved;
    @Size(max = 300)
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(mappedBy = "approvalIdapproval")
    private Collection<Attachement> attachementCollection;
    @OneToMany(mappedBy = "schooladminapproved")
    private Collection<Approvalchain> approvalchainCollection;
    @OneToMany(mappedBy = "hodapproved")
    private Collection<Approvalchain> approvalchainCollection1;
    @OneToMany(mappedBy = "financeapproved")
    private Collection<Approvalchain> approvalchainCollection2;
    @OneToMany(mappedBy = "pvcapproved")
    private Collection<Approvalchain> approvalchainCollection3;
    @OneToMany(mappedBy = "finalapproved")
    private Collection<Approvalchain> approvalchainCollection4;
    @JoinColumn(name = "APPLICATION_IDAPPLICATION", referencedColumnName = "IDAPPLICATION")
    @ManyToOne(optional = false)
    private Application applicationIdapplication;
    @JoinColumn(name = "ACCOUNT_IDACCOUNT", referencedColumnName = "IDACCOUNT")
    @ManyToOne(optional = false)
    private Account accountIdaccount;

    public Approval() {
    }

    public Approval(Integer idapproval) {
        this.idapproval = idapproval;
    }

    public Integer getIdapproval() {
        return idapproval;
    }

    public void setIdapproval(Integer idapproval) {
        this.idapproval = idapproval;
    }

    public String getFromsection() {
        return fromsection;
    }

    public void setFromsection(String fromsection) {
        this.fromsection = fromsection;
    }

    public Integer getSectionid() {
        return sectionid;
    }

    public void setSectionid(Integer sectionid) {
        this.sectionid = sectionid;
    }

    public Integer getSectionapproved() {
        return sectionapproved;
    }

    public void setSectionapproved(Integer sectionapproved) {
        this.sectionapproved = sectionapproved;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Attachement> getAttachementCollection() {
        return attachementCollection;
    }

    public void setAttachementCollection(Collection<Attachement> attachementCollection) {
        this.attachementCollection = attachementCollection;
    }

    @XmlTransient
    public Collection<Approvalchain> getApprovalchainCollection() {
        return approvalchainCollection;
    }

    public void setApprovalchainCollection(Collection<Approvalchain> approvalchainCollection) {
        this.approvalchainCollection = approvalchainCollection;
    }

    @XmlTransient
    public Collection<Approvalchain> getApprovalchainCollection1() {
        return approvalchainCollection1;
    }

    public void setApprovalchainCollection1(Collection<Approvalchain> approvalchainCollection1) {
        this.approvalchainCollection1 = approvalchainCollection1;
    }

    @XmlTransient
    public Collection<Approvalchain> getApprovalchainCollection2() {
        return approvalchainCollection2;
    }

    public void setApprovalchainCollection2(Collection<Approvalchain> approvalchainCollection2) {
        this.approvalchainCollection2 = approvalchainCollection2;
    }

    @XmlTransient
    public Collection<Approvalchain> getApprovalchainCollection3() {
        return approvalchainCollection3;
    }

    public void setApprovalchainCollection3(Collection<Approvalchain> approvalchainCollection3) {
        this.approvalchainCollection3 = approvalchainCollection3;
    }

    @XmlTransient
    public Collection<Approvalchain> getApprovalchainCollection4() {
        return approvalchainCollection4;
    }

    public void setApprovalchainCollection4(Collection<Approvalchain> approvalchainCollection4) {
        this.approvalchainCollection4 = approvalchainCollection4;
    }

    public Application getApplicationIdapplication() {
        return applicationIdapplication;
    }

    public void setApplicationIdapplication(Application applicationIdapplication) {
        this.applicationIdapplication = applicationIdapplication;
    }

    public Account getAccountIdaccount() {
        return accountIdaccount;
    }

    public void setAccountIdaccount(Account accountIdaccount) {
        this.accountIdaccount = accountIdaccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idapproval != null ? idapproval.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Approval)) {
            return false;
        }
        Approval other = (Approval) object;
        if ((this.idapproval == null && other.idapproval != null) || (this.idapproval != null && !this.idapproval.equals(other.idapproval))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Approval[ idapproval=" + idapproval + " ]";
    }
    
}
