/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;

import ec.com.technoloqie.entidades.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.com.technoloqie.entidades.Categoria;
import java.util.ArrayList;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author thc
 */
@Stateless
public class CategoriaManejador implements CategoriaManejadorRemote {
    
     @PersistenceContext(unitName = "SubastaAplication1.0-ejbPU")

     private EntityManager em; 

    public void crearCategoria(Categoria categoria) {
        em.persist(categoria);
    }

    public Categoria obtenerCategoria(Integer codigo) {
         Categoria categoria = new Categoria();
       try {
            Query query = em.createNamedQuery("Categoria.findByCategoriaId");
            query.setParameter("categoriaId", codigo);
            categoria = (Categoria) query.getSingleResult();
            System.out.println("categoria.Nombre = " + categoria.getNombre());
        } catch (NoResultException e) {
            System.out.println("la categoria no se encuentra registrado."+ e);
        }
        return categoria;
    }

    public void eliminarCategoria(Categoria categoria) {
        //tipoUsuario = em.merge(tipoUsuario);
        em.remove(categoria);
        em.flush();
    }

    public Categoria actualizarCategoria(Categoria categoria) {
       //tipoUsuario = em.merge(tipoUsuario);
        em.merge(categoria);
        em.flush();
        return categoria;
    }

    public List<Categoria> listarCategoria() {
        List<Categoria> categorias = new ArrayList();
        Query sql = em.createNamedQuery("Categoria.findAll");
        categorias = sql.getResultList();
        return categorias;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
