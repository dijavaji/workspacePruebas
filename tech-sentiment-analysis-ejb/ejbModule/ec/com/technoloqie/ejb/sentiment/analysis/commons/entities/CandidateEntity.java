package ec.com.technoloqie.ejb.sentiment.analysis.commons.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="SASTCANDIDATO")
public class CandidateEntity implements Serializable{
	
	//@EmbeddedId
	//CandidateEntityId id = new CandidateEntityId();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDCANDIDATO",nullable=false)
	private Integer id;
	
	@Column(name="IDORGPOL",nullable=false)
	private Integer idOrganization;
	
	@Column(name="CEDULA")
	private String cedula;
	
	@Column(name="NOMBRE")
	private String firstName;
	
	@Column(name="APELLIDO")
	private String lastName;
	
	@Column(name="NACIONALIDAD")
	private String nationality;
	
	@Column(name="CIUDAD")
	private String country;
	
	@Column(name="DIRECCION")
	private String address;
	
	@Column(name="TELEFONO")
	private String telephone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TWITTER")
	private String twitter;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

}
