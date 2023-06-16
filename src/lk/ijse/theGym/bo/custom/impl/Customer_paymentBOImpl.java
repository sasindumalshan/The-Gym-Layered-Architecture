package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Customer_paymentBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Customer_paymentDAO;
import lk.ijse.theGym.dto.CustomerPaymentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Customer_paymentBOImpl implements Customer_paymentBO {
    Customer_paymentDAO customer_paymentDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Customer_paymentDAO);
    @Override
    public ArrayList<CustomerPaymentDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CustomerPaymentDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerPaymentDTO dto) throws SQLException, ClassNotFoundException {
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
