/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author thc
 */
@Entity
@Table(name="usp_usuario_puja")
@TableGenerator(name="GEN_SECUENCIA_USP", // nombre
                table="sec_secuencia", //nombre de la tabla que guarda las secuencias
                pkColumnName="sec_codigo_entidad",
                pkColumnValue="SEQ_USUARIO_PUJA",
                valueColumnName="num_secuencial",
                initialValue=100,allocationSize=2)


@NamedQueries({@NamedQuery(name="UsuarioPuja.findAll",query="SELECT l FROM UsuarioPuja l"),
               @NamedQuery(name="UsuarioPuja.findByUsuarioPujaId",query="SELECT l FROM UsuarioPuja l WHERE l.id=:usuarioPujaId")})


public class UsuarioPuja implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator="GEN_SECUENCIA_USP")
    private Integer id;
     
     
     
  /*  @ManyToOne
     private Puja puja;
    
     @ManyToOne
     private Usuario usuario;

    public Puja getPuja() {
        return puja;
    }

    public void setPuja(Puja puja) {
        this.puja = puja;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     
   */

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
        if (!(object instanceof UsuarioPuja)) {
            return false;
        }
        UsuarioPuja other = (UsuarioPuja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uce.entidades.UsuarioPuja[ id=" + id + " ]";
    }
    
}
