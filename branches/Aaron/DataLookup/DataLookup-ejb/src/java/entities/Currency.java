/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
    @NamedQuery(name = "Currency.findByIdcurrency", query = "SELECT c FROM Currency c WHERE c.idcurrency = :idcurrency"),
    @NamedQuery(name = "Currency.findByCountryname", query = "SELECT c FROM Currency c WHERE c.countryname = :countryname"),
    @NamedQuery(name = "Currency.findByCurrencyname", query = "SELECT c FROM Currency c WHERE c.currencyname = :currencyname"),
    @NamedQuery(name = "Currency.findByCode3", query = "SELECT c FROM Currency c WHERE c.code3 = :code3"),
    @NamedQuery(name = "Currency.findByCurrencycode3", query = "SELECT c FROM Currency c WHERE c.currencycode3 = :currencycode3")})
public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCURRENCY")
    private Integer idcurrency;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODE3")
    private String code3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CURRENCYCODE3")
    private String currencycode3;
    @JoinColumn(name = "CODE2", referencedColumnName = "CODE2")
    @ManyToOne(optional = false)
    private Country code2;

    public Currency() {
    }

    public Currency(Integer idcurrency) {
        this.idcurrency = idcurrency;
    }

    public Currency(Integer idcurrency, String countryname, String currencyname, String code3, String currencycode3) {
        this.idcurrency = idcurrency;
        this.countryname = countryname;
        this.currencyname = currencyname;
        this.code3 = code3;
        this.currencycode3 = currencycode3;
    }

    public Integer getIdcurrency() {
        return idcurrency;
    }

    public void setIdcurrency(Integer idcurrency) {
        this.idcurrency = idcurrency;
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

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public String getCurrencycode3() {
        return currencycode3;
    }

    public void setCurrencycode3(String currencycode3) {
        this.currencycode3 = currencycode3;
    }

    public Country getCode2() {
        return code2;
    }

    public void setCode2(Country code2) {
        this.code2 = code2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurrency != null ? idcurrency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.idcurrency == null && other.idcurrency != null) || (this.idcurrency != null && !this.idcurrency.equals(other.idcurrency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Currency[ idcurrency=" + idcurrency + " ]";
    }
    
}
