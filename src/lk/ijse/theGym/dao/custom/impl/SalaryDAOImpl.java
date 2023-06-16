package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dao.custom.SalaryDAO;
import lk.ijse.theGym.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public ArrayList<Salary> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Salary dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Salary dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(Salary salary) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Salary salary) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Salary> search(Salary salary) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Salary> get(Salary salary) throws SQLException, ClassNotFoundException {
        return null;
    }
}
