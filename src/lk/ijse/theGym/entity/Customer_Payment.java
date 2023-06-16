package lk.ijse.theGym.entity;

public class Customer_Payment {
    private double monthly_fees;
    private String date;
    private String month;
    private String customer_id;
    private String year;

    public Customer_Payment() {
    }

    public Customer_Payment(double monthly_fees, String date, String month, String customer_id, String year) {
        this.monthly_fees = monthly_fees;
        this.date = date;
        this.month = month;
        this.customer_id = customer_id;
        this.year = year;
    }

    public double getMonthly_fees() {
        return monthly_fees;
    }

    public void setMonthly_fees(double monthly_fees) {
        this.monthly_fees = monthly_fees;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Customer_Payment{" +
                "monthly_fees=" + monthly_fees +
                ", date='" + date + '\'' +
                ", month='" + month + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
