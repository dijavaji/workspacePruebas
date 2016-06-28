package ec.com.technoloqie.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * clase prueba del objeto para consumir webservice 
 * @author dvasquez
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClasePrueba {
	
	private Long id;
	private String content;
	
	public ClasePrueba(){
		
	}
	
	 @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", contenido='" + content + '\'' +
                '}';
    }
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
