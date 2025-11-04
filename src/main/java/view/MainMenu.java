package view;

import java.util.Scanner;

import controller.LoginController;

public class MainMenu {

    public static void showMenu() {
        Scanner in = new Scanner(System.in);
        int options;

        do {
            System.out.println("===================================");
            System.out.println("  SISTEMA DE GESTIÓN ACADÉMICA ");
            System.out.println("===================================");
            System.out.println("1. Ingresar como Administrador");
            System.out.println("2. Ingresar como Docente");
            System.out.println("3. Ingresar como Estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            options = in.nextInt();
            in.nextLine();

            switch (options) {
                case 1:
                    LoginController.login("admin");
                    break;
                case 2:
                    LoginController.login("docente");
                    break;
                case 3:
                    LoginController.login("estudiante");
                    break;
                case 0:
                    System.out.println(" Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (options != 0);
        in.close();
    }

}
