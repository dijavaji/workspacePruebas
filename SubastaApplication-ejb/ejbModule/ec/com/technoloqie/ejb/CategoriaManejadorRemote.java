/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;


import javax.ejb.Remote;
import ec.com.technoloqie.entidades.Categoria;
import java.util.List;

/**
 *
 * @author thc
 */
@Remote
public interface CategoriaManejadorRemote {
    //public void crearUsuario(String nombre, String direccion, String email);
    public void crearCategoria(Categoria categoria);
    public Categoria obtenerCategoria(Integer codigo);
    public void eliminarCategoria(Categoria categoria);
    public Categoria actualizarCategoria(Categoria categoria);
    public List <Categoria> listarCategoria();
    
}
