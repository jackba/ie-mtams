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
    @NamedQuery(name = "Accountdepartment.findByIdaccount", query = "SELECT a FROM Accountdepartment a WHERE a.idaccount = :idaccount"),
    @NamedQuery(name = "Accountdepartment.findByIddepartment", query = "SELECT a FROM Accountdepartment a WHERE a.iddepartment = :iddepartment"),
    @NamedQuery(name = "Accountdepartment.findByIdaccountdepartment", query = "SELECT a FROM Accountdepartment a WHERE a.idaccountdepartment = :idaccountdepartment")})
public class Accountdepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACCOUNT")
    private int idaccount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDEPARTMENT")
    private int iddepartment;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACCOUNTDEPARTMENT")
    private Integer idaccountdepartment;

    public Accountdepartment() {
    }

    public Accountdepartment(Integer idaccountdepartment) {
        this.idaccountdepartment = idaccountdepartment;
    }

    public Accountdepartment(Integer idaccountdepartment, int idaccount, int iddepartment) {
        this.idaccountdepartment = idaccountdepartment;
        this.idaccount = idaccount;
        this.iddepartment = iddepartment;
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }

    public int getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(int iddepartment) {
        this.iddepartment = iddepartment;
    }

    public Integer getIdaccountdepartment() {
        return idaccountdepartment;
    }

    public void setIdaccountdepartment(Integer idaccountdepartment) {
        this.idaccountdepartment = idaccountdepartment;
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
