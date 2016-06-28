package ec.com.technoloqie.constructora.ejb;

import java.util.List;

import javax.ejb.Remote;

import ec.com.technoloqie.constructora.entidades.TipoUsuarioDTO;


@Remote
public interface TipoUsuarioManejadorRemote {
	
	 //public void crearUsuario(String nombre, String direccion, String email);
    public void crearTipoUsuario(TipoUsuarioDTO tipoUsuario);
    public TipoUsuarioDTO obtenerTipoUsuarioId(Integer codigo);
    public TipoUsuarioDTO obtenerTipoUsuarioNombre(String nombre);
    public void eliminarTipoUsuario(TipoUsuarioDTO tipoUsuario);
    public TipoUsuarioDTO actualizarTipoUsuario(TipoUsuarioDTO tipoUsuario);
    public List <TipoUsuarioDTO> listarTipoUsuario();

}
