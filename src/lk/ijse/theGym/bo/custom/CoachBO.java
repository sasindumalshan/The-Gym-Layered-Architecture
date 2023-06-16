package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.dto.CoachDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CoachBO extends CrudBO<CoachDTO, String> {
    CoachDTO get(String id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getALlId() throws SQLException, ClassNotFoundException;

    String getCoachCunt() throws SQLException, ClassNotFoundException;

    String getSalaryCount(String salary_id) throws SQLException, ClassNotFoundException;
     ArrayList<String> search(String s) throws SQLException, ClassNotFoundException;
}
