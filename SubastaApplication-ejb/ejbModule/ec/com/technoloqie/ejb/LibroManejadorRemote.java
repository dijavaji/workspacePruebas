/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;


import javax.ejb.Remote;
import ec.com.technoloqie.entidades.Libro;
import java.util.List;

/**
 *
 * @author thc
 */
@Remote
public interface LibroManejadorRemote {
     //public void crearUsuario(String nombre, String direccion, String email);
    public void crearLibro(Libro libro);
    public Libro obtenerLibro(Integer codigo);
    public void eliminarLibro(Libro libro);
    public Libro actualizarLibro(Libro libro);
    public List <Libro> listarLibro();
    
}
