/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;

import ec.com.technoloqie.entidades.UsuarioPuja;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thc
 */
@Stateless
public class UsuarioPujaManejador implements UsuarioPujaManejadorRemote {
    
     @PersistenceContext(unitName = "SubastaApplication-ejbPU")

     private EntityManager em; 

    public void crearUsuarioPuja(UsuarioPuja usuarioPuja) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public UsuarioPuja obtenerUsuarioPuja(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminarUsuarioPuja(UsuarioPuja usuarioPuja) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public UsuarioPuja actualizarUsuarioPuja(UsuarioPuja usuarioPuja) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<UsuarioPuja> listarUsuarioPuja() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
