package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.ItemBo;
import lk.ijse.theGym.dto.ItemsDTO;
import lk.ijse.theGym.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StoreFromController implements Initializable {
    private static StoreFromController instance;
    public Text txtAllItem;
    public Text txtLimiedItem;
    public VBox vBox;
    public JFXTextField txtSearch;
    ItemBo itemBo = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ITEM_BO);

    public StoreFromController() {
        instance = this;
    }

    public static StoreFromController getInstance() {
        return instance;
    }

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.swatchNavigation("AdminDashBordFrom.fxml", actionEvent);
    }

    public void searchItemOnKeyReleased(KeyEvent keyEvent) {

        vBox.getChildren().clear();
        try {
            //ResultSet setId=ItemsController.searchId(txtSearch.getText());
            ArrayList<String> search = itemBo.search(txtSearch.getText() + "%");
            for (String s : search) {
                setData(s);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        if (txtSearch.getText().equals("")) {
            loadAllId();
        }

    }

    public void newItemAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("AddItemFrom.fxml");
    }

    public void setData(String id) {
        try {
            FXMLLoader loader = new FXMLLoader(StoreFromController.class.getResource("/lk/ijse/theGym/view/bar/ItemBar.fxml"));
            Parent root = loader.load();
            ItemBarController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException e) {
        }

    }

    public void loadAllId() {
        vBox.getChildren().clear();
        try {
           // ResultSet ids = ItemsController.loadAllIds();
            ArrayList<ItemsDTO> all = itemBo.getAll();
            for (ItemsDTO dto :
                    all) {
                setData(dto.getItem_id());
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setCountOfAllItems() {

        try {
           /* ResultSet set = ItemsController.CountOfAllItems();
            if (set.next()) {*/
                txtAllItem.setText(itemBo.CountOfAllItems());
            //}
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void showLimitedStock() {
        try {
          /*  ResultSet set = ItemsController.limitedStock();
            if (set.next()) {*/
                txtLimiedItem.setText(itemBo.limitedStock());
          //  }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showLimitedStock();
        setCountOfAllItems();
        loadAllId();
    }
}
