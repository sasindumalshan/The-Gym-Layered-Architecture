package lk.ijse.theGym.RM;

import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.Schedule_detailsBO;
import lk.ijse.theGym.dao.custom.Schedule_detailsDAO;
import lk.ijse.theGym.db.DBConnection;
import lk.ijse.theGym.dto.ExercisesDTO;
import lk.ijse.theGym.dto.ScheduleDTO;
import lk.ijse.theGym.dto.ScheduleDetailsDTO;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleController {
    /*public static ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT * FROM exercises ORDER BY LENGTH(exercises_id )");
    }*/

    /*public static boolean update(ExercisesDTO exercises) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE exercises SET exercises=? WHERE exercises_id=?",
                exercises.getExercises(),
                exercises.getId()
                );
    }*/
/*
    public static boolean remove(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM exercises WHERE exercises_id=?",id);
    }*/

    /*public static boolean exsist(String id) throws SQLException, ClassNotFoundException {
        ResultSet set=CrudUtil.crudUtil("SELECT * FROM exercises WHERE exercises_id=?",id);
        return set.next() ;
    }*/

   /* public static void setData(ExercisesDTO exercises) throws SQLException, ClassNotFoundException {
        CrudUtil.crudUtil("INSERT INTO exercises VALUES (?,?)",
                exercises.getId(),
                exercises.getExercises()
                );
    }*/

   /* public static ResultSet getIds() throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT schedule_id FROM schedule ORDER BY LENGTH(schedule_id)");
    }*/
    //Schedule_detailsBO schedule_detailsBO= BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Schedule_detailsBO);
    /*public static boolean setSchedule(ScheduleDTO schedule, ArrayList<ScheduleDetailsDTO> scheduleDetails) throws SQLException {
        Connection connection=null;
        try {
            connection= DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            if (ScheduleController.setSchedule(schedule)){
//                ScheduleDetailsController.setDetails(scheduleDetails,schedule)
                if (schedule_detailsBO.setDetails(scheduleDetails,schedule)){
                   connection.commit();
                    System.out.println("tranceAction ok");
                    return true;

                }else {
                    System.out.println("SD RollBack");
                    connection.rollback();
                }
            }else {
                System.out.println("S RollBack");
                connection.rollback();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
        return false;
    }*/

   /* private static boolean setSchedule(ScheduleDTO schedule) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO schedule VALUES (?,?,?)",
                schedule.getCustomer_id(),
                schedule.getSchedule_id(),
                schedule.getCoach_id()
                );
    }*/
}
