package view.professor;

import java.math.BigDecimal;
import java.util.Scanner;

import model.NotaPrimerParcial;
import model.NotaSegundoParcial;
import services.common.NotasService;

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
        int idEstudiante = in.nextInt();

        System.out.print("ID de la materia: ");
        int idMateria = in.nextInt();

        in.nextLine();
        nota.setDeberes(leerNotaValida("nota de deberes"));
        nota.setTalleres(leerNotaValida("nota de talleres"));
        nota.setLecciones(leerNotaValida("nota de lecciones"));
        nota.setExamen(leerNotaValida("nota de examen"));

        notaService.crearNota(nota);

        System.out.print("\n¿Desea ingresar también las notas del SEGUNDO PARCIAL? (s/n): ");
        String opcion = in.next().trim().toLowerCase();

        if (opcion.equals("s")) {
            NotaSegundoParcial nota2 = new NotaSegundoParcial();
            nota2.setIdEstudiante(idEstudiante);
            nota2.setIdMateria(idMateria);

            System.out.println("\n--- Ingreso de notas SEGUNDO PARCIAL ---");
            nota2.setDeberes(leerNotaValida("deberes"));
            nota2.setTalleres(leerNotaValida("talleres"));
            nota2.setLecciones(leerNotaValida("lecciones"));
            nota2.setExamen(leerNotaValida("examen"));

            notaService.crearNotaSegundoParcial(nota2);
        }
        System.out.println("\nRegistro completado correctamente.");

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
        System.out.print("\n¿Desea editar notas del PRIMER o SEGUNDO PARCIAL? (1/2): ");
        int parcial = in.nextInt();
        in.nextLine();

        System.out.print("Ingrese el ID de la nota que desea modificar: ");
        int idNota = in.nextInt();
        in.nextLine();

        if (parcial == 1) {
            NotaPrimerParcial nota = new NotaPrimerParcial();
            nota.setId(idNota);

            System.out.println("\n--- Actualización de Notas (Primer Parcial) ---");
            nota.setDeberes(leerNotaValida("nueva nota de deberes"));
            nota.setTalleres(leerNotaValida("nueva nota de talleres"));
            nota.setLecciones(leerNotaValida("nueva nota de lecciones"));
            nota.setExamen(leerNotaValida("nueva nota de examen"));

            notaService.editarNota(nota);
        } else if (parcial == 2) {
            NotaSegundoParcial nota2 = new NotaSegundoParcial();
            nota2.setId(idNota);

            System.out.println("\n--- Actualización de Notas (Segundo Parcial) ---");
            nota2.setDeberes(leerNotaValida("nueva nota de deberes"));
            nota2.setTalleres(leerNotaValida("nueva nota de talleres"));
            nota2.setLecciones(leerNotaValida("nueva nota de lecciones"));
            nota2.setExamen(leerNotaValida("nueva nota de examen"));

            notaService.editarNotaSegundoParcial(nota2);
        } else {
            System.out.println(" Opción inválida. Solo 1 o 2.");
        }
    }

}
