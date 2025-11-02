package view.professor;

import java.util.Scanner;

public class ViewProfessor {
    public static void showMenuProfessor() {

        Scanner in = new Scanner(System.in);
        int options;

        do {
            System.out.println("\n=== MENÚ DOCENTE ===");
            System.out.println("1. Ingresar notas de estudiantes");
            System.out.println("2. Modificar notas");
            System.out.println("3. Consultar notas de un estudiante");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            options = in.nextInt();
            in.nextLine(); 

            switch (options) {
                case 1:
                    System.out.println("Ingresando notas...");
              
                    break;
                case 2:
                    System.out.println("Modificando notas...");
                   
                    break;
                case 3:
                    System.out.println("Consultando notas...");
   
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (options != 0);

    }
}
