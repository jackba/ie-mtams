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
public class SessionsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSESSIONS")
    private int idsessions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNTS_IDACCOUNTS")
    private int accountsIdaccounts;

    public SessionsPK() {
    }

    public SessionsPK(int idsessions, int accountsIdaccounts) {
        this.idsessions = idsessions;
        this.accountsIdaccounts = accountsIdaccounts;
    }

    public int getIdsessions() {
        return idsessions;
    }

    public void setIdsessions(int idsessions) {
        this.idsessions = idsessions;
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
        hash += (int) idsessions;
        hash += (int) accountsIdaccounts;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SessionsPK)) {
            return false;
        }
        SessionsPK other = (SessionsPK) object;
        if (this.idsessions != other.idsessions) {
            return false;
        }
        if (this.accountsIdaccounts != other.accountsIdaccounts) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SessionsPK[ idsessions=" + idsessions + ", accountsIdaccounts=" + accountsIdaccounts + " ]";
    }
    
}
