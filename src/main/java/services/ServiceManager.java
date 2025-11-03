package services;

import services.common.LoginService;
import services.common.NotasService;
import services.common.PermisoService;

public class ServiceManager {

    private static ServiceManager instance;

    private final LoginService loginService;
    private final PermisoService permisoService;
    private final NotasService notasService;
    

    private ServiceManager() {
        this.loginService = new LoginService();
        this.permisoService = new PermisoService();
        this.notasService = new NotasService();
    }

    public static ServiceManager getInstance() {
        if (instance == null) {
            instance = new ServiceManager();
        }
        return instance;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public PermisoService getPermisoService() {
        return permisoService;
    }

    public NotasService getNotasService() {
        return notasService;
    }

}
