package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.custom.Employee_salary_detailsDAO;
import lk.ijse.theGym.dto.EmployeeSalaryDetailsDTO;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee_salary_detailsDAOImpl implements Employee_salary_detailsDAO {

    @Override
    public  ArrayList<EmployeeSalaryDetailsDTO> getAll(String date) throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeSalaryDetailsDTO> list=new ArrayList<>();
        ResultSet set= CrudUtil.crudUtil("SELECT * FROM employee_salary_details WHERE date LIKE ?",date+"%");
        while (set.next()){
            list.add(new EmployeeSalaryDetailsDTO(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4)
            ));
        }
        return list;
    }

}
