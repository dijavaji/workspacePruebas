/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;

import ec.com.technoloqie.entidades.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thc
 */
@Stateless
public class TipoUsuarioManejador implements TipoUsuarioManejadorRemote {
    
    @PersistenceContext(unitName = "SubastaAplication1.0-ejbPU")

     private EntityManager em; 
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void crearTipoUsuario(TipoUsuario tipoUsuario) {
        em.persist(tipoUsuario);
    }

    public TipoUsuario obtenerTipoUsuarioId(Integer codigo) {
        TipoUsuario tipoUsuario = new TipoUsuario();
       try {
            Query query = em.createNamedQuery("TipoUsuario.findById");
            query.setParameter("tipoUsuarioId", codigo);
            tipoUsuario = (TipoUsuario) query.getSingleResult();
            System.out.println("estudiante.Nombre = " + tipoUsuario.getNombre());
        } catch (NoResultException e) {
            System.out.println("El usuario no se encuentra registrado."+ e);
        }
        return tipoUsuario;
    }

    public void eliminarTipoUsuario(TipoUsuario tipoUsuario) {
        //tipoUsuario = em.merge(tipoUsuario);
        em.remove(tipoUsuario);
        em.flush();
    }

    public TipoUsuario actualizarTipoUsuario(TipoUsuario tipoUsuario) {
        //tipoUsuario = em.merge(tipoUsuario);
        em.merge(tipoUsuario);
        em.flush();
        return tipoUsuario;
    }

    public List<TipoUsuario> listarTipoUsuario() {
         List<TipoUsuario> tipoUsuarios = new ArrayList();
        Query sql = em.createNamedQuery("TipoUsuario.findAll");
        tipoUsuarios = sql.getResultList();
        return tipoUsuarios;
    }

    public TipoUsuario obtenerTipoUsuarioNombre(String nombre) {
        TipoUsuario tipoUsuario = new TipoUsuario();
       try {
            Query query = em.createNamedQuery("TipoUsuario.findByNombre");
            query.setParameter("nombre", nombre);
            tipoUsuario = (TipoUsuario) query.getSingleResult();
            System.out.println("estudiante.Nombre = " + tipoUsuario.getNombre());
        } catch (NoResultException e) {
            System.out.println("El tipo usuario no se encuentra registrado."+ e);
        }
        return tipoUsuario;
    }
    
}
