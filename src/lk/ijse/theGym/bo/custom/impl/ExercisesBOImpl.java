package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.ExercisesBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.ExercisesDAO;

public class ExercisesBOImpl implements ExercisesBO {
    ExercisesDAO exercisesDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ExercisesDAO);
}
