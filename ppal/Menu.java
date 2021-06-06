package ppal;

import Clubes.Club;
import Usuarios.Usuario;

import java.util.Scanner;
import java.util.Vector;

public class Menu {

    public int menuinicial(){
        int opt = 0;
        Scanner teclado = new Scanner(System.in);

        // Informar de las opciones
        System.out.print(
                "\n-------- Bienvenidos--------" + "\n" +
                        "  0 - Salir" + "\n" +
                        "  1 - Registro" + "\n" +
                        "  2 - LogIn" + "\n" +
                        "Opcion:"
        );

        // recoger la opcion
        while (!teclado.hasNextInt()) {
            System.out.print("Error! numero: ");
            teclado.next();
        }
        opt = teclado.nextInt();

        return opt;
    }

    public int Menu1() {
        int opt1 = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.print(
                "\n-------- PERFIL USUARIO GENERAL --------" + "\n" +
                        "  0 - Atrás" + "\n" +
                        "  1 - Datos de usuario" + "\n" +
                        "  2 - Ver clubes"  + "\n" +
                        "Opcion:"
        );

        // recoger la opcion
        while (!teclado.hasNextInt()) {
            System.out.print("Error! numero: ");
            teclado.next();
        }
        opt1 = teclado.nextInt();

        return opt1;

    }

    public int menuUsuario(){
        int optUser = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.print(
                "\n-------- DATOS DEL USUARIO --------" + "\n" +
                        "  0 - Atrás" + "\n" +
                        "  1 - Ver datos" + "\n" +
                        "  2 - Modificar datos"+ "\n" +
                        "Opcion:"
        );

        // recoger la opcion
        while (!teclado.hasNextInt()) {
            System.out.print("Error! numero: ");
            teclado.next();
        }
        optUser = teclado.nextInt();

        return optUser;
    }

    public int menuClubes(){
        int optClub = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.print(
                "\n-------- VER CLUBES --------" + "\n" +
                        "  0 - Atrás" + "\n" +
                        "  1 - Ver todos los clubes" + "\n" +
                        "  2 - Ver mis clubes"+ "\n" +
                        "Opcion:"
        );

        // recoger la opcion
        while (!teclado.hasNextInt()) {
            System.out.print("Error! numero: ");
            teclado.next();
        }
        optClub = teclado.nextInt();

        return optClub;
    }
    public void menuclubnoapuntado(){
        System.out.print(
                "\n-------- CLUB --------" + "\n" +
                        "  0 - Atrás" + "\n" +
                        "  1 - Ver descripción" + "\n" +
                        "  2 - Apuntarse" + "\n"

        );
    }
    public void misClubes(Usuario user){
        Vector <Club> clubes = user.getClubes();
        System.out.println("[0]Salir");
        for (int i = 0; i < user.getClubes().size(); i++ ){
            System.out.println("["+i+1+"]" + clubes.elementAt(i).getNombre());
        }

    }

    public void menuclubapuntado(Club club,Usuario user) { //del club en el que estás registrado
        if(club.getAdmin() != user.getNumExp()){
            System.out.print(
                    "\n-------- CLUB --------" + "\n" +
                            "  0 - Salir" + "\n" +
                            "  1 - Ver actividades" + "\n" +
                            "  2 - Ver miembros" + "\n" +
                            "  3 - Apuntarse a una actividad" + "\n" +
                            "  4 - Ver tablón de anuncios" + "\n" +
                            "  5 - Quitarse de una actividad" + "\n"

            );

        }
        else{
            System.out.print(
                    "\n-------- CLUB --------" + "\n" +
                            "  0 - Salir" + "\n" +
                            "  1 - Ver actividades" + "\n" +
                            "  2 - Ver miembros" + "\n" +
                            "  3 - Apuntarse a una actividad" + "\n" +
                            "  4 - Ver tablón de anuncios" + "\n" +
                            "  5 - Quitarse de una actividad" + "\n" +
                            "  6 -  Menú admin"+ "\n"
            );
        }

    }
    public void menuadmin(){

    }

    public void verTodosClubes(){
        System.out.println("1. Matemáticas \n" +
                "2. Física\n" +
                "3. Biología\n" +
                "4. Literatura\n" +
                "5. Filosofía\n" +
                "6. Atletismo\n" +
                "7. Tenis\n" +
                "8. Padel\n" +
                "9. Fútbol\n" +
                "10. Basket\n" +
                "11. Alpinismo\n" +
                "12. Ciclismo\n" +
                "13. Programación\n" +
                "14. E-Sports\n" +
                "15. Robótica\n");
    }

    public static void pulsaCualquierTeclaParaContinuar() {
        System.out.println("pulsa la tecla enter para continuar...");
        try {
            System.in.read(); // espera una entrada por el usuario para continuar la ejecucion del programa
        } catch (Exception e) {
        }
    }



/* MENU EJEMPLO PARA COGER COPY PASTE
    public static int pintar_menu_recoger_opcion () {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        // Informar de las opciones
        System.out.print(
                "\n-------- Bienvenidos al ALMACENAMIENTO --------" + "\n" +
                        "  0 - Salir" + "\n" +
                        "  1 - Datos de usuario productos" + "\n" +
                        "  2 - Listar almacenamiento" + "\n" +
                        "  3 - Exportar y Guardar almacenamiento" + "\n" +
                        "  4 - Eliminar 1 producto" + "\n" +
                        "  5 - Buscar producto por ID" + "\n" +
                        "  6 - Cargar almacenamiento guardado" + "\n" +
                        "OpciÃ³n:"
        );
        // recoger la opcion
        if (teclado.hasNextInt()) {
            opcion = teclado.nextInt();
        }
        else {
            teclado.next(); // Vaciar la basura del teclado...
        }
        return opcion;}*/












}