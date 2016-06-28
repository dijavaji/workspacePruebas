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
@Table(name="cat_categoria")
@TableGenerator(name="GEN_SECUENCIA_CAT", // nombre
                table="sec_secuencia", //nombre de la tabla que guarda las secuencias
                pkColumnName="sec_codigo_entidad",
                pkColumnValue="SEQ_CATEGORIA",
                valueColumnName="num_secuencial",
                initialValue=100,allocationSize=2)


@NamedQueries({@NamedQuery(name="Categoria.findAll",query="SELECT l FROM Categoria l"),
               @NamedQuery(name="Categoria.findByCategoriaId",query="SELECT l FROM Categoria l WHERE l.id=:categoriaId")})


public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator="GEN_SECUENCIA_CAT")
    @Column(name = "cat_id")
    private Integer id;
    
     @Column(name="cat_nombre",nullable=false)
    private String nombre; //atributo categoria
     
     
     /////Relaciones
     @OneToMany (mappedBy="catId")
	private Set<Libro> librocollection;

    public Set<Libro> getLibrocollection() {
        return librocollection;
    }

    public void setLibrocollection(Set<Libro> librocollection) {
        this.librocollection = librocollection;
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
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uce.entidades.Categoria[ id=" + id + " ]";
    }
    
}
