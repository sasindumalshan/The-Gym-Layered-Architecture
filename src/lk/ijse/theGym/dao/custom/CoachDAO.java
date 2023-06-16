package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dto.CoachDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CoachDAO extends CrudDAO<CoachDTO, String> {
    CoachDTO getCoach(String s) throws SQLException, ClassNotFoundException;

    ArrayList<String> getALlId() throws SQLException, ClassNotFoundException;

    String getCoachCunt() throws SQLException, ClassNotFoundException;

    String getSalaryCount(String salary_id) throws SQLException, ClassNotFoundException;
}
