package ec.com.technoloqie.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.technoloqie.ejb.UsuarioManejador;
import ec.com.technoloqie.entidades.Usuario;

@Named
@ViewScoped
public class UsuariosController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuarios;
	private Usuario usuarioSeleccionado;
	@Inject
	private UsuarioManejador usuarioFacade;

	public UsuariosController() {
		// TODO Auto-generated constructor stub
	}
	
	public String eliminar(Usuario usuario){
		usuarioFacade.remove(usuario);
		actualizaModeloUsuarios();
		return "";
	}
    
	public void actualizaModeloUsuarios(){
		usuarios = usuarioFacade.findAll();
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
