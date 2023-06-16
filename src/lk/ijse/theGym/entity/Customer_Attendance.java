package lk.ijse.theGym.entity;

public class Customer_Attendance {
    private String date;
    private String time;
    private String customer_id;

    public Customer_Attendance() {

    }

    public Customer_Attendance(String date, String time, String customer_id) {
        this.date = date;
        this.time = time;
        this.customer_id = customer_id;
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
        return "Customer_Attendance{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", customer_id='" + customer_id + '\'' +
                '}';
    }
}
