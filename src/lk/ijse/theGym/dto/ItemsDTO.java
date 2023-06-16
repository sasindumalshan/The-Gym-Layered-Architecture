package lk.ijse.theGym.dto;

import lk.ijse.theGym.entity.Item;

public class ItemsDTO {
    private String item_id;
    private String item_name;
    private String category;
    private int qut;
    private double price;
    private String brand;
    private String description;

    public ItemsDTO(String item_id, String item_name, String category, int qut, double price, String brand, String description) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.category = category;
        this.qut = qut;
        this.price = price;
        this.brand = brand;
        this.description = description;
    }

    public ItemsDTO() {
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemsDTO toDTO(Item item) {
        this.item_id = item.getItem_id();
        this.item_name = item.getItem_name();
        this.category = item.getCategory();
        this.qut = item.getQut();
        this.price = item.getPrice();
        this.brand = item.getBrand();
        this.description = item.getDescription();
        return this;
    }
}
