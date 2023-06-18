package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Supplier_order_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Supplier_order_detailsDAO;
import lk.ijse.theGym.dto.SupplierOrderDTO;
import lk.ijse.theGym.dto.SupplierOrderDetailsDTO;
import lk.ijse.theGym.dto.projection.SupplierItemProjection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Supplier_order_detailsBOImpl implements Supplier_order_detailsBO {
    Supplier_order_detailsDAO supplier_order_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Supplier_order_detailsDAO);

    @Override
    public String getMonthlyOrders() throws SQLException, ClassNotFoundException {
        return supplier_order_detailsDAO.getMonthlyOrders();
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String id=null;
        try {
            ArrayList<String> lastId = supplier_order_detailsDAO.getLastId();
            for (String s :
                    lastId) {
                id = s;
            }
            if (id!=null){
                String[] O00= id.split("O00");
                int incrementId= Integer.parseInt(O00[1]);
                incrementId++;
                return "O00"+incrementId;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "O001";
    }

    @Override
    public ResultSet getSupIdItemId(String id) throws SQLException, ClassNotFoundException {
        return supplier_order_detailsDAO.getSupIdItemId(id);
    }

    @Override
    public String getTotalOnDay(String day) throws SQLException, ClassNotFoundException {
        return supplier_order_detailsDAO.getTotalOnDay(day);
    }

    @Override
    public ArrayList<String> getFinalTotalOnYear(String year) throws SQLException, ClassNotFoundException {
        return supplier_order_detailsDAO.getFinalTotalOnYear(year);
    }

    @Override
    public String getMonthlyReport(String date) throws SQLException, ClassNotFoundException {
        return supplier_order_detailsDAO.getMonthlyReport(date);
    }

    @Override
    public ArrayList<String> getSearchName(String id) throws SQLException, ClassNotFoundException {
        return supplier_order_detailsDAO.getSearchName(id);
    }

    @Override
    public ArrayList<String> getSearchId(String id) throws SQLException, ClassNotFoundException {
        return supplier_order_detailsDAO.getSearchId(id);
    }

    @Override
    public SupplierItemProjection getSupDealsIdItem(String s) throws SQLException, ClassNotFoundException {
        return supplier_order_detailsDAO.getSupDealsIdItem(s);
    }

    @Override
    public boolean setOrderDetails(ArrayList<SupplierOrderDetailsDTO> orderDetails, SupplierOrderDTO supplierOrder) throws SQLException, ClassNotFoundException {
        return supplier_order_detailsDAO.setOrderDetails(orderDetails,supplierOrder);
    }
}
