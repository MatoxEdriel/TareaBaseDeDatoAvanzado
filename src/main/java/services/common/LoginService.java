package services.common;

import org.apache.ibatis.session.SqlSession;

import mapper.RolMapper;
import model.Rol;
import utils.MyBatisUtil;

public class LoginService {
    public Rol obtenerRolPorNombre(String nombreRol) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            RolMapper mapper = session.getMapper(RolMapper.class);
            Rol rol = mapper.selectByNombre(nombreRol);

            if (rol != null) {
                System.out.println("Rol encontrado: " + rol.getNombre());
            } else {
                System.out.println("Rol no encontrado: " + nombreRol);
            }
            return rol;
        } catch (Exception e) {
            System.err.println(" Error al obtener rol: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
