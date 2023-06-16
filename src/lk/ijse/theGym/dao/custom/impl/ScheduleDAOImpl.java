package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dao.custom.ScheduleDAO;
import lk.ijse.theGym.entity.Schedule;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public ArrayList<Schedule> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Schedule dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Schedule dto) throws SQLException, ClassNotFoundException {
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
    public ArrayList<Schedule> get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
