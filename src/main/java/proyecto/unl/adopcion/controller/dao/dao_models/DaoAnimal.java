package proyecto.unl.adopcion.controller.dao.dao_models;

import proyecto.unl.adopcion.base.models.Animal;
import proyecto.unl.adopcion.controller.dao.AdapterDao;

public class DaoAnimal extends AdapterDao<Animal>{
    private Animal obj;

    public DaoAnimal(){
        super(Animal.class);

    }

    public Animal getObj() {
        if (obj == null) {
            this.obj = new Animal();
        }
        return this.obj;
    }

    public void setObj(Animal obj) {
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
        DaoAnimal da = new DaoAnimal();
        da.getObj().setId(da.listAll().getLength() + 1);
        da.getObj().setNombre("Perro 1");
        da.getObj().setEspecie("Perro");
        da.getObj().setRaza("Labrador");
        
        if (da.save()) {
            System.out.println("Guardado");
        } else {
            System.out.println("Error al guardar");

        }
     
    }

}