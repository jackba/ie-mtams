/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Badger
 */
@Entity
@Table(name = "TASK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findByIdtasks", query = "SELECT t FROM Task t WHERE t.idtasks = :idtasks"),
    @NamedQuery(name = "Task.findByTask", query = "SELECT t FROM Task t WHERE t.task = :task"),
    @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description")})
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTASKS")
    private Integer idtasks;
    @Size(max = 45)
    @Column(name = "TASK")
    private String task;
    @Size(max = 512)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tasksIdtasks")
    private List<Permission> permissionList;

    public Task() {
    }

    public Task(Integer idtasks) {
        this.idtasks = idtasks;
    }

    public Integer getIdtasks() {
        return idtasks;
    }

    public void setIdtasks(Integer idtasks) {
        this.idtasks = idtasks;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtasks != null ? idtasks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.idtasks == null && other.idtasks != null) || (this.idtasks != null && !this.idtasks.equals(other.idtasks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Task[ idtasks=" + idtasks + " ]";
    }
    
}
