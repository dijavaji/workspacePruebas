package ec.com.technoloqie.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.technoloqie.ejb.TipoUsuarioManejador;
import ec.com.technoloqie.ejb.UsuarioManejador;
import ec.com.technoloqie.entidades.TipoUsuario;
import ec.com.technoloqie.entidades.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	private Usuario usuario;
	private List <TipoUsuario> tipoUsuarios;
	
	@Inject
	private UsuarioManejador usuarioFacade;
	
	@Inject
	private TipoUsuarioManejador tipUsuarioFacade;
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
	}
	
	
	public void actualizaModeloUsuario(){
		// actualiza trabajo
		if(usuario.getId()!=null)
			usuario = usuarioFacade.find(usuario.getId());
		// carga drones para selectOneMenu
		this.tipoUsuarios = tipUsuarioFacade.findAll();
	}
	
	public String aceptar(){
		try{
			usuarioFacade.edit(usuario);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación realizada correctamente", ""));
			return "/pages/usuarios?faces-redirect=true";
		}catch(EJBException e){
			
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getCause().toString(), ""));
			return null;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<TipoUsuario> getTipoUsuarios() {
		return tipoUsuarios;
	}


	public void setTipoUsuarios(List<TipoUsuario> tipoUsuarios) {
		this.tipoUsuarios = tipoUsuarios;
	}


}
