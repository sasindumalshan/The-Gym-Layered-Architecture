package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dao.custom.PackageDAO;
import lk.ijse.theGym.entity.Package;

import java.sql.SQLException;
import java.util.ArrayList;

public class PackageDAOImpl implements PackageDAO {
    @Override
    public ArrayList<Package> getAll() throws SQLException, ClassNotFoundException {
        return null;

    }

    @Override
    public boolean save(Package dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Package dto) throws SQLException, ClassNotFoundException {
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
    public ArrayList<Package> get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
