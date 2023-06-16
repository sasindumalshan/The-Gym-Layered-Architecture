package lk.ijse.theGym.dao;

import lk.ijse.theGym.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDAOFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes res) {
        switch (res) {
            case EMPLOYEE:
                return (T) new EmployeeDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            case Coach_attendanceDAO:
                return (T) new Coach_attendanceDAOImpl();
            case CoachDAO:
                return (T) new CoachDAOImpl();
            case Customer_attendanceDAO:
                return (T) new Customer_attendanceDAOImpl();
            case Customer_paymentDAO:
                return (T) new Customer_paymentDAOImpl();
            case CustomerDAO:
                return (T) new CustomerDAOImpl();
            case Employee_attendanceDAO:
                return (T) new Employee_attendanceDAOImpl();
            case Employee_salary_detailsDAO:
                return (T) new Employee_salary_detailsDAOImpl();
            case ExercisesDAO:
                return (T) new ExercisesDAOImpl();
            case Order_detailsDAO:
                return (T) new Order_detailsDAOImpl();
            case OrdersDAO:
                return (T) new OrdersDAOImpl();
            case Package_detailsDAO:
                return (T) new Package_detailsDAOImpl();
            case PackageDAO:
                return (T) new PackageDAOImpl();
            case SalaryDAO:
                return (T) new SalaryDAOImpl();
            case Schedule_detailsDAO:
                return (T) new Schedule_detailsDAOImpl();
            case ScheduleDAO:
                return (T) new ScheduleDAOImpl();
            case Suppler_orderDAO:
                return (T) new Suppler_orderDAOImpl();
            case Supplier_order_detailsDAO:
                return (T) new Supplier_order_detailsDAOImpl();
            case SupplierDAO:
                return (T) new SupplierDAOImpl();
            case coach_salary_details:
                return (T) new Coach_salary_detailsDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        EMPLOYEE,
        ITEM,
        Coach_attendanceDAO,
        CoachDAO,
        Customer_attendanceDAO,
        Customer_paymentDAO,
        coach_salary_details,
        CustomerDAO,
        Employee_attendanceDAO,
        Employee_salary_detailsDAO,
        ExercisesDAO,
        Order_detailsDAO,
        OrdersDAO,
        Package_detailsDAO,
        PackageDAO,
        SalaryDAO,
        Schedule_detailsDAO,
        ScheduleDAO,
        Suppler_orderDAO,
        Supplier_order_detailsDAO,
        SupplierDAO
    }


}
