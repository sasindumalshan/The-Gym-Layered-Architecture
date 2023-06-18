package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.dto.CoachSalaryDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Coach_salary_detailsBO  {
     ArrayList<CoachSalaryDetailsDTO> getAll(String date) throws SQLException, ClassNotFoundException;
}
