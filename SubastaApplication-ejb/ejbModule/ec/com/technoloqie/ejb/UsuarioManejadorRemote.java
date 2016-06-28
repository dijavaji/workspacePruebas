/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;


import javax.ejb.Remote;
import ec.com.technoloqie.entidades.Usuario;
import java.util.List;

/**
 *
 * @author thc
 */
@Remote
public interface UsuarioManejadorRemote {
     //public void crearUsuario(String nombre, String direccion, String email);
    public void crearUsuario(Usuario usuario);
    public Usuario obtenerUsuario(Integer codigo);
    public void eliminarUsuario(Usuario usuario);
    public Usuario actualizarUsuario(Usuario usuario);
    public List <Usuario> listarUsuario();
}
