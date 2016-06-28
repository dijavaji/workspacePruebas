/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.technoloqie.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author thc
 */
@Entity
@Table(name="puj_puja")
@TableGenerator(name="GEN_SECUENCIA_PUJ", // nombre
                table="sec_secuencia", //nombre de la tabla que guarda las secuencias
                pkColumnName="sec_codigo_entidad",
                pkColumnValue="SEQ_PUJA",
                valueColumnName="num_secuencial",
                allocationSize=1)


//@NamedQueries({@NamedQuery(name="retornaUsuarios",query="SELECT l FROM usu_usuario l"),
               //@NamedQuery(name="findByCodigo",query="SELECT l FROM usu_usuario l WHERE l.id=:codUsuario")})

@NamedQueries({
    @NamedQuery(name = "Puja.findAll", query = "SELECT e FROM Puja e")
    //@NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT e FROM Usuario e WHERE e.employeeId = :employeeId"),
    //@NamedQuery(name = "Usuario.findByFirstName", query = "SELECT e FROM Usuario e WHERE e.firstName = :firstName"),
    //@NamedQuery(name = "Usuario.findByLastName", query = "SELECT e FROM Usuario e WHERE e.lastName = :lastName"),
    //@NamedQuery(name = "Usuario.findByEmail", query = "SELECT e FROM Usuario e WHERE e.email = :email"),
    //@NamedQuery(name = "Usuario.findByPhoneNumber", query = "SELECT e FROM Usuario e WHERE e.phoneNumber = :phoneNumber"),
    //@NamedQuery(name = "Usuario.findByHireDate", query = "SELECT e FROM Usuario e WHERE e.hireDate = :hireDate"),
    //@NamedQuery(name = "Usuario.findBySalary", query = "SELECT e FROM Usuario e WHERE e.salary = :salary"),
    //@NamedQuery(name = "Usuario.findByCommissionPct", query = "SELECT e FROM Employees e WHERE e.commissionPct = :commissionPct")
})
public class Puja implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator="GEN_SECUENCIA_PUJ")
    @Column(name = "puj_id")
    private Integer id;

    // @Column(name="puj_hora",nullable=false)
    //@Temporal(javax.persistence.TemporalType.DATE)
    //private Date hora; //atributo hora
     
     @Column(name="puj_fecha",nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha; //atributo fecha

     
    @Column(name="puj_precio_puja",nullable=false)
    private Double precioPuja;// atributo puja
    
    @Column(name="puj_precio_final",nullable=false)
    private Double precioFinal;// precio final
    
    @Column(name="puj_adjudicado",nullable=true)
    private String adjudicado;// adjudicado

    public String getAdjudicado() {
        return adjudicado;
    }

    public void setAdjudicado(String adjudicado) {
        this.adjudicado = adjudicado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Double getPrecioPuja() {
        return precioPuja;
    }

    public void setPrecioPuja(Double precioPuja) {
        this.precioPuja = precioPuja;
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
        if (!(object instanceof Puja)) {
            return false;
        }
        Puja other = (Puja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.uce.entidades.Puja[ id=" + id + " ]";
    }
    
}
