package lk.ijse.theGym.entity;

public class Salary {
    private String salary_Id;
    private String role;
    private double salary;

    public Salary() {
    }

    public Salary(String salary_Id, String role, double salary) {
        this.salary_Id = salary_Id;
        this.role = role;
        this.salary = salary;
    }

    public String getSalary_Id() {
        return salary_Id;
    }

    public void setSalary_Id(String salary_Id) {
        this.salary_Id = salary_Id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salary_Id='" + salary_Id + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }
}
