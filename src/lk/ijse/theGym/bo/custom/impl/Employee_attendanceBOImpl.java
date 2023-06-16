package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.bo.custom.Employee_attendanceBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Employee_attendanceDAO;
import lk.ijse.theGym.dto.EmployeeAttendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Employee_attendanceBOImpl implements Employee_attendanceBO {
    Employee_attendanceDAO employee_attendanceDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Employee_attendanceDAO);
    @Override
    public ArrayList<EmployeeAttendanceDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(EmployeeAttendanceDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(EmployeeAttendanceDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existByID(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
