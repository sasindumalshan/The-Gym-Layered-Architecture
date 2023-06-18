package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dto.CoachSalaryDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Coach_salary_detailsDAO {
     ArrayList<CoachSalaryDetailsDTO> getAll(String date) throws SQLException, ClassNotFoundException;
}
