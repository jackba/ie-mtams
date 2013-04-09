/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import clientPackage.client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Riaan
 */
@Stateless
public class dataAcess implements dataAcessLocal 
{
    @PersistenceContext
    private EntityManager em;
    public void insert(client newClient)
    {
        em.persist(newClient);
        throw new IllegalArgumentException("Database level");
    }
    
    public List<client> findAll()
    {
        Query q = em.createQuery("select * from APP.CLIENT");
        List<client> result = q.getResultList();
        return result;
        
    }
    
}
