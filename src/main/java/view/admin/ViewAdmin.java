package view.admin;

import java.util.Scanner;

public class ViewAdmin {

    public static void showMenuAdmin() {

        Scanner in = new Scanner(System.in);
        int options;
        do {
            System.out.println("\n=== MENÚ ADMINISTRADOR ===");
            System.out.println("1. Gestionar usuarios");
            System.out.println("2. Ver reportes");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            options = in.nextInt();

            switch (options) {
                case 1:
                    System.out.println("Función para gestionar usuarios...");
                    break;
                case 2:
                    System.out.println("Mostrando reportes...");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (options != 0);

    }
}
