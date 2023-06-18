package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Order_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Order_detailsDAO;
import lk.ijse.theGym.dao.custom.OrdersDAO;
import lk.ijse.theGym.dao.custom.impl.util.ReturnUtil;
import lk.ijse.theGym.dto.OrderDTO;
import lk.ijse.theGym.util.CrudUtil;
import lk.ijse.theGym.view.data.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Order_detailsBOImpl implements Order_detailsBO {
    Order_detailsDAO order_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Order_detailsDAO);


    @Override
    public boolean setOrderDetails(ArrayList<Order> orderDetails, OrderDTO order) throws SQLException, ClassNotFoundException {
        return order_detailsDAO.setOrderDetails( orderDetails,order);
    }

    @Override
    public ArrayList<OrderDTO> getDataForOrderId(String id) throws SQLException, ClassNotFoundException {
        return order_detailsDAO.getDataForOrderId(id);
    }

    @Override
    public ArrayList<OrderDTO> getAllData(String date) throws SQLException, ClassNotFoundException {
        return order_detailsDAO.getAllData(date);
    }

    @Override
    public ArrayList<String> getAllYears() throws SQLException, ClassNotFoundException {
        return order_detailsDAO.getAllYears();
    }
}
