package lk.ijse.theGym.entity;

public class Order_details {
    private String order_id;
    private String item_id;
    private String price;
    private String qut;

    public Order_details() {
    }

    public Order_details(String order_id, String item_id, String price, String qut) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.price = price;
        this.qut = qut;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQut() {
        return qut;
    }

    public void setQut(String qut) {
        this.qut = qut;
    }

    @Override
    public String toString() {
        return "Order_details{" +
                "order_id='" + order_id + '\'' +
                ", item_id='" + item_id + '\'' +
                ", price='" + price + '\'' +
                ", qut='" + qut + '\'' +
                '}';
    }
}
