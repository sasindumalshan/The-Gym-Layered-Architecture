package lk.ijse.theGym.entity;

public class Suppler_order {
    private String order_id;
    private double total;
    private String suppler_id;
    private String date;
    private String time;

  public Suppler_order() {
  }

  public Suppler_order(String order_id, double total, String suppler_id, String date, String time) {
    this.order_id = order_id;
    this.total = total;
    this.suppler_id = suppler_id;
    this.date = date;
    this.time = time;
  }

  public String getOrder_id() {
    return order_id;
  }

  public void setOrder_id(String order_id) {
    this.order_id = order_id;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public String getSuppler_id() {
    return suppler_id;
  }

  public void setSuppler_id(String suppler_id) {
    this.suppler_id = suppler_id;
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

  @Override
  public String toString() {
    return "Suppler_order{" +
            "order_id='" + order_id + '\'' +
            ", total=" + total +
            ", suppler_id='" + suppler_id + '\'' +
            ", date='" + date + '\'' +
            ", time='" + time + '\'' +
            '}';
  }
}
