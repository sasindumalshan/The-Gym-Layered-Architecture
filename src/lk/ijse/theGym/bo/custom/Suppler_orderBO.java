package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.dto.SupplierOrderDTO;
import lk.ijse.theGym.dto.SupplierOrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Suppler_orderBO {
    ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;

    ArrayList<String> searchIDOrCustomerId(String text) throws SQLException, ClassNotFoundException;

    String getIds() throws SQLException, ClassNotFoundException;

    boolean setOrder(ArrayList<SupplierOrderDetailsDTO> orderDetails, SupplierOrderDTO supplierOrder) throws SQLException;


}
