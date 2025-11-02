package controller;

import java.util.List;

import org.checkerframework.checker.units.qual.s;

import model.Permiso;
import model.Rol;

import services.ServiceManager;
import view.admin.ViewAdmin;
import view.professor.ViewProfessor;
import view.students.ViewStudent;

public class LoginController {

    private static final ServiceManager serviceManager = ServiceManager.getInstance();

    public static void login(String nombreRol) {

        Rol rol = serviceManager.getLoginService().obtenerRolPorNombre(nombreRol);

        List<Permiso> permisos = serviceManager.getPermisoService().obtenerPermisosPorRol(rol.getId());

        System.out.println("\nPermisos del rol '" + rol.getNombre() + "':");
        if (permisos != null && !permisos.isEmpty()) {
            for (Permiso p : permisos) {
                System.out.println(" - " + p.getNombre());
            }
        } else {
            System.out.println(" (Sin permisos asignados)");
        }

        switch (rol.getNombre().toLowerCase()) {
            case "admin":
                ViewAdmin.showMenuAdmin();
                break;
            case "docente":
                ViewProfessor.showMenuProfessor();
                break;
            case "estudiante":
                ViewStudent.showMenuStudent();
                break;
            default:
                System.out.println("Rol no reconocido.");
        }
    }
}