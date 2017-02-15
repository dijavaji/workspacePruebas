package ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class CandidateEntityId {
	
	public static final String NOMBRE_SECUENCIA = "SSPCOSECARCIMPR";
	
	@Column(name="IDCANDIDATO",nullable=false)
	private Integer id;
	
	@Column(name="IDORGPOL",nullable=false)
	private Integer idOrganization;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(Integer idOrganization) {
		this.idOrganization = idOrganization;
	}
}
