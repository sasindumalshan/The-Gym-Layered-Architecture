package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Supplier_order_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Supplier_order_detailsDAO;

public class Supplier_order_detailsBOImpl implements Supplier_order_detailsBO {
    Supplier_order_detailsDAO supplier_order_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Supplier_order_detailsDAO);
}
