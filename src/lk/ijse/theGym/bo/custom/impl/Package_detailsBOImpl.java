package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Package_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Package_detailsDAO;

public class Package_detailsBOImpl implements Package_detailsBO {
    Package_detailsDAO package_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Package_detailsDAO);
}
