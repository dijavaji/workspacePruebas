/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.com.technoloqie.entidades.Usuario;

/**
 *
 * @author thc
 */
@Stateless
@LocalBean
public class UsuarioManejador extends AbstractManejador<Usuario> {
    
	@PersistenceContext(unitName = "SubastaApplication-ejbPU")
     private EntityManager em; 
	
	public UsuarioManejador(){
		super(Usuario.class);
	}

     protected EntityManager getEntityManager(){
     	return em;
     }
     
}
