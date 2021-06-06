package ppal;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import Clubes.Club;
import Clubes.Evento;
import Usuarios.Usuario;

import java.util.HashMap;

import static java.awt.SystemColor.menu;

public class ppal {
    Scanner teclado = new Scanner(System.in);

    static final HashMap<Integer, String> exppass = new HashMap<>();
    static final HashMap<Integer, Usuario> expuser = new HashMap<>();
    static final HashMap<String, Integer> explogin = new HashMap<>();

    public static void crearclubes(Club[] clubes) {

        clubes[0] = new Club("Matemáticas", "", 12);
        clubes[2] = new Club("Física", "", 12);
        clubes[3] = new Club("Biología", "", 12);
        clubes[4] = new Club("Literatura", "", 12);
        clubes[5] = new Club("Filosofía", "", 12);
        clubes[6] = new Club("Atletismo", "", 12);
        clubes[7] = new Club("Tenis", "", 12);
        clubes[8] = new Club("Padel", "", 12);
        clubes[9] = new Club("Futbol", "", 12);
        clubes[10] = new Club("Basket", "", 12);
        clubes[11] = new Club("Alpinismo", "", 12);
        clubes[12] = new Club("Programación", "", 12);
        clubes[13] = new Club("E-Sports", "", 12);
        clubes[14] = new Club("Roboótica", "", 12);
    }

    public static void registro() {
        Scanner teclado = new Scanner(System.in);

        int numExp = 0;

        String nombre = "";
        String apellido = "";
        String carrera = "";
        String contraseña = "";

        boolean correcto = false;
        String numero_Expediente = "";

        do {
            System.out.println("Numero expediente: ");
            numero_Expediente = teclado.nextLine();
            if (numero_Expediente.matches("[0-9]*")) { // validar que la entrada sea numeria
                correcto = true;
            } else {
                correcto = false;
            }
        } while (!correcto);

        
        numExp = Integer.parseInt(numero_Expediente);

        System.out.println("Nombre: ");
        while (!teclado.hasNextLine()) {
            System.out.print("Error! Nombre: ");
            teclado.next();
        }
        nombre = teclado.nextLine();

        System.out.println("Apellido: ");
        while (!teclado.hasNextLine()) {
            System.out.print("Error! Apellido: ");
            teclado.next();
        }
        apellido = teclado.nextLine();

        System.out.println("Carrera: ");
        while (!teclado.hasNextLine()) {
            System.out.print("Error! Carrera: ");
            teclado.next();
        }
        carrera = teclado.nextLine();

        System.out.println("Contraseña: ");
        while (!teclado.hasNextLine()) {
            System.out.print("Error! Contraseña: ");
            teclado.next();
        }
        contraseña = teclado.nextLine();

        System.out.println("Gracias por registrarte!");

        exppass.put(numExp, contraseña);
        expuser.put(numExp, new Usuario(numExp, nombre, apellido, carrera, contraseña));
        explogin.put("", numExp);

    }

    public static boolean inicioSesion(int exp) {
        String password = "";
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Contraseña: ");
            while (!teclado.hasNextLine()) {
                System.out.print("Error! Contraseña: ");
                teclado.next();
            }
            password = teclado.nextLine();
        }  while  (!password.equals(exppass.get(exp)));

        if (password.equals(exppass.get(exp))) {
            Usuario actual = expuser.get(exp);
            return true;
        } else {
            System.out.println("Contraseña incorrecta");
            return false;
        }
    }

    public void hacerLider(int Exp) {
        Usuario x = expuser.get(Exp);
        x.setLider(true);
    }

    public static void main(String[] args) {
        Club clubes[] = new Club[15];
        crearclubes(clubes);
        Menu menu = new Menu();
        Scanner teclado = new Scanner(System.in);
        boolean correcto = false;
        int exp = 0;
        int opt = -1;
        int opt1 = -1;
        int optUser = -1;
        int optClub = -1;
        boolean registrado = false;

        while (opt != 0) {
            opt = menu.menuinicial();
            switch (opt) {
                case 1:
                    registro();
                    registrado = true;
                    break;
                case 2:
                    while (!registrado) {
                        System.out.print("Error! Registrate primero!\n");
                        registro();
                        registrado = true;
                    }
                    System.out.println("--------BIENVENIDO AL LOGIN--------");
                    do {
                        System.out.println("Numero expediente: ");
                        while (!teclado.hasNextInt()) {
                            System.out.print("Error! numero: ");
                            teclado.next();
                        }
                        exp = teclado.nextInt();
                    } while (!explogin.containsValue(exp));

                    correcto = inicioSesion(exp);
                    opt1 = -1;
                    optUser = -1;
                    optClub = -1;
                    if (correcto = true) {
                        Usuario user = expuser.get(exp);
                        while (opt1 != 0) {
                            opt1 = menu.Menu1();

                            switch (opt1) {
                                case 1:
                                    while (optUser != 0) {
                                        optUser = menu.menuUsuario();
                                        switch (optUser) {
                                            case 1:
                                                System.out.println(user.toString());
                                                pulsaCualquierTeclaParaContinuar();
                                                break;
                                            case 2:
                                                user.ModDAtos();
                                                exppass.replace(user.getNumExp(), user.getContraseña());
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta");
                                        }
                                    }
                                    break;
                                case 2:
                                    while (optClub != 0) {
                                        optClub = menu.menuClubes();
                                        switch (optClub) {
                                            case 1:
                                                menu.verTodosClubes();
                                                System.out.println("Selecciona un club");
                                                int optTodos = teclado.nextInt();
                                                int apuntado = 0;
                                                if (user.getClubes().size() > 0) {
                                                    for (int i = 0; i < user.getClubes().size(); i++) {
                                                        Club actual = (Club) user.getClubes().elementAt(i);
                                                        if (clubes[optTodos - 1].getNombre().equals(actual.getNombre()))
                                                            apuntado = 1;
                                                        break;
                                                    }
                                                }
                                                if (apuntado == 0 || user.getClubes().size() == 0) {
                                                    menu.menuclubnoapuntado();
                                                    int noapunt = teclado.nextInt();
                                                    switch (noapunt) {
                                                        case 0:
                                                            break;
                                                        case 1:
                                                            System.out.println(clubes[optTodos - 1].getDescripcion());
                                                            break;
                                                        case 2:
                                                            clubes[optTodos - 1].setMiembros(clubes[optTodos - 1].getMiembros() + 1);
                                                            user.añadirClub(clubes[optTodos - 1]);
                                                            System.out.println("Bienvenido");
                                                            clubes[optTodos - 1].setAdmin(user.getNumExp());
                                                    }
                                                } else {
                                                    menu.menuclubapuntado(clubes[optTodos-1],user);
                                                    int optapt = teclado.nextInt();
                                                    switch (optapt) {
                                                        case 0:
                                                            break;
                                                        case 1: // VER ACTIVIDAD
                                                            if(clubes[optTodos-1].getHorario().size() > 0){
                                                            ArrayList<Evento> VerEventos = clubes[optTodos-1].getHorario();
                                                                for (int i = 0; i < VerEventos.size(); i++) {
                                                                    System.out.println("[" + i + 1 + "] " + VerEventos.toString());
                                                                }
                                                            }
                                                            else
                                                                System.out.println("No hay actividades disponibles");
                                                            break;

                                                        case 2:
                                                            System.out.println(clubes[optTodos - 1].getMiembros());
                                                            break;

                                                        case 3:
                                                            if(clubes[optTodos-1].getHorario().size() > 0){
                                                                Evento[] actividad = new Evento[clubes[optTodos - 1].getHorario().size()];
                                                                for (int i = 0; i < clubes[optTodos - 1].getHorario().size(); i++) {
                                                                    System.out.println("[" + i + 1 + "]" + clubes[optTodos - 1].getHorario().get(i).getNombre());
                                                                    actividad[i] = clubes[optTodos - 1].getHorario().get(i);

                                                                }
                                                                System.out.println("Elige una actividad");
                                                                int act = teclado.nextInt();
                                                                user.ApuntarActividad(actividad[act]);
                                                                clubes[optTodos-1].getHorario().get(act).setApuntados(clubes[optTodos].getHorario().get(act).getApuntados() + 1);

                                                            }
                                                            else
                                                                System.out.println("No hay actividades disponibles");
                                                            break;

                                                        case 4:
                                                            if(clubes[optTodos].getTablon().size() > 0){
                                                                for (int i = 0; i < clubes[optTodos].getTablon().size(); i++) {
                                                                    System.out.println("[" + i + 1 + "]" + clubes[optTodos].getTablon().get(i).toString());
                                                                    System.out.println("-------------------------------------------------------------");
                                                                }
                                                            }
                                                           else
                                                               System.out.println("No hay anuncios");
                                                            break;
                                                        case 5:
                                                            if (user.getActividades().size() > 0) {
                                                                for (int i = 0; i < user.getActividades().size(); i++) {
                                                                    System.out.println("[" + i + 1 + "]" + user.getActividades().elementAt(i).getNombre());
                                                                }
                                                                System.out.println("Selecciona una actividad");
                                                                int elimact = teclado.nextInt();
                                                                user.getActividades().elementAt(elimact).setApuntados(user.getActividades().elementAt(elimact).getApuntados() - 1);
                                                                user.getActividades().removeElementAt(elimact);
                                                            } else
                                                                System.out.println("No tienes actividades");
                                                            break;

                                                        case 6:
                                                            clubes[optTodos-1].Menu();


                                                        default:
                                                            break;

                                                    }
                                                }


                                                break;
                                            case 2:
                                                if (user.getClubes().size() > 0) {
                                                    menu.misClubes(user);
                                                    int myClub = teclado.nextInt();
                                                    Club actual = (Club) user.getClubes().elementAt(myClub-1);
                                                    menu.menuclubapuntado(actual,user);
                                                    int optapt = teclado.nextInt();
                                                    switch (optapt) {
                                                        case 0:
                                                            break;
                                                        case 2:
                                                            System.out.println(actual.getMiembros());
                                                            break;
                                                        case 1:
                                                            if(actual.getHorario().size() > 0){
                                                                for (int i = 0; i < actual.getHorario().size(); i++) {
                                                                    System.out.println("[" + i + 1 + "]" + actual.getHorario().get(i).toString());

                                                                }

                                                            }
                                                            else
                                                                System.out.println("No hay actividades disponibles");
                                                            break;

                                                        case 3:
                                                            if(actual.getHorario().size() > 0){
                                                                Evento[] actividad = new Evento [actual.getHorario().size()];
                                                                for (int i = 0; i < actual.getHorario().size(); i++) {
                                                                    System.out.println("[" + i + 1 + "]" + actual.getHorario().get(i).getNombre());
                                                                    actividad[i] = actual.getHorario().get(i);

                                                                }
                                                                System.out.println("Elige una actividad");
                                                                int act = teclado.nextInt();
                                                                user.ApuntarActividad(actividad[act]);
                                                                actual.getHorario().get(act).setApuntados(actual.getHorario().get(act).getApuntados() + 1);

                                                            }
                                                            else
                                                                System.out.println("No hay actividades disponibles");
                                                            break;

                                                        case 4:
                                                            if(actual.getTablon().size() > 0){
                                                                for (int i = 0; i < actual.getTablon().size(); i++) {
                                                                    System.out.println("[" + i + 1 + "]" + actual.getTablon().get(i).toString());
                                                                    System.out.println("-------------------------------------------------------------");
                                                                }
                                                            }
                                                            else
                                                                System.out.println("No hay anuncios");
                                                            break;
                                                        case 5:
                                                            if (user.getActividades().size() > 0) {
                                                                for (int i = 0; i < user.getActividades().size(); i++) {
                                                                    System.out.println("[" + i + 1 + "]" + user.getActividades().elementAt(i).getNombre());
                                                                }
                                                                System.out.println("Selecciona una actividad");
                                                                int elimact = teclado.nextInt();
                                                                user.getActividades().elementAt(elimact).setApuntados(user.getActividades().elementAt(elimact).getApuntados() - 1);
                                                                user.getActividades().removeElementAt(elimact);
                                                            } else
                                                                System.out.println("No tienes actividades");
                                                            break;

                                                        case 6:
                                                            actual.Menu();
                                                            break;
                                                        default:
                                                            break;

                                                    }
                                                }
                                               else
                                                   System.out.println("No estás apuntado a ningún club");

                                                break;

                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta");
                                        }
                                    }
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Opción incorrecta");
                            }
                        }
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }

    public static void pulsaCualquierTeclaParaContinuar() {
        System.out.println("pulsa la tecla enter para continuar...");
        try {
            System.in.read(); // espera una entrada por el usuario para continuar la ejecucion del programa
        } catch (Exception e) {
        }
    }
}