/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;


import javax.ejb.Remote;
import ec.com.technoloqie.entidades.UsuarioPuja;
import java.util.List;

/**
 *
 * @author thc
 */
@Remote
public interface UsuarioPujaManejadorRemote {
    
    //public void crearUsuario(String nombre, String direccion, String email);
    public void crearUsuarioPuja(UsuarioPuja usuarioPuja);
    public UsuarioPuja obtenerUsuarioPuja(Integer codigo);
    public void eliminarUsuarioPuja(UsuarioPuja usuarioPuja);
    public UsuarioPuja actualizarUsuarioPuja(UsuarioPuja usuarioPuja);
    public List <UsuarioPuja> listarUsuarioPuja();
    
}
