package lk.ijse.theGym.entity;

public class Supplier_order_details {
    private String order_id;
    private String item_code;
    private int qut;
    private double price;

    public Supplier_order_details() {
    }

    public Supplier_order_details(String order_id, String item_code, int qut, double price) {
        this.order_id = order_id;
        this.item_code = item_code;
        this.qut = qut;
        this.price = price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public int getQut() {
        return qut;
    }

    public void setQut(int qut) {
        this.qut = qut;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String
    toString() {
        return "Supplier_order_details{" +
                "order_id='" + order_id + '\'' +
                ", item_code='" + item_code + '\'' +
                ", qut=" + qut +
                ", price=" + price +
                '}';
    }
}
