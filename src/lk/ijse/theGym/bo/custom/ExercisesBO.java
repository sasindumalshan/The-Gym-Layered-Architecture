package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.dto.ExercisesDTO;

import java.sql.SQLException;

public interface ExercisesBO {
    String getNextId() throws SQLException, ClassNotFoundException;

    boolean setExercises(ExercisesDTO exercises) throws SQLException, ClassNotFoundException;
}
