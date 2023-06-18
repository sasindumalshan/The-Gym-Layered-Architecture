package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Schedule_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Schedule_detailsDAO;
import lk.ijse.theGym.dto.ScheduleDTO;
import lk.ijse.theGym.dto.ScheduleDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Schedule_detailsBOImpl implements Schedule_detailsBO {
    Schedule_detailsDAO schedule_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Schedule_detailsDAO);

    @Override
    public boolean setDetails(ArrayList<ScheduleDetailsDTO> scheduleDetails, ScheduleDTO schedule) throws SQLException, ClassNotFoundException {
        return schedule_detailsDAO.setDetails(scheduleDetails,schedule);
    }
}
