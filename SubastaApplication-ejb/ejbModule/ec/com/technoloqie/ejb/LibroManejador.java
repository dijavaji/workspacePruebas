/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;

import ec.com.technoloqie.entidades.Libro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thc
 */
@Stateless
public class LibroManejador implements LibroManejadorRemote {
     @PersistenceContext(unitName = "SubastaApplication-ejbPU")

     private EntityManager em; 

    public void crearLibro(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Libro obtenerLibro(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminarLibro(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Libro actualizarLibro(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Libro> listarLibro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
