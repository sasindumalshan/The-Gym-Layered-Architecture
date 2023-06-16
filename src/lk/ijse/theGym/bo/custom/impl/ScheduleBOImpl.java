package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.bo.custom.ScheduleBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.ScheduleDAO;
import lk.ijse.theGym.dto.ScheduleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleBOImpl implements ScheduleBO {
    ScheduleDAO scheduleDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ScheduleDAO);
    @Override
    public ArrayList<ScheduleDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ScheduleDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ScheduleDTO dto) throws SQLException, ClassNotFoundException {
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
