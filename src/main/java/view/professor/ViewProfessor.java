package view.professor;
import services.NotasService;
import java.math.BigDecimal;
import java.util.Scanner;

import model.NotaPrimerParcial;

public class ViewProfessor {

    private static final Scanner in = new Scanner(System.in);
    private static final NotasService notaService = new NotasService();

    public static void showMenuProfessor() {

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

    private static void ingresarNota() {
        NotaPrimerParcial nota = new NotaPrimerParcial();

        System.out.println("\n--- Ingreso de Notas ---");
        System.out.print("ID del estudiante: ");
        nota.setIdEstudiante(in.nextInt());

        nota.setNotaDeberes(leerNotaValida("nota de deberes"));
        nota.setNotaTalleres(leerNotaValida("nota de talleres"));
        nota.setNotaLeccion(leerNotaValida("nota de lecciones"));
        nota.setNotaExamen(leerNotaValida("nota de examen"));

        BigDecimal promedio = calcularPromedio(
                nota.getNotaDeberes(),
                nota.getNotaTalleres(),
                nota.getNotaLeccion(),
                nota.getNotaExamen());
        nota.setPromedio(promedio);

        notaService.crearNota(nota);
    }

    private static void editarNota() {
        System.out.print("\nIngrese el ID de la nota que desea modificar: ");
        int idNota = in.nextInt();
        in.nextLine();

        NotaPrimerParcial nota = new NotaPrimerParcial();
        nota.setIdNota(idNota);

        System.out.println("\n--- Actualización de Notas ---");
        nota.setNotaDeberes(leerNotaValida("nueva nota de deberes"));
        nota.setNotaTalleres(leerNotaValida("nueva nota de talleres"));
        nota.setNotaLeccion(leerNotaValida("nueva nota de lecciones"));
        nota.setNotaExamen(leerNotaValida("nueva nota de examen"));

        BigDecimal promedio = calcularPromedio(
                nota.getNotaDeberes(),
                nota.getNotaTalleres(),
                nota.getNotaLeccion(),
                nota.getNotaExamen());
        nota.setPromedio(promedio);

        notaService.editarNota(nota);
    }

}
