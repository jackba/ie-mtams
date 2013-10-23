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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riaan
 */
@Entity
@Table(name = "STAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stage.findAll", query = "SELECT s FROM Stage s"),
    @NamedQuery(name = "Stage.findByIdstage", query = "SELECT s FROM Stage s WHERE s.idstage = :idstage"),
    @NamedQuery(name = "Stage.findByStage", query = "SELECT s FROM Stage s WHERE s.stage = :stage")})
public class Stage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDSTAGE")
    private Integer idstage;
    @Size(max = 45)
    @Column(name = "STAGE")
    private String stage;

    public Stage() {
    }

    public Stage(Integer idstage) {
        this.idstage = idstage;
    }

    public Integer getIdstage() {
        return idstage;
    }

    public void setIdstage(Integer idstage) {
        this.idstage = idstage;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstage != null ? idstage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stage)) {
            return false;
        }
        Stage other = (Stage) object;
        if ((this.idstage == null && other.idstage != null) || (this.idstage != null && !this.idstage.equals(other.idstage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Stage[ idstage=" + idstage + " ]";
    }
    
}
