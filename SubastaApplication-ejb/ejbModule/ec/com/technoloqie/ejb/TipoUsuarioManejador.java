/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.com.technoloqie.entidades.TipoUsuario;

/**
 *
 * @author thc
 */
@Stateless
public class TipoUsuarioManejador extends AbstractManejador<TipoUsuario>  {
	
	@PersistenceContext(unitName = "SubastaApplication-ejbPU")
    private EntityManager em; 
   
	
    public TipoUsuarioManejador() {
		super(TipoUsuario.class);
	}


	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

    
}
