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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "ACCOUNTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByIdaccounts", query = "SELECT a FROM Accounts a WHERE a.idaccounts = :idaccounts"),
    @NamedQuery(name = "Accounts.findByUsername", query = "SELECT a FROM Accounts a WHERE a.username = :username"),
    @NamedQuery(name = "Accounts.findByPassword", query = "SELECT a FROM Accounts a WHERE a.password = :password"),
    @NamedQuery(name = "Accounts.findByRoleIdrole", query = "SELECT a FROM Accounts a WHERE a.roleIdrole = :roleIdrole")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACCOUNTS")
    private Integer idaccounts;
    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_IDROLE")
    private int roleIdrole;

    public Accounts() {
    }

    public Accounts(Integer idaccounts) {
        this.idaccounts = idaccounts;
    }

    public Accounts(Integer idaccounts, String password, int roleIdrole) {
        this.idaccounts = idaccounts;
        this.password = password;
        this.roleIdrole = roleIdrole;
    }

    public Integer getIdaccounts() {
        return idaccounts;
    }

    public void setIdaccounts(Integer idaccounts) {
        this.idaccounts = idaccounts;
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

    public int getRoleIdrole() {
        return roleIdrole;
    }

    public void setRoleIdrole(int roleIdrole) {
        this.roleIdrole = roleIdrole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccounts != null ? idaccounts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.idaccounts == null && other.idaccounts != null) || (this.idaccounts != null && !this.idaccounts.equals(other.idaccounts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Accounts[ idaccounts=" + idaccounts + " ]";
    }
    
}
