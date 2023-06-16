package lk.ijse.theGym.dao.custom.impl;


import lk.ijse.theGym.dao.custom.CustomerDAO;
import lk.ijse.theGym.dto.projection.CustomerPackageProjection;
import lk.ijse.theGym.entity.Customer;
import lk.ijse.theGym.util.CrudUtil;
import lk.ijse.theGym.util.DateTimeUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT * FROM customer order by LENGTH(customer_id),customer_id");
        ArrayList<Customer> list = new ArrayList<>();
        while (set.next()) {
            list.add(new Customer(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7),
                    set.getString(8),
                    set.getString(9),
                    set.getString(10),
                    set.getString(11),
                    set.getString(12),
                    set.getString(13),
                    set.getString(14)
            ));
        }
        return list;
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                customer.getCustomer_id(),
                customer.getFist_name(),
                customer.getLast_name(),
                customer.getAddress_street(),
                customer.getAddress_city(),
                customer.getAddress_lene(),
                customer.getE_mail(),
                customer.getBirthday(),
                customer.getNic(),
                customer.getContact_number(),
                customer.getGender(),
                customer.getPackage_id(),
                customer.getPackage_activate_date(),
                customer.getDate()
        );
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE customer SET fist_name=?,last_name=?,address_city=?,address_street=?,address_lene=?,e_mail=?,contact_number=?,nic=?,birthday=? WHERE customer_id=?",
                dto.getFist_name(),
                dto.getLast_name(),
                dto.getAddress_city(),
                dto.getAddress_street(),
                dto.getAddress_lene(),
                dto.getE_mail(),
                dto.getContact_number(),
                dto.getNic(),
                dto.getBirthday(),
                dto.getCustomer_id()


        );
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM customer WHERE customer_id=?", s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> search(String s) throws SQLException, ClassNotFoundException {
        ResultSet set= CrudUtil.crudUtil("SELECT customer_id FROM customer WHERE customer_id LIKE ? OR fist_name LIKE ? OR last_name LIKE ?",s+"%",s+"%",s+"%");
        ArrayList<String> list=new ArrayList<>();
        while (set.next()){
            list.add(set.getString(1));
        }
        return list;
    }

    @Override
    public ArrayList<Customer> get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Customer getCustomer(String s) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT * FROM customer WHERE customer_id=?", s);
        if (set.next()) {
            return new Customer(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7),
                    set.getString(8),
                    set.getString(9),
                    set.getString(10),
                    set.getString(11),
                    set.getString(12),
                    set.getString(13),
                    set.getString(14)
            );
        }
        return null;
    }

    @Override
    public ArrayList<String> getPackage(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT  package_Id FROM customer WHERE customer_id=?", id);
        ArrayList<String> list = new ArrayList<>();
        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }

    @Override
    public String getCustomerCount() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT COUNT(*) FROM customer");
        if (set.next()) {
            return set.getString(1);
        }
        return null;
    }
    @Override
    public  String getPackageUsageCount(String id) throws SQLException, ClassNotFoundException {
        ResultSet set= CrudUtil.crudUtil("SELECT COUNT(*) FROM customer WHERE package_id=?",id);
        if (set.next()) {
            return set.getString(1);
        }
        return null;
    }
    @Override
    public ArrayList<String> getAllYears() throws SQLException, ClassNotFoundException {
        ResultSet set= CrudUtil.crudUtil("SELECT DISTINCT year FROM customer_payment");
        ArrayList<String> list = new ArrayList<>();
        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }
    @Override
    public  boolean updatePackage(String id,String packId) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE customer SET package_id=?,package_activate_date=? WHERE customer_id=?",packId, DateTimeUtil.dateNow(),id);
    }

    @Override
    public  ArrayList<CustomerPackageProjection> getIdForData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set= CrudUtil.crudUtil("SELECT " +
                "customer.customer_id," +
                "customer.fist_name," +
                "customer.last_name," +
                "customer.e_mail," +
                "customer.nic," +
                "package.package_price " +
                "FROM customer INNER JOIN package ON customer.package_id = package.package_Id WHERE customer.customer_id=?",id);
        ArrayList<CustomerPackageProjection>list=new ArrayList<>();
        while (set.next()){
          list.add(new CustomerPackageProjection(
                  set.getString(1),
                  set.getString(2),
                  set.getString(3),
                  set.getString(4),
                  set.getString(5),
                  Double.parseDouble(set.getString(6))
          ));
        }
        return list;
    }
}
