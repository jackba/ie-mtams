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
@Table(name = "ACCOUNTDEPARTMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accountdepartment.findAll", query = "SELECT a FROM Accountdepartment a"),
    @NamedQuery(name = "Accountdepartment.findByIdaccountdepartment", query = "SELECT a FROM Accountdepartment a WHERE a.idaccountdepartment = :idaccountdepartment")})
public class Accountdepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDACCOUNTDEPARTMENT")
    private Integer idaccountdepartment;
    @JoinColumn(name = "IDDEPARTMENT", referencedColumnName = "IDDEPARTMENT")
    @ManyToOne(optional = false)
    private Department iddepartment;
    @JoinColumn(name = "IDACCOUNT", referencedColumnName = "IDACCOUNT")
    @ManyToOne(optional = false)
    private Account idaccount;

    public Accountdepartment() {
    }

    public Accountdepartment(Integer idaccountdepartment) {
        this.idaccountdepartment = idaccountdepartment;
    }

    public Integer getIdaccountdepartment() {
        return idaccountdepartment;
    }

    public void setIdaccountdepartment(Integer idaccountdepartment) {
        this.idaccountdepartment = idaccountdepartment;
    }

    public Department getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Department iddepartment) {
        this.iddepartment = iddepartment;
    }

    public Account getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(Account idaccount) {
        this.idaccount = idaccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccountdepartment != null ? idaccountdepartment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountdepartment)) {
            return false;
        }
        Accountdepartment other = (Accountdepartment) object;
        if ((this.idaccountdepartment == null && other.idaccountdepartment != null) || (this.idaccountdepartment != null && !this.idaccountdepartment.equals(other.idaccountdepartment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Accountdepartment[ idaccountdepartment=" + idaccountdepartment + " ]";
    }
    
}
