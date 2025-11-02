package controller;

import services.LoginService;
import view.admin.ViewAdmin;
import view.professor.ViewProfessor;
import view.students.ViewStudent;

public class LoginController {

    private static LoginService loginService = new LoginService();

    public static void login(String nombreRol) {

        String rol = loginService.obtenerRolPorNombre(nombreRol);

        switch (rol.toLowerCase()) {
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