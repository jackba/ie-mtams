/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco Remane
 */
@Entity
@Table(name = "PERSONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findBySchool", query = "SELECT p FROM Personal p WHERE p.school = :school"),
    @NamedQuery(name = "Personal.findByStaffnumber", query = "SELECT p FROM Personal p WHERE p.staffnumber = :staffnumber"),
    @NamedQuery(name = "Personal.findByTitle", query = "SELECT p FROM Personal p WHERE p.title = :title"),
    @NamedQuery(name = "Personal.findByFname", query = "SELECT p FROM Personal p WHERE p.fname = :fname"),
    @NamedQuery(name = "Personal.findByGname", query = "SELECT p FROM Personal p WHERE p.gname = :gname")})
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "SCHOOL")
    private String school;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STAFFNUMBER")
    private Integer staffnumber;
    @Size(max = 5)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 45)
    @Column(name = "FNAME")
    private String fname;
    @Size(max = 45)
    @Column(name = "GNAME")
    private String gname;

    public Personal() {
    }

    public Personal(Integer staffnumber) {
        this.staffnumber = staffnumber;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getStaffnumber() {
        return staffnumber;
    }

    public void setStaffnumber(Integer staffnumber) {
        this.staffnumber = staffnumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffnumber != null ? staffnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.staffnumber == null && other.staffnumber != null) || (this.staffnumber != null && !this.staffnumber.equals(other.staffnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Personal[ staffnumber=" + staffnumber + " ]";
    }
    
}
