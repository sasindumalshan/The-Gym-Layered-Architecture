package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.SupplierBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.SupplierDAO;
import lk.ijse.theGym.dao.custom.impl.util.ReturnUtil;
import lk.ijse.theGym.dto.SupplierDTO;
import lk.ijse.theGym.entity.Supplier;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO supplierDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SupplierDAO);

    @Override
    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.save(new Supplier().toEntity(dto));
    }

    @Override
    public boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new Supplier().toEntity(dto));
    }

    @Override
    public boolean existByID(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getCount() throws SQLException, ClassNotFoundException {
        return supplierDAO.getCount();
    }
    @Override
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
       return supplierDAO.getAllId();
    }

    @Override
    public Supplier getSupplier(String id) throws SQLException, ClassNotFoundException{
        return supplierDAO.getSupplier(id);
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
     // return supplierDAO.getLastId();
        ArrayList<String> lastId = supplierDAO.getLastId();
        String id = null;
        for (String s:lastId) {
            id=s;
        }
        try {
            String[] S = id.split("S00");
            int Next= Integer.parseInt(S[1]);
            Next++;
            return "S00"+Next;
        }catch (NullPointerException e){
            return "S001";
        }
    }

    @Override
    public String getComName(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.getComName(id);
    }

    @Override
    public ArrayList<String> getSearchName(String name) throws SQLException, ClassNotFoundException {
        return supplierDAO.getSearchName(name);
    }

    @Override
    public ArrayList<String> getSearchId(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.getSearchId(id);
    }
}
