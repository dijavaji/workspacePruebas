package ec.com.technoloqie.constructora.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class UsuarioDTO {
	//@OneToOne(mappedBy = "estudiante")
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator="GEN_SECUENCIA_USR")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usu_id")
    private Integer id;
    
     @Column(name="usu_nombre",nullable=false)
    private String nombre; //atributo nombre
     
     @Column(name="usu_apellido",nullable=false)
    private String apellido; //atributo apellido

     
    @Column(name="usu_direccion",nullable=false)
    private String direccion;// atributo direccion
    
    @Column(name="usu_email",nullable=false)
    private String email;// email
    
    @Column(name="usu_telefono",nullable=false)
    private String telefono;// telefono
    
    @Column(name="usu_pass",nullable=false)
    private String pass;// pass
    
    @ManyToOne
	@JoinColumn(name="tip_id",nullable=false)
	private TipoUsuarioDTO tipId;
    

    public TipoUsuarioDTO getTipId() {
        return tipId;
    }

    public void setTipId(TipoUsuarioDTO tipId) {
        this.tipId = tipId;
    }
    
    /*@ManyToOne
    private TipoUsuario tipo_usuario;

    public TipoUsuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
*/

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioDTO)) {
            return false;
        }
        UsuarioDTO other = (UsuarioDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uce.entidades.Usuario[ id=" + id + " ]";
    }
}
