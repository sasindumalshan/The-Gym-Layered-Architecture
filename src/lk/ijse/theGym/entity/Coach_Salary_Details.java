package lk.ijse.theGym.entity;

public class Coach_Salary_Details {
    private String coach_id;
    private String date;
    private double price;
    private String salary_id;

    public Coach_Salary_Details() {
    }

    public Coach_Salary_Details(String coach_id, String date, double price, String salary_id) {
        this.coach_id = coach_id;
        this.date = date;
        this.price = price;
        this.salary_id = salary_id;
    }

    public String getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(String coach_id) {
        this.coach_id = coach_id;
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
        return "Coach_Salary_Details{" +
                "coach_id='" + coach_id + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", salary_id='" + salary_id + '\'' +
                '}';
    }
}
