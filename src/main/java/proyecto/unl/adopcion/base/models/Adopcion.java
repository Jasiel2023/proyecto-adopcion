package proyecto.unl.adopcion.base.models;

public class Adopcion {
    private Integer id;
    private Integer id_adoptante;
    private Integer id_animal;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_adoptante() {
        return this.id_adoptante;
    }

    public void setId_adoptante(Integer id_adoptante) {
        this.id_adoptante = id_adoptante;
    }

    public Integer getId_animal() {
        return this.id_animal;
    }

    public void setId_animal(Integer id_animal) {
        this.id_animal = id_animal;
    }

}
