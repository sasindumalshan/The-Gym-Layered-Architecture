package lk.ijse.theGym.dto.projection;

public class EmployeeAttendanceProjection {
    private String employeeID;
    private String  fistName;
    private String lastName;
    private String employeeRoll;
    private String attendDate;
    private String attendTime;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeRoll() {
        return employeeRoll;
    }

    public void setEmployeeRoll(String employeeRoll) {
        this.employeeRoll = employeeRoll;
    }

    public String getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(String attendDate) {
        this.attendDate = attendDate;
    }

    public String getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(String attendTime) {
        this.attendTime = attendTime;
    }
}
