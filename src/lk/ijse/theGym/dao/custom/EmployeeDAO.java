package lk.ijse.theGym.dao.custom;


import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee, String> {
    //ResultSet get(String id) throws SQLException, ClassNotFoundException;

     ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException;

    String getEmployeeCount() throws SQLException, ClassNotFoundException;

    ResultSet getDateForEmployee(String dateNow) throws SQLException, ClassNotFoundException;

    String getSalaryCount(String salary_id) throws SQLException, ClassNotFoundException;
}
