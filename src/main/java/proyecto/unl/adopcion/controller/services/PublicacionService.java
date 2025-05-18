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
import proyecto.unl.adopcion.base.models.Publicacion;
import proyecto.unl.adopcion.controller.dao.dao_models.DaoPublicacion;

@BrowserCallable
@AnonymousAllowed

public class PublicacionService {
    
    private DaoPublicacion da;
    public PublicacionService() {
        da = new DaoPublicacion();
    }

    public void createPublicacion(@NotNull Integer id_animal, @NotEmpty String nombre, 
                                 @NotEmpty String img_url, @NonNull Date fecha, @NotEmpty String estado, @NotEmpty String descripcion) throws Exception{
            da.getObj().setId_animal(id_animal);
            da.getObj().setNombre(nombre);
            da.getObj().setImg_url(img_url);
            da.getObj().setFecha(fecha);
            da.getObj().setEstado(estado);
            da.getObj().setDescripcion(descripcion);
            if (!da.save()) {
                throw new Exception("No se pudo guardar los datos del adopcion");
            }
    }

    public List<Publicacion> list(Pageable pageable){
        return Arrays.asList(da.listAll().toArrary());
        
    }

    public List<Publicacion> listAll(){
        return (List<Publicacion>)Arrays.asList(da.listAll().toArrary());
        
    }
}