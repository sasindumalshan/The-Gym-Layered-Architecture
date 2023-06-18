package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.Order_detailsBO;
import lk.ijse.theGym.bo.custom.Suppler_orderBO;
import lk.ijse.theGym.dto.OrderDTO;
import lk.ijse.theGym.util.DateTimeUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderDetailsFromController<Supplier_orderBO> implements Initializable {
    public AnchorPane anchorpane;
    public ScrollPane scrollPane;
    public VBox vBox;
    public JFXTextField search;
    public JFXComboBox comboSelectMonth;
    public JFXComboBox comboSelectYear;
    String[] allMonth = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
    ArrayList<String> searchIds = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorpane.setStyle("-fx-background-color: transparent");
        setComboMonth();
        setComboYear();
        String[] split = DateTimeUtil.dateNow().split("-");
        setData(split[0] + "-" + split[1] + "-");
        comboSelectYear.setValue(DateTimeUtil.yearNow());
        comboSelectMonth.setValue(DateTimeUtil.monthNow());
    }

    private void setData(String date) {
        vBox.getChildren().clear();
        try {
            //ResultSet set = OrderDetailsController.getAllData(date);
            ArrayList<OrderDTO> allData = order_detailsBO.getAllData(date);
            for (OrderDTO s:allData) {
                navigation(s.getCustomer_id(), s.getDate(), s.getTime(), s.getOrder_id(), String.valueOf(s.getFinal_total()));
            }
        } catch (SQLException | IOException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    ArrayList<String> year = new ArrayList<>();
    Order_detailsBO order_detailsBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Order_detailsBO);

    private void setComboYear() {
        try {
            year.clear();
            year.add(DateTimeUtil.yearNow());

           // ResultSet set = OrderDetailsController.getAllYears();
            ArrayList<String> allYears = order_detailsBO.getAllYears();
            for (String s:allYears) {
                for (int i = 0; i < year.size(); i++) {
                    String[] split = s.split("-");

                    if (!year.get(i).equals(split[0])) {
                        year.add(split[0]);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        comboSelectYear.getItems().addAll(year);
    }

    private void setComboMonth() {
        comboSelectMonth.getItems().addAll(allMonth);
    }

    private void navigation(String customerId, String date, String time, String orderId, String total) throws IOException {
        FXMLLoader loader = new FXMLLoader(StoreFromController.class.getResource("/lk/ijse/theGym/view/bar/OrderDetailsBarFrom.fxml"));
        Parent root = loader.load();
        OrderDetailsBarFromController controller = loader.getController();
        controller.setData(customerId, date, time, orderId, total);
        vBox.getChildren().add(root);
    }
    Suppler_orderBO suppler_orderBO= BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Suppler_orderBO);
    public void searchOnKeyReleased(KeyEvent keyEvent) {
        vBox.getChildren().clear();
        if (search.getText().equals("")){
            System.out.println("empty");
            selectComboBox();

        }else {
            searchIds.clear();
            vBox.getChildren().clear();
            try {
              //  ResultSet set = OrderDetailsController.searchIDOrCustomerId(search.getText());
                ArrayList<String> list = suppler_orderBO.searchIDOrCustomerId(search.getText());
                for (String s:list) {
                    for (int i = 0; i < searchIds.size(); i++) {
                        if (!searchIds.get(i).equals(s)) {
                            searchIds.add(s);
                        }
                    }
                    if (searchIds.isEmpty()) {
                        searchIds.add(s);
                    }

                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            getAllDataForOrderId();

        }


    }

    private void getAllDataForOrderId() {
        vBox.getChildren().clear();
        try {
            for (int i = 0; i < searchIds.size(); i++) {
              //  ResultSet set=OrderDetailsController.getDataForOrderId(searchIds.get(i));
                ArrayList<OrderDTO> dataForOrderId = order_detailsBO.getDataForOrderId(searchIds.get(i));
                for (OrderDTO s:dataForOrderId){
                    navigation(s.getCustomer_id(), s.getDate(), s.getTime(), s.getOrder_id(), String.valueOf(s.getFinal_total()));
                }
            }
        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void comboSelectMonthOnAction(ActionEvent actionEvent) {
        selectComboBox();
    }

    private void selectComboBox() {
        String monthIndex = null;
        for (int i = 0; i < allMonth.length; i++) {
            if (allMonth[i].equals(String.valueOf(comboSelectMonth.getValue()))) {
                i++;
                monthIndex = String.valueOf(i);
                monthIndex = monthIndex.length() == 1 ? "0" + monthIndex : monthIndex;
            }
        }
        System.out.println(monthIndex);
        setData(comboSelectYear.getValue() + "-" + monthIndex + "-");
    }

    public void comboSelectYearOnAction(ActionEvent actionEvent) {
        selectComboBox();
    }
}
