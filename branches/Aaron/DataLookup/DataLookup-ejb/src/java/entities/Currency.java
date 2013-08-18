/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "CURRENCY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @NamedQuery(name = "Currency.findByCountryname", query = "SELECT c FROM Currency c WHERE c.countryname = :countryname"),
    @NamedQuery(name = "Currency.findByCurrencyname", query = "SELECT c FROM Currency c WHERE c.currencyname = :currencyname"),
    @NamedQuery(name = "Currency.findByCode2", query = "SELECT c FROM Currency c WHERE c.currencyPK.code2 = :code2"),
    @NamedQuery(name = "Currency.findByCode3", query = "SELECT c FROM Currency c WHERE c.currencyPK.code3 = :code3"),
    @NamedQuery(name = "Currency.findByCurrencycode3", query = "SELECT c FROM Currency c WHERE c.currencyPK.currencycode3 = :currencycode3")})
public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CurrencyPK currencyPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "COUNTRYNAME")
    private String countryname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CURRENCYNAME")
    private String currencyname;

    public Currency() {
    }

    public Currency(CurrencyPK currencyPK) {
        this.currencyPK = currencyPK;
    }

    public Currency(CurrencyPK currencyPK, String countryname, String currencyname) {
        this.currencyPK = currencyPK;
        this.countryname = countryname;
        this.currencyname = currencyname;
    }

    public Currency(String code2, String code3, String currencycode3) {
        this.currencyPK = new CurrencyPK(code2, code3, currencycode3);
    }

    public CurrencyPK getCurrencyPK() {
        return currencyPK;
    }

    public void setCurrencyPK(CurrencyPK currencyPK) {
        this.currencyPK = currencyPK;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCurrencyname() {
        return currencyname;
    }

    public void setCurrencyname(String currencyname) {
        this.currencyname = currencyname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyPK != null ? currencyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.currencyPK == null && other.currencyPK != null) || (this.currencyPK != null && !this.currencyPK.equals(other.currencyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Currency[ currencyPK=" + currencyPK + " ]";
    }
    
}
