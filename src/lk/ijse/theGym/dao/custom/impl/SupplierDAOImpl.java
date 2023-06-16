package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dao.custom.SupplierDAO;
import lk.ijse.theGym.entity.Supplier;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ResultSet set= CrudUtil.crudUtil("SELECT * FROM supplier ORDER BY LENGTH(supplier_id),supplier_id");
        ArrayList<Supplier> list=new ArrayList<>();
        while (set.next()){
            list.add(new Supplier(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5)
            ));
        }
        return list;
    }

    @Override
    public boolean save(Supplier dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Supplier dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
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

    @Override
    public ArrayList<String> search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Supplier> get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
