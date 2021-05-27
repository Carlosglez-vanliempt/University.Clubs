package Usuarios;
import java.util.Vector;
import java.util.Scanner;
public class Miembro {
    Scanner in = new Scanner(System.in);
    Vector clubes;
    Vector actividades;

    public void ApuntarActividad(){
    }
    public void añadirClub(int opt, String [] club){
    System.out.println("Elige un club");
    System.out.println("1. Matemáticas \n" +
            "2. Física\n" +
            "3. Biología\n" +
            "4.Literatura\n" +
            "5.Filosofía\n" +
            "6.Atletismo\n" +
            "7.Tenis\n" +
            "8.Padel\n" +
            "9.Fútbol\n" +
            "10. Basket\n" +
            "11. Alpinismo\n" +
            "12. Ciclismo\n" +
            "13. Programación\n" +
            "14. E-Sports\n" +
            "15. Robótica");
    opt = in.nextInt();
    clubes.addElement(club[opt-1]);
    }
    public void eliminarClub(int opt){
        System.out.println("Elige un club");
        for (int i = 0; i < clubes.size();i++){
            System.out.println(i+1 +""+ clubes.elementAt(i));
        }
        opt = in.nextInt();
        clubes.removeElementAt(opt-1);
    }
    public void borrarActividad(String actividad){

    }


}
