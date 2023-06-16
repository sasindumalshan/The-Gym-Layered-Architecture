package lk.ijse.theGym.entity;

public class Employee_attendance {
    private String date;
    private String time;
    private String employee_id;

    public Employee_attendance() {
    }

    public Employee_attendance(String date, String time, String employee_id) {
        this.date = date;
        this.time = time;
        this.employee_id = employee_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return "Employee_attendance{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", employee_id='" + employee_id + '\'' +
                '}';
    }
}
