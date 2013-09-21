/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "SESSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s"),
    @NamedQuery(name = "Session.findByIdsessions", query = "SELECT s FROM Session s WHERE s.idsessions = :idsessions"),
    @NamedQuery(name = "Session.findByDate", query = "SELECT s FROM Session s WHERE s.date = :date"),
    @NamedQuery(name = "Session.findByExpires", query = "SELECT s FROM Session s WHERE s.expires = :expires")})
public class Session implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDSESSIONS")
    private Integer idsessions;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "EXPIRES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "IDACCOUNT")
    @ManyToOne(optional = false)
    private Account accountid;

    public Session() {
    }

    public Session(Integer idsessions) {
        this.idsessions = idsessions;
    }

    public Integer getIdsessions() {
        return idsessions;
    }

    public void setIdsessions(Integer idsessions) {
        this.idsessions = idsessions;
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

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsessions != null ? idsessions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.idsessions == null && other.idsessions != null) || (this.idsessions != null && !this.idsessions.equals(other.idsessions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Session[ idsessions=" + idsessions + " ]";
    }
    
}
