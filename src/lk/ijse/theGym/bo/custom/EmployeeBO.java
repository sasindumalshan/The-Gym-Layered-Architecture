package lk.ijse.theGym.bo.custom;


import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.dto.EmployeeDTO;
import lk.ijse.theGym.dto.projection.EmployeeAttendanceProjection;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends CrudBO<EmployeeDTO,String> {

    EmployeeDTO get(String id) throws SQLException, ClassNotFoundException;

    String getEmployeeCount() throws SQLException, ClassNotFoundException;

    ArrayList<EmployeeAttendanceProjection> getDateForEmployee(String dateNow) throws SQLException, ClassNotFoundException;

    ArrayList<String> search(String text) throws SQLException, ClassNotFoundException;
}
