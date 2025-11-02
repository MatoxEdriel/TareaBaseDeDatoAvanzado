package services;

import org.apache.ibatis.session.SqlSession;

import mapper.RolMapper;
import model.Rol;
import utils.MyBatisUtil;

public class LoginService {
    public String obtenerRolPorNombre(String nombreRol) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            RolMapper mapper = session.getMapper(RolMapper.class);
            Rol rol = mapper.selectByNombre(nombreRol);

            if (rol != null) {
                System.out.println("Bienvenido xd " + rol.getNombre());
                return rol.getNombre();
            } else {
                System.out.println("" + nombreRol);
                return null;
            }
        } catch (Exception e) {
            System.err.println(" internal error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
