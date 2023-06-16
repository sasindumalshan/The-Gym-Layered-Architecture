package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dao.custom.ExercisesDAO;
import lk.ijse.theGym.entity.Exercises;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExercisesDAOImpl implements ExercisesDAO {
    @Override
    public ArrayList<Exercises> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Exercises dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Exercises dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Exercises> get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
