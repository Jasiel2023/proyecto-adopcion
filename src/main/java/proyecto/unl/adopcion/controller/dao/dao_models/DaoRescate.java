package proyecto.unl.adopcion.controller.dao.dao_models;

import proyecto.unl.adopcion.base.models.Rescate;
import proyecto.unl.adopcion.controller.dao.AdapterDao;

public class DaoRescate extends AdapterDao<Rescate>{
    private Rescate obj;

    public DaoRescate(){
        super(Rescate.class);

    }

    public Rescate getObj() {
        if (obj == null) {
            this.obj = new Rescate();
        }
        return this.obj;
    }

    public void setObj(Rescate obj) {
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
        DaoRescate da = new DaoRescate();
        da.getObj().setId(da.listAll().getLength() + 1);
        da.getObj().setLugar_rescate(base_path+"Calle Falsa 123");
        da.getObj().setFecha_rescate(null);
        da.getObj().setDescripcion("Descripcion del rescate");
        
        if (da.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");

        }
     
    }

}
