/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Badger
 */
@Embeddable
public class TravelprofilePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRAVELPROFILE")
    private int idtravelprofile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNTS_IDACCOUNTS")
    private int accountsIdaccounts;

    public TravelprofilePK() {
    }

    public TravelprofilePK(int idtravelprofile, int accountsIdaccounts) {
        this.idtravelprofile = idtravelprofile;
        this.accountsIdaccounts = accountsIdaccounts;
    }

    public int getIdtravelprofile() {
        return idtravelprofile;
    }

    public void setIdtravelprofile(int idtravelprofile) {
        this.idtravelprofile = idtravelprofile;
    }

    public int getAccountsIdaccounts() {
        return accountsIdaccounts;
    }

    public void setAccountsIdaccounts(int accountsIdaccounts) {
        this.accountsIdaccounts = accountsIdaccounts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtravelprofile;
        hash += (int) accountsIdaccounts;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TravelprofilePK)) {
            return false;
        }
        TravelprofilePK other = (TravelprofilePK) object;
        if (this.idtravelprofile != other.idtravelprofile) {
            return false;
        }
        if (this.accountsIdaccounts != other.accountsIdaccounts) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TravelprofilePK[ idtravelprofile=" + idtravelprofile + ", accountsIdaccounts=" + accountsIdaccounts + " ]";
    }
    
}
