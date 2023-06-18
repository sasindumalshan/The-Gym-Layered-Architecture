package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDAO extends CrudDAO<Supplier, String> {
    String getCount() throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;

    Supplier getSupplier(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getLastId() throws SQLException, ClassNotFoundException;

    String getComName(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getSearchName(String name) throws SQLException, ClassNotFoundException;

    public ArrayList<String> getSearchId(String id) throws SQLException, ClassNotFoundException;

}
