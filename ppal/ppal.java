package ppal;
import java.awt.*;
import java.util.Scanner;

import usuarios.Usuario;

import java.util.HashMap;

import static java.awt.SystemColor.menu;

public class ppal {
    Scanner teclado = new Scanner(System.in);

    static final HashMap<Integer, String> exppass = new HashMap<>();
    static final HashMap<Integer, Usuario> expuser = new HashMap<>();
    static final HashMap<String, Integer> explogin = new HashMap<>();

    public static void registro() {
        Scanner teclado = new Scanner(System.in);

        int numExp = 0;

        String nombre = "";
        String apellido = "";
        String carrera = "";
        String contraseña = "";

        System.out.println("Numero expediente: ");
        while (!teclado.hasNextInt()) {
            System.out.print("Error! numero: ");
            teclado.next();
        }
        numExp = teclado.nextInt();

        System.out.println("Nombre: ");
        while (!teclado.hasNext()) {
            System.out.print("Error! Nombre: ");
            teclado.next();
        }
        nombre = teclado.next();

        System.out.println("Apellido: ");
        while (!teclado.hasNext()) {
            System.out.print("Error! Apellido: ");
            teclado.next();
        }
        apellido = teclado.next();

        System.out.println("Carrera: ");
        while (!teclado.hasNext()) {
            System.out.print("Error! Carrera: ");
            teclado.next();
        }
        carrera = teclado.next();

        System.out.println("Contraseña: ");
        while (!teclado.hasNext()) {
            System.out.print("Error! Contraseña: ");
            teclado.next();
        }
        contraseña = teclado.next();

        System.out.println("Gracias por registrarte!");

        exppass.put(numExp, contraseña);
        expuser.put(numExp, new Usuario(numExp, nombre, apellido, carrera, contraseña));
        explogin.put("", numExp);

    }

    public static boolean inicioSesion(int exp) {
        String password = "";
        Scanner teclado = new Scanner(System.in);

        do{
            System.out.println("Contraseña: ");
            while (!teclado.hasNext()) {
                System.out.print("Error! Contraseña: ");
                teclado.next();
            }
            password = teclado.next();
        } while  (!password.equals(exppass.get(exp)));

        if (password.equals(exppass.get(exp))) {
            Usuario actual = expuser.get(exp);
            return true;
        } else {
            System.out.println("Contraseña incorrecta");
            return false;
        }
    }

    public void hacerLider (int Exp) {
        Usuario x = expuser.get(Exp);
        x.setLider(true);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner teclado = new Scanner(System.in);
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

                    boolean correcto = inicioSesion(exp);

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
                                                break;
                                            case 2:
                                                user.ModDAtos();
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Opción incorrecta");
                                        }
                                    }
                                    break;
                                case 2:
                                    while (optClub != 0){
                                        optClub = menu.menuClubes();
                                        switch (optClub){
                                            case 1:
                                                menu.verTodosClubes();
                                                break;
                                            case 2:
                                                menu.misClubes(user);
                                                break;
                                            case 3:
                                                //usuario.añadirClub();
                                                //REGISTRARME EN CLUB
                                                //UNA VEZ REGISTRADO EN EL CLUB
                                                //ACCEDO AL MENU DE CLUB
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
}


