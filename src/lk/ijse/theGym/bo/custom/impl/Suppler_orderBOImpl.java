package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Suppler_orderBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Suppler_orderDAO;

public class Suppler_orderBOImpl implements Suppler_orderBO {
    Suppler_orderDAO suppler_orderDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Suppler_orderDAO);
}
