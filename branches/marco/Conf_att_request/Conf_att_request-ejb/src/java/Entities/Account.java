/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco Remane
 */
@Entity
@Table(name = "ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByIdaccount", query = "SELECT a FROM Account a WHERE a.idaccount = :idaccount"),
    @NamedQuery(name = "Account.findByAccount", query = "SELECT a FROM Account a WHERE a.account = :account"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findBySalt", query = "SELECT a FROM Account a WHERE a.salt = :salt"),
    @NamedQuery(name = "Account.findByDateCreated", query = "SELECT a FROM Account a WHERE a.dateCreated = :dateCreated"),
    @NamedQuery(name = "Account.findByDateLogin", query = "SELECT a FROM Account a WHERE a.dateLogin = :dateLogin")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACCOUNT")
    private Integer idaccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ACCOUNT")
    private String account;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 45)
    @Column(name = "SALT")
    private String salt;
    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "DATE_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLogin;

    public Account() {
    }

    public Account(Integer idaccount) {
        this.idaccount = idaccount;
    }

    public Account(Integer idaccount, String account, String password) {
        this.idaccount = idaccount;
        this.account = account;
        this.password = password;
    }

    public Integer getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(Integer idaccount) {
        this.idaccount = idaccount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
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
