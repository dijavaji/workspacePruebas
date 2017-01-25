package ec.com.technoloqie.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.technoloqie.entidades.Usuario;

/**
 * Session Bean implementation class UsuarioManejador
 */
@Stateless
@LocalBean
public class UsuarioManejador implements UsuarioManejadorRemote{
	
    @PersistenceContext(unitName = "VamosAlColeSmart1.0-ejb")

    private EntityManager em; 
	
    /**
     * Default constructor. 
     */
    public UsuarioManejador() {
        // TODO Auto-generated constructor stub
    }

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

}
