package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.EmployeeBO;
import lk.ijse.theGym.dto.EmployeeDTO;
import lk.ijse.theGym.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeDetailBar {
    public Text txtEmployeeId;
    public Text txtName;
    public Text txtRole;
    public Text txtCity;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;

    EmployeeBO employeeBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.EMPLOYEE_BO);

    public void viewDataOnMouseClick(MouseEvent mouseEvent) throws IOException {
        ViewEmployeeDetailsFromController.empID = txtEmployeeId.getText();
        Navigation.popupNavigation("ViewEmployeeDetailsFrom.fxml");

    }

    public void UpdateOnAction(ActionEvent actionEvent) throws IOException {
//        EmployeeController.empID = txtEmployeeId.getText();
        UpdateEmployeeFromController.empID = txtEmployeeId.getText();

        Navigation.popupNavigation("UpdateEmployeeFrom.fxml");

    }

    public void deleteOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are your sure", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult().equals(ButtonType.YES)) {
            try {
               // boolean isDelete = EmployeeController.RemoveEmployee(txtEmployeeId.getText());
                boolean delete = employeeBO.delete(txtEmployeeId.getText());
                if (delete) {
                    EmployeeFromController.getInstance().vBox.getChildren().clear();
                    EmployeeFromController.getInstance().loadAllId();
                } else {
                    System.out.println("Not deleted !");
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    public void setData(String id) {
        System.out.println("setData");
        try {
//            ResultSet set = EmployeeController.ScrollPaneLoadData(ids);
            EmployeeDTO employeeDTO = employeeBO.get(id);
            txtEmployeeId.setText(employeeDTO.getEmployee_id());
            txtName.setText(employeeDTO.getFist_name() + " " +employeeDTO.getLast_name());
            txtCity.setText(employeeDTO.getAddress_city());
            txtRole.setText(employeeDTO.getRoll());


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setData(EmployeeDTO employee) {
        txtEmployeeId.setText(employee.getEmployee_id());
        txtName.setText(employee.getFist_name() + " " + employee.getLast_name());
        txtRole.setText(employee.getRoll());
        txtCity.setText(employee.getAddress_city());
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        btnDelete.setVisible(true);
        btnUpdate.setVisible(true);
    }

    public void mouseExited(MouseEvent mouseEvent) {
        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);
    }
}
