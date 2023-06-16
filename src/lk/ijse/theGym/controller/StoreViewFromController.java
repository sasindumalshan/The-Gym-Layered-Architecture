package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.ItemBo;
import lk.ijse.theGym.dto.ItemsDTO;
import lk.ijse.theGym.model.ItemsController;
import lk.ijse.theGym.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StoreViewFromController implements Initializable {


    public Text txtAllItems;
    public Text txtLimitedItems;
    public JFXTextField search;
    public ScrollPane scrollPane;
    public VBox vBox;
    public JFXComboBox comboCategory;

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.swatchNavigation("CashiarDashBordFrom.fxml", actionEvent);
    }

    public void searchOnKeyReleased(KeyEvent keyEvent) {

        if (search.getText().equals("")) {
            vBox.getChildren().clear();
            loadAllItems();
        } else {
            vBox.getChildren().clear();
            try {
                //ResultSet set1 = ItemsController.getSearchID(search.getText() + "%");
                ArrayList<String> id = itemBo.search(search.getText() + "%");
                for (int i = 0; i < id.size(); i++) {
                    //ResultSet set = ItemsController.getItemsForId(id.get(i));
                   ItemsDTO dto= itemBo.get(id.get(i));
                   navigation(dto.getItem_id(), dto.getItem_name(), dto.getBrand(), dto.getQut()+"", dto.getPrice()+"");
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLimitedItem();
        loadAllItems();
        loadAllCategory();
        comboCategory.setValue("All Items");
        setAllItemsCount();
    }

    private void setLimitedItem() {
        try {
            ResultSet set=ItemsController.limitedStock();
            if (set.next()){
                txtLimitedItems.setText(set.getString(1)); }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setAllItemsCount() {
        try {
            ResultSet set = ItemsController.CountOfAllItems();
            if (set.next()){
                txtAllItems.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void loadAllCategory() {
        ArrayList<String> category = new ArrayList<>();
        category.add("All Items");
        try {
            ResultSet set = ItemsController.getAllCategory();
            while (set.next()) {
                category.add(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        comboCategory.getItems().addAll(category);
    }
        ItemBo itemBo= BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ITEM_BO);
    private void loadAllItems() {
        vBox.getChildren().clear();
        try {
            /*ResultSet set = ItemsController.getAllItems();
            while (set.next()) {
                navigation(set.getString(1), set.getString(2), set.getString(6), set.getString(4), set.getString(5));
            }*/
            ArrayList<ItemsDTO> all = itemBo.getAll();
            for (ItemsDTO dto:all) {
                navigation(dto.getItem_id(), dto.getItem_name(),dto.getBrand(), String.valueOf(dto.getQut()),String.valueOf(dto.getPrice()));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void CategoryOnAction(ActionEvent actionEvent) {
        vBox.getChildren().clear();
        if (String.valueOf(comboCategory.getValue()).equals("All Items")) {
            loadAllItems();
        } else {
            try {
                ResultSet set = ItemsController.getSelectedCategoryData(String.valueOf(comboCategory.getValue()));
                while (set.next()) {
                    navigation(set.getString(1), set.getString(2), set.getString(6), set.getString(4), set.getString(5));
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void navigation(String itemCode, String itemName, String brand, String qty, String price) {

        try {
            FXMLLoader loader = new FXMLLoader(StoreFromController.class.getResource("/lk/ijse/theGym/view/bar/StroeViewBarFrom.fxml"));
            Parent root = loader.load();
            StoreViewBarFromController controller = loader.getController();
            controller.setData(itemCode, itemName, brand, qty, price);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
