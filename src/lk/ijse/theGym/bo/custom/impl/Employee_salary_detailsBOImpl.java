package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.Employee_salary_detailsBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.Employee_salary_detailsDAO;
import lk.ijse.theGym.dto.EmployeeSalaryDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Employee_salary_detailsBOImpl implements Employee_salary_detailsBO {
    Employee_salary_detailsDAO employee_salary_detailsDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.Employee_salary_detailsDAO);

    @Override
    public ArrayList<EmployeeSalaryDetailsDTO> getAll(String date) throws SQLException, ClassNotFoundException {
        return employee_salary_detailsDAO.getAll(date);
    }
}
