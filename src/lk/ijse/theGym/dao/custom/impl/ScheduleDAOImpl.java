package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.custom.ScheduleDAO;
import lk.ijse.theGym.dao.custom.impl.util.ReturnUtil;
import lk.ijse.theGym.dto.ExercisesDTO;
import lk.ijse.theGym.dto.ScheduleDTO;
import lk.ijse.theGym.entity.Schedule;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public boolean setSchedule(ScheduleDTO schedule) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO schedule VALUES (?,?,?)",
                schedule.getCustomer_id(),
                schedule.getSchedule_id(),
                schedule.getCoach_id()
        );
    }

    @Override
    public ArrayList<Schedule> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Schedule> list=new ArrayList<>();
        ResultSet set= CrudUtil.crudUtil("SELECT * FROM exercises ORDER BY LENGTH(exercises_id )");
        while (set.next()){
           list.add( new Schedule(
                   set.getString(1),
                   set.getString(2),
                   set.getString(3)
           ));
        }
        return list;
    }

    @Override
    public boolean update(ExercisesDTO exercises) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE exercises SET exercises=? WHERE exercises_id=?",
                exercises.getExercises(),
                exercises.getId()
        );
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM exercises WHERE exercises_id=?", id);
    }

    public boolean exists(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT * FROM exercises WHERE exercises_id=?", id);
        return set.next();
    }

    @Override
    public void setData(ExercisesDTO exercises) throws SQLException, ClassNotFoundException {
        CrudUtil.crudUtil("INSERT INTO exercises VALUES (?,?)",
                exercises.getId(),
                exercises.getExercises()
        );
    }

    @Override
    public ArrayList<String> getIds() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT schedule_id FROM schedule ORDER BY LENGTH(schedule_id)")) ;
    }
}
