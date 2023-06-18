package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.CoachBO;
import lk.ijse.theGym.bo.custom.Coach_salary_detailsBO;
import lk.ijse.theGym.bo.custom.EmployeeBO;
import lk.ijse.theGym.bo.custom.Employee_salary_detailsBO;
import lk.ijse.theGym.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.theGym.dto.*;
import lk.ijse.theGym.model.*;
import lk.ijse.theGym.util.DateTimeUtil;
import lk.ijse.theGym.util.Notification;
import lk.ijse.theGym.util.RegexUtil;
import lk.ijse.theGym.view.data.salary;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class SalaryFromController implements Initializable {
    public static String clickId;
    public static String salaryPrice;
    private static String id;
    private static String salaryId;
    public AnchorPane anchorPane;
    public VBox Vbox;
    public Text txtId;
    public JFXRadioButton salary;
    public JFXRadioButton salaryDetails;
    public Pane addSalary;
    public JFXTextField lblPrice;
    public JFXTextField txtOtherRole;
    public JFXButton btnAdd;
    public JFXComboBox comboRole;
    public Pane givenSalary;
    public JFXComboBox comboId;
    public Text txtName;
    public Text txtNic;
    public Text txtAttendance;
    public Text txtAvailableSalary;
    public Text txtPerMonthSalary;
    public JFXButton btnAdd1;
    public Text availableRole;
    public Text txtSalary;
    public Text usage;
    public Pane otherRole;
    public JFXComboBox comboMonth;
    public JFXComboBox comboYear;
    public Text txtIdSearch;
    public Pane paneSalaryId;
    private  static SalaryFromController controller;

    public SalaryFromController() {
        controller=this;
    }

    public static SalaryFromController getController() {
        return controller;
    }

    String[] allMonth = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};

    public void setData(String id, String price) {
        System.out.println("click");
        System.out.println(id);
        if (salary.isSelected()) {
            lblPrice.setText(price);
            btnAdd.setText("OK");
            salaryPrice = price;
            paneSalaryId.setVisible(true);
            txtIdSearch.setText(id);
            clickId=id;
        }
    }

    public void addOnAction(ActionEvent actionEvent) {
        if (comboId.getValue()!=null) {
            try {
//                EmployeeController.idExists(id)
                if (employeeBO.get(id)!=null) {
                    if (EmployeeSalaryDetailsController.addDetails(new EmployeeSalaryDetailsDTO(
                            id,
                            DateTimeUtil.dateNow(),
                            txtPerMonthSalary.getText(),
                            salaryId
                    ))) {
                        Notification.notification("Salary is Payed","payed successful ");
//                        new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                        setSalaryDetails();
                    }
                }
                if (coachBO.get(id)!=null) {
                    if (CoachSalaryDetailsController.addDetails(new CoachSalaryDetailsDTO(
                            id,
                            DateTimeUtil.dateNow(),
                            txtPerMonthSalary.getText(),
                            salaryId
                    ))) {
                        Notification.notification("Salary is Payed","payed successful ");
//                        new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                    }
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }else {
            Notification.notificationWARNING("please select employee","No select employee");
        }
    }
    CoachBO coachBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.CoachBO);

    public void idOnAction(ActionEvent actionEvent) {
        try {
            //ResultSet set1 = EmployeeController.getDataForId(String.valueOf(comboId.getValue()));

            EmployeeDTO employeeDTO = employeeBO.get(String.valueOf(comboId.getValue()));

            if (employeeDTO!=null) {
                salaryId = employeeDTO.getSalary_Id();
                id = employeeDTO.getEmployee_id();
                txtName.setText(employeeDTO.getFist_name() + " " + employeeDTO.getLast_name());
                txtNic.setText(employeeDTO.getNic());
                ResultSet set = EmployeeAttendanceController.getAttendanceCount(String.valueOf(comboId.getValue()));
                if (set.next()) {
                    txtAttendance.setText(set.getString(1));
                }
                ResultSet set2 = SalaryController.findSalary(employeeDTO.getSalary_Id());
                if (set2.next()) {
                    txtAvailableSalary.setText(set2.getString(1));
                }
                SimpleDateFormat format = new SimpleDateFormat("MM");
                int days = DateTimeUtil.getDays(Integer.parseInt(DateTimeUtil.yearNow()), Integer.valueOf(format.format(new Date())));
                double oneDaySalary = Double.parseDouble(txtAvailableSalary.getText()) / days;
                double preSalary = oneDaySalary * Integer.parseInt(txtAttendance.getText());
                txtPerMonthSalary.setText(String.valueOf(preSalary));
            }
            //ResultSet set = CoachController.getDataForId(String.valueOf(comboId.getValue()));
            CoachDTO dto = coachBO.get(String.valueOf(comboId.getValue()));
          //  if (set.next()) {
                salaryId = dto.getSalary_id();
                id = dto.getCoach_id();
                txtName.setText(dto.getFist_name()+ " " +dto.getLast_name());
                txtNic.setText(dto.getNic());
                ResultSet resultSet = CoachAttendanceController.getAttendanceCount(String.valueOf(comboId.getValue()));
                if (resultSet.next()) {
                    txtAttendance.setText(resultSet.getString(1));
                }
                ResultSet set2 = SalaryController.findSalary(dto.getSalary_id());
                if (set2.next()) {
                    txtAvailableSalary.setText(set2.getString(1));
                }
                SimpleDateFormat format = new SimpleDateFormat("MM");
                int days = DateTimeUtil.getDays(Integer.parseInt(DateTimeUtil.yearNow()), Integer.valueOf(format.format(new Date())));
                double oneDaySalary = Double.parseDouble(txtAvailableSalary.getText()) / days;
                double preSalary = oneDaySalary * Integer.parseInt(txtAttendance.getText());
                txtPerMonthSalary.setText(String.valueOf(preSalary));
            //}

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void roleOnAction(ActionEvent actionEvent) {
        try {
            if (comboRole.getValue().equals("other")) {
                otherRole.setVisible(true);
            } else {
                otherRole.setVisible(false);
                txtOtherRole.setText("");
            }
        }catch (Exception e){

        }

    }

    public void salaryAddOnAction(ActionEvent actionEvent) {
        System.out.println("cilck");
        if (!lblPrice.getText().equals("")) {
            if (btnAdd.getText().equals("ADD NEW SALARY")) {
                String role = null;
                if (txtOtherRole.getText().equals("")) {
                    role = String.valueOf(comboRole.getValue());
                } else {
                    role = txtOtherRole.getText();
                }
                try {
                    if (SalaryController.addSalary(new SalaryDTO(
                            getNextId(),
                            role,
                            Double.valueOf(lblPrice.getText())

                    ))) {
                        Notification.notification("Salary Added","your salary Added");
//                        new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                        setSalaryData();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (btnAdd.getText().equals("OK")) {
                System.out.println("ok");
                clear();
                btnAdd.setText("ADD NEW SALARY");
            }
            if (btnAdd.getText().equals("UPDATE SALARY")) {
                try {
                    if (SalaryController.updateSalary(clickId, lblPrice.getText())) {
//                      new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                        Notification.notification("Salary Updated","your salary is updated ");
                        btnAdd.setText("ADD NEW SALARY");
                        comboRole.getItems().clear();
                        setRole();
                        clear();
                        setSalaryData();
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                btnAdd.setText("ADD NEW SALARY");
            }
        }else {
            Notification.notificationWARNING("Place add data","add data ");
        }
    }

    private String getNextId() {
        String id=null;
        try {
            ResultSet set = SalaryController.getlastId();
            if (set.next()) {
               id=set.getString(1);
            }try {
                String[] s = id.split("S");
                int n= Integer.parseInt(s[1]);
                n++;
                return "S"+n;
            }catch (NullPointerException e){
                return "S1";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "S1";
    }

    public void salaryOnAction(ActionEvent actionEvent) {
        if (salary.isSelected()) {
            addSalary.setVisible(true);
            txtId.setText("SALARY ID");
            txtSalary.setText("SALARY");
            availableRole.setText("AVAILABLE ROLE");
            usage.setText("USAGE");
            givenSalary.setVisible(false);
            setSalaryData();
            comboMonth.setVisible(false);
            comboYear.setVisible(false);
        }
        if (salaryDetails.isSelected()) {
            addSalary.setVisible(false);
            txtId.setText("EMP ID");
            txtSalary.setText("SALARY");
            availableRole.setText("SALARY ID");
            usage.setText("DATE");
            givenSalary.setVisible(true);
            setSalaryDetails();
            comboMonth.setValue(true);
            comboYear.setValue(true);
            setEmpIds();
        }
    }

    public void salaryDetaisOnAction(ActionEvent actionEvent) {
        if (salary.isSelected()) {
            addSalary.setVisible(true);
            txtId.setText("SALARY ID");
            txtSalary.setText("SALARY");
            availableRole.setText("AVAILABLE ROLE");
            usage.setText("USAGE");
            givenSalary.setVisible(false);
            setSalaryData();
            comboMonth.setVisible(false);
            comboYear.setVisible(false);
        }
        if (salaryDetails.isSelected()) {
            setSalaryDetails();
            addSalary.setVisible(false);
            txtId.setText("EMP ID");
            txtSalary.setText("SALARY");
            availableRole.setText("SALARY ID");
            usage.setText("DATE");
            givenSalary.setVisible(true);
            comboMonth.setVisible(true);
            comboYear.setVisible(true);
            setEmpIds();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setStyle("-fx-background-color: transparent");
        salary.fire();
        setRole();
        otherRole.setVisible(false);
        setMonth();
        setYear();
        comboYear.setValue(DateTimeUtil.yearNow());
        comboMonth.setValue(DateTimeUtil.monthNow());
        btnAdd.setText("ADD NEW SALARY");
        paneSalaryId.setVisible(false);

    }

    private void setYear() {
        ArrayList<String> year = new ArrayList<>();
        year.add(DateTimeUtil.yearNow());
        boolean isNotDuplicate = true;
        boolean isNotDuplicate2 = true;

        try {
            ResultSet set = CoachSalaryDetailsController.getDays();
            while (set.next()) {
                String[] split = set.getString(1).split("-");
                String s = split[0];
                for (int i = 0; i < year.size(); i++) {
                    if (year.get(i).equals(s)) {
                        isNotDuplicate = false;
                    }
                }
                if (isNotDuplicate) {
                    year.add(s);
                }
            }
            ResultSet set1 = EmployeeSalaryDetailsController.getDays();
            while (set1.next()) {
                String[] split = set1.getString(1).split("-");
                String s = split[0];
                for (int i = 0; i < year.size(); i++) {
                    if (year.get(i).equals(s)) {
                        isNotDuplicate2 = false;
                    }
                }
                if (isNotDuplicate2) {
                    year.add(s);
                }
            }
            comboYear.getItems().addAll(year);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setMonth() {
        comboMonth.getItems().clear();
        comboMonth.getItems().addAll(allMonth);
    }

    private void setEmpIds() {
        comboId.getItems().clear();
        ArrayList<String> ids = new ArrayList<>();
        try {
           // ResultSet set = EmployeeController.getAllIds();
            ArrayList<String> allIds = employeeBO.getAllIds();
            for (String s:allIds) {
                String month = null;
                for (int i = 0; i < allMonth.length; i++) {
                    if (allMonth[i].equals(comboMonth.getValue())) {
                        month = String.valueOf(i).length() == 1 ? "0" + (i + 1) : String.valueOf((i + 1));
                    }

                }
                ResultSet set1 = EmployeeSalaryDetailsController.existThisMonth(comboYear.getValue() + "-" + month, s);
                if (!set1.next()) {
                    ids.add(s);
                }

            }
           // ResultSet set1 = CoachController.getALlId();
            ArrayList<String> aLlId = coachBO.getALlId();
            for (String s:aLlId) {
                String month = null;
                for (int i = 0; i < allMonth.length; i++) {
                    if (allMonth[i].equals(comboMonth.getValue())) {
                        month = String.valueOf(i).length() == 1 ? "0" + (i + 1) : String.valueOf((i + 1));
                    }

                }
                ResultSet set2 = CoachSalaryDetailsController.exsistThisMonth(comboYear.getValue() + "-" + month, s);
                if (!set2.next()) {
                    ids.add(s);
                }


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        comboId.getItems().addAll(ids);
    }

    private void setRole() {
        comboRole.getItems().clear();
        ArrayList<String> role = new ArrayList<>();
        role.clear();
        try {
            ResultSet set = SalaryController.getAllRoles();
            while (set.next()) {
                role.add(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        role.add("other");
        comboRole.getItems().addAll(role);

    }
    Coach_salary_detailsBO coach_salary_detailsBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Coach_salary_detailsBO);
    Employee_salary_detailsBO employee_salary_detailsBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Employee_salary_detailsBO);
    public void setSalaryDetails() {
        String month = null;
        for (int i = 0; i < allMonth.length; i++) {
            if (allMonth[i].equals(comboMonth.getValue())) {
                month = String.valueOf(i).length() == 1 ? "0" + (i + 1) : String.valueOf((i + 1));
            }

        }

        Vbox.getChildren().clear();
        try {
            //ResultSet set = EmployeeSalaryController.getAll(comboYear.getValue() + "-" + month);
            ArrayList<EmployeeSalaryDetailsDTO> all1 = employee_salary_detailsBO.getAll(comboYear.getValue() + "-" + month);
            for (EmployeeSalaryDetailsDTO dto:all1) {
                navigation(dto.getEmployee_id(), dto.getPrice(), dto.getSalary_id(), dto.getDate());
            }
          //  ResultSet set1 = CoachSalaryController.getAll(comboYear.getValue() + "-" + month);

            ArrayList<CoachSalaryDetailsDTO> all = coach_salary_detailsBO.getAll(comboYear.getValue() + "-" + month);
            for (CoachSalaryDetailsDTO dto:all) {
                navigation(dto.getEmployee_id(), dto.getPrice(), dto.getSalary_id(), dto.getDate());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    EmployeeBO employeeBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.EMPLOYEE_BO);
    public void setSalaryData() {
        ArrayList<lk.ijse.theGym.view.data.salary> salaryData = new ArrayList<>();
        Vbox.getChildren().clear();
        try {
            ResultSet set = SalaryController.getAll();
            while (set.next()) {
                boolean isNotDuplicate1 = true;
                int index1 = -1;
                int index2 = -1;
                boolean isNotDuplicate2 = true;
              //  ResultSet set2 = EmployeeController.getSalaryCount(set.getString(1));
                String salaryCount1 = employeeBO.getSalaryCount(set.getString(1));
                if (salaryCount1!=null) {

                    for (int i = 0; i < salaryData.size(); i++) {
                        if (set.getString(1).equals(salaryData.get(i).getId())) {
                            isNotDuplicate1 = false;
                            index1 = i;
                        }
                    }
                    if (isNotDuplicate1) {
                        salaryData.add(new salary(
                                set.getString(1),
                                set.getString(3),
                                set.getString(2),
                                salaryCount1 == null ? "0" : salaryCount1

                        ));
                    } else {
                        isNotDuplicate1 = true;
                        salaryData.get(index1).setUsage(String.valueOf(Integer.valueOf(salaryData.get(index1).getUsage()) + Integer.parseInt(salaryCount1)));

                    }

                } else {
                    for (int i = 0; i < salaryData.size(); i++) {
                        if (set.getString(1).equals(salaryData.get(i).getId())) {
                            isNotDuplicate1 = false;
                            index1 = i;
                        }
                    }
                    if (isNotDuplicate1) {
                        salaryData.add(new salary(
                                set.getString(1),
                                set.getString(3),
                                set.getString(2),
                                salaryData.get(index1).getUsage() == null ? "0" : String.valueOf(Integer.valueOf(salaryData.get(index1).getUsage()) + Integer.parseInt(salaryCount1))

                        ));
                    } else {
                        isNotDuplicate1 = true;
                        salaryData.get(index1).setUsage(String.valueOf(Integer.valueOf(salaryData.get(index1).getUsage()) + Integer.parseInt(salaryCount1)));

                    }
                }
               // ResultSet set3 = CoachController.getSalaryCount(set.getString(1));
                String salaryCount = coachBO.getSalaryCount(set.getString(1));
                if (salaryCount!=null) {
                    for (int i = 0; i < salaryData.size(); i++) {
                        if (set.getString(1).equals(salaryData.get(i).getId())) {
                            isNotDuplicate2 = false;
                            index2 = i;
                        }
                    }
                    if (isNotDuplicate2) {
                        salaryData.add(new salary(
                                set.getString(1),
                                set.getString(3),
                                set.getString(2),
                                salaryCount == null ? "0" : salaryCount

                        ));
                    } else {
                        isNotDuplicate2 = true;
                        salaryData.get(index2).setUsage(String.valueOf(Integer.valueOf(salaryData.get(index2).getUsage()) + Integer.parseInt(salaryCount)));

                    }
                } else {
                    for (int i = 0; i < salaryData.size(); i++) {
                        if (set.getString(1).equals(salaryData.get(i).getId())) {
                            isNotDuplicate2 = false;
                            index2 = i;
                        }
                    }
                    if (isNotDuplicate2) {
                        salaryData.add(new salary(
                                set.getString(1),
                                set.getString(3),
                                set.getString(2),
                                salaryData.get(index2).getUsage() == null ? "0" : salaryCount

                        ));
                    } else {
                        isNotDuplicate2 = true;
                        salaryData.get(index2).setUsage(String.valueOf(Integer.valueOf(salaryData.get(index2).getUsage()) + Integer.parseInt(salaryCount)));
                    }
                }

            }
            for (int i = 0; i < salaryData.size(); i++) {

                navigation(salaryData.get(i).getId(), salaryData.get(i).getSalary(), salaryData.get(i).getRole(), salaryData.get(i).getUsage());
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void navigation(String id, String salary, String role, String usage) {
        try {
            FXMLLoader loader = new FXMLLoader(StoreFromController.class.getResource("/lk/ijse/theGym/view/bar/SalaryDetailsBar.fxml"));
            Parent root = loader.load();
            SalaryDetailsBarController controller = loader.getController();
            controller.setData(id, salary, role, usage);
            Vbox.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void monthOnAction(ActionEvent actionEvent) {
        setSalaryDetails();
        setEmpIds();

    }

    public void yearOnAction(ActionEvent actionEvent) {
        setSalaryDetails();
        setEmpIds();
    }

    private void clear() {
        lblPrice.clear();
        paneSalaryId.setVisible(false);
    }

    public void priceOnAction(KeyEvent keyEvent) {
        if (RegexUtil.regex(btnAdd,lblPrice,lblPrice.getText(),"^([+-]?[0-9]+(?:\\.[0-9]{0,4})?)$","-fx-text-fill: white")){
           try {
               if (salaryPrice.equals(lblPrice.getText())) {

               } else {
                   btnAdd.setText("UPDATE SALARY");
               }
           }catch (NullPointerException n){}


        }

    }

    public void otherRole(KeyEvent keyEvent) {
        if (RegexUtil.regex(btnAdd,txtOtherRole,txtOtherRole.getText(),"\\b([a-z]|[A-Z])+","-fx-text-fill: white")){

        }
    }

    public void employeeId(KeyEvent keyEvent) {

    }
}
