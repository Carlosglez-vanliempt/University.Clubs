
package Clubes;

public class Evento {
    private String nombre;
    private String lugar;
    private int apuntados;
    private String fecha;
    //Constructor

    public Evento(String nombre, String lugar, int capacidad, String fecha) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.apuntados = apuntados;
        this.fecha = fecha;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getApuntados() {
        return apuntados;
    }

    public void setApuntados(int capacidad) {
        this.apuntados = capacidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}
