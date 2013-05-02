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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michelle Thornton
 */
@Entity
@Table(name = "PERMISSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
    @NamedQuery(name = "Permission.findByIdpermissions", query = "SELECT p FROM Permission p WHERE p.idpermissions = :idpermissions"),
    @NamedQuery(name = "Permission.findByPermission", query = "SELECT p FROM Permission p WHERE p.permission = :permission"),
    @NamedQuery(name = "Permission.findByDiscritption", query = "SELECT p FROM Permission p WHERE p.discritption = :discritption"),
    @NamedQuery(name = "Permission.findByCreateperm", query = "SELECT p FROM Permission p WHERE p.createperm = :createperm"),
    @NamedQuery(name = "Permission.findByDeleteperm", query = "SELECT p FROM Permission p WHERE p.deleteperm = :deleteperm"),
    @NamedQuery(name = "Permission.findByUpdateperm", query = "SELECT p FROM Permission p WHERE p.updateperm = :updateperm"),
    @NamedQuery(name = "Permission.findByReadperm", query = "SELECT p FROM Permission p WHERE p.readperm = :readperm"),
    @NamedQuery(name = "Permission.findByGrantperm", query = "SELECT p FROM Permission p WHERE p.grantperm = :grantperm")})
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPERMISSIONS")
    private Integer idpermissions;
    @Size(max = 45)
    @Column(name = "PERMISSION")
    private String permission;
    @Size(max = 45)
    @Column(name = "DISCRITPTION")
    private String discritption;
    @Column(name = "CREATEPERM")
    private Short createperm;
    @Column(name = "DELETEPERM")
    private Short deleteperm;
    @Column(name = "UPDATEPERM")
    private Short updateperm;
    @Column(name = "READPERM")
    private Short readperm;
    @Column(name = "GRANTPERM")
    private Short grantperm;
    @JoinColumn(name = "TASKS_IDTASKS", referencedColumnName = "IDTASKS")
    @ManyToOne(optional = false)
    private Task tasksIdtasks;
    @JoinColumn(name = "ROLES_IDROLES", referencedColumnName = "IDROLES")
    @ManyToOne(optional = false)
    private Role rolesIdroles;

    public Permission() {
    }

    public Permission(Integer idpermissions) {
        this.idpermissions = idpermissions;
    }

    public Integer getIdpermissions() {
        return idpermissions;
    }

    public void setIdpermissions(Integer idpermissions) {
        this.idpermissions = idpermissions;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDiscritption() {
        return discritption;
    }

    public void setDiscritption(String discritption) {
        this.discritption = discritption;
    }

    public Short getCreateperm() {
        return createperm;
    }

    public void setCreateperm(Short createperm) {
        this.createperm = createperm;
    }

    public Short getDeleteperm() {
        return deleteperm;
    }

    public void setDeleteperm(Short deleteperm) {
        this.deleteperm = deleteperm;
    }

    public Short getUpdateperm() {
        return updateperm;
    }

    public void setUpdateperm(Short updateperm) {
        this.updateperm = updateperm;
    }

    public Short getReadperm() {
        return readperm;
    }

    public void setReadperm(Short readperm) {
        this.readperm = readperm;
    }

    public Short getGrantperm() {
        return grantperm;
    }

    public void setGrantperm(Short grantperm) {
        this.grantperm = grantperm;
    }

    public Task getTasksIdtasks() {
        return tasksIdtasks;
    }

    public void setTasksIdtasks(Task tasksIdtasks) {
        this.tasksIdtasks = tasksIdtasks;
    }

    public Role getRolesIdroles() {
        return rolesIdroles;
    }

    public void setRolesIdroles(Role rolesIdroles) {
        this.rolesIdroles = rolesIdroles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpermissions != null ? idpermissions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.idpermissions == null && other.idpermissions != null) || (this.idpermissions != null && !this.idpermissions.equals(other.idpermissions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Permission[ idpermissions=" + idpermissions + " ]";
    }
    
}
