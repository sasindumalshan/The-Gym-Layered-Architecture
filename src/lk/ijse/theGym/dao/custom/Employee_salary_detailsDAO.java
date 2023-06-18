package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dto.EmployeeSalaryDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Employee_salary_detailsDAO {
    ArrayList<EmployeeSalaryDetailsDTO> getAll(String date) throws SQLException, ClassNotFoundException;
}
