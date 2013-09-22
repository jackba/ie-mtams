/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riaan
 */
@Entity
@Table(name = "APPROVALCHAIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Approvalchain.findAll", query = "SELECT a FROM Approvalchain a"),
    @NamedQuery(name = "Approvalchain.findById", query = "SELECT a FROM Approvalchain a WHERE a.id = :id"),
    @NamedQuery(name = "Approvalchain.findByApplicationcomplete", query = "SELECT a FROM Approvalchain a WHERE a.applicationcomplete = :applicationcomplete"),
    @NamedQuery(name = "Approvalchain.findBySchooladmincomplete", query = "SELECT a FROM Approvalchain a WHERE a.schooladmincomplete = :schooladmincomplete"),
    @NamedQuery(name = "Approvalchain.findByHodcomplete", query = "SELECT a FROM Approvalchain a WHERE a.hodcomplete = :hodcomplete"),
    @NamedQuery(name = "Approvalchain.findByFinancecomplete", query = "SELECT a FROM Approvalchain a WHERE a.financecomplete = :financecomplete"),
    @NamedQuery(name = "Approvalchain.findByPvccomplete", query = "SELECT a FROM Approvalchain a WHERE a.pvccomplete = :pvccomplete"),
    @NamedQuery(name = "Approvalchain.findByFinalcomplete", query = "SELECT a FROM Approvalchain a WHERE a.finalcomplete = :finalcomplete")})
public class Approvalchain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "APPLICATIONCOMPLETE")
    private Integer applicationcomplete;
    @Column(name = "SCHOOLADMINCOMPLETE")
    private Integer schooladmincomplete;
    @Column(name = "HODCOMPLETE")
    private Integer hodcomplete;
    @Column(name = "FINANCECOMPLETE")
    private Integer financecomplete;
    @Column(name = "PVCCOMPLETE")
    private Integer pvccomplete;
    @Column(name = "FINALCOMPLETE")
    private Integer finalcomplete;
    @JoinColumn(name = "SCHOOLADMINAPPROVED", referencedColumnName = "IDAPPROVAL")
    @ManyToOne
    private Approval schooladminapproved;
    @JoinColumn(name = "HODAPPROVED", referencedColumnName = "IDAPPROVAL")
    @ManyToOne
    private Approval hodapproved;
    @JoinColumn(name = "FINANCEAPPROVED", referencedColumnName = "IDAPPROVAL")
    @ManyToOne
    private Approval financeapproved;
    @JoinColumn(name = "PVCAPPROVED", referencedColumnName = "IDAPPROVAL")
    @ManyToOne
    private Approval pvcapproved;
    @JoinColumn(name = "FINALAPPROVED", referencedColumnName = "IDAPPROVAL")
    @ManyToOne
    private Approval finalapproved;
    @JoinColumn(name = "APPLICATIONID", referencedColumnName = "IDAPPLICATION")
    @ManyToOne(optional = false)
    private Application applicationid;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "IDACCOUNT")
    @ManyToOne(optional = false)
    private Account accountid;
    @JoinColumn(name = "SCHOOLADMIN", referencedColumnName = "IDACCOUNT")
    @ManyToOne
    private Account schooladmin;
    @JoinColumn(name = "HOD", referencedColumnName = "IDACCOUNT")
    @ManyToOne
    private Account hod;
    @JoinColumn(name = "FINANCE", referencedColumnName = "IDACCOUNT")
    @ManyToOne
    private Account finance;
    @JoinColumn(name = "PVC", referencedColumnName = "IDACCOUNT")
    @ManyToOne
    private Account pvc;
    @JoinColumn(name = "FINALFINANCE", referencedColumnName = "IDACCOUNT")
    @ManyToOne
    private Account finalfinance;

    public Approvalchain() {
    }

    public Approvalchain(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicationcomplete() {
        return applicationcomplete;
    }

    public void setApplicationcomplete(Integer applicationcomplete) {
        this.applicationcomplete = applicationcomplete;
    }

    public Integer getSchooladmincomplete() {
        return schooladmincomplete;
    }

    public void setSchooladmincomplete(Integer schooladmincomplete) {
        this.schooladmincomplete = schooladmincomplete;
    }

    public Integer getHodcomplete() {
        return hodcomplete;
    }

    public void setHodcomplete(Integer hodcomplete) {
        this.hodcomplete = hodcomplete;
    }

    public Integer getFinancecomplete() {
        return financecomplete;
    }

    public void setFinancecomplete(Integer financecomplete) {
        this.financecomplete = financecomplete;
    }

    public Integer getPvccomplete() {
        return pvccomplete;
    }

    public void setPvccomplete(Integer pvccomplete) {
        this.pvccomplete = pvccomplete;
    }

    public Integer getFinalcomplete() {
        return finalcomplete;
    }

    public void setFinalcomplete(Integer finalcomplete) {
        this.finalcomplete = finalcomplete;
    }

    public Approval getSchooladminapproved() {
        return schooladminapproved;
    }

    public void setSchooladminapproved(Approval schooladminapproved) {
        this.schooladminapproved = schooladminapproved;
    }

    public Approval getHodapproved() {
        return hodapproved;
    }

    public void setHodapproved(Approval hodapproved) {
        this.hodapproved = hodapproved;
    }

    public Approval getFinanceapproved() {
        return financeapproved;
    }

    public void setFinanceapproved(Approval financeapproved) {
        this.financeapproved = financeapproved;
    }

    public Approval getPvcapproved() {
        return pvcapproved;
    }

    public void setPvcapproved(Approval pvcapproved) {
        this.pvcapproved = pvcapproved;
    }

    public Approval getFinalapproved() {
        return finalapproved;
    }

    public void setFinalapproved(Approval finalapproved) {
        this.finalapproved = finalapproved;
    }

    public Application getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(Application applicationid) {
        this.applicationid = applicationid;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    public Account getSchooladmin() {
        return schooladmin;
    }

    public void setSchooladmin(Account schooladmin) {
        this.schooladmin = schooladmin;
    }

    public Account getHod() {
        return hod;
    }

    public void setHod(Account hod) {
        this.hod = hod;
    }

    public Account getFinance() {
        return finance;
    }

    public void setFinance(Account finance) {
        this.finance = finance;
    }

    public Account getPvc() {
        return pvc;
    }

    public void setPvc(Account pvc) {
        this.pvc = pvc;
    }

    public Account getFinalfinance() {
        return finalfinance;
    }

    public void setFinalfinance(Account finalfinance) {
        this.finalfinance = finalfinance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Approvalchain)) {
            return false;
        }
        Approvalchain other = (Approvalchain) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Approvalchain[ id=" + id + " ]";
    }
    
}
