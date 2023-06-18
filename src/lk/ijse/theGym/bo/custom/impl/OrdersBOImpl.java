package lk.ijse.theGym.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.ItemBo;
import lk.ijse.theGym.bo.custom.Order_detailsBO;
import lk.ijse.theGym.bo.custom.OrdersBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.OrdersDAO;
import lk.ijse.theGym.db.DBConnection;
import lk.ijse.theGym.dto.OrderDTO;
import lk.ijse.theGym.view.data.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersBOImpl implements OrdersBO {
    OrdersDAO ordersDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.OrdersDAO);

    @Override
    public boolean setOrder(OrderDTO order) throws SQLException, ClassNotFoundException {
        return ordersDAO.setOrder(order);
    }
    Order_detailsBO order_detailsBO= BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Order_detailsBO);
    ItemBo itemBo=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ITEM_BO);
    @Override
    public boolean PlaceOrder(OrderDTO order, ArrayList<Order> orderDetails) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
//            OrderController.setOrder(order)
            if (setOrder(order)) {
//                OrderDetailsController.setOrderDetails(orderDetails,order)
                if (order_detailsBO.setOrderDetails(orderDetails,order)) {
//                    ItemsController.updateQty(orderDetails)
                    if (itemBo.updateQty(orderDetails)) {
                        connection.commit();
                        //new Alert(Alert.AlertType.CONFIRMATION,"Order Success !").show();
                        return true;
                    } else {
                        connection.rollback();
                        new Alert(Alert.AlertType.ERROR,"Order fail !").show();
                    }
                } else {
                    connection.rollback();
                    new Alert(Alert.AlertType.ERROR,"Order fail !").show();
                }
            } else {
                connection.rollback();
                new Alert(Alert.AlertType.ERROR,"Order fail !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    @Override
    public String getLastOrderId() throws SQLException, ClassNotFoundException {
        ArrayList<String> lastOrderId = ordersDAO.getLastOrderId();
        String id = null;
        for (String s:lastOrderId){
            id=s;
        }
        try {
            String[] O = id.split("O00");
            int n= Integer.parseInt(O[1]);
            n++;
            return "O00"+n;
        }catch (NullPointerException e){
            return "O001" ;
        }
    }

    @Override
    public String getMonthlyReport(String date) throws SQLException, ClassNotFoundException {
        return ordersDAO.getMonthlyReport(date);
    }

    @Override
    public ArrayList<String> getFinalTotalOnYear(String year) throws SQLException, ClassNotFoundException {
        return ordersDAO.getFinalTotalOnYear(year);
    }

    @Override
    public String getFinalTotalOnDay(String day) throws SQLException, ClassNotFoundException {
        return ordersDAO.getFinalTotalOnDay(day);
    }


}
