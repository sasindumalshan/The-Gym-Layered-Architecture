package lk.ijse.theGym.controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.CoachBO;
import lk.ijse.theGym.bo.custom.CustomerBO;
import lk.ijse.theGym.dto.CoachDTO;
import lk.ijse.theGym.dto.CustomerDTO;
import lk.ijse.theGym.model.PackController;
import lk.ijse.theGym.model.SalaryController;
import lk.ijse.theGym.util.DateTimeUtil;
import lk.ijse.theGym.util.Navigation;
import lk.ijse.theGym.util.Notification;
import lk.ijse.theGym.util.RegexUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

public class CustomerAddFromController implements Initializable {
    public static boolean isAddOnActionSelected;
    public static boolean isViewOnActionSelected;
    public static boolean isUpdateOnActionSelected;
    public static String id;
    static String Mid = null;
    static String Mname = null;
    static String Memail = null;
    private static CustomerAddFromController instance;
    public JFXTextField lblFastName;
    public JFXTextField lblLastName;
    public JFXTextField lblCity;
    public JFXTextField lblStreet;
    public JFXTextField lblLene;
    public JFXTextField lblEmail;
    public JFXDatePicker dPBirthDay;
    public JFXTextField lblNic;
    public JFXTextField lblMobile;
    public JFXComboBox comboGender;
    public JFXButton btn;
    public JFXComboBox comboPackage;
    public JFXRadioButton rBMember;
    public ToggleGroup btnCoach;
    public JFXRadioButton rBCoach;
    public Text txtTitle;
    public JFXButton btnUpdate;
    public Text CoachTypeOrPackage;
    public Pane salaryId;
    public JFXComboBox comboSalary;
    public Text txtgender;
    public Text txtPackage;
    public Text salary;
    public Text txtBirthday;
    public Text txtJoinDate;
    public Text txtpackdate;
    public Text salaryPrice;
    public Text TXTSalaryPrice;
    CoachBO coachBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.CoachBO);
    CustomerBO customerBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.CustomerBO);

    public CustomerAddFromController() {
        instance = this;
    }

    public static CustomerAddFromController getInstance() {
        return instance;
    }

    public void setData() {
        System.out.println("setdata di" + id);
        try {
            setCustomerData(id);
            setCoachData(id);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void setCoachData(String id) throws SQLException, ClassNotFoundException {
        // ResultSet set = CoachController.getAllForID(id);
        CoachDTO dto = coachBO.get(id);

        setDataForTextField(

                dto.getFist_name(),
                dto.getLast_name(),
                dto.getAddress_city(),
                dto.getAddress_street(),
                dto.getAddress_lene(),
                dto.getE_mail(),
                dto.getContact_number(),
                dto.getNic(),
                dto.getCoach_type(),
                dto.getRegister_date(),
                setsalaryPrice(dto.getSalary_id()),
                dto.getBirthday(),
                "JOINING DATE : " + dto.getRegister_date(),
                ""
        );

    }

    private String setsalaryPrice(String string) {
        try {
            ResultSet set = SalaryController.getSalary(string);
            if (set.next()) {
                return set.getString(1);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private void setCustomerData(String id) throws SQLException, ClassNotFoundException {
        // ResultSet set = CustomerController.getAllForId(id);
        CustomerDTO customer = customerBO.getCustomer(id);

        setDataForTextField(
                customer.getFist_name(),
                customer.getLast_name(),
                customer.getAddress_city(),
                customer.getAddress_street(),
                customer.getAddress_lene(),
                customer.getE_mail(),
                customer.getContact_number(),
                customer.getNic(),
                customer.getGender(),
                getPackageName(customer.getPackage_id()),
                "",
                customer.getBirthday(),
                "PACKAGE ACTIVATE DATE : " + customer.getPackage_activate_date(),
                "JOINING DATE : " + customer.getDate()
        );


    }

    private String getPackageName(String id) {
        try {
            ResultSet set = PackController.getName(id);
            if (set.next()) {
                return set.getString(1);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private void setDataForTextField(String fistName, String lastName, String city, String street, String lene, String email, String mobileNo, String nic, String gender, String packageName, String salaryPrice, String birthday, String pDate, String jDate) {
        lblFastName.setText(fistName);
        lblLastName.setText(lastName);
        lblCity.setText(city);
        lblStreet.setText(street);
        lblLene.setText(lene);
        lblEmail.setText(email);
        lblMobile.setText(mobileNo);
        lblNic.setText(nic);
        txtgender.setText(gender);
        txtBirthday.setText(birthday);
        txtPackage.setText(packageName);
        salary.setText(salaryPrice);
        txtpackdate.setText(pDate);
        txtJoinDate.setText(jDate);
    }

    public void anchorPaneOnMouseEntered(MouseEvent mouseEvent) {
//        if (isAddOnActionSelected) {
//            if (rBMember.isSelected()) {
//                btn.setText("ADD NEW MEMBER");
//            } else {
//                btn.setText("ADD NEW COACH");
//            }
//            btnUpdate.setVisible(false);
//        } else {
//            btnUpdate.setVisible(true);
//        }
//        if (isViewOnActionSelected) {
//            btn.setText("CLOSE");
//        }
//        if (btn.getText().equals("CLOSE")){
//            btnUpdate.setVisible(true);
//        }
        btnUpdate.setVisible(true);
    }

    public void anchorPaneOnMouseExited(MouseEvent mouseEvent) {
        btnUpdate.setVisible(false);
    }

    public void btnOnAction(ActionEvent actionEvent) {
        ArrayList<String> regex = new ArrayList<>();

        if (btn.getText().equals("CLOSE")) {
            isViewOnActionSelected = false;
            Navigation.close(actionEvent);
        }

        regex.add("\\b([a-z]|[A-Z])+");//fN
        regex.add("\\b([a-z]|[A-Z])+");//lN
        regex.add("\\b([a-z]|[A-Z])+");//c
        // regex.add("\\b([a-z]|[A-Z])+");//s
        //  regex.add("\\b([a-z]|[A-Z])+");//le
        regex.add("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{3,4}$");//email
        regex.add("^(?:19|20)?\\d{2}[0-9]{10}|[0-9]{9}[x|X|v|V]$");//nic
        regex.add("0((11)|(7(7|0|8|4|9|1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}");//mobil
        if (!RegexUtil.checkFinalResult(regex, btn, lblFastName, lblLastName, lblCity, lblEmail, lblNic, lblMobile)) {
            Notification.notificationWARNING("Pleace Enter Data", "fill the full from  ");
        } else {
            if (comboPackage.getValue() == null) {
            } else {
                if (btn.getText().equals("ADD NEW MEMBER")) {
                    Mid = customerNextId();
                    Memail = lblEmail.getText();
                    Mname = lblFastName.getText() + " " + lblLastName.getText();
                    try {
                       /* CustomerController.addCustomer(
                                new CustomerDTO(
                                        Mid,
                                        lblFastName.getText(),
                                        lblLastName.getText(),
                                        lblStreet.getText(),
                                        lblCity.getText(),
                                        lblLene.getText(),
                                        lblEmail.getText(),
                                        selectedDate(),
                                        lblNic.getText(),
                                        lblMobile.getText(),
                                        String.valueOf(comboGender.getValue()),
                                        String.valueOf(getPackageId()),
                                        DateTimeUtil.dateNow(),
                                        DateTimeUtil.dateNow()
                                ))*/
                        if (customerBO.save(
                                new CustomerDTO(
                                        Mid,
                                        lblFastName.getText(),
                                        lblLastName.getText(),
                                        lblStreet.getText(),
                                        lblCity.getText(),
                                        lblLene.getText(),
                                        lblEmail.getText(),
                                        selectedDate(),
                                        lblNic.getText(),
                                        lblMobile.getText(),
                                        String.valueOf(comboGender.getValue()),
                                        String.valueOf(getPackageId()),
                                        DateTimeUtil.dateNow(),
                                        DateTimeUtil.dateNow()
                                )
                        )) {
//                        new Alert(Alert.AlertType.CONFIRMATION, "Added !").show();
                            Notification.notification("Successfully Add", "Member Added");
                            isAddOnActionSelected = false;
                            RegisterFromController.getInstance().setCustomerData();
                            Navigation.close(actionEvent);

//                        =================================================================


                            try {
                                JasperReport jasperReport = JasperCompileManager.compileReport("C:\\My Aplication\\C4\\TheGym\\src\\lk\\ijse\\theGym\\view\\report\\busnescard.jrxml");
                                JRDataSource jrDataSource = new JRBeanCollectionDataSource(Arrays.asList(new Object()));

                                HashMap hm = new HashMap();
                                hm.put("id", Mid);
                                hm.put("name", Mname);
                                hm.put("email", Memail);

                                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, jrDataSource);
                                JasperViewer.viewReport(jasperPrint, false);
//
                            } catch (JRException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Notification.notificationWARNING("Error", "place check agens");
//                        new Alert(Alert.AlertType.WARNING, "not Added").show();
                        }
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }

                }

            }


            if (btn.getText().equals("ADD NEW COACH")) {
                Mid = getCoachNextId();
                Mname = lblFastName.getText() + " " + lblLastName.getText();
                Memail = lblEmail.getText();

                if (comboSalary.getValue() == null) {

                } else {
                    try {
                       /* CoachController.addCoach(
                                new CoachDTO(
                                        Mid,
                                        lblFastName.getText(),
                                        lblLastName.getText(),
                                        lblStreet.getText(),
                                        lblCity.getText(),
                                        lblLene.getText(),
                                        lblEmail.getText(),
                                        selectedDate(),
                                        lblNic.getText(),
                                        lblMobile.getText(),
                                        String.valueOf(comboGender.getValue()),
                                        DateTimeUtil.dateNow(),
                                        String.valueOf(comboSalary.getValue()),
                                        String.valueOf(comboPackage.getValue())
                                )
                        )*/
                        if (coachBO.save(new CoachDTO(
                                Mid,
                                lblFastName.getText(),
                                lblLastName.getText(),
                                lblStreet.getText(),
                                lblCity.getText(),
                                lblLene.getText(),
                                lblEmail.getText(),
                                selectedDate(),
                                lblNic.getText(),
                                lblMobile.getText(),
                                String.valueOf(comboGender.getValue()),
                                DateTimeUtil.dateNow(),
                                String.valueOf(comboSalary.getValue()),
                                String.valueOf(comboPackage.getValue())
                        ))) {
                            RegisterFromController.getInstance().rBtnCoach.fire();
                            Notification.notification("Successfully Add", "Member Added");

//                        new Alert(Alert.AlertType.CONFIRMATION, "Added").show();
                            RegisterFromController.getInstance().setCoachesData();
                            Navigation.close(actionEvent);

//                        ================================================

                            try {
                                JasperReport jasperReport = JasperCompileManager.compileReport("C:\\My Aplication\\C4\\TheGym\\src\\lk\\ijse\\theGym\\view\\report\\busnescard.jrxml");
                                JRDataSource jrDataSource = new JRBeanCollectionDataSource(Arrays.asList(new Object()));

                                HashMap hm = new HashMap();
                                hm.put("id", Mid);
                                hm.put("name", Mname);
                                hm.put("email", Memail);

                                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, jrDataSource);
                                JasperViewer.viewReport(jasperPrint, false);
//
                            } catch (JRException e) {
                                e.printStackTrace();
                            }

                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                isAddOnActionSelected = false;

            }
            if (btn.getText().equals("CLOSE")) {
                isViewOnActionSelected = false;
                Navigation.close(actionEvent);
            }
            if (btn.getText().equals("UPDATE")) {
                try {
//                    CustomerController.idExists(id)
                    if (customerBO.getCustomer(id)!=null) {
                       /* CoachController.updateCustomer(new CustomerDTO(
                                id,
                                lblFastName.getText(),
                                lblLastName.getText(),
                                lblStreet.getText(),
                                lblCity.getText(),
                                lblLene.getText(),
                                lblEmail.getText(),
                                selectedDate(),
                                lblNic.getText(),
                                lblMobile.getText(),
                                txtgender.getText(),
                                txtPackage.getText(),
                                null,
                                null

                        ))*/
                        if (customerBO.update(
                                new CustomerDTO(
                                        id,
                                        lblFastName.getText(),
                                        lblLastName.getText(),
                                        lblStreet.getText(),
                                        lblCity.getText(),
                                        lblLene.getText(),
                                        lblEmail.getText(),
                                        selectedDate(),
                                        lblNic.getText(),
                                        lblMobile.getText(),
                                        txtgender.getText(),
                                        txtPackage.getText(),
                                        null,
                                        null

                                )
                        )) {
                            Notification.notification("Successfully Updated", "Member Updated");

//                            new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                            Navigation.close(actionEvent);
                            RegisterFromController.getInstance().setCustomerData();
                        } else {
//                        Navigation.close(actionEvent);

                        }
                    }
                    //  CoachController.idExists(id)
                    if (coachBO.get(id) != null) {
                        /*CoachController.updateCoach(new CoachDTO(
                                id,
                                lblFastName.getText(),
                                lblLastName.getText(),
                                lblStreet.getText(),
                                lblCity.getText(),
                                lblLene.getText(),
                                lblEmail.getText(),
                                selectedDate(),
                                lblNic.getText(),
                                lblMobile.getText(),
                                txtgender.getText(),
                                null,
                                null,
                                String.valueOf(comboPackage.getValue())
                        ))*/
                        if (coachBO.update(
                                new CoachDTO(
                                        id,
                                        lblFastName.getText(),
                                        lblLastName.getText(),
                                        lblStreet.getText(),
                                        lblCity.getText(),
                                        lblLene.getText(),
                                        lblEmail.getText(),
                                        selectedDate(),
                                        lblNic.getText(),
                                        lblMobile.getText(),
                                        txtgender.getText(),
                                        null,
                                        null,
                                        String.valueOf(comboPackage.getValue())
                                )
                        )) {
                            Notification.notification("Successfully Updated", "Member Updated");

//                            new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                            Navigation.close(actionEvent);
                            RegisterFromController.getInstance().setCoachesData();
                        }
                    }
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }

                isUpdateOnActionSelected = false;

            }
            lblFastName.setEditable(true);
            lblLastName.setEditable(true);
            lblCity.setEditable(true);
            lblStreet.setEditable(true);
            lblLene.setEditable(true);
            lblEmail.setEditable(true);
            dPBirthDay.setEditable(true);
            lblNic.setEditable(true);
            lblMobile.setEditable(true);
//        comboPackage.setEditable(true);
//        comboGender.setEditable(true);
            rBMember.setVisible(true);
            rBCoach.setVisible(true);
            RegisterFromController.getInstance().setCoachCount();
            RegisterFromController.getInstance().setCustomerCount();

        }
    }

    private void setSalaryId() {
        comboSalary.getItems().clear();
        ArrayList<String> salaryIds = new ArrayList<>();
        try {
            ResultSet set = SalaryController.getAllSalaryIds();
            while (set.next()) {
                salaryIds.add(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        comboSalary.getItems().addAll(salaryIds);

    }

    private String getCoachNextId() {
        // String id = null;
        try {
            // ResultSet set = CoachController.getLastaId();
         /*   while (set.next()) {
                id = set.getString(1);
            }
            try {
                String[] T = id.split("T");
                int Next = Integer.parseInt(T[1]);
                Next++;
                return "T" + Next;
            } catch (NullPointerException e) {
                return "T1";
            }*/
            return coachBO.generateNewID();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "T1";
    }

    private Object getPackageId() {
        try {
            ResultSet set = PackController.getID(String.valueOf(comboPackage.getValue()));
            if (set.next()) {

                return set.getString(1);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }

    private String selectedDate() {
        if (dPBirthDay.getValue() == null) {
            return null;
        }
        LocalDate date = dPBirthDay.getValue();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private String customerNextId() {
        String id = null;
        try {

            /*ResultSet set = CustomerController.getLastId();
            while (set.next()) {
                id = set.getString(1);
            }
            try {
                String[] c = id.split("c");
                int n = Integer.parseInt(c[1]);
                n++;
                return "c" + n;
            } catch (NullPointerException e) {
                return "c1";
            }*/
            return customerBO.generateNewID();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "c1";

    }

    public void updateOnAction(ActionEvent actionEvent) {
        lblFastName.setEditable(true);
        lblLastName.setEditable(true);
        lblCity.setEditable(true);
        lblStreet.setEditable(true);
        lblLene.setEditable(true);
        lblEmail.setEditable(true);
        dPBirthDay.setVisible(true);
        lblNic.setEditable(true);
        lblMobile.setEditable(true);
        comboPackage.setVisible(false);
        comboGender.setVisible(false);
        rBMember.setVisible(false);
        rBCoach.setVisible(false);
        txtBirthday.setVisible(false);
        isViewOnActionSelected = false;
        btn.setText("UPDATE");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setSalaryId();
        salaryId.setVisible(true);
        rBMember.fire();
        btnUpdate.setVisible(false);
        if (isViewOnActionSelected) {
            setData();
            btn.setText("CLOSE");
            lblFastName.setEditable(false);
            lblLastName.setEditable(false);
            lblCity.setEditable(false);
            lblStreet.setEditable(false);
            lblLene.setEditable(false);
            lblEmail.setEditable(false);
            dPBirthDay.setVisible(false);
            lblNic.setEditable(false);
            lblMobile.setEditable(false);
            comboPackage.setVisible(false);
            comboGender.setVisible(false);
            rBMember.setVisible(false);
            rBCoach.setVisible(false);

        }
        if (rBMember.isSelected()) {
            comboSalary.setVisible(false);
            salaryId.setVisible(false);
            CoachTypeOrPackage.setText("PACKAGE");
            setPackageType();
            btn.setText("ADD NEW MEMBER");
        } else {
            salaryId.setVisible(true);
            comboSalary.setVisible(true);
            CoachTypeOrPackage.setText("COACH TYPE");
            setCoachType();
            btn.setText("ADD NEW COACH");
        }

        setGender();
    }

    private void setGender() {
        String[] gender = {"MALE", "FEMALE", "OTHER"};
        comboGender.getItems().addAll(gender);
    }

    private void setPackageType() {
        ArrayList<String> packageType = new ArrayList<>();
        try {
            ResultSet set = PackController.getAllPackageType();
            while (set.next()) {
                packageType.add(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        comboPackage.getItems().addAll(packageType);

    }

    public void rBMemberOnAction(ActionEvent actionEvent) {
        if (rBMember.isSelected()) {
            salaryId.setVisible(false);
            comboSalary.setVisible(false);
            setPackageType();
            CoachTypeOrPackage.setText("PACKAGE");
            btn.setText("ADD NEW MEMBER");
        } else {
            salaryId.setVisible(true);
            comboSalary.setVisible(true);
            CoachTypeOrPackage.setText("COACH TYPE");
            setCoachType();
            btn.setText("ADD NEW COACH");
        }
    }

    private void setCoachType() {
        comboPackage.getItems().clear();
        String[] coach = {"Company", "custom"};
        comboPackage.getItems().addAll(coach);
    }

    public void rBCoachOnAction(ActionEvent actionEvent) {
        if (rBMember.isSelected()) {
            salaryId.setVisible(false);
            comboSalary.setVisible(false);
            CoachTypeOrPackage.setText("PACKAGE");
            setPackageType();
            btn.setText("ADD NEW MEMBER");
        } else {
            salaryId.setVisible(true);
            comboSalary.setVisible(true);
            CoachTypeOrPackage.setText("COACH TYPE");
            setCoachType();
            btn.setText("ADD NEW COACH");
        }
    }

    public void comboOnAction(ActionEvent actionEvent) {
        if (String.valueOf(comboPackage.getValue()).equals("Company")) {
            salaryId.setVisible(true);

        } else {
            comboSalary.setVisible(true);
        }
    }

    //========================================================================================
    public void fistName(KeyEvent keyEvent) {
        RegexUtil.regex(btn, lblFastName, lblFastName.getText(), "\\b([a-z]|[A-Z])+", "-fx-text-fill: white");
    }

    public void lastName(KeyEvent keyEvent) {
        RegexUtil.regex(btn, lblLastName, lblLastName.getText(), "\\b([a-z]|[A-Z])+", "-fx-text-fill: white");
    }

    public void city(KeyEvent keyEvent) {
        RegexUtil.regex(btn, lblCity, lblCity.getText(), "\\b([a-z]|[A-Z])+", "-fx-text-fill: black");
    }

    public void street(KeyEvent keyEvent) {
        RegexUtil.regex(btn, lblStreet, lblStreet.getText(), "\\b([a-z]|[A-Z])+", "-fx-text-fill: black");
    }

    public void lene(KeyEvent keyEvent) {
        RegexUtil.regex(btn, lblLene, lblLene.getText(), "\\b([a-z]|[A-Z])+", "-fx-text-fill: black");
    }

    public void email(KeyEvent keyEvent) {
        RegexUtil.regex(btn, lblEmail, lblEmail.getText(), "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{3,4}$", "-fx-text-fill: white");
    }

    public void nic(KeyEvent keyEvent) {
        RegexUtil.regex(btn, lblNic, lblNic.getText(), "^(?:19|20)?\\d{2}[0-9]{10}|[0-9]{9}[x|X|v|V]$", "-fx-text-fill: white");
    }

    public void mobileNo(KeyEvent keyEvent) {
        RegexUtil.regex(btn, lblMobile, lblMobile.getText(), "0((11)|(7(7|0|8|4|9|1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}", "-fx-text-fill: white");
    }

    public void colse(MouseEvent mouseEvent) {
        Navigation.close(mouseEvent);
    }

    public void cmbSalary(ActionEvent actionEvent) {
        try {
            ResultSet set = SalaryController.getSalary(String.valueOf(comboSalary.getValue()));
            if (set.next()) {

                TXTSalaryPrice.setText(set.getString(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
