package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.bo.custom.CoachBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.CoachDAO;
import lk.ijse.theGym.dto.CoachDTO;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoachBOImpl implements CoachBO {
    CoachDTO dto;
    CoachDAO coachDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CoachDAO);
    @Override
    public ArrayList<CoachDTO> getAll() throws SQLException, ClassNotFoundException {
        return coachDAO.getAll();
    }

    @Override
    public boolean save(CoachDTO dto) throws SQLException, ClassNotFoundException {
        return coachDAO.save(new CoachDTO().toEntity(dto));
    }

    @Override
    public boolean update(CoachDTO dto) throws SQLException, ClassNotFoundException {
        return coachDAO.update(new CoachDTO().toEntity(dto));
    }

    @Override
    public boolean existByID(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return coachDAO.delete(s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ArrayList<CoachDTO> all = coachDAO.getAll();
        String id = null;
        for (CoachDTO dto:all) {
            id = dto.getCoach_id();
        }
        try {
            String[] T = id.split("T");
            int Next = Integer.parseInt(T[1]);
            Next++;
            return "T" + Next;
        } catch (NullPointerException e) {
            return "T1";
        }
    }

    @Override
    public CoachDTO get(String id) throws SQLException, ClassNotFoundException {
        return coachDAO.getCoach(id);
    }
    @Override
    public ArrayList<String> getALlId() throws SQLException, ClassNotFoundException{
        return coachDAO.getALlId();
    }

    @Override
    public String getCoachCunt() throws SQLException, ClassNotFoundException {
        return coachDAO.getCoachCunt();
    }

    @Override
    public String getSalaryCount(String salary_id) throws SQLException, ClassNotFoundException {
        return coachDAO.getSalaryCount(salary_id);
    }

    @Override
    public ArrayList<String> search(String s) throws SQLException, ClassNotFoundException {
        return coachDAO.search(s);
    }
}
