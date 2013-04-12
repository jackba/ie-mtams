/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "SESSIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessions.findAll", query = "SELECT s FROM Sessions s"),
    @NamedQuery(name = "Sessions.findByIdsessions", query = "SELECT s FROM Sessions s WHERE s.sessionsPK.idsessions = :idsessions"),
    @NamedQuery(name = "Sessions.findByAccountsIdaccounts", query = "SELECT s FROM Sessions s WHERE s.sessionsPK.accountsIdaccounts = :accountsIdaccounts"),
    @NamedQuery(name = "Sessions.findByDate", query = "SELECT s FROM Sessions s WHERE s.date = :date"),
    @NamedQuery(name = "Sessions.findByExpirydate", query = "SELECT s FROM Sessions s WHERE s.expirydate = :expirydate")})
public class Sessions implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SessionsPK sessionsPK;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "EXPIRYDATE")
    @Temporal(TemporalType.DATE)
    private Date expirydate;

    public Sessions() {
    }

    public Sessions(SessionsPK sessionsPK) {
        this.sessionsPK = sessionsPK;
    }

    public Sessions(int idsessions, int accountsIdaccounts) {
        this.sessionsPK = new SessionsPK(idsessions, accountsIdaccounts);
    }

    public SessionsPK getSessionsPK() {
        return sessionsPK;
    }

    public void setSessionsPK(SessionsPK sessionsPK) {
        this.sessionsPK = sessionsPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionsPK != null ? sessionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessions)) {
            return false;
        }
        Sessions other = (Sessions) object;
        if ((this.sessionsPK == null && other.sessionsPK != null) || (this.sessionsPK != null && !this.sessionsPK.equals(other.sessionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Sessions[ sessionsPK=" + sessionsPK + " ]";
    }
    
}
