package proyecto.unl.adopcion.base.models;

import java.sql.Date;

public class Rescate {
    private Integer id;
    private String lugar_rescate;
    private Date fecha_rescate;
    private String descripcion;
    private Integer id_animal;

    public Integer getId_animal() {
        return this.id_animal;
    }

    public void setId_animal(Integer id_animal) {
        this.id_animal = id_animal;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLugar_rescate() {
        return this.lugar_rescate;
    }

    public void setLugar_rescate(String lugar_rescate) {
        this.lugar_rescate = lugar_rescate;
    }

    public Date getFecha_rescate() {
        return this.fecha_rescate;
    }

    public void setFecha_rescate(Date fecha_rescate) {
        this.fecha_rescate = fecha_rescate;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
