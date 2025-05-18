package proyecto.unl.adopcion.controller.dao.dao_models;

import proyecto.unl.adopcion.base.models.Adopcion;
import proyecto.unl.adopcion.controller.dao.AdapterDao;

public class DaoAdopcion extends AdapterDao<Adopcion>{
    private Adopcion obj;

    public DaoAdopcion(){
        super(Adopcion.class);

    }

    public Adopcion getObj() {
        if (obj == null) {
            this.obj = new Adopcion();
        }
        return this.obj;
    }

    public void setObj(Adopcion obj) {
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
        DaoAdopcion da = new DaoAdopcion();
        da.getObj().setId(da.listAll().getLength() + 1);
        da.getObj().setId_adoptante(null);
        da.getObj().setId_animal(null);
        if (da.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");

        }
    }

}
