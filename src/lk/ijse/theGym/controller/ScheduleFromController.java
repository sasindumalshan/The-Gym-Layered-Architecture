package lk.ijse.theGym.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lk.ijse.theGym.bo.BoFactory;
import lk.ijse.theGym.bo.custom.CoachBO;
import lk.ijse.theGym.bo.custom.CustomerBO;
import lk.ijse.theGym.bo.custom.ExercisesBO;
import lk.ijse.theGym.bo.custom.ScheduleBO;
import lk.ijse.theGym.dto.CoachDTO;
import lk.ijse.theGym.dto.CustomerDTO;
import lk.ijse.theGym.dto.projection.CustomerPackageProjection;
import lk.ijse.theGym.entity.Schedule;
import lk.ijse.theGym.dto.ExercisesDTO;
import lk.ijse.theGym.dto.ScheduleDTO;
import lk.ijse.theGym.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScheduleFromController implements Initializable {
    private static ScheduleFromController controller;
    public JFXComboBox comboMember;
    public JFXComboBox comboCoach;
    public JFXButton btnNew;
    public JFXButton btnDone;
    public JFXButton newSchedule;
    public Text coachName;
    public Text memberName;
    public JFXTextField lblExe;
    public VBox vBox;

    public ScheduleFromController() {
        controller = this;
    }

    public static ScheduleFromController getController() {
        return controller;
    }

    public void memberOnAction(ActionEvent actionEvent) {
        try {
            //ResultSet set = CustomerController.getIdForData(String.valueOf(comboMember.getValue()));
            ArrayList<CustomerPackageProjection> idForData = customerBO.getIdForData(String.valueOf(comboMember.getValue()));
            memberName.setText(idForData.get(0).getFistNAme() + " " + idForData.get(0).getLastName());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    CoachBO coachBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.CoachBO);

    public void coachOnAction(ActionEvent actionEvent) {
        try {
            //ResultSet set = CoachController.getAllForID(String.valueOf(comboCoach.getValue()));

            CoachDTO dto = coachBO.get(String.valueOf(comboCoach.getValue()));
                coachName.setText(dto.getFist_name() + " " + dto.getLast_name());

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    ExercisesBO exercisesBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ExercisesBO);

    public void newOnAction(ActionEvent actionEvent) {

        if (btnNew.getText().equals("ADD")) {
            try {
                if (exercisesBO.setExercises(
                        new ExercisesDTO(
                                nextId(),
                                lblExe.getText()
                        )
                )) {
                    ScheduleFromController.getController().setData();
                    new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                }
                lblExe.clear();
                lblExe.setVisible(false);
                btnNew.setText("NEW");
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }

        }
        if (btnNew.getText().equals("NEW")) {
            lblExe.setVisible(true);
            btnNew.setText("ADD");
        }

    }
   // ExercisesBO exercisesBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ExercisesBO);
    private String nextId() {
        try {
          /*  ResultSet set = ExerciseController.getNextId();
            String id = null;
            while (set.next()) {
                id = set.getString(1);
            }
            try {
                String[] x0s = id.split("X0");
                int nextId = Integer.parseInt(x0s[1]);
                nextId++;
                return "X0" + nextId;
            } catch (NullPointerException e) {
                return "X01";
            }*/
           return exercisesBO.getNextId();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }
    ScheduleBO scheduleBO=BoFactory.getBoFactory().getBO(BoFactory.BOTypes.ScheduleBO);
    public void donOnAction(ActionEvent actionEvent) {
        if (btnDone.getText().equals("Close")) {
            Navigation.close(actionEvent);
        }
        if (btnDone.getText().equals("DONE")) {
            boolean isFullFillArray = true;
            for (int i = 0; i < ScheduleBarController.scheduleDetails.size(); i++) {
                if (ScheduleBarController.scheduleDetails.get(i).getSteps().equals(null)) {
                    new Alert(Alert.AlertType.WARNING,"Chech").show();
                    isFullFillArray = false;
                    break;
                }
            }
            if (isFullFillArray) {
                try {

                    /*ScheduleController.setSchedule(
                            new ScheduleDTO(
                                    String.valueOf( comboMember.getValue()),
                                    getNextScheduleId(),
                                    String.valueOf(comboCoach.getValue())
                            ),ScheduleBarController.scheduleDetails
                    )*/

                    if (scheduleBO.setSchedule(
                            new ScheduleDTO(
                                    String.valueOf( comboMember.getValue()),
                                    getNextScheduleId(),
                                    String.valueOf(comboCoach.getValue())
                            ),ScheduleBarController.scheduleDetails
                    )) {
                        setData();
                        new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
                        Navigation.close(actionEvent);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }

        }
        ScheduleBarController.newUser = true;
        coachName.setText("");
        memberName.setText("");
        comboCoach.setVisible(false);
        comboMember.setVisible(false);
        setAllIdsCoach();
        setAllIdsCustomer();

    }

    private String getNextScheduleId() {
        try {
            String id=null;
//            ResultSet set =ScheduleController.getIds();
            /*while (set.next()){
                id=set.getString(1);
            }
           try {
                String[] s = id.split("S");
                int NextId = Integer.parseInt(s[1]);
                NextId++;
                return "S" + NextId;
            }catch (NullPointerException e){
               return "S1";
           }*/
            return scheduleBO.getIds();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void btnNewScheduleOnAction(ActionEvent actionEvent) {
        ScheduleBarController.newUser = false;
        comboCoach.setVisible(true);
        comboMember.setVisible(true);
        btnDone.setText("DONE");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAllIdsCustomer();
        setAllIdsCoach();
        newSchedule.setVisible(false);
        comboMember.setVisible(false);
        comboCoach.setVisible(false);
        lblExe.setVisible(false);
        setData();
        btnDone.setText("Close");
        setDefaultSchedule();

    }

    private void setDefaultSchedule() {
        String[] ex = {"Deadlift", "Back squat", "Bench Press", "Dumbbell romanian deadlift", "Kettlebell swing",
                "Suspended pushup", "Pullup", "Medicine ball slam", "Swiss Ball Rollout", "Banded Good Morning", "Hamstring curl",
                "Suspended inverted row", "Barbell overhead press", "Barbell hip thrust"
        };
        try {
            if (!scheduleBO.exists("X01")) {
                for (int i = 0; i < ex.length; i++) {
                    scheduleBO.setData(
                            new ExercisesDTO(
                                    nextId(),
                                    ex[i]
                            )
                    );
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setData() {
        vBox.getChildren().clear();

        try {
           // ResultSet set = ScheduleController.getAll();
            ArrayList<Schedule> all = scheduleBO.getAll();
            for (Schedule schedule:all) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/theGym/view/bar/SheduleBar.fxml"));
                Parent root = loader.load();
                ScheduleBarController controller = loader.getController();
                controller.setData(schedule.getSchedule_id(),schedule.getCustomer_id());
                vBox.getChildren().add(root);
            }

        } catch (IOException e) {
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setAllIdsCoach() {
        comboCoach.getItems().clear();
        ArrayList<String> id = new ArrayList<>();
        try {
           // ResultSet set = CoachController.getALlId();
            ArrayList<String> aLlId = coachBO.getALlId();
            for (String s:aLlId) {
                id.add(s);
            }
            comboCoach.getItems().addAll(id);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    CustomerBO customerBO = BoFactory.getBoFactory().getBO(BoFactory.BOTypes.CustomerBO);

    private void setAllIdsCustomer() {
        comboMember.getItems().clear();
        ArrayList<String> id = new ArrayList<>();
        try {
         //   ResultSet set = CustomerController.getAll();
            ArrayList<CustomerDTO> all = customerBO.getAll();
            for (CustomerDTO dto:all) {
                id.add(dto.getCustomer_id());
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        comboMember.getItems().addAll(id);

    }

    public void AnchorPaneMouseEntered(MouseEvent mouseEvent) {
        newSchedule.setVisible(true);

    }

    public void AnchorPaneMouseExited(MouseEvent mouseEvent) {
        newSchedule.setVisible(false);
    }

    public void closeOnMuseClick(MouseEvent mouseEvent) {
        Navigation.close(mouseEvent);
    }
}
