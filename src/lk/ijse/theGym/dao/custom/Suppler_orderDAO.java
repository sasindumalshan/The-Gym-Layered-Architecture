package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dto.SupplierOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Suppler_orderDAO {
    ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;

    ArrayList<String> searchIDOrCustomerId(String text) throws SQLException, ClassNotFoundException;

    ArrayList<String> getIds() throws SQLException, ClassNotFoundException;

    boolean setOrder(SupplierOrderDTO supplierOrder) throws SQLException, ClassNotFoundException;
}
