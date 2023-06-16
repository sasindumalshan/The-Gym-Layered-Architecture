package lk.ijse.theGym.dao.custom;


import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dto.EmployeeDTO;
import lk.ijse.theGym.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<Employee,String> {
    //ResultSet get(String id) throws SQLException, ClassNotFoundException;

    String getEmployeeCount() throws SQLException, ClassNotFoundException;

    ResultSet getDateForEmployee(String dateNow) throws SQLException, ClassNotFoundException;
}
