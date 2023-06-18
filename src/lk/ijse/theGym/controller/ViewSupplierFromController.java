package lk.ijse.theGym.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.SupplierBO;
import lk.ijse.theGym.entity.Supplier;
import lk.ijse.theGym.util.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewSupplierFromController implements Initializable {
    private static String id;
    public Text txtSupplierId;
    public Text txtCompanyName;
    public Text txtLocation;
    public Text txtMobilNo;
    public Text txtMail;
    SupplierBO supplierBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.SupplierBO);

    public static void setId(String id) {
        ViewSupplierFromController.id = id;
    }

    public void closeOnAction(ActionEvent actionEvent) {
        Navigation.close(actionEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData();
    }

    private void setData() {
        try {
            // ResultSet set=SupplierController.getSupplierDetails(id);
            Supplier supplier = supplierBO.getSupplier(id);
            txtSupplierId.setText(supplier.getSupplier_id());
            txtCompanyName.setText(supplier.getCompany_name());
            txtLocation.setText(supplier.getLocation());
            txtMail.setText(supplier.getMobile_no());
            txtMobilNo.setText(supplier.getMobile_no());

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
