package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.dto.OrderDTO;
import lk.ijse.theGym.view.data.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrdersBO {
    boolean setOrder(OrderDTO order) throws SQLException, ClassNotFoundException;

    boolean PlaceOrder(OrderDTO order, ArrayList<Order> orderDetails) throws SQLException;

    String getLastOrderId() throws SQLException, ClassNotFoundException;

    String getMonthlyReport(String date) throws SQLException, ClassNotFoundException;

    ArrayList<String> getFinalTotalOnYear(String year) throws SQLException, ClassNotFoundException;

    String getFinalTotalOnDay(String day) throws SQLException, ClassNotFoundException;


}
