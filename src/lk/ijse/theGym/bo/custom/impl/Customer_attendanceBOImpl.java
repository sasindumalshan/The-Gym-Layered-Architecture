package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Customer_attendanceBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.CustomerDAO;
import lk.ijse.theGym.dao.custom.Customer_attendanceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Customer_attendanceBOImpl implements Customer_attendanceBO {
    Customer_attendanceDAO customer_attendanceDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Customer_attendanceDAO);
    @Override
    public ArrayList<CustomerDAO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CustomerDAO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerDAO dto) throws SQLException, ClassNotFoundException {
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
