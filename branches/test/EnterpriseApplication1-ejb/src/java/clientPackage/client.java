/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientPackage;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Riaan
 */
@Entity
public class client implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;

    public client() 
    {
        
    }

    public client(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    client(String id__firstName, String surname) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String toString() 
    {
        return "id " + this.id + this.name + " " + this.surname;
    }

}
