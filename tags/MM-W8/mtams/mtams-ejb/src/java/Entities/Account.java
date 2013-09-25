/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riaan
 */
@Entity
@Table(name = "ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByIdaccount", query = "SELECT a FROM Account a WHERE a.idaccount = :idaccount"),
    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findBySalt", query = "SELECT a FROM Account a WHERE a.salt = :salt"),
    @NamedQuery(name = "Account.findByDatecreated", query = "SELECT a FROM Account a WHERE a.datecreated = :datecreated"),
    @NamedQuery(name = "Account.findByDatelogin", query = "SELECT a FROM Account a WHERE a.datelogin = :datelogin")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDACCOUNT")
    private Integer idaccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 45)
    @Column(name = "SALT")
    private String salt;
    @Column(name = "DATECREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Column(name = "DATELOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountIdaccount")
    private Collection<Application> applicationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaccount")
    private Collection<Accountdepartment> accountdepartmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountid")
    private Collection<Travelerprofile> travelerprofileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountid")
    private Collection<Session> sessionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountid")
    private Collection<Approvalchain> approvalchainCollection;
    @OneToMany(mappedBy = "schooladmin")
    private Collection<Approvalchain> approvalchainCollection1;
    @OneToMany(mappedBy = "hod")
    private Collection<Approvalchain> approvalchainCollection2;
    @OneToMany(mappedBy = "finance")
    private Collection<Approvalchain> approvalchainCollection3;
    @OneToMany(mappedBy = "pvc")
    private Collection<Approvalchain> approvalchainCollection4;
    @OneToMany(mappedBy = "finalfinance")
    private Collection<Approvalchain> approvalchainCollection5;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountIdaccount")
    private Collection<Approval> approvalCollection;
    @OneToMany(mappedBy = "accountid")
    private Collection<Accountrole> accountroleCollection;

    public Account() {
    }

    public Account(Integer idaccount) {
        this.idaccount = idaccount;
    }

    public Account(Integer idaccount, String username, String password) {
        this.idaccount = idaccount;
        this.username = username;
        this.password = password;
    }

    public Integer getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(Integer idaccount) {
        this.idaccount = idaccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getDatelogin() {
        return datelogin;
    }

    public void setDatelogin(Date datelogin) {
        this.datelogin = datelogin;
    }

    @XmlTransient
    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    @XmlTransient
    public Collection<Accountdepartment> getAccountdepartmentCollection() {
        return accountdepartmentCollection;
    }

    public void setAccountdepartmentCollection(Collection<Accountdepartment> accountdepartmentCollection) {
        this.accountdepartmentCollection = accountdepartmentCollection;
    }

    @XmlTransient
    public Collection<Travelerprofile> getTravelerprofileCollection() {
        return travelerprofileCollection;
    }

    public void setTravelerprofileCollection(Collection<Travelerprofile> travelerprofileCollection) {
        this.travelerprofileCollection = travelerprofileCollection;
    }

    @XmlTransient
    public Collection<Session> getSessionCollection() {
        return sessionCollection;
    }

    public void setSessionCollection(Collection<Session> sessionCollection) {
        this.sessionCollection = sessionCollection;
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

    @XmlTransient
    public Collection<Approvalchain> getApprovalchainCollection5() {
        return approvalchainCollection5;
    }

    public void setApprovalchainCollection5(Collection<Approvalchain> approvalchainCollection5) {
        this.approvalchainCollection5 = approvalchainCollection5;
    }

    @XmlTransient
    public Collection<Approval> getApprovalCollection() {
        return approvalCollection;
    }

    public void setApprovalCollection(Collection<Approval> approvalCollection) {
        this.approvalCollection = approvalCollection;
    }

    @XmlTransient
    public Collection<Accountrole> getAccountroleCollection() {
        return accountroleCollection;
    }

    public void setAccountroleCollection(Collection<Accountrole> accountroleCollection) {
        this.accountroleCollection = accountroleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccount != null ? idaccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.idaccount == null && other.idaccount != null) || (this.idaccount != null && !this.idaccount.equals(other.idaccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Account[ idaccount=" + idaccount + " ]";
    }
    
}
