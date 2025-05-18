package proyecto.unl.adopcion.controller.dao.dao_models;

import proyecto.unl.adopcion.base.models.Adoptante;
import proyecto.unl.adopcion.controller.dao.AdapterDao;

public class DaoAdoptante extends AdapterDao<Adoptante>{
    private Adoptante obj;

    public DaoAdoptante(){
        super(Adoptante.class);

    }

    public Adoptante getObj() {
        if (obj == null) {
            this.obj = new Adoptante();
        }
        return this.obj;
    }

    public void setObj(Adoptante obj) {
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
        DaoAdoptante da = new DaoAdoptante();
        da.getObj().setId(da.listAll().getLength() + 1);
        da.getObj().setNombre("Juan");
        da.getObj().setApellido("Perez");
        da.getObj().setDni("123456789");
        da.getObj().setEmail(base_path+"@gmail.com");
        da.getObj().setTelefono("123456789");
        da.getObj().setDireccion("Calle Falsa 123");
        da.getObj().setCiudad("LOja");
        
        if (da.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");

        }
     
    }

}