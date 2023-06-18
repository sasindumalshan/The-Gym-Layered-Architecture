package lk.ijse.theGym.entity;

import lk.ijse.theGym.dto.SupplierDTO;

public class Supplier {
    private String company_name;
    private String supplier_id;
    private String email;
    private String mobile_no;
    private String location;

    public Supplier() {
    }

    public Supplier(String company_name, String supplier_id, String email, String mobile_no, String location) {
        this.company_name = company_name;
        this.supplier_id = supplier_id;
        this.email = email;
        this.mobile_no = mobile_no;
        this.location = location;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "company_name='" + company_name + '\'' +
                ", supplier_id='" + supplier_id + '\'' +
                ", email='" + email + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Supplier toEntity(SupplierDTO dto) {
        this.company_name = dto.getCompany_name();
        this.supplier_id = dto.getSupplier_id();
        this.email = dto.getEmail();
        this.mobile_no = dto.getMobile_no();
        this.location = dto.getLocation();
        return this;
    }
}
