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
 * @author Marco Remane
 */
@Embeddable
public class SessionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "IDSESSIONS")
    private int idsessions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNTID")
    private int accountid;

    public SessionPK() {
    }

    public SessionPK(int idsessions, int accountid) {
        this.idsessions = idsessions;
        this.accountid = accountid;
    }

    public int getIdsessions() {
        return idsessions;
    }

    public void setIdsessions(int idsessions) {
        this.idsessions = idsessions;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idsessions;
        hash += (int) accountid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SessionPK)) {
            return false;
        }
        SessionPK other = (SessionPK) object;
        if (this.idsessions != other.idsessions) {
            return false;
        }
        if (this.accountid != other.accountid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SessionPK[ idsessions=" + idsessions + ", accountid=" + accountid + " ]";
    }
    
}
