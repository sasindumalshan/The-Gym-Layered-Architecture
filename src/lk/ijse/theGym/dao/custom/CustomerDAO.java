package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dto.projection.CustomerPackageProjection;
import lk.ijse.theGym.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;


public interface CustomerDAO extends CrudDAO<Customer, String> {
    Customer getCustomer(String s) throws SQLException, ClassNotFoundException;

    String getCustomerCount() throws SQLException, ClassNotFoundException;

    String getPackageUsageCount(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllYears() throws SQLException, ClassNotFoundException;

    boolean updatePackage(String id, String packId) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerPackageProjection> getIdForData(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getPackage(String id) throws SQLException, ClassNotFoundException;
}
