package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dto.OrderDTO;
import lk.ijse.theGym.view.data.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Order_detailsDAO {
    boolean setOrderDetails(ArrayList<Order> orderDetails, OrderDTO order) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllYears() throws SQLException, ClassNotFoundException;

    ArrayList<OrderDTO> getDataForOrderId(String id) throws SQLException, ClassNotFoundException;

    ArrayList<OrderDTO> getAllData(String date) throws SQLException, ClassNotFoundException;

}
