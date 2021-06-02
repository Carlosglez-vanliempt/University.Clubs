package Clubes;

import java.util.ArrayList;
import java.util.Scanner;

public class Club {
    private String nombre;
    private String descripcion;
    private String miembros;
    private String tablon;

    public Club(String nombre, String descripcion, String miembros, String tablon) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.miembros = miembros;
        this.tablon = tablon;
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

    public String getMiembros() {
        return miembros;
    }

    public void setMiembros(String miembros) {
        this.miembros = miembros;
    }

    public String getTablon() {
        return tablon;
    }

    public void setTablon(String tablon) {
        this.tablon = tablon;
    }





    public void Menu(){
        Scanner teclado = new Scanner(System.in);
        ArrayList<Evento> horario = new ArrayList<Evento>();

        Scanner input = new Scanner(System.in);
        String menu = "0";
        do {
            System.out.println("\n\n\n----MENU ADMIN----");
            System.out.print(
                    "1 - Registrar horario\n" +
                            "2 - Crear nuevo evento\n" +
                            "3 - Cambiar aula de un evento\n" +
                            "4 - Cancelar evento\n" +
                            "5 - Modificar descripción\n" +

                            "0 - Salir\n" +
                            "Introduce el número de la opcion que quieras realizar: "
            );
            switch (menu = input.nextLine()) {
                case "1":
                   horario = registrar_horario();

                    break;
                case "2":
                    crear_evento(horario);

                    break;
                case "3":
                    cambiar_aula(horario);

                    break;
                case "4":
                    cancelar_evento(horario);

                    break;
                case "5":
                    mod_inscripcion();

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
        Evento actividad = new Evento();
        Scanner teclado = new Scanner(System.in);
        String input;
        int input2;
        ArrayList<Evento> horario = new ArrayList<Evento>();
        int numero_productos = 0;

        // Solicitar productos
        System.out.print("Indique numero de eventos o actividades a listar: ");
        if (teclado.hasNextInt()) {
            numero_productos = teclado.nextInt();
        } else {
            System.out.print("Error en el numero de productos.");
        }
        if (numero_productos > 0) {
            // solicitar los datos de los productos
            for (int i = 0; i < numero_productos; i++) {

                System.out.println("----- Producto "+(i+1)+" -----");

                // establecemos el objeto
                System.out.println("Por favor introduzca el nombre del evento");
                input = teclado.next();
                actividad.setNombre(input);


                System.out.println("Por favor introduzca el lugar del evento");
                input = teclado.next();
                actividad.setLugar(input);


                System.out.println("Por favor introduzca el aforo máximo del evento");
                input2 = teclado.nextInt();
                actividad.setCapacidad(input2);

                System.out.println("Por favor introduzca la fecha de realización del evento");
                input = teclado.next();
                actividad.setFecha(input);

                // guardamos el objeto en el array
                horario.add(new Evento(actividad.getNombre(),actividad.getLugar(),actividad.getCapacidad(),actividad.getFecha()));

            }
            System.out.println("Se ha generado el inventario de forma correcta");
        }
        return horario;
    }
    private void crear_evento(ArrayList<Evento> horario){
        Evento actividad = new Evento();
        Scanner teclado = new Scanner(System.in);
        String input;
        int input2;
        int numero_productos = 0;
        System.out.println("Por favor introduzca el nombre del nuevo evento");
        input = teclado.next();
        actividad.setNombre(input);


        System.out.println("Por favor introduzca el lugar del evento");
        input = teclado.next();
        actividad.setLugar(input);


        System.out.println("Por favor introduzca el aforo máximo del evento");
        input2 = teclado.nextInt();
        actividad.setCapacidad(input2);

        System.out.println("Por favor introduzca la fecha de realización del evento");
        input = teclado.next();
        actividad.setFecha(input);

        // guardamos el objeto en el array
        horario.add(new Evento(actividad.getNombre(),actividad.getLugar(),actividad.getCapacidad(),actividad.getFecha()));
    }
    private void cambiar_aula(ArrayList<Evento> horario){
        Evento actividad = new Evento();
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
            actividad = horario.get(posicion);
            System.out.println("Por favor introduzca el lugar del evento");
            String input = teclado.next();
            actividad.setLugar(input);
            horario.remove(posicion);
            horario.add(posicion, actividad);


    }
    }
    private void cancelar_evento(ArrayList<Evento> horario){
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
    }
    private void mod_inscripcion(){}
}
