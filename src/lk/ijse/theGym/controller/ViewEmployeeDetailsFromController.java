package lk.ijse.theGym.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.EmployeeBO;
import lk.ijse.theGym.dto.EmployeeDTO;
import lk.ijse.theGym.model.EmployeeController;
import lk.ijse.theGym.util.Navigation;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewEmployeeDetailsFromController implements Initializable {
    public static String empID;
    public Text txtFName;
    public Text txtLName;
    public Text txtEmail;
    public Text txtCity;
    public Text txtStreet;
    public Text txtLane;
    public Text txtNIC;
    public Text txtMONo;
    public Text txtBirthday;
    public Text txtRole;
    public Text txtId;

    EmployeeBO employeeBO= BoFactory.getBoFactory().getBO(BoFactory.BOTypes.EMPLOYEE_BO);

    public void closeOnAction(ActionEvent actionEvent) {
        Navigation.close(actionEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData();
    }

    private void setData() {
        try {
           /* ResultSet set = EmployeeController.getAllData();
            if (set.next()) {
                txtId.setText(set.getString(1));
                txtFName.setText(set.getString(2));
                txtLName.setText(set.getString(3));
                txtRole.setText(set.getString(6));
                txtStreet.setText(set.getString(7));
                txtCity.setText(set.getString(8));
                txtLane.setText(set.getString(9));
                txtEmail.setText(set.getString(10));
                txtBirthday.setText(set.getString(11));
                txtNIC.setText(set.getString(12));
                txtMONo.setText(set.getString(13));
            }*/
            EmployeeDTO employeeDTO = employeeBO.get(empID);
            txtFName.setText(employeeDTO.getFist_name());
            txtLName.setText(employeeDTO.getLast_name());
            txtRole.setText(employeeDTO.getRoll());
            txtStreet.setText(employeeDTO.getAddress_street());
            txtCity.setText(employeeDTO.getAddress_city());
            txtLane.setText(employeeDTO.getAddress_lene());
            txtEmail.setText(employeeDTO.getE_mail());
            txtBirthday.setId(employeeDTO.getBirthday());
            txtNIC.setText(employeeDTO.getNic());
            txtMONo.setText(employeeDTO.getContact_number());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
