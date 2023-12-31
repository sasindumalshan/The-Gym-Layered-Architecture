package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.OrdersBO;
import lk.ijse.theGym.bo.custom.Supplier_order_detailsBO;
import lk.ijse.theGym.model.*;
import lk.ijse.theGym.util.DateTimeUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import static lk.ijse.theGym.bo.BoFactory.BOTypes.OrdersBO;

public class ReportChartsFrom implements Initializable {
    public Text txtReport;
    public LineChart chart;
    public JFXComboBox rBtnSelectMonth;
    public JFXComboBox rBtnSelectYear;
    public JFXRadioButton fiveYearReport;
    public AnchorPane anchorpane;
    public CategoryAxis yAxy;
    public NumberAxis xAxy;
    ArrayList<String> supplierOder = new ArrayList<>();
    ArrayList<String> sumOfEmployeeSalary = new ArrayList<>();
    ArrayList<String> sumOfCoachSalary = new ArrayList<>();
    ArrayList<String> customerOder = new ArrayList<>();
    ArrayList<String> customerPayment = new ArrayList<>();
    ArrayList<String> Profit = new ArrayList<>();
    ArrayList<String> lost = new ArrayList<>();
    ArrayList<String> days = new ArrayList<>();
    ArrayList<String> year = new ArrayList<>();
    ArrayList<String> m = new ArrayList<>();

    String[] allMonth = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};

    private String setMonthForQulQuery(String month) {
        int increment = 1;
        for (String m : allMonth) {
            if (month.equals(m)) {
                return String.valueOf(increment).length() == 1 ? "0" + increment : String.valueOf(increment);

            }
            increment++;
        }
        return null;
    }

    private void onlyYearReport() {
        txtReport.setText(String.valueOf(rBtnSelectYear.getValue()) + " REPORT ");
        clear();
        try {
            for (String month : allMonth) {
               // ResultSet set = SupplierOrderDetailsController.getMonthlyReport(String.valueOf(rBtnSelectYear.getValue() + "-" + setMonthForQulQuery(month) + "-" + "%"));
                String monthlyReport = supplier_order_detailsBO.getMonthlyReport(String.valueOf(rBtnSelectYear.getValue() + "-" + setMonthForQulQuery(month) + "-" + "%"));
                if (monthlyReport!=null) {
                    if (monthlyReport == null) {
//                        System.out.println("null");
                        supplierOder.add("0");
                    } else {

                        supplierOder.add(monthlyReport);
                        System.out.println(monthlyReport);
                    }
                } else {
                    System.out.println("else");
                    supplierOder.add("0");
                }
            }
            for (String month : allMonth) {
                ResultSet set = EmployeeSalaryDetailsController.getMonthlyReport(String.valueOf(rBtnSelectYear.getValue() + "-" + setMonthForQulQuery(month) + "-" + "%"));
                if (set.next()) {
                    if (set.getString(1) == null) {
                        sumOfEmployeeSalary.add("0");
                    } else {
                        sumOfEmployeeSalary.add(set.getString(1));
                    }
                } else {
                    sumOfEmployeeSalary.add("0");
                }
            }
            for (String month : allMonth) {
                ResultSet set = CoachSalaryDetailsController.getMonthlyReport(String.valueOf(rBtnSelectYear.getValue() + "-" + setMonthForQulQuery(month) + "-" + "%"));
                if (set.next()) {
                    if (set.getString(1) == null) {
                        sumOfCoachSalary.add("0");
                    } else {
                        sumOfCoachSalary.add(set.getString(1));
                    }
                } else {
                    sumOfCoachSalary.add("0");
                }
            }
            for (String month : allMonth) {
                String lastOrderId = ordersBO.getLastOrderId();
               // ResultSet set = OrderController.getMonthlyReport(String.valueOf(rBtnSelectYear.getValue() + "-" + setMonthForQulQuery(month) + "-" + "%"));
                if (lastOrderId!=null) {
                    if (lastOrderId == null) {
                        customerOder.add("0");
                    } else {
                        customerOder.add(lastOrderId);
                    }
                } else {
                    customerOder.add("0");
                }
            }
            for (String month : allMonth) {
                ResultSet set = CustomerPaymentController.getMonthlyReport(String.valueOf(rBtnSelectYear.getValue() + "-" + setMonthForQulQuery(month) + "-" + "%"));
                if (set.next()) {
                    if (set.getString(1) == null) {
                        customerPayment.add("0");
                    } else {
                        customerPayment.add(set.getString(1));
                    }
                } else {
                    customerPayment.add("0");
                }
            }
            for (int i = 0; i < customerOder.size(); i++) {
                int total = 0;
                total += Double.parseDouble(customerPayment.get(i)) + Double.parseDouble(customerPayment.get(i));
                Profit.add(String.valueOf(total));
            }
            for (int i = 0; i < supplierOder.size(); i++) {
                int total = 0;
                total += Integer.parseInt(supplierOder.get(i)) + Integer.parseInt(sumOfEmployeeSalary.get(i)) + Integer.parseInt(sumOfCoachSalary.get(i));
                lost.add(String.valueOf(total));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        if (m.isEmpty()) {
            m.addAll(Arrays.asList(allMonth));
        }
        setList(setChartLost(m, lost), setChartSupplierOrder(m, supplierOder), setChartCustomersOrder(m, customerOder), setChartProfit(m, Profit));


    }
    OrdersBO ordersBO= BoFactory.getBoFactory().getBO(OrdersBO);
    private void clear() {
        if (!supplierOder.isEmpty()) {
            supplierOder.clear();
        }
        if (!days.isEmpty()) {
            days.clear();
        }
        if (!sumOfCoachSalary.isEmpty()) {
            sumOfCoachSalary.clear();
        }
        if (!sumOfEmployeeSalary.isEmpty()) {
            sumOfEmployeeSalary.clear();
        }
        if (!customerOder.isEmpty()) {
            customerOder.clear();
        }
        if (!customerPayment.isEmpty()) {
            customerPayment.clear();
        }
        if (!lost.isEmpty()) {
            lost.clear();
        }
        if (!Profit.isEmpty()) {
            Profit.clear();
        }
    }

    public void selectMonthOnAction(ActionEvent actionEvent) {
        if (String.valueOf(rBtnSelectMonth.getValue()).equals("") | String.valueOf(rBtnSelectMonth.getValue()) == null) {
            onlyYearReport();
        } else {
            selectMonth();
        }
    }

    private void selectFiveYear() {
        txtReport.setText("Five Years REPORT");
        clear();

        try {

            for (String year : year) {
                int orderTotal = 0;
               // ResultSet set = OrderController.getFinalTotalOnYear(year);

                ArrayList<String> finalTotalOnYear = ordersBO.getFinalTotalOnYear(year);

                for (String s:finalTotalOnYear) {

                    if (s == null) {
                        orderTotal += 0;
                    } else {
                        orderTotal += Integer.parseInt(s);
                    }
                }
                customerOder.add(String.valueOf(orderTotal));
            }

            for (String year : year) {
                int supplierOrder = 0;
               // ResultSet set = SupplierOrderDetailsController.getFinalTotalOnYear(year);
                ArrayList<String> finalTotalOnYear = supplier_order_detailsBO.getFinalTotalOnYear(year);
                for (String s:finalTotalOnYear) {

                    if (s== null) {
                        supplierOrder += 0;
                    } else {
                        supplierOrder += Integer.parseInt(s);
                    }
                }
                supplierOder.add(String.valueOf(supplierOrder));
            }

            for (String year : year) {
                int customerPaymentTotal = 0;
                ResultSet set = CustomerPaymentController.getFinalTotalOnYear(year);
                while (set.next()) {
                    if (set.getString(1) == null) {
                        customerPaymentTotal += 0;
                    } else {
                        customerPaymentTotal += Double.parseDouble(set.getString(1));
                    }
                }
                customerPayment.add(String.valueOf(customerPaymentTotal));


            }

            for (String year : year) {
                int empSalaryTotal = 0;
                ResultSet set = EmployeeSalaryDetailsController.getFinalTotalOnYear(year);
                while (set.next()) {
                    if (set.getString(1) == null) {
                        empSalaryTotal += 0;
                    } else {
                        empSalaryTotal += Integer.parseInt(set.getString(1));
                    }
                }
                sumOfEmployeeSalary.add(String.valueOf(empSalaryTotal));
            }

            for (String year : year) {
                int coachSalary = 0;
                ResultSet set = CoachSalaryDetailsController.getFinalTotalOnYear(year);
                while (set.next()) {
                    if (set.getString(1) == null) {
                        coachSalary += 0;
                    } else {
                        coachSalary += Integer.parseInt(set.getString(1));
                    }
                }
                sumOfCoachSalary.add(String.valueOf(coachSalary));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        for (int i = 0; i < supplierOder.size(); i++) {
            int total = 0;
            total += (Integer.parseInt(supplierOder.get(i)) + Integer.parseInt(sumOfEmployeeSalary.get(i)) + Integer.parseInt(sumOfCoachSalary.get(i)));
            lost.add(String.valueOf(total));
        }
        for (int i = 0; i < customerOder.size(); i++) {
            int total = 0;
         total += (Integer.parseInt(customerPayment.get(i))+Integer.parseInt(customerOder.get(i)));
            Profit.add(String.valueOf(total));
        }
        setList(setChartLost(year, lost), setChartSupplierOrder(year, supplierOder), setChartCustomersOrder(year, customerOder), setChartProfit(year, Profit));

    }
    Supplier_order_detailsBO supplier_order_detailsBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.Supplier_order_detailsBO);

    private void selectMonth() {
        clear();
        chart.getData().clear();
        try {

            String year = null;
            String month = null;
            if (rBtnSelectYear.getValue() == null) {
                year = DateTimeUtil.yearNow();

            } else {
                year = String.valueOf(rBtnSelectYear.getValue());
            }
            txtReport.setText(year + " " + rBtnSelectMonth.getValue() + " " + " REPORT ");
            int i = 0;
            for (String CurrentMonth : allMonth) {
                i++;
                if (CurrentMonth.equals(String.valueOf(rBtnSelectMonth.getValue()))) {
                    month = String.valueOf(i).length() == 1 ? "0" + i : String.valueOf(i);
                }
            }

            for (int j = 0; j < DateTimeUtil.getDays(Integer.valueOf(year), Integer.valueOf(month)); j++) {

                days.add(String.valueOf(j + 1).length() == 1 ? "0" + (j + 1) : String.valueOf(j + 1));

            }
            for (String countOfDay : days) {
             //   ResultSet set = SupplierOrderDetailsController.getTotalOnDay(year + "-" + month + "-" + countOfDay);
                String totalOnDay = supplier_order_detailsBO.getTotalOnDay(year + "-" + month + "-" + countOfDay);
                if (totalOnDay!=null) {
                    if (totalOnDay == null) {
                        supplierOder.add("0");
                    } else {
                        supplierOder.add((totalOnDay));
                    }
                } else {
                    supplierOder.add("0");
                }
            }
            for (String countOfDay : days) {
                String finalTotalOnDay = ordersBO.getFinalTotalOnDay(year + "-" + month + "-" + countOfDay);
                //ResultSet set = OrderController.getFinalTotalOnDay(year + "-" + month + "-" + countOfDay);
                if (finalTotalOnDay!=null) {
                    if (finalTotalOnDay == null) {
                        customerOder.add("0");
                    } else {
                        customerOder.add(finalTotalOnDay);
                    }
                } else {
                    customerOder.add("0");
                }
            }
            for (String countOfDay : days) {
                ResultSet set = CustomerPaymentController.getFinalTotal(year + "-" + month + "-" + countOfDay);
                if (set.next()) {
                    if (set.getString(1) == null) {
                        customerPayment.add("0");
                    } else {
                        customerPayment.add(set.getString(1));
                    }
                } else {
                    customerPayment.add("0");
                }
            }
            for (int j = 0; j < customerOder.size(); j++) {
                double total = Double.parseDouble(customerPayment.get(j)) + Double.parseDouble(customerOder.get(j));
                Profit.add(String.valueOf(total));
            }
            for (String countOfDay : days) {
                ResultSet set = EmployeeSalaryDetailsController.getSumOfSalaryOnDay(year + "-" + month + "-" + countOfDay);
                if (set.next()) {
                    if (set.getString(1) == null) {
                        sumOfEmployeeSalary.add("0");
                    } else {
                        sumOfEmployeeSalary.add(set.getString(1));
                    }
                } else {
                    sumOfEmployeeSalary.add("0");
                }
            }
            for (String countOfDay : days) {
                ResultSet set = CoachSalaryDetailsController.getSumOfSalaryOnDay(year + "-" + month + "-" + countOfDay);
                if (set.next()) {
                    if (set.getString(1) == null) {
                        sumOfCoachSalary.add("0");
                    } else {
                        sumOfCoachSalary.add(set.getString(1));
                    }
                } else {
                    sumOfCoachSalary.add("0");
                }
            }
            for (int j = 0; j < days.size(); j++) {
                int total = Integer.parseInt(sumOfEmployeeSalary.get(j)) + Integer.parseInt(sumOfCoachSalary.get(j)) + Integer.parseInt(supplierOder.get(j));
                lost.add(String.valueOf(total));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

//        setChartLost(days, lost);
//        setChartSupplierOrder(days, supplierOder);
//        setChartCustomersOrder(days, customerOder);
//        setChartProfit(days, Profit);
        for (String x : lost) {

        }
        setList(setChartLost(days, lost), setChartSupplierOrder(days, supplierOder), setChartCustomersOrder(days, customerOder), setChartProfit(days, Profit));

    }

    private void setList(XYChart.Series setChartLost, XYChart.Series setChartSupplierOrder, XYChart.Series setChartCustomersOrder, XYChart.Series setChartProfit) {
        chart.getData().clear();
        yAxy.setAnimated(false);
        yAxy.setTickMarkVisible(false);

        chart.getData().addAll(setChartLost, setChartCustomersOrder, setChartProfit, setChartSupplierOrder);
        chart.getXAxis().setAutoRanging(true);


    }

    public void selectYearOnAction(ActionEvent actionEvent) {
        if (String.valueOf(rBtnSelectMonth.getValue()).equals("") | String.valueOf(rBtnSelectMonth.getValue()) == null) {
            onlyYearReport();
        } else {

            selectMonth();
        }
    }

    public void fiveYearReportOnAction(ActionEvent actionEvent) {
        if (fiveYearReport.isSelected()) {

            selectFiveYear();
            rBtnSelectMonth.setDisable(true);
            rBtnSelectYear.setDisable(true);
        } else {
            rBtnSelectMonth.setDisable(false);
            rBtnSelectYear.setDisable(false);
            if (String.valueOf(rBtnSelectMonth.getValue()).equals("") | String.valueOf(rBtnSelectMonth.getValue()) == null) {
                onlyYearReport();
            }
            if (!String.valueOf(rBtnSelectMonth.getValue()).equals("") | String.valueOf(rBtnSelectMonth.getValue()) == null) {
                selectMonth();
            }
        }
    }

    private void setFiveYears() {

        int currentYear = Integer.parseInt(DateTimeUtil.yearNow());
        for (int i = 0; i < 5; i++) {
            year.add(String.valueOf(currentYear));
            currentYear--;
        }
        rBtnSelectYear.getItems().addAll(year);
    }

    private void setAllMonth() {
        rBtnSelectMonth.getItems().add("");
        rBtnSelectMonth.getItems().addAll(allMonth);
    }

    private XYChart.Series setChartProfit(ArrayList<String> list, ArrayList<String> value) {
        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < list.size(); i++) {
            series.getData().add(new XYChart.Data<String, Object>(list.get(i), Double.parseDouble(value.get(i))));
        }
//        chart.getData().addAll(series);
        chart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
//        series.getNode().setStyle("-fx-stroke: #21F80A");
        series.setName("Profit");
        return series;

    }

    private XYChart.Series setChartSupplierOrder(ArrayList<String> list, ArrayList<String> value) {

        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < list.size(); i++) {
            series.getData().add(new XYChart.Data<String, Integer>(list.get(i), Integer.parseInt(value.get(i))));
        }
//        chart.getData().addAll(series);
        chart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
//        series.getNode().setStyle("-fx-stroke: #FF06DC");
        series.setName("Supplier Orders");
        return series;
    }

    private XYChart.Series setChartCustomersOrder(ArrayList<String> list, ArrayList<String> value) {
        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < list.size(); i++) {
            series.getData().add(new XYChart.Data<String, Integer>(list.get(i), Integer.parseInt(value.get(i))));
        }
//        chart.getData().addAll(series);
        chart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
//        series.getNode().setStyle("-fx-stroke: #4702FF");
        series.setName("Customer Orders");
        return series;
    }

    private XYChart.Series setChartLost(ArrayList<String> list, ArrayList<String> value) {

        XYChart.Series series = new XYChart.Series();


        for (int i = 0; i < list.size(); i++) {
            series.getData().add(new XYChart.Data<String, Integer>(list.get(i), Integer.parseInt(value.get(i))));
        }
//        chart.getData().addAll(series);
        chart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
//        series.getNode().setStyle("-fx-stroke: #FE030A");
        series.setName("Lost");
        return series;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAllMonth();
        setFiveYears();
        anchorpane.setStyle("-fx-background-color: transparent");
        chart.setStyle("-fx-background-color: transparent");
        rBtnSelectMonth.setValue(DateTimeUtil.monthNow());
        selectMonth();
        ReportFromController.setStatus(lost, Profit);
        rBtnSelectYear.setValue(DateTimeUtil.yearNow());

    }

}
