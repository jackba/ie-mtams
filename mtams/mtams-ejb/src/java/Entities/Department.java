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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riaan
 */
@Entity
@Table(name = "DEPARTMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartment", query = "SELECT d FROM Department d WHERE d.department = :department"),
    @NamedQuery(name = "Department.findByIddepartment", query = "SELECT d FROM Department d WHERE d.iddepartment = :iddepartment")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DEPARTMENT")
    private String department;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDEPARTMENT")
    private Integer iddepartment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddepartment")
    private Collection<Accountdepartment> accountdepartmentCollection;

    public Department() {
    }

    public Department(Integer iddepartment) {
        this.iddepartment = iddepartment;
    }

    public Department(Integer iddepartment, String department) {
        this.iddepartment = iddepartment;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Integer iddepartment) {
        this.iddepartment = iddepartment;
    }

    @XmlTransient
    public Collection<Accountdepartment> getAccountdepartmentCollection() {
        return accountdepartmentCollection;
    }

    public void setAccountdepartmentCollection(Collection<Accountdepartment> accountdepartmentCollection) {
        this.accountdepartmentCollection = accountdepartmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartment != null ? iddepartment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.iddepartment == null && other.iddepartment != null) || (this.iddepartment != null && !this.iddepartment.equals(other.iddepartment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Department[ iddepartment=" + iddepartment + " ]";
    }
    
}
