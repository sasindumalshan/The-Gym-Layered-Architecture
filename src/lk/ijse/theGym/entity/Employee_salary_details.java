package lk.ijse.theGym.entity;

public class Employee_salary_details {
    private String employee_id;
    private String date;
    private double price;
    private String salary_id;

    public Employee_salary_details() {
    }

    public Employee_salary_details(String employee_id, String date, double price, String salary_id) {
        this.employee_id = employee_id;
        this.date = date;
        this.price = price;
        this.salary_id = salary_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(String salary_id) {
        this.salary_id = salary_id;
    }

    @Override
    public String toString() {
        return "Employee_salary_details{" +
                "employee_id='" + employee_id + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", salary_id='" + salary_id + '\'' +
                '}';
    }
}
