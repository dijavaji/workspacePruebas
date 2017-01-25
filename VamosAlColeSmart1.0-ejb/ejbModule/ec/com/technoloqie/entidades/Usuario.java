package ec.com.technoloqie.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name="usu_usuario")
@TableGenerator(name="GEN_SECUENCIA_USR", // nombre
                table="sec_secuencia", //nombre de la tabla que guarda las secuencias
                pkColumnName="sec_codigo_entidad",
                pkColumnValue="SEQ_USUARIO",
                valueColumnName="num_secuencial",
                allocationSize=1)


//@NamedQueries({@NamedQuery(name="retornaUsuarios",query="SELECT l FROM usu_usuario l"),
               //@NamedQuery(name="findByCodigo",query="SELECT l FROM usu_usuario l WHERE l.id=:codUsuario")})

@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT e FROM Usuario e"),
    @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT e FROM Usuario e WHERE e.id = :usuarioId")
    //@NamedQuery(name = "Usuario.findByFirstName", query = "SELECT e FROM Usuario e WHERE e.firstName = :firstName"),
    //@NamedQuery(name = "Usuario.findByLastName", query = "SELECT e FROM Usuario e WHERE e.lastName = :lastName"),
    //@NamedQuery(name = "Usuario.findByEmail", query = "SELECT e FROM Usuario e WHERE e.email = :email"),
    //@NamedQuery(name = "Usuario.findByPhoneNumber", query = "SELECT e FROM Usuario e WHERE e.phoneNumber = :phoneNumber"),
    //@NamedQuery(name = "Usuario.findByHireDate", query = "SELECT e FROM Usuario e WHERE e.hireDate = :hireDate"),
    //@NamedQuery(name = "Usuario.findBySalary", query = "SELECT e FROM Usuario e WHERE e.salary = :salary"),
    //@NamedQuery(name = "Usuario.findByCommissionPct", query = "SELECT e FROM Employees e WHERE e.commissionPct = :commissionPct")
})

public class Usuario implements Serializable {
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
	private TipoUsuario tipId;
   // @OneToMany (mappedBy="usuId")
	
    

    public TipoUsuario getTipId() {
        return tipId;
    }

    public void setTipId(TipoUsuario tipId) {
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.technoloqie.entidades.Usuario[ id=" + id + " ]";
    }
    
}

