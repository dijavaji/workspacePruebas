package ec.com.technoloqie.ejb.sentiment.analysis.commons.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="SASTORGPOL")
public class PoliticalOrganizationEntity implements Serializable{
	
	@Id
    //@GeneratedValue
	@Column(name="IDORGPOL",nullable=false)
	private Integer id;
	
	@Column(name="LISTA")
	private String nameList;
	
	@Column(name="NOMBREORGANIZACION")
	private String nameOrganization;
	
	@Column(name="TIPOORGANIZACION")
	private String organizationType;
	
	@Column(name="AMBITOORGANIZACION")
	private String organizationAmbit;
	
	@Column(name="PAIS")
	private String country;
	
	@Column(name="PROVINCIA")
	private String province;
	
	@Column(name="CANTON")
	private String city;
	
	@Column(name="PARROQUIA")
	private String parroquia;
	
	@Column(name="CONSULADO")
	private String consulate;
	
	@Column(name="CIRCUNSCRIPCIONEXTERIOR")
	private String externalCircumscription;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PAGINAWEB")
	private String webPage;
	
	@Column(name="MAXIMAAUTORIDAD")
	private String authority;
	
	@Column(name="SEDEPRINCIPAL")
	private String sede;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameList() {
		return nameList;
	}

	public void setNameList(String nameList) {
		this.nameList = nameList;
	}

	public String getNameOrganization() {
		return nameOrganization;
	}

	public void setNameOrganization(String nameOrganization) {
		this.nameOrganization = nameOrganization;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getOrganizationAmbit() {
		return organizationAmbit;
	}

	public void setOrganizationAmbit(String organizationAmbit) {
		this.organizationAmbit = organizationAmbit;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getParroquia() {
		return parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getConsulate() {
		return consulate;
	}

	public void setConsulate(String consulate) {
		this.consulate = consulate;
	}

	public String getExternalCircumscription() {
		return externalCircumscription;
	}

	public void setExternalCircumscription(String externalCircumscription) {
		this.externalCircumscription = externalCircumscription;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebPage() {
		return webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

}
