package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.custom.SupplierDAO;
import lk.ijse.theGym.dao.custom.impl.util.ReturnUtil;
import lk.ijse.theGym.entity.Supplier;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT * FROM supplier ORDER BY LENGTH(supplier_id),supplier_id");
        ArrayList<Supplier> list = new ArrayList<>();
        while (set.next()) {
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
        return CrudUtil.crudUtil("INSERT INTO supplier VALUES (?,?,?,?,?)",
                dto.getCompany_name(),
                dto.getSupplier_id(),
                dto.getEmail(),
                dto.getMobile_no(),
                dto.getLocation()
        );
    }

    @Override
    public boolean update(Supplier dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE supplier SET  company_name=?,email=?,location=?,mobile_no=? WHERE supplier_id=?",
                dto.getCompany_name(),
                dto.getEmail(),
                dto.getLocation(),
                dto.getMobile_no(),
                dto.getSupplier_id()
        );
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM supplier WHERE supplier_id=?", s);
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

    @Override
    public String getCount() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValue(CrudUtil.crudUtil("SELECT COUNT(*) FROM supplier"));
    }

    @Override
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT supplier_id FROM supplier"));
    }

    @Override
    public Supplier getSupplier(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT * FROM supplier WHERE supplier_id=?", id);
        if (set.next()) {
            return new Supplier(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5)

            );
        }
        return null;
    }

    @Override
    public ArrayList<String> getLastId() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT supplier_id FROM supplier ORDER BY LENGTH(supplier_id),supplier_id"));
    }

    @Override
    public String getComName(String id) throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValue(CrudUtil.crudUtil("SELECT company_name FROM supplier WHERE supplier_id=?", id));
    }

    @Override
    public ArrayList<String> getSearchName(String name) throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT supplier_id FROM supplier WHERE company_name LIKE ?", name + "%"));
    }

    @Override
    public ArrayList<String> getSearchId(String id) throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT supplier_id FROM supplier WHERE supplier.supplier_id LIKE ?", id + "%")) ;
    }
}
