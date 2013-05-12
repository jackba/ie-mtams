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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco Remane
 */
@Entity
@Table(name = "SESSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s"),
    @NamedQuery(name = "Session.findByIdsessions", query = "SELECT s FROM Session s WHERE s.sessionPK.idsessions = :idsessions"),
    @NamedQuery(name = "Session.findByAccountid", query = "SELECT s FROM Session s WHERE s.sessionPK.accountid = :accountid"),
    @NamedQuery(name = "Session.findByDate", query = "SELECT s FROM Session s WHERE s.date = :date"),
    @NamedQuery(name = "Session.findByExpires", query = "SELECT s FROM Session s WHERE s.expires = :expires")})
public class Session implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SessionPK sessionPK;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "EXPIRES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "IDACCOUNT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Account account;

    public Session() {
    }

    public Session(SessionPK sessionPK) {
        this.sessionPK = sessionPK;
    }

    public Session(int idsessions, int accountid) {
        this.sessionPK = new SessionPK(idsessions, accountid);
    }

    public SessionPK getSessionPK() {
        return sessionPK;
    }

    public void setSessionPK(SessionPK sessionPK) {
        this.sessionPK = sessionPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionPK != null ? sessionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.sessionPK == null && other.sessionPK != null) || (this.sessionPK != null && !this.sessionPK.equals(other.sessionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Session[ sessionPK=" + sessionPK + " ]";
    }
    
}
