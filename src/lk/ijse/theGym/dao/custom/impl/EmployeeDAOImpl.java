package lk.ijse.theGym.dao.custom.impl;


import lk.ijse.theGym.dao.custom.EmployeeDAO;
import lk.ijse.theGym.dao.custom.impl.util.ReturnUtil;
import lk.ijse.theGym.entity.Employee;
import lk.ijse.theGym.util.CrudUtil;
import lk.ijse.theGym.util.RegexUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {

    Employee employee;

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();
        ResultSet set = CrudUtil.crudUtil("SELECT * FROM employee ORDER BY LENGTH(employee_id),employee_id");
        while (set.next()) {
            employee = new Employee();
            employee.setEmployee_id(set.getString(1));
            employee.setFist_name(set.getString(2));
            employee.setLast_name(set.getString(3));
            employee.setUsr_name(set.getString(4));
            employee.setPassword(set.getString(5));
            employee.setRoll(set.getString(6));
            employee.setAddress_street(set.getString(7));
            employee.setAddress_city(set.getString(8));
            employee.setAddress_lene(set.getString(9));
            employee.setE_mail(set.getString(10));
            employee.setBirthday(set.getString(11));
            employee.setNic(set.getString(12));
            employee.setContact_number(set.getString(13));
            employee.setDate(set.getString(14));
            employee.setSalary_Id(set.getString(15));
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?)",
                employee.getEmployee_id(),
                employee.getFist_name(),
                employee.getLast_name(),
                employee.getUsr_name(),
                employee.getPassword(),
                employee.getRoll(),
                employee.getAddress_street(),
                employee.getAddress_city(),
                employee.getAddress_lene(),
                employee.getE_mail(),
                employee.getBirthday(),
                employee.getNic(),
                employee.getContact_number(),
                employee.getDate(),
                employee.getSalary_Id()
        );
    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE employee SET fist_name=?,last_name=?,usr_name=?,password=?,roll=?,address_street=?,address_city=?,address_lene=?,e_mail=?,birthday=?,nic=?,contact_number=?,salary_Id=? WHERE employee_id=?",
                employee.getFist_name(),
                employee.getLast_name(),
                employee.getUsr_name(),
                employee.getPassword(),
                employee.getRoll(),
                employee.getAddress_street(),
                employee.getAddress_city(),
                employee.getAddress_lene(),
                employee.getE_mail(),
                employee.getBirthday(),
                employee.getNic(),
                employee.getContact_number(),
                employee.getSalary_Id(),
                employee.getEmployee_id()
        );
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE  FROM employee WHERE employee_id=?", s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> search(String text) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT  employee_id FROM employee WHERE employee_id LIKE ? OR fist_name LIKE ? OR last_name LIKE ?", text + "%", text + "%", text + "%");
        ArrayList<String> ids = new ArrayList<>();
        while (set.next()) {
            ids.add(set.getString(1));
        }
        return ids;
    }

    @Override
    public ArrayList<Employee> get(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.crudUtil("SELECT * FROM employee WHERE employee_id=? ORDER BY LENGTH(employee_id),employee_id", id);
        ArrayList<Employee> employees = new ArrayList<>();
        while (set.next()) {
            employee = new Employee();
            employee.setEmployee_id(set.getString(1));
            employee.setFist_name(set.getString(2));
            employee.setLast_name(set.getString(3));
            employee.setUsr_name(set.getString(4));
            employee.setPassword(set.getString(5));
            employee.setRoll(set.getString(6));
            employee.setAddress_street(set.getString(7));
            employee.setAddress_city(set.getString(8));
            employee.setAddress_lene(set.getString(9));
            employee.setE_mail(set.getString(10));
            employee.setBirthday(set.getString(11));
            employee.setNic(set.getString(12));
            employee.setContact_number(set.getString(13));
            employee.setDate(set.getString(14));
            employee.setSalary_Id(set.getString(15));
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public String getEmployeeCount() throws SQLException, ClassNotFoundException {
        ResultSet set= CrudUtil.crudUtil("SELECT COUNT(*) FROM employee");
        if (set.next()){
            return set.getString(1);
        }
        return null;
    }

    @Override
    public ResultSet getDateForEmployee(String dateNow) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("SELECT employee.employee_id,employee.fist_name,employee.last_name,employee.roll,employee_attendance.date,employee_attendance.time FROM employee_attendance INNER JOIN Employee ON Employee_Attendance.employee_id = Employee.employee_id WHERE employee_attendance.date=?", dateNow);
    }

    @Override
    public String getSalaryCount(String salary_id) throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValue(CrudUtil.crudUtil("SELECT COUNT(*) FROM employee WHERE salary_Id=?",salary_id)) ;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues( CrudUtil.crudUtil("SELECT employee_id FROM  employee"));
    }
}
