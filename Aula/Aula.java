package Aula;

public class Aula {

    private int id;
    private String nombre;
    private int capacidad;
    private double localizacion;

    public Aula(int id, String nombre, int capacidad, double localizacion) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id= " + id +
                ", nombre= '" + nombre + '\'' +
                ", capacidad= " + capacidad +
                ", localizacion= " + localizacion +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(double localizacion) {
        this.localizacion = localizacion;
    }
}
