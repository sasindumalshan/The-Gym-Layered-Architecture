package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.dto.CustomerDTO;
import lk.ijse.theGym.dto.projection.CustomerPackageProjection;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends CrudBO<CustomerDTO, String> {
    CustomerDTO getCustomer(String s) throws SQLException, ClassNotFoundException;

    ArrayList<String> getPackage(String id) throws SQLException, ClassNotFoundException;

    String getCustomerCount() throws SQLException, ClassNotFoundException;

    String getPackageUsageCount(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllYears() throws SQLException, ClassNotFoundException;

    boolean updatePackage(String id, String packId) throws SQLException, ClassNotFoundException;

    ArrayList<String> search(String id) throws SQLException, ClassNotFoundException;

    public  ArrayList<CustomerPackageProjection> getIdForData(String id) throws SQLException, ClassNotFoundException;
}
