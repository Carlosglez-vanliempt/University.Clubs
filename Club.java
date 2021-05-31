import java.util.Scanner;

public class Club {
    private String nombre;
    private String descripcion;
    private String miembros;
    private String tablón;

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

    public String getTablón() {
        return tablón;
    }

    public void setTablón(String tablón) {
        this.tablón = tablón;
    }



    public void Menu(){
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
                    registrar_horario();

                    break;
                case "2":
                    crear_evento();

                    break;
                case "3":
                    cambiar_aula();

                    break;
                case "4":
                    cancelar_evento();

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
        }while (!menu.equals("0"));
    }

    private void registrar_horario(){}
    private void crear_evento(){}
    private void cambiar_aula(){}
    private void cancelar_evento(){}
    private void mod_inscripcion(){}
}
