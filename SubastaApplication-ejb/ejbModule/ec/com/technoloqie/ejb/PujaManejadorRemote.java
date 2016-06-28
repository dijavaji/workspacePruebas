/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.ejb;


import javax.ejb.Remote;
import ec.com.technoloqie.entidades.Puja;
import java.util.List;

/**
 *
 * @author thc
 */
@Remote
public interface PujaManejadorRemote {
     //public void crearUsuario(String nombre, String direccion, String email);
    public void crearPuja(Puja puja);
    public Puja obtenerPuja(Integer codigo);
    public void eliminarPuja(Puja puja);
    public Puja actualizarPuja(Puja puja);
    public List <Puja> listarPuja();
    
}
