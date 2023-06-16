package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.PackageBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.PackageDAO;

public class PackageBOImpl implements PackageBO {
    PackageDAO packageDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PackageDAO);
}
