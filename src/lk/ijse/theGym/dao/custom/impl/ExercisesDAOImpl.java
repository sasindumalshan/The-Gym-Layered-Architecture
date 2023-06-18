package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dao.custom.ExercisesDAO;
import lk.ijse.theGym.dto.ExercisesDTO;
import lk.ijse.theGym.entity.Exercises;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExercisesDAOImpl implements ExercisesDAO {
    public ArrayList<String> getNextId() throws SQLException, ClassNotFoundException {
        ArrayList<String> list=new ArrayList<>();
        ResultSet set= CrudUtil.crudUtil("SELECT exercises_id FROM exercises ORDER BY LENGTH(exercises_id ),exercises_id");
        while (set.next()){
            list.add(set.getString(1));
        }
        return list;
    }

    public boolean setExercises(ExercisesDTO exercises) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO exercises VALUES (?,?)",
                exercises.getId(),
                exercises.getExercises()
        );
    }

}
