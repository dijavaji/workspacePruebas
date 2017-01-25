package ec.com.technoloqie.ejb;

import java.util.List;
import javax.ejb.Remote;
import ec.com.technoloqie.entidades.TipoUsuario;

@Remote
public interface TipoUsuarioManejadorRemote {
	//public void crearUsuario(String nombre, String direccion, String email);
    public void crearTipoUsuario(TipoUsuario tipoUsuario);
    public TipoUsuario obtenerTipoUsuarioId(Integer codigo);
    public TipoUsuario obtenerTipoUsuarioNombre(String nombre);
    public void eliminarTipoUsuario(TipoUsuario tipoUsuario);
    public TipoUsuario actualizarTipoUsuario(TipoUsuario tipoUsuario);
    public List <TipoUsuario> listarTipoUsuario();
}
