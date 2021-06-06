package Usuarios;
import Clubes.Club;
import Clubes.Evento;

import java.util.Vector;
import java.util.Scanner;
public class Usuario {


    private int numExp;
    private String nombre;
    private String apellido;
    private String carrera;
    private String contraseña;
    boolean lider = false;
    Vector<Club> clubes = new Vector();
    Vector <Evento> actividades = new Vector();

    public Vector getClubes() {
        return clubes;
    }

    public void setClubes(Vector clubes) {
        this.clubes = clubes;
    }

    public boolean isLider() {
        return lider;
    }

    public void setLider(boolean lider) {
        this.lider = lider;
    }

    Scanner in = new Scanner(System.in);

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

    public void inicioSesion(int numExp, String contraseña) {
        String pssw;
        System.out.println("Introduce tu contraseña");
        pssw = in.next();
        if (pssw.equals(this.contraseña)) {
            System.out.println("ok");
        }
    }

    public void ModDAtos() {
        String cambio = "";
        System.out.println("-------- DATOS DEL USUARIO PARA MODIFICAR --------");
        System.out.println("  1 - Número Expediente");
        System.out.println("  2 - Nombre");
        System.out.println("  3 - Apellido");
        System.out.println("  4 - Carrera");
        System.out.println("  5 - Contraseña");
        int seleccion = in.nextInt();
        String numero_Expediente;
        boolean correcto;
        switch (seleccion) {
            case 1:
                System.out.println("Introduce el nuevo número de expediente");
              int nexp = in.nextInt();

                setNumExp(nexp);
                break;

            case 2:
                System.out.println("Introduce el nuevo nombre");
                cambio = in.nextLine();
                setNombre(cambio);
                break;
            case 3:
                System.out.println("Introduce el nuevo apellido");
                cambio = in.nextLine();
                setApellido(cambio);
                break;

            case 4:
                System.out.println("Introduce la nueva carrera");
                cambio = in.nextLine();
                setCarrera(cambio);
                break;
            case 5:
                System.out.println("Introduce la nueva contraseña");
                cambio = in.nextLine();
                setContraseña(cambio);
                break;

            default:
                System.out.println("Introduce una opción correcta");
                break;
        }
    }

    public void ApuntarActividad(Evento evento) {
        actividades.addElement(evento);

    }

    public Vector<Evento> getActividades() {
        return actividades;
    }

    public void añadirClub(Club club) {
      clubes.addElement(club);
    }

    public void eliminarClub(int opt) {
        System.out.println("Elige un club");
        for (int i = 0; i < clubes.size(); i++) {
            System.out.println(i + 1 + "" + clubes.elementAt(i));
        }
        opt = in.nextInt();
        clubes.removeElementAt(opt - 1);
    }

    public void borrarActividad(String actividad) {

    }

    @Override
    public String toString() {

        if (lider){
            System.out.print("-------- DATOS DE TU USUARIO -------" + "\n" + "Número de Expediente: " + numExp + "\n"
                    + "Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n" + "Carrera: " + carrera + "\n"
                    + "Contraseña: " + contraseña + "\n" + "Eres lider? " + lider + "\n");
        }else{
            System.out.print("-------- DATOS DE TU USUARIO -------" + "\n" + "Número de Expediente: " + numExp + "\n"
                    + "Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n" + "Carrera: " + carrera + "\n"
                    + "Contraseña: " + contraseña + "\n" );
        }
        
        return "";
    }




}
