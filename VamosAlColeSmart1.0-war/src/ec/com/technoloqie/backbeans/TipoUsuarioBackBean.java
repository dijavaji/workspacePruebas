package ec.com.technoloqie.backbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ec.com.technoloqie.ejb.TipoUsuarioManejadorRemote;
import ec.com.technoloqie.entidades.TipoUsuario;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;


@ManagedBean(name = "tipoUsuarioBackBean")
@RequestScoped
public class TipoUsuarioBackBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@EJB
	private TipoUsuarioManejadorRemote manejadorTipoUsuario;
    private TipoUsuario tipoUsuario;
    private Integer codigo;
    private String nombre;
    private List<TipoUsuario> listaTipoUsuario = new ArrayList<TipoUsuario>();
    
    public String loadListTipoUsuario(){
    	cargarDatos();
    	return "pages/tipoUsuario/adminTipoUsuario";
    }

    /*public void loadData() {
        cargarDatos();
    }*/
    
    public void tipoUsuarioListener(ActionEvent event){
    	this.tipoUsuario = (TipoUsuario)event.getComponent().getAttributes().get("tipoUsuarioFila");
      }
    
    public String verDatos(){
    	return "pages/tipoUsuario/viewTipoUsuario";
    }
    
    public String guardar(){
        try{
        tipoUsuario = new TipoUsuario();
        tipoUsuario.setNombre(nombre);
        manejadorTipoUsuario.crearTipoUsuario(tipoUsuario);
        }catch(Exception e){
            System.out.println("Fallo al guardar Tipo Usuario"+ e);
        }
       return "linkVerTipoUsuario";
    }
    
    private void cargarDatos() {
        this.listaTipoUsuario = manejadorTipoUsuario.listarTipoUsuario();
        System.out.println("size: " + listaTipoUsuario.size());
        for (TipoUsuario tipUsu : listaTipoUsuario) {
            System.out.println("codigo:" + tipUsu.getId() + "  nombre:" + tipUsu.getNombre() );
            System.out.println("<br />");
        }
    }
    
    public String cancelar() {
        //cargarDatos();
    	nombre = null;
    	codigo = null;
        return "/principal";
    }
    
    public String nuevoTipoUsuario(){
    	///pages/places?faces-redirect=truecreateTipoUsuario?faces-redirect=true
    	return "createTipoUsuario";
    }
    
    public String eliminar() {
        manejadorTipoUsuario.eliminarTipoUsuario(tipoUsuario);
        cargarDatos();
        return "";
    }

  public String modificar() {

        if (nombre != null ) {
            tipoUsuario.setNombre(nombre);
            tipoUsuario = manejadorTipoUsuario.actualizarTipoUsuario(tipoUsuario);
            cargarDatos();
        }

         return "linkVerTipoUsuario";
    }
    
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public List<TipoUsuario> getListaTipoUsuario() {
		return listaTipoUsuario;
	}
	public void setListaTipoUsuario(List<TipoUsuario> listaTipoUsuario) {
		this.listaTipoUsuario = listaTipoUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


}
