/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author thc
 */
@Entity
@Table(name="lib_libro")
@TableGenerator(name="GEN_SECUENCIA_LIB", // nombre
                table="sec_secuencia", //nombre de la tabla que guarda las secuencias
                pkColumnName="sec_codigo_entidad",
                pkColumnValue="SEQ_LIBRO",
                valueColumnName="num_secuencial",
                allocationSize=1)


//@NamedQueries({@NamedQuery(name="retornaUsuarios",query="SELECT l FROM usu_usuario l"),
               //@NamedQuery(name="findByCodigo",query="SELECT l FROM usu_usuario l WHERE l.id=:codUsuario")})

@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT e FROM Libro e"),
    @NamedQuery(name = "Libro.findByLibroId", query = "SELECT e FROM Libro e WHERE e.id = :libroId")
    //@NamedQuery(name = "Usuario.findByFirstName", query = "SELECT e FROM Usuario e WHERE e.firstName = :firstName"),
    //@NamedQuery(name = "Usuario.findByLastName", query = "SELECT e FROM Usuario e WHERE e.lastName = :lastName"),
    //@NamedQuery(name = "Usuario.findByEmail", query = "SELECT e FROM Usuario e WHERE e.email = :email"),
    //@NamedQuery(name = "Usuario.findByPhoneNumber", query = "SELECT e FROM Usuario e WHERE e.phoneNumber = :phoneNumber"),
    //@NamedQuery(name = "Usuario.findByHireDate", query = "SELECT e FROM Usuario e WHERE e.hireDate = :hireDate"),
    //@NamedQuery(name = "Usuario.findBySalary", query = "SELECT e FROM Usuario e WHERE e.salary = :salary"),
    //@NamedQuery(name = "Usuario.findByCommissionPct", query = "SELECT e FROM Employees e WHERE e.commissionPct = :commissionPct")
})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator="GEN_SECUENCIA_LIB")
    @Column(name = "lib_id")
    private Integer id;
    
    @Column(name="lib_nombre",nullable=false)
    private String nombre; //atributo nombre
     
     @Column(name="lib_autor",nullable=false)
    private String autor; //atributo autor

     
    @Column(name="lib_editorial",nullable=true)
    private String editorial;// atributo editorial
    
    @Column(name="lib_descripcion",nullable=true)
    private String descripcion;// descripcion
    
    @Column(name="lib_estado",nullable=true)
    private String estado;// estado
    
    @Column(name="lib_precio_inicial",nullable=false)
    private Double precioInicial;// precio inicial
    
    @Column(name="lib_fecha_limite",nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaLimiteSubasta;// fecha limite de lasubasta
    
//////relaciones
     @ManyToOne
	@JoinColumn(name="usu_id",nullable=false)
	private Usuario usuId;
    
      @ManyToOne
	@JoinColumn(name="cat_id",nullable=false)
	private Categoria catId;

    public Categoria getCatId() {
        return catId;
    }

    public void setCatId(Categoria catId) {
        this.catId = catId;
    }
      
      

    public Usuario getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuario usuId) {
        this.usuId = usuId;
    }
     

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaLimiteSubasta() {
        return fechaLimiteSubasta;
    }

    public void setFechaLimiteSubasta(Date fechaLimiteSubasta) {
        this.fechaLimiteSubasta = fechaLimiteSubasta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(Double precioInicial) {
        this.precioInicial = precioInicial;
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
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uce.entidades.Libro[ id=" + id + " ]";
    }
    
}
