/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riaan
 */
@Entity
@Table(name = "ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByIdroles", query = "SELECT r FROM Role r WHERE r.idroles = :idroles"),
    @NamedQuery(name = "Role.findByRole", query = "SELECT r FROM Role r WHERE r.role = :role"),
    @NamedQuery(name = "Role.findByDiscritption", query = "SELECT r FROM Role r WHERE r.discritption = :discritption")})
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDROLES")
    private Integer idroles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ROLE")
    private String role;
    @Size(max = 512)
    @Column(name = "DISCRITPTION")
    private String discritption;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolesIdroles")
    private Collection<Permission> permissionCollection;
    @OneToMany(mappedBy = "roleid")
    private Collection<Accountrole> accountroleCollection;

    public Role() {
    }

    public Role(Integer idroles) {
        this.idroles = idroles;
    }

    public Role(Integer idroles, String role) {
        this.idroles = idroles;
        this.role = role;
    }

    public Integer getIdroles() {
        return idroles;
    }

    public void setIdroles(Integer idroles) {
        this.idroles = idroles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDiscritption() {
        return discritption;
    }

    public void setDiscritption(String discritption) {
        this.discritption = discritption;
    }

    @XmlTransient
    public Collection<Permission> getPermissionCollection() {
        return permissionCollection;
    }

    public void setPermissionCollection(Collection<Permission> permissionCollection) {
        this.permissionCollection = permissionCollection;
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
        hash += (idroles != null ? idroles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idroles == null && other.idroles != null) || (this.idroles != null && !this.idroles.equals(other.idroles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Role[ idroles=" + idroles + " ]";
    }
    
}
