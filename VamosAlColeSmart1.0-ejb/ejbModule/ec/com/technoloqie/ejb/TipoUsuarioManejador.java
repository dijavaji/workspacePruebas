package ec.com.technoloqie.ejb;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ec.com.technoloqie.entidades.TipoUsuario;


/**
 * Session Bean implementation class TipoUsuarioManejador
 */
@Stateless
@LocalBean
public class TipoUsuarioManejador implements TipoUsuarioManejadorRemote {

	 @PersistenceContext(unitName = "VamosAlColeSmart1.0-ejb")
	 private EntityManager em; 
    /**
     * Default constructor. 
     */
    public TipoUsuarioManejador() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void crearTipoUsuario(TipoUsuario tipoUsuario) {
		em.persist(tipoUsuario);
	}

	@Override
	public TipoUsuario obtenerTipoUsuarioId(Integer codigo) {
		 TipoUsuario tipoUsuario = new TipoUsuario();
	       try {
	            Query query = em.createNamedQuery("TipoUsuario.findById");
	            query.setParameter("tipoUsuarioId", codigo);
	            tipoUsuario = (TipoUsuario) query.getSingleResult();
	            System.out.println("tipousuario.Nombre = " + tipoUsuario.getNombre());
	        } catch (NoResultException e) {
	            System.out.println("El usuario no se encuentra registrado."+ e);
	        }
	        return tipoUsuario;
	}

	@Override
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

	@Override
	public void eliminarTipoUsuario(TipoUsuario tipoUsuario) {
		//tipoUsuario = em.merge(tipoUsuario);
        em.remove(tipoUsuario);
        em.flush();
	}

	@Override
	public TipoUsuario actualizarTipoUsuario(TipoUsuario tipoUsuario) {
		//tipoUsuario = em.merge(tipoUsuario);
        em.merge(tipoUsuario);
        em.flush();
        return tipoUsuario;
	}

	@Override
	public List<TipoUsuario> listarTipoUsuario() {
		  List<TipoUsuario> tipoUsuarios = new ArrayList();
	        Query sql = em.createNamedQuery("TipoUsuario.findAll");
	        tipoUsuarios = sql.getResultList();
	        return tipoUsuarios;
	}

}
