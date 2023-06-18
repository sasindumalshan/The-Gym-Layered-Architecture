package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dto.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrdersDAO {
    boolean setOrder(OrderDTO order) throws SQLException, ClassNotFoundException;

    ArrayList<String> getLastOrderId() throws SQLException, ClassNotFoundException;

    String getMonthlyReport(String date) throws SQLException, ClassNotFoundException;

    ArrayList<String> getFinalTotalOnYear(String year) throws SQLException, ClassNotFoundException;

    public  String getFinalTotalOnDay(String day) throws SQLException, ClassNotFoundException;

}
