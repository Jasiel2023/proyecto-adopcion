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
import proyecto.unl.adopcion.base.models.Adopcion;
import proyecto.unl.adopcion.base.models.Animal;
import proyecto.unl.adopcion.controller.dao.dao_models.DaoAdopcion;
import proyecto.unl.adopcion.controller.dao.dao_models.DaoAnimal;

@BrowserCallable
@AnonymousAllowed

public class AdopcionService {
    
    private DaoAdopcion da;
    public AdopcionService() {
        da = new DaoAdopcion();
    }

    public void createAdopcion(@NotNull  Integer id_animal, @NotNull  Integer id_adoptante) throws Exception{
            da.getObj().setId_adoptante(id_adoptante);
            da.getObj().setId_animal(id_animal);
            if (!da.save()) {
                throw new Exception("No se pudo guardar los datos del adopcion");
            }
    }

    public List<Adopcion> list(Pageable pageable){
        return Arrays.asList(da.listAll().toArrary());
        
    }

    public List<Adopcion> listAll(){
        return (List<Adopcion>)Arrays.asList(da.listAll().toArrary());
        
    }
    
  

}
