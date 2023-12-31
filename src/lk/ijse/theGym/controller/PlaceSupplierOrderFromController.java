package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.ItemBo;
import lk.ijse.theGym.bo.custom.SupplierBO;
import lk.ijse.theGym.bo.custom.Supplier_order_detailsBO;
import lk.ijse.theGym.dto.ItemsDTO;
import lk.ijse.theGym.entity.Supplier;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlaceSupplierOrderFromController implements Initializable {

    public JFXTextField txtPrice;
    public JFXTextField txtQut;
    public JFXComboBox combSupplierId;
    public JFXComboBox combItemCode;
    public Text txtCompanyName;
    public Text txtItemName;
    private ArrayList<String> supplierId = new ArrayList<>();
    private ArrayList<String> itemsId = new ArrayList<>();

    public void supplierIdOnAction(ActionEvent actionEvent) {
        try {
           // ResultSet set = SupplierController.getSupplierDetails(String.valueOf(combSupplierId.getValue()));
            Supplier supplier = supplierBO.getSupplier(String.valueOf(combSupplierId.getValue()));
            txtCompanyName.setText(supplier.getSupplier_id());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    ItemBo itemBo= BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ITEM_BO);
    public void itemCodeOnAction(ActionEvent actionEvent) {
        try {
            //ResultSet set = ItemsController.ScrollPaneLoadData(String.valueOf(combItemCode.getValue()));
            ItemsDTO dto = itemBo.get(String.valueOf(combItemCode.getValue()));
            txtItemName.setText(dto.getItem_name());

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
//        try {
////            tranceAction();
//            Navigation.close(actionEvent);
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }
//        if (!SupplierFromController.getInstance().rBSuppliersOrder.isSelected()) {
//            SupplierFromController.getInstance().rBSuppliersOrder.fire();
//        } else {
//            SupplierFromController.getInstance().setAllOrder();
//        }
    }

//    private void tranceAction() throws SQLException, ClassNotFoundException {
//        try {
//            Connection connection = DBConnection.getInstance().getConnection();
//            connection.setAutoCommit(false);
//            SupplierOrderDetails details = new SupplierOrderDetails(
//                    getOrderId(),
//                    String.valueOf(combSupplierId.getValue()),
//                    String.valueOf(combItemCode.getValue()),
//                    Integer.parseInt(txtQut.getText()),
//                    DateTimeUtil.dateNow(),
//                    Double.parseDouble(txtPrice.getText())
//
//            );
//            boolean isAddedOrder = SupplierOrderDetailsController.setOrder(details);
//            if (isAddedOrder) {
//                boolean isUpdated = ItemsController.setOrderUpdateDetails(details);
//                if (isUpdated) {
//                   new Alert(Alert.AlertType.CONFIRMATION,"yes huththo yes  ! tranceAction ok").show();
//                    connection.commit();
//                }
//            }
//            connection.rollback();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBConnection.getInstance().getConnection().setAutoCommit(true);
//        }
//    }
    Supplier_order_detailsBO supplier_order_detailsBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Supplier_order_detailsBO);
    private String getOrderId() {
        try {
            /*ResultSet set = SupplierOrderDetailsController.getLastId();
            if (set.next()){
               String[] O00= set.getString(1).split("O00");
               int incrementId= Integer.parseInt(O00[1]);
               incrementId++;
               return "O00"+incrementId;
            }*/
            return supplier_order_detailsBO.getLastId();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "O001";
    }
    SupplierBO supplierBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.SupplierBO);

    private void setSupplierId() {
        try {
            //ResultSet set = SupplierController.getAllId();
            ArrayList<String> allId = supplierBO.getAllId();
            for (String s:allId) {
                supplierId.add(s);
            }
            combSupplierId.getItems().addAll(supplierId);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setItemsId() {
        try {
            //ResultSet set = ItemsController.loadAllIds();
            ArrayList<ItemsDTO> all = itemBo.getAll();
            for (ItemsDTO dto :
                    all) {
                itemsId.add(dto.getItem_id());
            }
            /*while (set.next()) {
                itemsId.add(set.getString(1));
            }*/
            combItemCode.getItems().addAll(itemsId);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setItemsId();
        setSupplierId();
    }


}
