package ec.com.technoloqie.ejb;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 * Session Bean implementation class Usuario
 */
@Stateless
@LocalBean
public class Usuario implements UsuarioRemote {

	
	 private EntityManager em; 

    /**
     * Default constructor. 
     */
    public Usuario() {
        // TODO Auto-generated constructor stub
    }

}
