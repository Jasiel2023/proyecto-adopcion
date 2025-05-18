package proyecto.unl.adopcion.controller.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.hibernate.engine.spi.ActionQueue;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.mappedtypes.Pageable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import proyecto.unl.adopcion.base.models.Animal;
import proyecto.unl.adopcion.controller.dao.dao_models.DaoAnimal;

@BrowserCallable
@AnonymousAllowed

public class AnimalService {
    
    private DaoAnimal da;
    public AnimalService() {
        da = new DaoAnimal();
    }

    public void createAnimal(@NotEmpty String nombre, @NotEmpty String especie,
                             @NotEmpty String raza) throws Exception{
            da.getObj().setEspecie(especie);
            da.getObj().setNombre(nombre);
            da.getObj().setRaza(raza);
            if (!da.save()) {
                throw new Exception("No se pudo guardar los datos del artista");
            }
    }

    public List<Animal> list(Pageable pageable){
        return Arrays.asList(da.listAll().toArrary());
        
    }

    public List<Animal> listAll(){
        return (List<Animal>)Arrays.asList(da.listAll().toArrary());
        
    }
    
  

}
