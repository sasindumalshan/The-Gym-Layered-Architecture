package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dto.ScheduleDTO;
import lk.ijse.theGym.dto.ScheduleDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Schedule_detailsDAO {
    boolean setDetails(ArrayList<ScheduleDetailsDTO> scheduleDetails, ScheduleDTO schedule) throws SQLException, ClassNotFoundException;
}
