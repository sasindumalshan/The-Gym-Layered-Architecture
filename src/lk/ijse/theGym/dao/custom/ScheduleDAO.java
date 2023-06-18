package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dto.ExercisesDTO;
import lk.ijse.theGym.dto.ScheduleDTO;
import lk.ijse.theGym.entity.Schedule;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ScheduleDAO {
    boolean setSchedule(ScheduleDTO schedule) throws SQLException, ClassNotFoundException;

    ArrayList<Schedule> getAll() throws SQLException, ClassNotFoundException;

    boolean update(ExercisesDTO exercises) throws SQLException, ClassNotFoundException;

    boolean remove(String id) throws SQLException, ClassNotFoundException;

    boolean exists(String id) throws SQLException, ClassNotFoundException;

    void setData(ExercisesDTO exercises) throws SQLException, ClassNotFoundException;

    ArrayList<String> getIds() throws SQLException, ClassNotFoundException;
}
