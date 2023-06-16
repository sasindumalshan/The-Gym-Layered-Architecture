package lk.ijse.theGym.dto;

public class SalaryDTO {
    private String id;
    private String role;
    private double salary;

    public SalaryDTO() {
    }

    public SalaryDTO(String id, String role, double salary) {
        this.id = id;
        this.role = role;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }
}
