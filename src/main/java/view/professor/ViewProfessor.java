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
                    ingresarNota();
                    break;
                case 2:
                    System.out.println("Modificando notas...");
                    editarNota();
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

        System.out.print("ID de la materia: ");
        nota.setIdMateria(in.nextInt());
        in.nextLine();
        nota.setDeberes(leerNotaValida("nota de deberes"));
        nota.setTalleres(leerNotaValida("nota de talleres"));
        nota.setLecciones(leerNotaValida("nota de lecciones"));
        nota.setExamen(leerNotaValida("nota de examen"));

        notaService.crearNota(nota);
    }

    private static BigDecimal leerNotaValida(String nombreCampo) {
        BigDecimal nota;
        do {
            System.out.print("Ingrese " + nombreCampo + " (0 a 10): ");
            double valor = in.nextDouble();
            if (valor < 0 || valor > 10) {
                System.out.println("La nota debe estar entre 0 y 10.");
                nota = null;
            } else {
                nota = BigDecimal.valueOf(valor);
            }
        } while (nota == null);
        return nota;
    }

    private static void editarNota() {
        System.out.print("\nIngrese el ID de la nota que desea modificar: ");
        int idNota = in.nextInt();
        in.nextLine();

        NotaPrimerParcial nota = new NotaPrimerParcial();
        nota.setId(idNota);

        System.out.println("\n--- Actualización de Notas ---");
        nota.setDeberes(leerNotaValida("nueva nota de deberes"));
        nota.setTalleres(leerNotaValida("nueva nota de talleres"));
        nota.setLecciones(leerNotaValida("nueva nota de lecciones"));
        nota.setExamen(leerNotaValida("nueva nota de examen"));

        notaService.editarNota(nota);
    }

}
