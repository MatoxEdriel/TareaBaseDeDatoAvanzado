package services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mapper.NotaPrimerParcialMapper;
import model.NotaPrimerParcial;
import model.NotaPrimerParcialExample;
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
}
