package lk.ijse.theGym.entity;

public class Orders {
    private String time;
    private String date;
    private double final_total;
    private String customer_id;

    public Orders() {
    }

    public Orders(String time, String date, double final_total, String customer_id) {
        this.time = time;
        this.date = date;
        this.final_total = final_total;
        this.customer_id = customer_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFinal_total() {
        return final_total;
    }

    public void setFinal_total(double final_total) {
        this.final_total = final_total;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", final_total=" + final_total +
                ", customer_id='" + customer_id + '\'' +
                '}';
    }
}
