/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;

import ec.com.technoloqie.entidades.Usuario;
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
public class UsuarioManejador implements UsuarioManejadorRemote {
    
     @PersistenceContext(unitName = "SubastaAplication1.0-ejbPU")

     private EntityManager em; 

    public void crearUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    public Usuario obtenerUsuario(Integer codigo) {
        Usuario usuario = new Usuario();
       try {
            Query query = em.createNamedQuery("TipoUsuario.findByTipoUsuarioId");
            query.setParameter("usuarioId", codigo);
            usuario = (Usuario) query.getSingleResult();
            System.out.println("usuario.Nombre = " + usuario.getNombre());
        } catch (NoResultException e) {
            System.out.println("El usuario no se encuentra registrado."+ e);
        }
        return usuario;
    }

    public void eliminarUsuario(Usuario usuario) {
        //tipoUsuario = em.merge(tipoUsuario);
        em.remove(usuario);
        em.flush();
    }

    public Usuario actualizarUsuario(Usuario usuario) {
       //tipoUsuario = em.merge(tipoUsuario);
        em.merge(usuario);
        em.flush();
        return usuario;
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> tipoUsuarios = new ArrayList();
        Query sql = em.createNamedQuery("Usuario.findAll");
        tipoUsuarios = sql.getResultList();
        return tipoUsuarios;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
