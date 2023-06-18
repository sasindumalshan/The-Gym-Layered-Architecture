package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.custom.Suppler_orderDAO;
import lk.ijse.theGym.dao.custom.impl.util.ReturnUtil;
import lk.ijse.theGym.dto.SupplierOrderDTO;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Suppler_orderDAOImpl implements Suppler_orderDAO {
    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT order_id FROM Suppler_Order"));
    }
    @Override
    public  ArrayList<String> searchIDOrCustomerId(String text) throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT order_id FROM orders WHERE order_id LIKE ? OR customer_id LIKE ?",text+"%",text+"%")) ;
    }

    public  ArrayList<String> getIds() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT order_id FROM Suppler_Order ORDER BY LENGTH(order_id),order_id")) ;
    }

    @Override
    public boolean setOrder(SupplierOrderDTO supplierOrder) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO suppler_order VALUES (?,?,?,?,?)",
                supplierOrder.getOrder_id(),
                supplierOrder.getTotal(),
                supplierOrder.getSuppler_id(),
                supplierOrder.getDate(),
                supplierOrder.getTime()

        );
    }

}
