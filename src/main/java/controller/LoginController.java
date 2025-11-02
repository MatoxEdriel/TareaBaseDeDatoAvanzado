package controller;

import java.util.List;

import model.Permiso;
import model.Rol;
import services.LoginService;
import services.PermisoService;
import view.admin.ViewAdmin;
import view.professor.ViewProfessor;
import view.students.ViewStudent;

public class LoginController {

    private static LoginService loginService = new LoginService();
    private static PermisoService permisoService = new PermisoService();

    public static void login(String nombreRol) {

        Rol rol = loginService.obtenerRolPorNombre(nombreRol);

        List<Permiso> permisos = permisoService.obtenerPermisosPorRol(rol.getId());

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