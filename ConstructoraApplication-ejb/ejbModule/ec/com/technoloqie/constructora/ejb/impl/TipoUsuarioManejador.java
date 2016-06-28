package ec.com.technoloqie.constructora.ejb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.technoloqie.constructora.ejb.TipoUsuarioManejadorRemote;
import ec.com.technoloqie.constructora.entidades.TipoUsuarioDTO;

/**
 * Session Bean implementation class TipoUsuarioManejador
 */
@Stateless
@LocalBean
public class TipoUsuarioManejador implements TipoUsuarioManejadorRemote {
	
	 @PersistenceContext(unitName = "SubastaAplication1.0-ejbPU")

     private EntityManager em; 
	 
	 // Add business logic below. (Right-click in editor and choose
	    // "Insert Code > Add Business Method")

	    public void crearTipoUsuario(TipoUsuarioDTO tipoUsuario) {
	        em.persist(tipoUsuario);
	    }

	    public TipoUsuarioDTO obtenerTipoUsuarioId(Integer codigo) {
	    	TipoUsuarioDTO tipoUsuario = new TipoUsuarioDTO();
	       try {
	            Query query = em.createNamedQuery("TipoUsuario.findById");
	            query.setParameter("tipoUsuarioId", codigo);
	            tipoUsuario = (TipoUsuarioDTO) query.getSingleResult();
	            System.out.println("estudiante.Nombre = " + tipoUsuario.getNombre());
	        } catch (NoResultException e) {
	            System.out.println("El usuario no se encuentra registrado."+ e);
	        }
	        return tipoUsuario;
	    }

	    public void eliminarTipoUsuario(TipoUsuarioDTO tipoUsuario) {
	        //tipoUsuario = em.merge(tipoUsuario);
	        em.remove(tipoUsuario);
	        em.flush();
	    }

	    public TipoUsuarioDTO actualizarTipoUsuario(TipoUsuarioDTO tipoUsuario) {
	        //tipoUsuario = em.merge(tipoUsuario);
	        em.merge(tipoUsuario);
	        em.flush();
	        return tipoUsuario;
	    }

	    public List<TipoUsuarioDTO> listarTipoUsuario() {
	         List<TipoUsuarioDTO> tipoUsuarios = new ArrayList();
	        Query sql = em.createNamedQuery("TipoUsuario.findAll");
	        tipoUsuarios = sql.getResultList();
	        return tipoUsuarios;
	    }

	    public TipoUsuarioDTO obtenerTipoUsuarioNombre(String nombre) {
	    	TipoUsuarioDTO tipoUsuario = new TipoUsuarioDTO();
	       try {
	            Query query = em.createNamedQuery("TipoUsuario.findByNombre");
	            query.setParameter("nombre", nombre);
	            tipoUsuario = (TipoUsuarioDTO) query.getSingleResult();
	            System.out.println("estudiante.Nombre = " + tipoUsuario.getNombre());
	        } catch (NoResultException e) {
	            System.out.println("El tipo usuario no se encuentra registrado."+ e);
	        }
	        return tipoUsuario;
	    }

}
