package proyecto.unl.adopcion.controller.dao.dao_models;

import proyecto.unl.adopcion.base.models.Publicacion;
import proyecto.unl.adopcion.controller.dao.AdapterDao;

public class DaoPublicacion extends AdapterDao<Publicacion>{
    private Publicacion obj;

    public DaoPublicacion(){
        super(Publicacion.class);

    }

    public Publicacion getObj() {
        if (obj == null) {
            this.obj = new Publicacion();
        }
        return this.obj;
    }

    public void setObj(Publicacion obj) {
        this.obj = obj;
    }

    public Boolean save() {
        try {
            this.persist(obj);
            return true;
        } catch (Exception e) {
            //LOG DE ERROR
            
            return false;
            // TODO: handle exception
        }

    }

    public Boolean update(Integer pos) {
        try {
            this.update(obj, pos);
            return true;
        } catch (Exception e) {
            //LOG DE ERROR
            
            return false;
            // TODO: handle exception
        }

    }


    public static void main(String[] args) {
        DaoPublicacion da = new DaoPublicacion();
        da.getObj().setId(da.listAll().getLength() + 1);
        da.getObj().setNombre("Publicacion 1");
        da.getObj().setDescripcion("Descripcion de la publicacion 1");
        da.getObj().setImg_url("imagen1.jpg");
        da.getObj().setFecha(null);
        da.getObj().setEstado("disponible");
        
        if (da.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");

        }
     
    }

}

