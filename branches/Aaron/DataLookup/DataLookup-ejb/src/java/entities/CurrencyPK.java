/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aaron
 */
@Embeddable
public class CurrencyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODE2")
    private String code2;
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

    public CurrencyPK() {
    }

    public CurrencyPK(String code2, String code3, String currencycode3) {
        this.code2 = code2;
        this.code3 = code3;
        this.currencycode3 = currencycode3;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code2 != null ? code2.hashCode() : 0);
        hash += (code3 != null ? code3.hashCode() : 0);
        hash += (currencycode3 != null ? currencycode3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrencyPK)) {
            return false;
        }
        CurrencyPK other = (CurrencyPK) object;
        if ((this.code2 == null && other.code2 != null) || (this.code2 != null && !this.code2.equals(other.code2))) {
            return false;
        }
        if ((this.code3 == null && other.code3 != null) || (this.code3 != null && !this.code3.equals(other.code3))) {
            return false;
        }
        if ((this.currencycode3 == null && other.currencycode3 != null) || (this.currencycode3 != null && !this.currencycode3.equals(other.currencycode3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CurrencyPK[ code2=" + code2 + ", code3=" + code3 + ", currencycode3=" + currencycode3 + " ]";
    }
    
}
