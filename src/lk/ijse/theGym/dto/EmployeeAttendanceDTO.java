package lk.ijse.theGym.dto;

public class EmployeeAttendanceDTO {
    private String employeeID;
    private String date;
    private String time;

    public EmployeeAttendanceDTO() {
    }

    public EmployeeAttendanceDTO(String employeeID, String date, String time) {
        this.employeeID = employeeID;
        this.date = date;
        this.time = time;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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
}
