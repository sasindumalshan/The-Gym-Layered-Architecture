package lk.ijse.theGym.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.ItemBo;
import lk.ijse.theGym.dto.ItemsDTO;
import lk.ijse.theGym.util.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewItemFromController implements Initializable {

    public static String itemCode;
    public Text txtItemCode;
    public Text txtCategory;
    public Text txtName;
    public Text txtPrice;
    public Text txtBrand;
    public Text txtDescription;
    ItemBo itemBo = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ITEM_BO);

    public void setData() {
        try {
//            ResultSet set = ItemsController.viewAllItemDetails();
            ItemsDTO dto = itemBo.get(itemCode);
            txtItemCode.setText(dto.getItem_id());
            txtPrice.setText(String.valueOf(dto.getPrice()));
            txtBrand.setText(dto.getBrand());
            txtName.setText(dto.getItem_name());
            txtCategory.setText(dto.getCategory());
            txtDescription.setText(dto.getDescription());

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeOnAction(ActionEvent actionEvent) {
        Navigation.close(actionEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData();
    }
}
