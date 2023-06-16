package lk.ijse.theGym.entity;

public class Package_details {
    private String customer_id;
    private String package_Id;
    private String date;

    public Package_details() {
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPackage_Id() {
        return package_Id;
    }

    public void setPackage_Id(String package_Id) {
        this.package_Id = package_Id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Package_details{" +
                "customer_id='" + customer_id + '\'' +
                ", package_Id='" + package_Id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
