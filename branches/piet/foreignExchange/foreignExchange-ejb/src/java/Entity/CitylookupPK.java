/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Riaan
 */
@Embeddable
public class CitylookupPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCITYLOOKUP")
    private int idcitylookup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COUNTRYLOOKUP_IDCOUNTRYLOOKUP")
    private int countrylookupIdcountrylookup;

    public CitylookupPK() {
    }

    public CitylookupPK(int idcitylookup, int countrylookupIdcountrylookup) {
        this.idcitylookup = idcitylookup;
        this.countrylookupIdcountrylookup = countrylookupIdcountrylookup;
    }

    public int getIdcitylookup() {
        return idcitylookup;
    }

    public void setIdcitylookup(int idcitylookup) {
        this.idcitylookup = idcitylookup;
    }

    public int getCountrylookupIdcountrylookup() {
        return countrylookupIdcountrylookup;
    }

    public void setCountrylookupIdcountrylookup(int countrylookupIdcountrylookup) {
        this.countrylookupIdcountrylookup = countrylookupIdcountrylookup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcitylookup;
        hash += (int) countrylookupIdcountrylookup;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitylookupPK)) {
            return false;
        }
        CitylookupPK other = (CitylookupPK) object;
        if (this.idcitylookup != other.idcitylookup) {
            return false;
        }
        if (this.countrylookupIdcountrylookup != other.countrylookupIdcountrylookup) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CitylookupPK[ idcitylookup=" + idcitylookup + ", countrylookupIdcountrylookup=" + countrylookupIdcountrylookup + " ]";
    }
    
}
