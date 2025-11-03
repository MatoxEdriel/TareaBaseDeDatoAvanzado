package services.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mapper.NotaPrimerParcialMapper;
import mapper.NotaSegundoParcialMapper;
import model.NotaFinal;
import model.NotaPrimerParcial;
import model.NotaPrimerParcialExample;
import model.NotaSegundoParcial;
import model.NotaSegundoParcialExample;
import utils.MyBatisUtil;

public class NotasService {

    public void crearNota(NotaPrimerParcial nota) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            NotaPrimerParcialMapper mapper = session.getMapper(NotaPrimerParcialMapper.class);
            mapper.insert(nota);
            session.commit();
            System.out.println("Nota ingresada  uwu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarNota(NotaPrimerParcial nota) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            NotaPrimerParcialMapper mapper = session.getMapper(NotaPrimerParcialMapper.class);
            mapper.updateByPrimaryKey(nota);
            session.commit();
            System.out.println("Nota actualizada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<NotaPrimerParcial> obtenerTodas() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            NotaPrimerParcialMapper mapper = session.getMapper(NotaPrimerParcialMapper.class);
            NotaPrimerParcialExample example = new NotaPrimerParcialExample();
            return mapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Segundo parcial.

    public void crearNotaSegundoParcial(NotaSegundoParcial nota) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            NotaSegundoParcialMapper mapper = session.getMapper(NotaSegundoParcialMapper.class);
            mapper.insert(nota);
            session.commit();
            System.out.println("nota de segundo parcial ingresada correctamente.");
        } catch (Exception e) {
            System.err.println(" Error al insertar nota de segundo parcial:");
            e.printStackTrace();
        }
    }

    public void editarNotaSegundoParcial(NotaSegundoParcial nota) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            NotaSegundoParcialMapper mapper = session.getMapper(NotaSegundoParcialMapper.class);
            mapper.updateByPrimaryKey(nota);
            session.commit();
            System.out.println("Nota de segundo parcial actualizada correctamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar nota de segundo parcial:");
            e.printStackTrace();
        }
    }

    public List<NotaSegundoParcial> obtenerNotasSegundoParcial() {
        try (SqlSession session = MyBatisUtil.getSession()) {
            NotaSegundoParcialMapper mapper = session.getMapper(NotaSegundoParcialMapper.class);
            NotaSegundoParcialExample example = new NotaSegundoParcialExample();
            return mapper.selectByExample(example);
        } catch (Exception e) {
            System.err.println(" Error al obtener notas de segundo parcial:");
            e.printStackTrace();
            return null;
        }
    }

    public List<NotaFinal> obtenerNotasFinalesPorEstudiante(int idEstudiante) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            mapper.NotaFinalMapper mapper = session.getMapper(mapper.NotaFinalMapper.class);

            model.NotaFinalExample example = new model.NotaFinalExample();
            example.createCriteria().andIdEstudianteEqualTo(idEstudiante);

            return mapper.selectByExample(example);
        } catch (Exception e) {
            System.err.println("Error al obtener las notas finales del estudiante:");
            e.printStackTrace();
            return null;
        }
    }

}
