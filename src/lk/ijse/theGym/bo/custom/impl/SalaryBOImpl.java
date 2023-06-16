package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.bo.custom.SalaryBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.SalaryDAO;
import lk.ijse.theGym.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBOImpl implements SalaryBO {
    SalaryDAO salaryDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SalaryDAO);
    @Override
    public ArrayList<SalaryDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existByID(String s) throws SQLException, ClassNotFoundException {
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
}
