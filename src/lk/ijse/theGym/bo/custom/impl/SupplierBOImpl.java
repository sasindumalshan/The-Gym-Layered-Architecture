package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.bo.custom.SupplierBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.SupplierDAO;
import lk.ijse.theGym.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO supplierDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SupplierDAO);
    @Override
    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException {
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
