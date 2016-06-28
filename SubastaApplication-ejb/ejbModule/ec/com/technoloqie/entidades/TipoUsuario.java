/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.entidades;

import java.io.Serializable;
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

/**
 *
 * @author thc
 */
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


public class TipoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator="GEN_SECUENCIA_TIP")
    @Column(name = "tip_id")
    private Integer id;
    
    @Column(name="tip_nombre",nullable=false)
    private String nombre; //atributo nombre

    //<editor-fold defaultstate="collapsed" desc="Relaciones">
	@OneToMany (mappedBy="tipId",targetEntity=Usuario.class)
	private Set<Usuario> usercollection;

    public Set<Usuario> getUsuariocollection() {
        return usercollection;
    }

    public void setUsuariocollection(Set<Usuario> usercollection) {
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
    
}
