package view.students;

import java.util.Scanner;

public class ViewStudent {
    public static void showMenuStudent() {

        Scanner in = new Scanner(System.in);
        int options;

        do {
            System.out.println("\n=== MENÚ ESTUDIANTE ===");
            System.out.println("1. Consultar mis notas");
            System.out.println("2. Consultar mis materias");
            System.out.println("3. Ver mi información personal");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            options = in.nextInt();
            in.nextLine();

            switch (options) {
                case 1:
                    System.out.println("📚 Mostrando tus notas...");
                    break;
                case 2:
                    System.out.println("🧾 Listando materias...");
                    break;
                case 3:
                    System.out.println("👤 Mostrando datos personales...");
                    break;
                case 0:
                    System.out.println("🔙 Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida. Intente nuevamente.");
            }
        } while (options != 0);
        in.close();

    }
}
