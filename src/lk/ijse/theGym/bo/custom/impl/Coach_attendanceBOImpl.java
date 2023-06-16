package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.Coach_attendanceBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Coach_attendanceDAO;
import lk.ijse.theGym.dto.CoachAttendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Coach_attendanceBOImpl implements Coach_attendanceBO {
    Coach_attendanceDAO coach_attendanceDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Coach_attendanceDAO);
    @Override
    public ArrayList<CoachAttendanceDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CoachAttendanceDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CoachAttendanceDTO dto) throws SQLException, ClassNotFoundException {
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
