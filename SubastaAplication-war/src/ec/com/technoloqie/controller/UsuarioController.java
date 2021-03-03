package ec.com.technoloqie.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import ec.com.technoloqie.entidades.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	private Usuario usuario;
	private List<Drone> drones;
	private PuntoRuta puntoRutaSeleccionado;
	
	private PuntoRuta puntoRutaNuevo = new PuntoRuta();
	
	private Integer indiceFilaSeleccionada;
	
	@Inject
	private TrabajoFacade trabajoFacade;
	@Inject
	private DroneFacade droneFacade;	

	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void creaObjetoTrabajo(){
		usuario = new Usuario();
	}
	
	public Boolean isDisabledBotonesAdicionPto(){
		// activo si elemento seleccionado o lista vacía 
		return !(indiceFilaSeleccionada!=null && indiceFilaSeleccionada>=0 || trabajo!=null && trabajo.getPuntosDeRuta()!=null && trabajo.getPuntosDeRuta().isEmpty());
	}
	
	public void actualizaIndice(){
		FacesContext context = FacesContext.getCurrentInstance();
	    Map<String,String> map = context.getExternalContext().getRequestParameterMap();
	    String pIndex = (String) map.get("index");
	    indiceFilaSeleccionada = Integer.parseInt(pIndex);
	}
	
	public void actualizaModeloTrabajo(){
		// actualiza trabajo
		if(trabajo.getIdTrabajo()!=null)
			trabajo = trabajoFacade.find(trabajo.getIdTrabajo());
		// carga drones para selectOneMenu
		drones = droneFacade.findAll();
	}
	
	public void nuevoPuntoRuta(Boolean insertarDelante){
		PuntoRuta puntoRuta = new PuntoRuta();
		puntoRuta.setLatitud(puntoRutaNuevo.getLatitud());
		puntoRuta.setLongitud(puntoRutaNuevo.getLongitud());
		puntoRuta.setAltitud(puntoRutaNuevo.getAltitud());
		Long idNegativo = -(new Date().getTime());
		
		puntoRuta.setIdPuntoRuta(idNegativo.intValue());
		// añade nuevo punto de ruta a la entidad new o detached
		if(!insertarDelante && indiceFilaSeleccionada!=null)
			indiceFilaSeleccionada++;
		trabajo.getPuntosDeRuta().add(indiceFilaSeleccionada==null?0:indiceFilaSeleccionada, puntoRuta);
	}
	
	public String aceptar(){
		try{
			trabajoFacade.edit(trabajo);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Operación realizada correctamente", ""));
			return "/trabajos?faces-redirect=true";
		}catch(EJBException e){
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getCause().toString(), ""));
			return null;
		}
	}
	
	public void eliminarPuntoRuta(PuntoRuta pto){
		trabajo.getPuntosDeRuta().remove(pto);
	}
	
	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Punto de ruta editado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowEditCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición de punto de ruta cancelada.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }	


}
