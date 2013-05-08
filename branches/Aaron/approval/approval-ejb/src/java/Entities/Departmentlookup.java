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
 * @author aaron
 */
@Entity
@Table(name = "DEPARTMENTLOOKUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departmentlookup.findAll", query = "SELECT d FROM Departmentlookup d"),
    @NamedQuery(name = "Departmentlookup.findByDepartment", query = "SELECT d FROM Departmentlookup d WHERE d.department = :department")})
public class Departmentlookup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DEPARTMENT")
    private String department;

    public Departmentlookup() {
    }

    public Departmentlookup(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (department != null ? department.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departmentlookup)) {
            return false;
        }
        Departmentlookup other = (Departmentlookup) object;
        if ((this.department == null && other.department != null) || (this.department != null && !this.department.equals(other.department))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Departmentlookup[ department=" + department + " ]";
    }
    
}
