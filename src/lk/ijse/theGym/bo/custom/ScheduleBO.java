package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.dto.ExercisesDTO;
import lk.ijse.theGym.dto.ScheduleDTO;
import lk.ijse.theGym.dto.ScheduleDetailsDTO;
import lk.ijse.theGym.entity.Schedule;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ScheduleBO {
    boolean setSchedule(ScheduleDTO schedule, ArrayList<ScheduleDetailsDTO> scheduleDetails) throws SQLException;

    ArrayList<Schedule> getAll() throws SQLException, ClassNotFoundException;

    boolean update(ExercisesDTO exercises) throws SQLException, ClassNotFoundException;

    boolean remove(String id) throws SQLException, ClassNotFoundException;

    boolean exists(String id) throws SQLException, ClassNotFoundException;

    void setData(ExercisesDTO exercises) throws SQLException, ClassNotFoundException;

    String getIds() throws SQLException, ClassNotFoundException;
    public boolean setSchedule(ScheduleDTO schedule) throws SQLException, ClassNotFoundException;

}
