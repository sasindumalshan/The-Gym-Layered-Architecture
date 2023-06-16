package lk.ijse.theGym.bo;


import lk.ijse.theGym.bo.custom.impl.*;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {

    }

    public static BoFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BOTypes {
        EMPLOYEE_BO,
        ITEM_BO,
        Coach_attendanceBO,
        Coach_salary_detailsBO,
        CoachBO,
        Customer_attendanceBO,
        Customer_paymentBO,
        CustomerBO,
        Employee_attendanceBO,
        Employee_salary_detailsBO,
        ExercisesBO,
        Order_detailsBO,
        OrdersBO,
        Package_detailsBO,
        PackageBO,
        SalaryBO,
        Schedule_detailsBO,
        ScheduleBO,
        Suppler_orderBO,
        Supplier_order_detailsBO,
        SupplierBO
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes) {
        switch (boTypes) {
            case EMPLOYEE_BO:
                return (T) new EmployeeBOImpl();
            case ITEM_BO:
                return (T) new ItemBoImpl();
            case Coach_attendanceBO:
                return (T) new Coach_attendanceBOImpl();
            case Coach_salary_detailsBO:
                return (T) new Coach_salary_detailsBOImpl();
            case CoachBO:
                return (T) new CoachBOImpl();
            case Customer_attendanceBO:
                return (T) new Customer_attendanceBOImpl();
            case Customer_paymentBO:
                return (T) new Customer_paymentBOImpl();
            case CustomerBO:
                return (T) new CustomerBOImpl();
            case Employee_attendanceBO:
                return (T) new Employee_attendanceBOImpl();
            case Employee_salary_detailsBO:
                return (T) new Employee_salary_detailsBOImpl();
            case ExercisesBO:
                return (T) new ExercisesBOImpl();
            case Order_detailsBO:
                return (T) new Order_detailsBOImpl();
            case OrdersBO:
                return (T) new OrdersBOImpl();
            case Package_detailsBO:
                return (T) new Package_detailsBOImpl();
            case PackageBO:
                return (T) new PackageBOImpl();
            case SalaryBO:
                return (T) new SalaryBOImpl();
            case Schedule_detailsBO:
                return (T) new Schedule_detailsBOImpl();
            case ScheduleBO:
                return (T) new ScheduleBOImpl();
            case Suppler_orderBO:
                return (T) new Suppler_orderBOImpl();
            case Supplier_order_detailsBO:
                return (T) new Supplier_order_detailsBOImpl();
            case SupplierBO:
                return (T) new SupplierBOImpl();
            default:
                return null;
        }
    }

}
