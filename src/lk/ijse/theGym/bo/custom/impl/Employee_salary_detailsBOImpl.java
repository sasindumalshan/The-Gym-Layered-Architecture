package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Employee_salary_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Employee_salary_detailsDAO;

public class Employee_salary_detailsBOImpl implements Employee_salary_detailsBO {
    Employee_salary_detailsDAO employee_salary_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Employee_salary_detailsDAO);
}
