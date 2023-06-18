package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.dto.ScheduleDTO;
import lk.ijse.theGym.dto.ScheduleDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Schedule_detailsBO {
    boolean setDetails(ArrayList<ScheduleDetailsDTO> scheduleDetails, ScheduleDTO schedule) throws SQLException, ClassNotFoundException;
}
