package Usuarios;
import java.util.Vector;
import java.util.Scanner;
public class Usuario {
    private int numExp;
    private String nombre;
    private String apellido;
    private String carrera;
    private String contraseña;
    Scanner in = new Scanner (System.in);
    public Usuario(int numExp, String nombre, String apellido, String carrera, String contraseña) {
        this.numExp = numExp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.contraseña = contraseña;
    }

    public int getNumExp() {
        return numExp;
    }

    public void setNumExp(int numExp) {
        this.numExp = numExp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void inicioSesion(int numExp,String contraseña){
        String pssw;
        System.out.println("Introduce tu contraseña");
        pssw = in.next();
        if (pssw.equals(this.contraseña)) {
            System.out.println("ok");
        }

    }
    public void ModDAtos(){
        String cambio = "";
        System.out.println("[1] Número Expediente");
        System.out.println("[2] Nombre");
        System.out.println("[3] Apellido");
        System.out.println("[4] Carrera");
        System.out.println("[5] Contraseña");
        int seleccion = in.nextInt();
        switch (seleccion){
            case 1:
                System.out.println("Introduce el nuevo número de expediente");
                int exp = in.nextInt();
                setNumExp(exp);
                break;

            case 2:
                System.out.println("Introduce el nuevo nombre");
                cambio = in.next();
                setNombre(cambio);
                break;
            case 3:
                System.out.println("Introduce el nuevo apellido");
                cambio = in.next();
                setApellido(cambio);
                break;

            case 4:
                System.out.println("Introduce la nueva carrera");
                cambio = in.next();
                setCarrera(cambio);
                break;
            case 5:
                System.out.println("Introduce la nueva carrera");
                cambio = in.next();
                setCarrera(cambio);
                break;
            case 6:
                System.out.println("Introduce la nueva contraseña");
                cambio = in.next();
                setContraseña(cambio);
                break;

            default:
                System.out.println("Introduce una opción correcta");
                break;
        }
    }
}
