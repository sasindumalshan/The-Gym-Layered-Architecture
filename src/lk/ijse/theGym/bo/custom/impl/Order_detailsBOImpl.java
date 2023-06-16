package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Order_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Order_detailsDAO;

public class Order_detailsBOImpl implements Order_detailsBO {
    Order_detailsDAO order_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Order_detailsDAO);
}
