package view.admin;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import model.NotaFinal;
import model.NotaPrimerParcial;
import model.NotaSegundoParcial;
import services.common.NotasService;

public class ViewAdmin {

    private static final Scanner in = new Scanner(System.in);
    private static final NotasService notaService = new NotasService();

    public static void showMenuAdmin() {

        int options;
        do {
            System.out.println("\n=== MENÚ ADMINISTRADOR ===");
            System.out.println("1. Ingresar notas de estudiantes");
            System.out.println("2. Modificar notas");
            System.out.println("3. Consultar notas finales de un estudiante");
            System.out.println("4. Ver todas las notas finales");
            System.out.println("0. Volver");
            System.out.print("Seleccione: ");
            options = in.nextInt();

            switch (options) {
                case 1:
                    ingresarNota();
                    break;
                case 2:
                    editarNota();
                    break;
                case 3:
                    consultarNotasPorEstudiante();
                    break;
                case 4:
                    verTodasLasNotasFinales();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (options != 0);
    }

    private static void ingresarNota() {
        System.out.println("\n--- Ingreso de Notas (Admin) ---");
        System.out.print("ID del estudiante: ");
        int idEstudiante = in.nextInt();

        System.out.print("ID de la materia: ");
        int idMateria = in.nextInt();
        in.nextLine();

        NotaPrimerParcial nota1 = new NotaPrimerParcial();
        nota1.setIdEstudiante(idEstudiante);
        nota1.setIdMateria(idMateria);
        nota1.setDeberes(leerNotaValida("deberes"));
        nota1.setTalleres(leerNotaValida("talleres"));
        nota1.setLecciones(leerNotaValida("lecciones"));
        nota1.setExamen(leerNotaValida("examen"));
        notaService.crearNota(nota1);

        System.out.print("\n¿Desea ingresar también el segundo parcial? (s/n): ");
        String opcion = in.next().trim().toLowerCase();

        if (opcion.equals("s")) {
            NotaSegundoParcial nota2 = new NotaSegundoParcial();
            nota2.setIdEstudiante(idEstudiante);
            nota2.setIdMateria(idMateria);
            nota2.setDeberes(leerNotaValida("deberes 2"));
            nota2.setTalleres(leerNotaValida("talleres 2"));
            nota2.setLecciones(leerNotaValida("lecciones 2"));
            nota2.setExamen(leerNotaValida("examen 2"));
            notaService.crearNotaSegundoParcial(nota2);
        }

        System.out.println("\nRegistro completado correctamente.");
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
            System.out.println("\n--- Edición (Primer Parcial) ---");
            nota.setDeberes(leerNotaValida("nueva nota de deberes"));
            nota.setTalleres(leerNotaValida("nueva nota de talleres"));
            nota.setLecciones(leerNotaValida("nueva nota de lecciones"));
            nota.setExamen(leerNotaValida("nueva nota de examen"));
            notaService.editarNota(nota);

        } else if (parcial == 2) {
            NotaSegundoParcial nota2 = new NotaSegundoParcial();
            nota2.setId(idNota);
            System.out.println("\n--- Edición (Segundo Parcial) ---");
            nota2.setDeberes(leerNotaValida("nueva nota de deberes"));
            nota2.setTalleres(leerNotaValida("nueva nota de talleres"));
            nota2.setLecciones(leerNotaValida("nueva nota de lecciones"));
            nota2.setExamen(leerNotaValida("nueva nota de examen"));
            notaService.editarNotaSegundoParcial(nota2);

        } else {
            System.out.println("Opción inválida. Solo 1 o 2.");
        }
    }

    private static void consultarNotasPorEstudiante() {
        System.out.print("\nIngrese el ID del estudiante: ");
        int idEstudiante = in.nextInt();
        in.nextLine();

        List<NotaFinal> notas = notaService.obtenerNotasFinalesPorEstudiante(idEstudiante);

        if (notas == null || notas.isEmpty()) {
            System.out.println("No se encontraron notas finales para este estudiante.");
            return;
        }

        System.out.println("\n=== NOTAS FINALES DEL ESTUDINTE ===");
        for (NotaFinal nota : notas) {
            System.out.println("-----------------------------------");
            System.out.println("Materia ID: " + nota.getIdMateria());
            System.out.println("Promedio Final: " + nota.getPromedioFinal());
            System.out.println("Estado ID: " + nota.getIdEstado());
        }
        System.out.println("-----------------------------------");
    }

    private static void verTodasLasNotasFinales() {
        System.out.println("\n📘 === TODAS LAS NOTAS FINALES ===");
        List<NotaFinal> notas = notaService.obtenerNotasFinalesPorEstudiante(0); // 0 traerá todo si ajustas el mapper

        if (notas == null || notas.isEmpty()) {
            System.out.println("No hay registros de notas finales.");
            return;
        }

        for (NotaFinal nota : notas) {
            System.out.println("-----------------------------------");
            System.out.println("Estudiante ID: " + nota.getIdEstudiante());
            System.out.println("Materia ID: " + nota.getIdMateria());
            System.out.println("Promedio Final: " + nota.getPromedioFinal());
            System.out.println("Estado ID: " + nota.getIdEstado());
        }
        System.out.println("-----------------------------------");
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
}