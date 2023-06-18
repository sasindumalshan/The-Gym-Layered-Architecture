package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.custom.OrdersDAO;
import lk.ijse.theGym.dao.custom.impl.util.ReturnUtil;
import lk.ijse.theGym.db.DBConnection;
import lk.ijse.theGym.dto.OrderDTO;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersDAOImpl implements OrdersDAO {
    public boolean setOrder(OrderDTO order) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO orders VALUES (?,?,?,?,?)",
                order.getOrder_id(),
                order.getTime(),
                order.getDate(),
                order.getFinal_total(),
                order.getCustomer_id()
        );
    }

    public ArrayList<String> getLastOrderId() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1"));
    }

    public String getMonthlyReport(String date) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT SUM(final_total)FROM orders WHERE date LIKE ?", date);
    }

    @Override
    public ArrayList<String> getFinalTotalOnYear(String year) throws SQLException, ClassNotFoundException {
        /*PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT final_total  FROM orders WHERE date LIKE ?");
        statement.setString(1, year + "%");
        return statement.executeQuery();*/
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT final_total  FROM orders WHERE date LIKE ?", year + "%")) ;

    }

    @Override
    public  String getFinalTotalOnDay(String day) throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValue(CrudUtil.crudUtil("SELECT SUM(final_total)FROM orders WHERE date=?", day)) ;
    }

}
