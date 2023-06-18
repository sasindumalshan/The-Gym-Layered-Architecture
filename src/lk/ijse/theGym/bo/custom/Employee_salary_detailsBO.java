package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.dto.EmployeeSalaryDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Employee_salary_detailsBO {
    ArrayList<EmployeeSalaryDetailsDTO> getAll(String date) throws SQLException, ClassNotFoundException;
}
