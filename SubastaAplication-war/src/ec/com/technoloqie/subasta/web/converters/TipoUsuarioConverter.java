package ec.com.technoloqie.subasta.web.converters;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.com.technoloqie.entidades.TipoUsuario;

@FacesConverter("ec.com.technoloqie.subasta.web.converters.TipoUsuarioConverter")
public class TipoUsuarioConverter implements Converter{
	
	public TipoUsuarioConverter(){}
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        List<TipoUsuario> drones = (List<TipoUsuario>)component.getAttributes().get("attrtipoUser");
      if (submittedValue.trim().equals("")) {
          return null;
      } else {
          Iterator<TipoUsuario> it = drones.iterator();
          while(it.hasNext()){
        	  TipoUsuario p = it.next();
              if(p.toString().equals(submittedValue))
                  return p;                
          }
      }
      return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null) {
            return "";
        } else {
            return value.toString();
        }
    }

}
