package view.students;

import java.util.List;
import java.util.Scanner;

import model.NotaFinal;
import services.common.NotasService;

public class ViewStudent {

    private static final Scanner in = new Scanner(System.in);
    private static final NotasService notaService = new NotasService();

    public static void showMenuStudent() {

        int options;

        do {
            System.out.println("\n=== MENÚ ESTUDIANTE ===");
            System.out.println("1. Consultar mis notas");

            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            options = in.nextInt();
            in.nextLine();

            switch (options) {
                case 1:
                    consultarMisNotas();
                    break;
                case 2:
                    System.out.println("Listando materias...");
                    break;
                case 3:
                    System.out.println("Mostrando datos personales...");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (options != 0);
    }

    private static void consultarMisNotas() {
        System.out.print("\nIngrese su ID de estudiante: ");
        int idEstudiante = in.nextInt();
        in.nextLine();

        List<NotaFinal> notasFinales = notaService.obtenerNotasFinalesPorEstudiante(idEstudiante);

        if (notasFinales == null || notasFinales.isEmpty()) {
            System.out.println("No se encontraron notas finales para este estudiante.");
            return;
        }

        System.out.println("\n=== NOTAS FINALES ===");
        for (NotaFinal nota : notasFinales) {
            System.out.println("-----------------------------------");
            System.out.println("Materia ID: " + nota.getIdMateria());
            System.out.println("Promedio Final: " + nota.getPromedioFinal());
            System.out.println("Estado ID: " + nota.getIdEstado());
        }
        System.out.println("-----------------------------------");
    }
}