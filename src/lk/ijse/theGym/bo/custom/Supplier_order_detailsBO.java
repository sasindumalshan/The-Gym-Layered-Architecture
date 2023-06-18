package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.dto.SupplierOrderDTO;
import lk.ijse.theGym.dto.SupplierOrderDetailsDTO;
import lk.ijse.theGym.dto.projection.SupplierItemProjection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Supplier_order_detailsBO {
    String getMonthlyOrders() throws SQLException, ClassNotFoundException;

    String getLastId() throws SQLException, ClassNotFoundException;

    ResultSet getSupIdItemId(String id) throws SQLException, ClassNotFoundException;

    String getTotalOnDay(String day) throws SQLException, ClassNotFoundException;

    ArrayList<String> getFinalTotalOnYear(String year) throws SQLException, ClassNotFoundException;

    String getMonthlyReport(String date) throws SQLException, ClassNotFoundException;

    ArrayList<String> getSearchName(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getSearchId(String id) throws SQLException, ClassNotFoundException;

    SupplierItemProjection getSupDealsIdItem(String s) throws SQLException, ClassNotFoundException;


    boolean setOrderDetails(ArrayList<SupplierOrderDetailsDTO> orderDetails, SupplierOrderDTO supplierOrder) throws SQLException, ClassNotFoundException;
}
