package ec.com.technoloqie.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author thc
 */
@Entity
@Table(name="TIPO_USUARIO")
public class TipoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="TIPOUSUARIOID",nullable=false, unique=true)
    private Integer id;
    
    @Column(name="NOMBRE",nullable=false)
    private String nombre; //atributo nombre

    @OneToMany(mappedBy="tipoUsuario")
    private List<Usuario> usuarioCol;
    
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
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uce.entidades.TipoUsuario[ id=" + id + " ]";
    }

	public List getUsuarioCol() {
		return usuarioCol;
	}

	public void setUsuarioCol(List usuarioCol) {
		this.usuarioCol = usuarioCol;
	}

    
}
