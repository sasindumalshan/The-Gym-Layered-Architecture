package lk.ijse.theGym.dto.projection;

public class SupplierItemProjection {
    private String order_id;
    private String supplier_id;
    private String company_name;
    private String COUNTItem_code;
    private String total;

    public SupplierItemProjection() {
    }

    public SupplierItemProjection(String order_id, String supplier_id, String company_name, String COUNTItem_code, String total) {
        this.order_id = order_id;
        this.supplier_id = supplier_id;
        this.company_name = company_name;
        this.COUNTItem_code = COUNTItem_code;
        this.total = total;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCOUNTItem_code() {
        return COUNTItem_code;
    }

    public void setCOUNTItem_code(String COUNTItem_code) {
        this.COUNTItem_code = COUNTItem_code;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SupplierItemProjection{" +
                "order_id='" + order_id + '\'' +
                ", supplier_id='" + supplier_id + '\'' +
                ", company_name='" + company_name + '\'' +
                ", COUNTItem_code='" + COUNTItem_code + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
