package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Schedule_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Schedule_detailsDAO;

public class Schedule_detailsBOImpl implements Schedule_detailsBO {
    Schedule_detailsDAO schedule_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Schedule_detailsDAO);
}
