package lk.ijse.theGym.entity;

import lk.ijse.theGym.dto.EmployeeDTO;

import java.time.LocalDate;

public class Employee {
    private String employee_id;
    private String fist_name;
    private String last_name;
    private String usr_name;
    private String password;
    private String roll;
    private String address_street;
    private String address_city;
    private String address_lene;
    private String e_mail;
    private String birthday;
    private String nic;
    private String contact_number;
    private String date;
    private String salary_Id;

 public Employee() {
 }

 public Employee(String employee_id, String fist_name, String last_name, String usr_name, String password, String roll, String address_street, String address_city, String address_lene, String e_mail, String birthday, String nic, String contact_number, String date, String salary_Id) {
  this.employee_id = employee_id;
  this.fist_name = fist_name;
  this.last_name = last_name;
  this.usr_name = usr_name;
  this.password = password;
  this.roll = roll;
  this.address_street = address_street;
  this.address_city = address_city;
  this.address_lene = address_lene;
  this.e_mail = e_mail;
  this.birthday = birthday;
  this.nic = nic;
  this.contact_number = contact_number;
  this.date = date;
  this.salary_Id = salary_Id;
 }

 public String getEmployee_id() {
  return employee_id;
 }

 public void setEmployee_id(String employee_id) {
  this.employee_id = employee_id;
 }

 public String getFist_name() {
  return fist_name;
 }

 public void setFist_name(String fist_name) {
  this.fist_name = fist_name;
 }

 public String getLast_name() {
  return last_name;
 }

 public void setLast_name(String last_name) {
  this.last_name = last_name;
 }

 public String getUsr_name() {
  return usr_name;
 }

 public void setUsr_name(String usr_name) {
  this.usr_name = usr_name;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public String getRoll() {
  return roll;
 }

 public void setRoll(String roll) {
  this.roll = roll;
 }

 public String getAddress_street() {
  return address_street;
 }

 public void setAddress_street(String address_street) {
  this.address_street = address_street;
 }

 public String getAddress_city() {
  return address_city;
 }

 public void setAddress_city(String address_city) {
  this.address_city = address_city;
 }

 public String getAddress_lene() {
  return address_lene;
 }

 public void setAddress_lene(String address_lene) {
  this.address_lene = address_lene;
 }

 public String getE_mail() {
  return e_mail;
 }

 public void setE_mail(String e_mail) {
  this.e_mail = e_mail;
 }

 public String getBirthday() {
  return birthday;
 }

 public void setBirthday(String birthday) {
  this.birthday = birthday;
 }

 public String getNic() {
  return nic;
 }

 public void setNic(String nic) {
  this.nic = nic;
 }

 public String getContact_number() {
  return contact_number;
 }

 public void setContact_number(String contact_number) {
  this.contact_number = contact_number;
 }

 public String getDate() {
  return date;
 }

 public void setDate(String date) {
  this.date = date;
 }

 public String getSalary_Id() {
  return salary_Id;
 }

 public void setSalary_Id(String salary_Id) {
  this.salary_Id = salary_Id;
 }

 public Employee toEntity(EmployeeDTO dto) {
  this.employee_id = dto.getEmployee_id();
  this.fist_name =dto.getFist_name();
  this.last_name = dto.getLast_name();
  this.usr_name = dto.getUsr_name();
  this.password = dto.getPassword();
  this.roll = dto.getRoll();
  this.address_street = dto.getAddress_street();
  this.address_city = dto.getAddress_city();
  this.address_lene = dto.getAddress_lene();
  this.e_mail = dto.getE_mail();
  this.birthday = dto.getBirthday();
  this.nic = dto.getNic();
  this.contact_number = dto.getContact_number();
  this.date = dto.getDate();
  this.salary_Id = dto.getSalary_Id();
  return this;
 }
}
