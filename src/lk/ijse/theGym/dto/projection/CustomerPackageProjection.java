package lk.ijse.theGym.dto.projection;

public class CustomerPackageProjection {
    private String id;
    private String fistNAme;
    private String lastName;
    private String eMail;
    private String nic;
    private double package_price;

    public CustomerPackageProjection() {
    }

    public CustomerPackageProjection(String id, String fistNAme, String lastName, String eMail, String nic, double package_price) {
        this.id = id;
        this.fistNAme = fistNAme;
        this.lastName = lastName;
        this.eMail = eMail;
        this.nic = nic;
        this.package_price = package_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFistNAme() {
        return fistNAme;
    }

    public void setFistNAme(String fistNAme) {
        this.fistNAme = fistNAme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public double getPackage_price() {
        return package_price;
    }

    public void setPackage_price(double package_price) {
        this.package_price = package_price;
    }

    @Override
    public String toString() {
        return "CustomerPackageProjection{" +
                "id='" + id + '\'' +
                ", fistNAme='" + fistNAme + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", nic='" + nic + '\'' +
                ", package_price=" + package_price +
                '}';
    }
}
