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
     void crearUsuario(Usuario usuario);
     Usuario obtenerUsuario(Integer codigo);
     void eliminarUsuario(Usuario usuario);
     Usuario actualizarUsuario(Usuario usuario);
     List <Usuario> listarUsuario();
}
