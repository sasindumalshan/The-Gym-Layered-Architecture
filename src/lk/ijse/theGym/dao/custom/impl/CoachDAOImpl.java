package lk.ijse.theGym.dao.custom.impl;


import lk.ijse.theGym.dao.custom.CoachDAO;
import lk.ijse.theGym.dto.CoachDTO;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoachDAOImpl implements CoachDAO {


    @Override
    public ArrayList<CoachDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT  * FROM coach ORDER BY LENGTH(coach_id),coach_id");
        ArrayList<CoachDTO> list = new ArrayList<>();
        while (set.next()) {
            list.add(new CoachDTO(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7),
                    set.getString(8),
                    set.getString(9),
                    set.getString(10),
                    set.getString(11),
                    set.getString(12),
                    set.getString(13),
                    set.getString(14)
            ));
        }
        return list;
    }

    @Override
    public boolean save(CoachDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO coach VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                dto.getCoach_id(),
                dto.getFist_name(),
                dto.getLast_name(),
                dto.getAddress_street(),
                dto.getAddress_city(),
                dto.getAddress_lene(),
                dto.getE_mail(),
                dto.getBirthday(),
                dto.getNic(),
                dto.getContact_number(),
                dto.getGender(),
                dto.getRegister_date(),
                dto.getSalary_id(),
                dto.getCoach_type()
        );
    }

    @Override
    public boolean update(CoachDTO dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE coach SET fist_name=?,last_name=?,address_city=?,address_street=?,address_lene=?,e_mail=?,contact_number=?,nic=?,birthday=? WHERE coach_id=?",
                dto.getFist_name(),
                dto.getLast_name(),
                dto.getAddress_city(),
                dto.getAddress_street(),
                dto.getAddress_lene(),
                dto.getE_mail(),
                dto.getContact_number(),
                dto.getNic(),
                dto.getBirthday(),
                dto.getCoach_id()

        );
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE FROM coach WHERE coach_id=?", s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> search(String s) throws SQLException, ClassNotFoundException {
        ResultSet set=CrudUtil.crudUtil("SELECT coach_id FROM coach WHERE fist_name LIKE ? OR last_name LIKE ? OR coach_id LIKE ?", s + "%", s + "%",s + "%");
        ArrayList<String> list=new ArrayList<>();
       while (set.next()){
           list.add(set.getString(1));
       }
       return list;
    }

    @Override
    public ArrayList<CoachDTO> get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public CoachDTO getCoach(String s) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT * FROM coach WHERE coach_id=?", s);
        return new CoachDTO(
                set.getString(1),
                set.getString(2),
                set.getString(3),
                set.getString(4),
                set.getString(5),
                set.getString(6),
                set.getString(7),
                set.getString(8),
                set.getString(9),
                set.getString(10),
                set.getString(11),
                set.getString(12),
                set.getString(13),
                set.getString(14)
        );
    }

    public ArrayList<String> getALlId() throws SQLException, ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        ResultSet set = CrudUtil.crudUtil("SELECT coach_id FROM coach WHERE coach_type=?", "Company");
        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }

    @Override
    public String getCoachCunt() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT COUNT(*) FROM coach");
        if (set.next()) {
            return set.getString(1);
        }
        return "0";
    }

    @Override
    public String getSalaryCount(String salary_id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT COUNT(*) FROM coach WHERE salary_Id=?", salary_id);
        if (set.next()) {
            return set.getString(1);
        }
        return null;
    }
}
