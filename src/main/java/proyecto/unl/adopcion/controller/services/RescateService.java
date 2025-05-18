package proyecto.unl.adopcion.controller.services;


import java.lang.reflect.Array;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.hibernate.engine.spi.ActionQueue;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.github.javaparser.quality.NotNull;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.mappedtypes.Pageable;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;

import proyecto.unl.adopcion.base.models.Rescate;
import proyecto.unl.adopcion.controller.dao.dao_models.DaoRescate;

@BrowserCallable
@AnonymousAllowed

public class RescateService {
    
    private DaoRescate da;
    public RescateService() {
        da = new DaoRescate();
    }

    public void createRescate(@NotNull Integer id_animal,  @NotEmpty String lugar_rescate, @NonNull Date fecha_rescate,
                                @NotEmpty String descripcion) throws Exception{
            da.getObj().setId_animal(id_animal);
            da.getObj().setLugar_rescate(lugar_rescate);
            da.getObj().setFecha_rescate(fecha_rescate);
            da.getObj().setDescripcion(descripcion);
            if (!da.save()) {
                throw new Exception("No se pudo guardar los datos del adopcion");
            }
    }

    public List<Rescate> list(Pageable pageable){
        return Arrays.asList(da.listAll().toArrary());
        
    }

    public List<Rescate> listAll(){
        return (List<Rescate>)Arrays.asList(da.listAll().toArrary());
        
    }
    
  

}

