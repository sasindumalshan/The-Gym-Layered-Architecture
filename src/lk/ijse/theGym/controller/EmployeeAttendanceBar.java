package lk.ijse.theGym.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.theGym.util.Navigation;

import java.io.IOException;

public class EmployeeAttendanceBar {

    public Text txtEmployeeId;
    public Text txtName;
    public Text txtRole;
    public Text txtdate;
    public Text txtTime;

    public void viewDataOnMouseClick(MouseEvent mouseEvent) throws IOException {
        ViewEmployeeDetailsFromController.empID = txtEmployeeId.getText();
        Navigation.popupNavigation("ViewEmployeeDetailsFrom.fxml");
    }

    public void setData(String string, String string1, String string2, String string3, String string4, String string5) {
        txtEmployeeId.setText(string);
        txtName.setText(string1+" "+string2);
        txtRole.setText(string3);
        txtdate.setText(string4);
        txtTime.setText(string5);
    }
}
