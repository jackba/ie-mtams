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
@Table(name = "LEAVELOOKUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Leavelookup.findAll", query = "SELECT l FROM Leavelookup l"),
    @NamedQuery(name = "Leavelookup.findByLeavetype", query = "SELECT l FROM Leavelookup l WHERE l.leavetype = :leavetype")})
public class Leavelookup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LEAVETYPE")
    private String leavetype;

    public Leavelookup() {
    }

    public Leavelookup(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leavetype != null ? leavetype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leavelookup)) {
            return false;
        }
        Leavelookup other = (Leavelookup) object;
        if ((this.leavetype == null && other.leavetype != null) || (this.leavetype != null && !this.leavetype.equals(other.leavetype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Leavelookup[ leavetype=" + leavetype + " ]";
    }
    
}
