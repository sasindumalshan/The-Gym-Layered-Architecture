package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.CustomerBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.CustomerDAO;
import lk.ijse.theGym.dto.CustomerDTO;
import lk.ijse.theGym.dto.projection.CustomerPackageProjection;
import lk.ijse.theGym.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CustomerDAO);
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> list=new ArrayList<>();
        for (Customer customer:all){
            list.add(new CustomerDTO().toDTO(customer));
        }
        return list;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer().toEntity(dto));
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer().toEntity(dto));
    }

    @Override
    public boolean existByID(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
       // ResultSet set = CustomerController.getLastId();
        String id = null;
        ArrayList<Customer> all = customerDAO.getAll();
        for (Customer customer:all) {
            id = customer.getCustomer_id();
        }
        try {
            String[] c = id.split("c");
            int n = Integer.parseInt(c[1]);
            n++;
            return "c" + n;
        } catch (NullPointerException e) {
            return "c1";
        }
    }

    @Override
    public CustomerDTO getCustomer(String s) throws SQLException, ClassNotFoundException {
        return new CustomerDTO().toDTO(customerDAO.getCustomer(s));
    }

    @Override
    public ArrayList<String> getPackage(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.getPackage(id);
    }

    @Override
    public String getCustomerCount() throws SQLException, ClassNotFoundException {
        return customerDAO.getCustomerCount();
    }

    @Override
    public String getPackageUsageCount(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.getPackageUsageCount(id);
    }

    @Override
    public ArrayList<String> getAllYears() throws SQLException, ClassNotFoundException {
        return customerDAO.getAllYears();
    }

    @Override
    public boolean updatePackage(String id, String packId) throws SQLException, ClassNotFoundException {
        return customerDAO.updatePackage(id,packId);
    }

    @Override
    public ArrayList<String> search(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    @Override
    public ArrayList<CustomerPackageProjection> getIdForData(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.getIdForData(id);
    }


}
