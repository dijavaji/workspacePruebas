/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;

import ec.com.technoloqie.entidades.Puja;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thc
 */
@Stateless
public class PujaManejador implements PujaManejadorRemote {
     @PersistenceContext(unitName = "SubastaApplication-ejbPU")

     private EntityManager em; 

    public void crearPuja(Puja puja) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Puja obtenerPuja(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminarPuja(Puja puja) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Puja actualizarPuja(Puja puja) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Puja> listarPuja() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
