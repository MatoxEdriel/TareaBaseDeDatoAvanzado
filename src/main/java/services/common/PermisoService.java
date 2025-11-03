package services.common;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import mapper.RolPermisoMapper;
import model.Permiso;
import utils.MyBatisUtil;

public class PermisoService {

    public List<Permiso> obtenerPermisosPorRol(int rolId) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            RolPermisoMapper mapper = session.getMapper(RolPermisoMapper.class);
            return mapper.selectPermisosPorRolId(rolId);
        } catch (Exception e) {
            System.err.println(" Error al obtener permisos: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}