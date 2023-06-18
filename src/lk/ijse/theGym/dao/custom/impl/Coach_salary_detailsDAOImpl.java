package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.custom.Coach_salary_detailsDAO;
import lk.ijse.theGym.dto.CoachSalaryDetailsDTO;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Coach_salary_detailsDAOImpl implements Coach_salary_detailsDAO {
    @Override
    public ArrayList<CoachSalaryDetailsDTO> getAll(String date) throws SQLException, ClassNotFoundException {
        ArrayList<CoachSalaryDetailsDTO> list=new ArrayList<>();
        ResultSet set= CrudUtil.crudUtil("SELECT * FROM coach_salary_details WHERE date LIKE ?",date+"%");
        while (set.next()){
            list.add( new CoachSalaryDetailsDTO(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4)
            ));
        }
        return list;
    }
}
