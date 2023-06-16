package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Order_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.OrdersDAO;

public class OrdersBOImpl implements Order_detailsBO {
    OrdersDAO ordersDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.OrdersDAO);
}
