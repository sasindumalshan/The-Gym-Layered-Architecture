package lk.ijse.theGym.bo.custom.impl;


import lk.ijse.theGym.bo.custom.EmployeeBO;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.EmployeeDAO;
import lk.ijse.theGym.dto.EmployeeDTO;
import lk.ijse.theGym.dto.projection.EmployeeAttendanceProjection;
import lk.ijse.theGym.entity.Employee;
import lk.ijse.theGym.model.EmployeeController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO =  DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList <EmployeeDTO>arrayList=new ArrayList<>();
        ArrayList<Employee> all = employeeDAO.getAll();
        for (Employee employee :all) {
            employeeDTO=new EmployeeDTO();
            employeeDTO.setEmployee_id(employee.getEmployee_id());
            employeeDTO.setFist_name(employee.getFist_name());
            employeeDTO.setLast_name(employee.getLast_name());
            employeeDTO.setUsr_name(employee.getUsr_name());
            employeeDTO.setPassword(employee.getPassword());
            employeeDTO.setRoll(employee.getRoll());
            employeeDTO.setAddress_street(employee.getAddress_street());
            employeeDTO.setAddress_city(employee.getAddress_city());
            employeeDTO.setAddress_lene(employee.getAddress_lene());
            employeeDTO.setE_mail(employee.getE_mail());
            employeeDTO.setBirthday(String.valueOf(employee.getBirthday()));
            employeeDTO.setNic(employee.getNic());
            employeeDTO.setContact_number(employee.getContact_number());
            employeeDTO.setDate(String.valueOf(employee.getDate()));
            employeeDTO.setSalary_Id(employee.getSalary_Id());
            arrayList.add(employeeDTO);
        }
        return arrayList;

    }

    @Override
    public boolean save(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee().toEntity(dto));
    }

    @Override
    public boolean update(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee().toEntity(dto));
    }

    @Override
    public boolean existByID(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        String id=null;
        ArrayList<Employee> all = employeeDAO.getAll();
            id = all.get(all.size()-1).getEmployee_id();
            try {
            String[] e = id.split("e00");
            int Id = Integer.parseInt(e[1]);
            Id++;
            return "e00" + Id;
        } catch (NullPointerException e) {
            return "e001";
        }
    }
    EmployeeDTO employeeDTO;
    @Override
    public EmployeeDTO get(String id) throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employees = employeeDAO.get(id);
        employeeDTO=new EmployeeDTO();
        for (Employee employee :employees) {
            employeeDTO.setEmployee_id(employee.getEmployee_id());
            employeeDTO.setFist_name(employee.getFist_name());
            employeeDTO.setLast_name(employee.getLast_name());
            employeeDTO.setUsr_name(employee.getUsr_name());
            employeeDTO.setPassword(employee.getPassword());
            employeeDTO.setRoll(employee.getRoll());
            employeeDTO.setAddress_street(employee.getAddress_street());
            employeeDTO.setAddress_city(employee.getAddress_city());
            employeeDTO.setAddress_lene(employee.getAddress_lene());
            employeeDTO.setE_mail(employee.getE_mail());
            employeeDTO.setBirthday(String.valueOf(employee.getBirthday()));
            employeeDTO.setNic(employee.getNic());
            employeeDTO.setContact_number(employee.getContact_number());
            employeeDTO.setDate(String.valueOf(employee.getDate()));
            employeeDTO.setSalary_Id(employee.getSalary_Id());
        }
        return employeeDTO;

    }

    @Override
    public String getEmployeeCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmployeeCount();
    }

    EmployeeAttendanceProjection employeeAttendanceProjection;

    @Override
    public ArrayList<EmployeeAttendanceProjection> getDateForEmployee(String dateNow) throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeAttendanceProjection> arrayList=new ArrayList();
        ResultSet set = employeeDAO.getDateForEmployee(dateNow);


        while (set.next()){
            employeeAttendanceProjection=new EmployeeAttendanceProjection();
            employeeAttendanceProjection.setEmployeeID(set.getString(1));
            employeeAttendanceProjection.setFistName(set.getString(2));
            employeeAttendanceProjection.setLastName(set.getString(3));
            employeeAttendanceProjection.setEmployeeRoll(set.getString(4));
            employeeAttendanceProjection.setAttendDate(set.getString(5));
            employeeAttendanceProjection.setAttendTime(set.getString(6));
            arrayList.add(employeeAttendanceProjection);
        }
        return arrayList;
    }

    @Override
    public ArrayList<String> search(String text) throws SQLException, ClassNotFoundException {
        return employeeDAO.search(text);

    }
}
