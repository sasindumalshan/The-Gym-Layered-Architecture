package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.dto.SupplierDTO;
import lk.ijse.theGym.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends CrudBO<SupplierDTO, String> {
    String getCount() throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;

    Supplier getSupplier(String id) throws SQLException, ClassNotFoundException;

    String getLastId() throws SQLException, ClassNotFoundException;

    String getComName(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getSearchName(String name) throws SQLException, ClassNotFoundException;

    ArrayList<String> getSearchId(String id) throws SQLException, ClassNotFoundException;
}
