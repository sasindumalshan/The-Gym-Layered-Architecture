package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.dto.CustomerDTO;
import lk.ijse.theGym.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends CrudBO<CustomerDTO,String> {
    CustomerDTO getCustomer(String s) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getPackage(String id) throws SQLException, ClassNotFoundException ;
    String getCustomerCount() throws SQLException, ClassNotFoundException;
    String getPackageUsageCount(String id) throws SQLException, ClassNotFoundException;
}
