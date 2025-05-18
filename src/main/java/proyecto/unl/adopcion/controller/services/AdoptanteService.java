package proyecto.unl.adopcion.controller.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.hibernate.engine.spi.ActionQueue;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.github.javaparser.quality.NotNull;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.mappedtypes.Pageable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import proyecto.unl.adopcion.base.models.Adoptante;

import proyecto.unl.adopcion.controller.dao.dao_models.DaoAdoptante;

@BrowserCallable
@AnonymousAllowed

public class AdoptanteService {
    
    private DaoAdoptante da;
    public AdoptanteService() {
        da = new DaoAdoptante();
    }

    public void createAdoptante(@NotEmpty String nombre, @NotEmpty String apellido,
                                @NotEmpty String dni, @NotEmpty String email, @NotEmpty String telefono,
                                @NotEmpty String direccion, @NotEmpty String ciudad) throws Exception{
            da.getObj().setNombre(nombre);
            da.getObj().setApellido(apellido);
            da.getObj().setDni(dni);
            da.getObj().setEmail(email);
            da.getObj().setTelefono(telefono);
            da.getObj().setDireccion(direccion);
            da.getObj().setCiudad(ciudad);
            if (!da.save()) {
                throw new Exception("No se pudo guardar los datos del adopcion");
            }
    }

    public List<Adoptante> list(Pageable pageable){
        return Arrays.asList(da.listAll().toArrary());
        
    }

    public List<Adoptante> listAll(){
        return (List<Adoptante>)Arrays.asList(da.listAll().toArrary());
        
    }
    
  

}
