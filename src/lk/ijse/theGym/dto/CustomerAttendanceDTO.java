package lk.ijse.theGym.dto;

public class CustomerAttendanceDTO {
    private String date;
    private String time;
    private String customer_id;

    public CustomerAttendanceDTO(String date, String time, String customer_id) {
        this.date = date;
        this.time = time;
        this.customer_id = customer_id;
    }

    public CustomerAttendanceDTO() {
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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "CustomerAttendance{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", customer_id='" + customer_id + '\'' +
                '}';
    }
}
