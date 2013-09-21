/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "ACCOUNTROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accountrole.findAll", query = "SELECT a FROM Accountrole a"),
    @NamedQuery(name = "Accountrole.findByIduserroles", query = "SELECT a FROM Accountrole a WHERE a.iduserroles = :iduserroles")})
public class Accountrole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSERROLES")
    private Integer iduserroles;
    @JoinColumn(name = "ROLEID", referencedColumnName = "IDROLES")
    @ManyToOne
    private Role roleid;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "IDACCOUNT")
    @ManyToOne
    private Account accountid;

    public Accountrole() {
    }

    public Accountrole(Integer iduserroles) {
        this.iduserroles = iduserroles;
    }

    public Integer getIduserroles() {
        return iduserroles;
    }

    public void setIduserroles(Integer iduserroles) {
        this.iduserroles = iduserroles;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduserroles != null ? iduserroles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountrole)) {
            return false;
        }
        Accountrole other = (Accountrole) object;
        if ((this.iduserroles == null && other.iduserroles != null) || (this.iduserroles != null && !this.iduserroles.equals(other.iduserroles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Accountrole[ iduserroles=" + iduserroles + " ]";
    }
    
}
