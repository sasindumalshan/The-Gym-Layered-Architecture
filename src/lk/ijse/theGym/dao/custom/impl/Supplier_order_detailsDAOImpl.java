package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.custom.Supplier_order_detailsDAO;
import lk.ijse.theGym.dao.custom.impl.util.ReturnUtil;
import lk.ijse.theGym.dto.SupplierOrderDTO;
import lk.ijse.theGym.dto.SupplierOrderDetailsDTO;
import lk.ijse.theGym.dto.projection.SupplierItemProjection;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Supplier_order_detailsDAOImpl implements Supplier_order_detailsDAO {
    @Override
    public String getMonthlyOrders() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValue(CrudUtil.crudUtil("SELECT COUNT(*) FROM supplier_order_details")) ;
    }

    @Override
    public ArrayList<String> getLastId() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM supplier ORDER BY LENGTH(supplier_id),supplier_id");
    }

   /* @Override
    public static ResultSet getAllIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT order_id FROM supplier_order_details");
    }*/

    @Override
    public ResultSet getSupIdItemId(String id) throws SQLException, ClassNotFoundException {
        return  CrudUtil.crudUtil("SELECT Suppler_Order.order_id,Supplier.supplier_id,Supplier.company_name ,COUNT(item_code),Suppler_Order.total FROM suppler_order INNER JOIN supplier  ON Suppler_Order.suppler_id=Supplier.supplier_id  INNER JOIN supplier_order_details ON Supplier_Order_Details.order_id=Suppler_Order.order_id WHERE Suppler_Order.order_id=?", id);
    }

  /*  @Override
    public static ResultSet getDetails(String orderId) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM supplier_order_details WHERE order_id=?", orderId);
    }*/

    @Override
    public String getTotalOnDay(String day) throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValue( CrudUtil.crudUtil("SELECT SUM(total) FROM suppler_order WHERE date=?", day));
    }

    @Override
    public ArrayList<String> getFinalTotalOnYear(String year) throws SQLException, ClassNotFoundException {
        return  ReturnUtil.getValues( CrudUtil.crudUtil("SELECT total FROM suppler_order WHERE date LIKE ?", year + "%"));

    }

    @Override
    public String getMonthlyReport(String date) throws SQLException, ClassNotFoundException {
      //  System.out.println(date);
        return  ReturnUtil.getValue(  CrudUtil.crudUtil("SELECT SUM(total) FROM Suppler_Order WHERE date LIKE ?", date));
    }

    @Override
    public ArrayList<String>  getSearchName(String id) throws SQLException, ClassNotFoundException {
        return  ReturnUtil.getValues(   CrudUtil.crudUtil("SELECT order_id FROM Suppler_Order INNER JOIN supplier ON Supplier.supplier_id=Suppler_Order.suppler_id WHERE company_name LIKE ?", id + "%"));
    }

    @Override
    public ArrayList<String>  getSearchId(String id) throws SQLException, ClassNotFoundException {
        return  ReturnUtil.getValues( CrudUtil.crudUtil("SELECT order_id FROM Suppler_Order WHERE order_id LIKE ?", id + "%"));
    }
    @Override
    public SupplierItemProjection getSupDealsIdItem(String s) throws SQLException, ClassNotFoundException {
        ResultSet set= CrudUtil.crudUtil("SELECT" +
                " Suppler_Order.order_id," +
                "Supplier.supplier_id," +
                "Supplier.company_name ," +
                "COUNT(item_code)," +
                "Suppler_Order.total " +
                "FROM suppler_order INNER JOIN supplier  ON Suppler_Order.suppler_id=Supplier.supplier_id  INNER JOIN supplier_order_details ON Supplier_Order_Details.order_id=Suppler_Order.order_id WHERE Suppler_Order.order_id=?", s);
        if (set.next()){
            return new SupplierItemProjection(
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
    public boolean setOrderDetails(ArrayList<SupplierOrderDetailsDTO> orderDetails, SupplierOrderDTO supplierOrder) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (CrudUtil.crudUtil("INSERT INTO supplier_order_details VALUES (?,?,?,?)",
                    supplierOrder.getOrder_id(),
                    orderDetails.get(i).getItem_code(),
                    orderDetails.get(i).getQut(),
                    orderDetails.get(i).getPrice()
            )) {
                System.out.println("set" + i);
            } else {
                System.out.println("error");
                return false;
            }
        }

        return true;
    }

}
