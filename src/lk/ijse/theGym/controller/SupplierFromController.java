package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.Suppler_orderBO;
import lk.ijse.theGym.bo.custom.SupplierBO;
import lk.ijse.theGym.bo.custom.Supplier_order_detailsBO;
import lk.ijse.theGym.dto.projection.SupplierItemProjection;
import lk.ijse.theGym.entity.Supplier;
import lk.ijse.theGym.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SupplierFromController implements Initializable {
    private static SupplierFromController instance;
    public Text txtAllSuppliers;
    public Text txtMonthlyOrders;
    public JFXTextField search;
    public JFXRadioButton rBAllSuppliers;
    public JFXRadioButton rBSuppliersOrder;
    public VBox vBox;
    public Text txtId;
    public Text txtName;
    public Text txtLocation;
    public Text txtMoNo;
    public Text txtOption;
    ArrayList<String> suoId = new ArrayList<>();
    ArrayList<String> orderId = new ArrayList<>();


    public SupplierFromController() {
        instance = this;
    }

    public static SupplierFromController getInstance() {
        return instance;
    }
    Supplier_order_detailsBO supplier_order_detailsBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Supplier_order_detailsBO);

    private void setMonthlyOrders() {
        try {
           // ResultSet set = SupplierOrderDetailsController.getMonthlyOrders();
            //if (set.next()) {
                txtMonthlyOrders.setText(supplier_order_detailsBO.getMonthlyOrders());
           // }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    SupplierBO supplierBO= BoFactory.getBoFactory().getBO(BoFactory.BOTypes.SupplierBO);
    public void setAllSuppliersCount() {
        try {
            txtAllSuppliers.setText(supplierBO.getCount());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.swatchNavigation("AdminDashBordFrom.fxml", actionEvent);
    }

    public void searchOnAction(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {

//        try {
//            if (rBAllSuppliers.isSelected()) {
//                if (!search.getText().equals("")) {
//                    vBox.getChildren().clear();
//                    ResultSet set1 = SupplierController.searchSupplierId(search.getText());
//                    if (set1.next()) {
//                        transferSupplierData(set1.getString(2));
//                    }
//                    ResultSet set2 = SupplierController.searchSupplierName(search.getText());
//                    if (set2.next()) {
//                        transferSupplierData(set2.getString(2));
//                    }
//                }
//            } if(search.getText().equals("")){
//                setAllIdForLoadAllSupplier();
//            }
//            if (rBSuppliersOrder.isSelected()) {
////                ResultSet set1 = SupplierController.searchSupplierOrderId(search.getText());
////                ResultSet set2 = SupplierController.searchSupplierOrderName(search.getText());
//            }
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }

//        try {
        suoId.clear();
        orderId.clear();
        vBox.getChildren().clear();
        if (search.getText().equals("")) {
            suoId.clear();
            orderId.clear();
            if (rBAllSuppliers.isSelected()) {
                //setAllIdForLoadAllSupplier();
                System.out.println("sup");
            }
            if (rBSuppliersOrder.isSelected()) {
//                setAllOrder();
            }
        }
        if (rBAllSuppliers.isSelected()) {


          //  ResultSet set1 = SupplierController.getSearchName(search.getText());
            ArrayList<String> searchName = supplierBO.getSearchName(search.getText());
            for (String s:searchName) {
                boolean isNotDuplicate1 = true;
                if (suoId.isEmpty()) {
                    suoId.add(s);
                }
                for (int i = 0; i < suoId.size(); i++) {
                    if (suoId.get(i).equals(s)) {
                        isNotDuplicate1 = false;
                    }
                }
                if (isNotDuplicate1) {
                    suoId.add(s);
                }
            }
           // ResultSet set2 = SupplierController.getSearchId(search.getText());
            ArrayList<String> searchId = supplierBO.getSearchId(search.getText());
            for (String s:searchId) {
                boolean isNotDuplicate2 = true;
                if (suoId.isEmpty()) {
                    suoId.add(s);
                }
                for (int i = 0; i < suoId.size(); i++) {
                    if (suoId.get(i).equals(s)) {
                        isNotDuplicate2 = false;
                    }
                }
                if (isNotDuplicate2) {
                    suoId.add(s);
                }
            }
            for (int i = 0; i < suoId.size(); i++) {
                //ResultSet set = SupplierController.getSupplierDetails(suoId.get(i));
                //ResultSet set = SupplierController.getSupplierDetails(suoId.get(i));
                Supplier supplier = supplierBO.getSupplier(suoId.get(i));
                navigation(supplier.getSupplier_id(),supplier.getCompany_name(), supplier.getLocation(),supplier.getMobile_no());
            }
        }
        if (rBSuppliersOrder.isSelected()) {
           // ResultSet set1 = SupplierOrderDetailsController.getSearchName(search.getText());
            ArrayList<String> searchName = supplier_order_detailsBO.getSearchName(search.getText());
            for (String s:searchName) {
                boolean isNotDuplicate1 = true;
                if (orderId.isEmpty()) {
                    orderId.add(s);
                }
                for (int i = 0; i < orderId.size(); i++) {
                    if (orderId.get(i).equals(s)) {
                        isNotDuplicate1 = false;
                    }
                }
                if (isNotDuplicate1) {
                    orderId.add(s);
                }
            }
           // ResultSet set2 = SupplierOrderDetailsController.getSearchId(search.getText());
            ArrayList<String> searchId = supplier_order_detailsBO.getSearchId(search.getText());
            for (String s:searchId) {
                boolean isNotDuplicate2 = true;
                if (orderId.isEmpty()) {
                    orderId.add(s);
                }
                for (int i = 0; i < orderId.size(); i++) {
                    if (orderId.get(i).equals(s)) {
                        isNotDuplicate2 = false;
                    }
                }
                if (isNotDuplicate2) {
                    orderId.add(s);
                }
            }
            for (int i = 0; i < orderId.size(); i++) {
               /* ResultSet resultSet = SupplierOrderDetailsController.getSupDetaolsIdItemId(orderId.get(i));
                if (resultSet.next()) {*/
                SupplierItemProjection sp = supplier_order_detailsBO.getSupDealsIdItem(orderId.get(i));
                navigationOrderDetails(sp.getOrder_id(), sp.getSupplier_id(),sp.getCompany_name(),sp.getCOUNTItem_code(), sp.getTotal());

                //}
            }
        }
//        }

    }

    public void addSupplierOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("AddSupplierFrom.fxml");
    }

    public void newOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupNavigation("PlaceSupplierOrderFrom.fxml");
    }

    public void allSuppliersOnAction(ActionEvent actionEvent) {
        if (rBAllSuppliers.isSelected()) {
            rBSuppliersOrder.setSelected(false);
            setAllIdForLoadAllSupplier();
            txtId.setText("Supplier ID");
            txtName.setText("Company Name");
            txtLocation.setText("Location");
            txtMoNo.setText("Mobile No.");
            txtOption.setText("Option");
        } else {
            rBSuppliersOrder.fire();
        }
    }

    public void SuppliersOrderOnAction(ActionEvent actionEvent) {
        if (rBSuppliersOrder.isSelected()) {
            rBAllSuppliers.setSelected(false);
            setAllOrder();
            txtId.setText("Order ID");
            txtName.setText("Company Name");
            txtLocation.setText("Item Name");
            txtMoNo.setText("Unit Price");
            txtOption.setText("QUT");
        } else {
            rBAllSuppliers.fire();
        }
    }

    Suppler_orderBO suppler_orderBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Suppler_orderBO);
    public void setAllOrder() {
        vBox.getChildren().clear();
        try {
           // ResultSet set = SupplierOrderController.getAllIds();
            ArrayList<String> allIds = suppler_orderBO.getAllIds();
            for (String s:allIds) {
                transferOrderData(s);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void transferOrderData(String id) {
        try {
            ResultSet set = supplier_order_detailsBO.getSupIdItemId(id);
            if (set.next()) {
           // String supIdItemId = supplier_order_detailsBO.getSupIdItemId(id);
            navigationOrderDetails(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void setAllIdForLoadAllSupplier() {
        System.out.println("setAllIdForLoadAllSupplier");
        vBox.getChildren().clear();
        try {
//            ResultSet set = SupplierController.getAllId();
            ArrayList<String> allId = supplierBO.getAllId();
            for (String s:allId) {
                transferSupplierData(s);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void transferSupplierData(String id) {
        try {
          //  ResultSet set = SupplierController.getSupplierDetails(id);
            Supplier supplier = supplierBO.getSupplier(id);
            navigation(supplier.getSupplier_id(), supplier.getCompany_name(), supplier.getLocation(), supplier.getMobile_no());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void navigation(String company_name, String supplier_id, String location, String mobile_no) {
        try {
            FXMLLoader loader = new FXMLLoader(StoreFromController.class.getResource("/lk/ijse/theGym/view/bar/SupplierDetailBar.fxml"));
            Parent root = loader.load();
            SupplierDetailBarController controller = loader.getController();
            controller.setData(company_name, supplier_id, location, mobile_no);
            vBox.getChildren().add(root);
        } catch (IOException e) {
        }
    }

    private void navigationOrderDetails(String orderId, String companyName, String itemName, String price, String qut) {
        try {
            FXMLLoader loader = new FXMLLoader(StoreFromController.class.getResource("/lk/ijse/theGym/view/bar/SupplierOrderDetailBar.fxml"));
            Parent root = loader.load();
            SupplierOrderDetailBarController controller = loader.getController();
            controller.setData(orderId, companyName, itemName, price, qut);
            vBox.getChildren().add(root);
        } catch (IOException e) {
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setMonthlyOrders();
        setAllSuppliersCount();
        rBAllSuppliers.fire();
    }
}

