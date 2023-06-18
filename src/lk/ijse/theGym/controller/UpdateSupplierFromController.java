package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.SupplierBO;
import lk.ijse.theGym.entity.Supplier;
import lk.ijse.theGym.dto.SupplierDTO;
import lk.ijse.theGym.util.Navigation;
import lk.ijse.theGym.util.Notification;
import lk.ijse.theGym.util.RegexUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdateSupplierFromController implements Initializable {
    private static String id;
    public JFXTextField txtMobilNo;
    public JFXTextField txtCompanyName;
    public JFXTextField txtLocation;
    public JFXTextField txtEmail;
    public JFXButton btnUpdate;

    public static void setId(String id) {
        UpdateSupplierFromController.id = id;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCurrentlyData();
    }

    private void setCurrentlyData() {
        try {
          //  ResultSet set = SupplierController.getSupplierDetails(id);
            Supplier supplier = supplierBO.getSupplier(id);

                txtCompanyName.setText(supplier.getCompany_name());
                txtEmail.setText(supplier.getEmail());
                txtLocation.setText(supplier.getLocation());
                txtMobilNo.setText(supplier.getMobile_no());

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    SupplierBO supplierBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.SupplierBO);

    public void updateOnAction(ActionEvent actionEvent) {
        if (txtEmail.getText().equals("") | txtLocation.getText().equals("")| txtCompanyName.getText().equals("")| txtMobilNo.getText().equals("")){
            Notification.notificationWARNING("Please Entre data","Empty Data ");
        }else {
            try {
//                boolean isUpdated = SupplierController.updateSupplier(new SupplierDTO(
                boolean isUpdated = supplierBO.update(new SupplierDTO(
                        txtCompanyName.getText(),
                        id,
                        txtEmail.getText(),
                        txtMobilNo.getText(),
                        txtLocation.getText()
                ));
                if(isUpdated){
                    SupplierFromController.getInstance().setAllIdForLoadAllSupplier();
                    Navigation.close(actionEvent);
                    Notification.notification("Updated","your Data Is Updated");
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }

    }
//==========================================================
    public void mobile(KeyEvent keyEvent) {
        RegexUtil.regex(btnUpdate, txtMobilNo, txtMobilNo.getText(), "0((11)|(7(7|0|8|4|9|1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}", "-fx-text-fill: white");

    }

    public void company(KeyEvent keyEvent) {
        RegexUtil.regex(btnUpdate, txtCompanyName, txtCompanyName.getText(), "\\b([a-z]|[A-Z])+", "-fx-text-fill: white");

    }

    public void location(KeyEvent keyEvent) {
        RegexUtil.regex(btnUpdate, txtLocation, txtLocation.getText(), "\\b([a-z]|[A-Z])+", "-fx-text-fill: white");

    }

    public void email(KeyEvent keyEvent) {
        RegexUtil.regex(btnUpdate, txtEmail, txtEmail.getText(), "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{3,4}$", "-fx-text-fill: white");

    }

    public void close(MouseEvent mouseEvent) {
        Navigation.close(mouseEvent);
    }
}
