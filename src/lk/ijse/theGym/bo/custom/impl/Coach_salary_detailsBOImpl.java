package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.bo.custom.Coach_salary_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Coach_salary_detailsDAO;
import lk.ijse.theGym.dto.CoachSalaryDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Coach_salary_detailsBOImpl implements Coach_salary_detailsBO {
    Coach_salary_detailsDAO coach_salary_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.coach_salary_details) ;
    @Override
    public ArrayList<CoachSalaryDetailsDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CoachSalaryDetailsDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CoachSalaryDetailsDTO dto) throws SQLException, ClassNotFoundException {
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
