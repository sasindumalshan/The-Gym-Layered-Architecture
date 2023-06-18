package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.ItemBo;
import lk.ijse.theGym.bo.custom.Suppler_orderBO;
import lk.ijse.theGym.bo.custom.Supplier_order_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Suppler_orderDAO;
import lk.ijse.theGym.db.DBConnection;
import lk.ijse.theGym.dto.SupplierOrderDTO;
import lk.ijse.theGym.dto.SupplierOrderDetailsDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Suppler_orderBOImpl implements Suppler_orderBO {
    Suppler_orderDAO suppler_orderDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Suppler_orderDAO);

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return suppler_orderDAO.getAllIds();
    }

    @Override
    public ArrayList<String> searchIDOrCustomerId(String text) throws SQLException, ClassNotFoundException {
        return suppler_orderDAO.searchIDOrCustomerId(text);
    }

    @Override
    public String getIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> ids = suppler_orderDAO.getIds();
        String id = null;
        for (String s:ids) {
            id = s;
        }
        try {
            String[] os = id.split("O");
            int nextId = Integer.parseInt(os[1]);
            nextId++;
            return "O" + nextId;
        } catch (NullPointerException e) {
            return "O1";
        }
    }
    ItemBo itemBo= BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ITEM_BO);

    Supplier_order_detailsBO supplier_order_detailsBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Supplier_order_detailsBO);

    public boolean setOrder(ArrayList<SupplierOrderDetailsDTO> orderDetails, SupplierOrderDTO supplierOrder) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (setOrder(supplierOrder)) {
               // System.out.println("Oder OK");
//                SupplierOrderDetailsController.setOrderDetails(orderDetails, supplierOrder)
                if (supplier_order_detailsBO.setOrderDetails(orderDetails, supplierOrder)) {
                 //   System.out.println("Oder details OK");
//                    ItemsController.supplierUpdateQty(orderDetails)
                    if (itemBo.supplierUpdateQty(orderDetails)) {
                        connection.commit();
                        return true;
                    } else {
                        connection.rollback();
                    }
                } else {
                    connection.rollback();
                }
            } else {
                connection.rollback();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }

        return false;
    }

    private  boolean setOrder(SupplierOrderDTO supplierOrder) throws SQLException, ClassNotFoundException {
        return suppler_orderDAO.setOrder(supplierOrder);
    }

}
