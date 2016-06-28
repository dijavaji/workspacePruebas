package ec.com.technoloqie.constructora.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="tip_tipo_usuario")
@TableGenerator(name="GEN_SECUENCIA_TIP", // nombre
                table="sec_secuencia", //nombre de la tabla que guarda las secuencias
                pkColumnName="sec_codigo_entidad",
                pkColumnValue="SEQ_TIPO_USU",
                valueColumnName="num_secuencial",
                initialValue=100,allocationSize=2)


@NamedQueries({@NamedQuery(name="TipoUsuario.findAll",query="SELECT l FROM TipoUsuario l"),
               @NamedQuery(name="TipoUsuario.findById",query="SELECT l FROM TipoUsuario l WHERE l.id=:tipoUsuarioId"),
               @NamedQuery(name="TipoUsuario.findByNombre",query="SELECT l FROM TipoUsuario l WHERE l.nombre=:nombre")})
public class TipoUsuarioDTO {
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.TABLE,generator="GEN_SECUENCIA_TIP")
	    @Column(name = "tip_id")
	    private Integer id;
	    
	    @Column(name="tip_nombre",nullable=false)
	    private String nombre; //atributo nombre

	    //<editor-fold defaultstate="collapsed" desc="Relaciones">
		@OneToMany (mappedBy="tipId",targetEntity=UsuarioDTO.class)
		private Set<UsuarioDTO> usercollection;

	    public Set<UsuarioDTO> getUsuariocollection() {
	        return usercollection;
	    }

	    public void setUsuariocollection(Set<UsuarioDTO> usercollection) {
	        this.usercollection = usercollection;
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
	        if (!(object instanceof TipoUsuarioDTO)) {
	            return false;
	        }
	        TipoUsuarioDTO other = (TipoUsuarioDTO) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "ec.edu.uce.entidades.TipoUsuario[ id=" + id + " ]";
	    }
}
