
package Clubes;

import java.util.ArrayList;
import java.util.Scanner;

public class Club {
    private String nombre;
    private String descripcion;
    private int miembros;
    private ArrayList<Anuncio> tablon = new ArrayList<>();
    private ArrayList<Evento> horario = new ArrayList<>();

    private int admin;

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public ArrayList<Evento> getHorario() {
        return horario;
    }

    public Club(String nombre, String descripcion, int miembros) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.miembros = miembros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMiembros() {
        return miembros;
    }

    public void setMiembros(int miembros) {
        this.miembros = miembros;
    }

    public ArrayList<Anuncio> getTablon() {
        return tablon;
    }

    public void Menu(){
        Scanner teclado = new Scanner(System.in);

        Scanner input = new Scanner(System.in);
        String menu = "0";
        do {
            System.out.println("\n\n\n----MENU ADMIN----");
            System.out.print(
                    "1 - Registrar horario\n" +
                            "2 - Crear nuevo evento\n" +
                            "3 - Cambiar aula de un evento\n" +
                            "4 - Cancelar evento\n" +
                            "5 - Añadir anuncio\n" +

                            "0 - Salir\n" +
                            "Introduce el número de la opcion que quieras realizar: "
            );
            switch (menu = input.nextLine()) {
                case "1":
                    horario = registrar_horario();

                    break;
                case "2":
                    horario = crear_evento(horario);

                    break;
                case "3":
                    horario = cambiar_aula(horario);

                    break;
                case "4":
                    horario = cancelar_evento(horario);

                    break;
                case "5":
                    tablon = anuncio(tablon);

                    break;
                case "x":
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.print("Introduce una opcion correcta: ");
            }
        } while (!menu.equals("0"));
    }

    private ArrayList<Evento> registrar_horario(){

        Scanner teclado = new Scanner(System.in);
        String input;
        int input2;
        ArrayList<Evento> horario = new ArrayList<Evento>();
        int numero_eventos = 0;

        // Solicitar productos
        System.out.print("Indique numero de eventos o actividades a listar: ");
        if (teclado.hasNextInt()) {
            numero_eventos = teclado.nextInt();
        } else {
            System.out.print("Error en el numero de productos.");
        }
        if (numero_eventos> 0) {
            // solicitar los datos de los productos
            for (int i = 0; i < numero_eventos; i++) {

                System.out.println("----- Evento "+(i+1)+" -----");

                // establecemos el objeto
                System.out.println("Por favor introduzca el nombre del evento");
                String nombre = teclado.next();


                System.out.println("Por favor introduzca el lugar del evento");
                String lugar = teclado.next();



                System.out.println("Por favor introduzca los ocupantes del evento");
                int ocupantes = teclado.nextInt();


                System.out.println("Por favor introduzca la fecha de realización del evento");
                String fecha = teclado.next();


                // guardamos el objeto en el array
                horario.add(new Evento(nombre,lugar,ocupantes,fecha));

            }
            System.out.println("Se ha generado el inventario de forma correcta");
        }
        return horario;
    }
    private ArrayList<Evento> crear_evento(ArrayList<Evento> horario){
        Scanner teclado = new Scanner(System.in);
        String input;
        int input2;
        int numero_productos = 0;
        System.out.println("Por favor introduzca el nombre del evento");
        String nombre = teclado.next();


        System.out.println("Por favor introduzca el lugar del evento");
        String lugar = teclado.next();



        System.out.println("Por favor introduzca los ocupantes del evento");
        int ocupantes = teclado.nextInt();


        System.out.println("Por favor introduzca la fecha de realización del evento");
        String fecha = teclado.next();

        horario.add(new Evento(nombre,lugar,ocupantes,fecha));
        return horario;
    }
    private ArrayList<Evento> cambiar_aula(ArrayList<Evento> horario){
        String nombre = "prueba";
        String lugar = "prueba";
        int ocupantes = 0;
        String fecha = "prueba";
        Evento actividad = new Evento(nombre,lugar,ocupantes,fecha);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor introduzca el nombre del evento");
        nombre = teclado.next();
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < horario.size() && !encontrado) {
            if (horario.get(posicion).getNombre() == nombre) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        if (encontrado) {
            actividad = horario.get(posicion);
            System.out.println("Por favor introduzca el lugar del evento");
            String input = teclado.next();
            actividad.setLugar(input);
            horario.remove(posicion);
            horario.add(posicion, actividad);


        }
        return horario;
    }
    private ArrayList<Evento> cancelar_evento(ArrayList<Evento> horario){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor introduzca el nombre del evento");
        String nombre = teclado.next();
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < horario.size() && !encontrado) {
            if (horario.get(posicion).getNombre() == nombre) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        if (encontrado) {
            horario.remove(posicion);
        }
        return horario;
    }
    private ArrayList<Anuncio> anuncio(ArrayList<Anuncio> tablon){
        String desc = "prueba";
        String fecha = "prueba";
        Anuncio aviso = new Anuncio(desc,fecha);
        Scanner teclado = new Scanner(System.in);
        String input;
        System.out.println("Por favor introduzca el nombre del nuevo evento");
        input = teclado.next();
        aviso.setAnuncio(input);


        System.out.println("Por favor introduzca el lugar del evento");
        input = teclado.next();
        aviso.setFecha(input);
        tablon.add(aviso);
        return tablon;

    }
}