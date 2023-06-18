package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dto.ExercisesDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExercisesDAO {
    ArrayList<String> getNextId() throws SQLException, ClassNotFoundException;

    boolean setExercises(ExercisesDTO exercises) throws SQLException, ClassNotFoundException;
}
