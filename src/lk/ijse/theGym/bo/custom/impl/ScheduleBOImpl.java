package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.ScheduleBO;
import lk.ijse.theGym.bo.custom.Schedule_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.ScheduleDAO;
import lk.ijse.theGym.db.DBConnection;
import lk.ijse.theGym.dto.ExercisesDTO;
import lk.ijse.theGym.dto.ScheduleDTO;
import lk.ijse.theGym.dto.ScheduleDetailsDTO;
import lk.ijse.theGym.entity.Schedule;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleBOImpl implements ScheduleBO {
    ScheduleDAO scheduleDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ScheduleDAO);
    Schedule_detailsBO schedule_detailsBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Schedule_detailsBO);

    public boolean setSchedule(ScheduleDTO schedule, ArrayList<ScheduleDetailsDTO> scheduleDetails) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (setSchedule(schedule)) {
//                ScheduleDetailsController.setDetails(scheduleDetails,schedule)
                if (schedule_detailsBO.setDetails(scheduleDetails, schedule)) {
                    connection.commit();
                    System.out.println("tranceAction ok");
                    return true;

                } else {
                    System.out.println("SD RollBack");
                    connection.rollback();
                }
            } else {
                System.out.println("S RollBack");
                connection.rollback();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    @Override
    public ArrayList<Schedule> getAll() throws SQLException, ClassNotFoundException {
        return scheduleDAO.getAll();
    }

    @Override
    public boolean update(ExercisesDTO exercises) throws SQLException, ClassNotFoundException {
        return scheduleDAO.update(exercises);
    }

    @Override
    public boolean remove(String id) throws SQLException, ClassNotFoundException {
        return scheduleDAO.remove(id);
    }

    @Override
    public boolean exists(String id) throws SQLException, ClassNotFoundException {
        return exists(id);
    }

    @Override
    public void setData(ExercisesDTO exercises) throws SQLException, ClassNotFoundException {
        scheduleDAO.setData(exercises);
    }

    @Override
    public String getIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> ids = scheduleDAO.getIds();
        String id=null;
        for (String s:ids){
            id=s;
        }
        try {
            String[] s = id.split("S");
            int NextId = Integer.parseInt(s[1]);
            NextId++;
            return "S" + NextId;
        }catch (NullPointerException e){
            return "S1";
        }
    }

    @Override
    public boolean setSchedule(ScheduleDTO schedule) throws SQLException, ClassNotFoundException {
        /*return CrudUtil.crudUtil("INSERT INTO schedule VALUES (?,?,?)",
                schedule.getCustomer_id(),
                schedule.getSchedule_id(),
                schedule.getCoach_id()
        );*/
        return scheduleDAO.setSchedule(schedule);
    }
}
