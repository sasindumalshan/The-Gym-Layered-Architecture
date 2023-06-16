package lk.ijse.theGym.entity;

import lk.ijse.theGym.dto.ItemsDTO;

public class Item {
    private String item_id;
    private String item_name;
    private String category;
    private int qut;
    private double price;
    private String brand;
    private String description;

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
 public Item toEntity(ItemsDTO dto){
  this.item_id=dto.getItem_id();
  this.item_name=dto.getItem_name();
  this.category=dto.getCategory();
  this.qut=dto.getQut();
  this.price=dto.getPrice();
  this.brand=dto.getBrand();
  this.description=dto.getDescription();
  return this;
 }
}
