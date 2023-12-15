package dao;

import java.util.ArrayList;
import model.Pais;

public interface IGenericDao<Object> {

    long insert(Pais obj);
    long update(Pais obj);
    long delete(Pais obj);
    ArrayList<Pais> getAll();
    Pais getById(int id);
}

