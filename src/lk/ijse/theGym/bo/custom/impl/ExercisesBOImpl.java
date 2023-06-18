package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.ExercisesBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.ExercisesDAO;
import lk.ijse.theGym.dto.ExercisesDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExercisesBOImpl implements ExercisesBO {
    ExercisesDAO exercisesDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ExercisesDAO);

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ArrayList<String> ids = exercisesDAO.getNextId();
        String id = null;
        for (String s:ids) {
            id = s;
        }
        try {
            String[] x0s = id.split("X0");
            int nextId = Integer.parseInt(x0s[1]);
            nextId++;
            return "X0" + nextId;
        } catch (NullPointerException e) {
            return "X01";
        }
    }

    @Override
    public boolean setExercises(ExercisesDTO exercises) throws SQLException, ClassNotFoundException {
        return false;
    }
}
