package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.neusoft.entity.Patient;
import com.neusoft.service.PatientManager;
import com.neusoft.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description 这是病人管理主页面的控制器类
 * @Since version-1.0
 */
public class PatientManagementViewController implements Initializable {
    @FXML
    private JFXButton newFileBtn;
    @FXML
    private JFXButton delFileBtn;
    @FXML
    private JFXButton modFileBtn;
    @FXML
    private JFXButton evaBtn;
    @FXML
    private ImageView searchBtn;
    @FXML
    private ImageView searchCancelBtn;
    @FXML
    private TextField searchText;
    @FXML
    private JFXButton backToMain;
    @FXML
    private TableView<Patient> tableView;
    @FXML
    private TableColumn<Patient, String> nameCol;
    @FXML
    private TableColumn<Patient, String> birthdayCol;
    @FXML
    private TableColumn<Patient, String> genderCol;
    @FXML
    private TableColumn<Patient, String> contactCol;
    @FXML
    private TableColumn<Patient, String> ECPCol;
    @FXML
    private TableColumn<Patient, String> ECNCol;

    private List<Patient> searchedList = new ArrayList<Patient>();

    private StaffMainViewController staffMainViewController;
    private EvaluateViewController evaluateViewController;

    private ObservableList<Patient> patientObservableList = FXCollections.observableArrayList();
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description This is description of method
 * @Param [location, resources]
 * @Return void
 * @Since version-1.0
 */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        patientObservableList.clear();
        List<Patient> patients = PatientManager.getInstance().getPatients();
        patientObservableList.addAll(patients);
        tableView.setItems(patientObservableList);
        nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        birthdayCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("birthday"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
        contactCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("contact"));
        ECPCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("ECP"));
        ECNCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("ECN"));
    }
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void modifyPatient(MouseEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Patient selectedPatient = tableView.getSelectionModel().getSelectedItem();
            PatientSettingViewController controller = (PatientSettingViewController) ViewManager.newWindow("patientSettingView.fxml");
            controller.setPatient(selectedPatient);
            controller.setParentController(this);
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "请选中表格中一名病患");
            nullWarning.setHeaderText("未选中任何一名病患！");
            nullWarning.show();
        }
    }
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    void removePatient(MouseEvent event) {
        if (tableView.getSelectionModel().getSelectedItems().size() >= 1) {
            Alert delWarning = new Alert(Alert.AlertType.CONFIRMATION, "确定删除所选病患信息吗？");
            delWarning.setHeaderText("点击确认删除档案");
            delWarning.setTitle("");
            Optional<ButtonType> op = delWarning.showAndWait();
            if (op.get() == ButtonType.OK) {
                for (Patient selectedStaffSingle : tableView.getSelectionModel().getSelectedItems()) {
                    PatientManager.getInstance().removePatient(selectedStaffSingle);
                }
                initialize(null, null);
            }
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "请选中表格中至少一名病患");
            nullWarning.setHeaderText("未选中任何一名病患！");
            nullWarning.show();
        }
    }
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void createNewAccount(MouseEvent event) {
        NewPatientViewController controller = (NewPatientViewController) ViewManager.newWindow("newPatientView.fxml");
        controller.setParentController(this);
    }
/*
 * @Author DengYimo
 * @Date  5:02
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void searchByName(MouseEvent event) {
        searchedList.clear();
        String name = searchText.getText();
        for (Patient patient : PatientManager.getInstance().getPatients()) {
            if (patient.getName().contains(name)) {
                searchedList.add(patient);
            }
        }
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        patientObservableList.clear();
        patientObservableList.addAll(searchedList);
        tableView.setItems(patientObservableList);
        nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        birthdayCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("birthday"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
        contactCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("contact"));
        ECPCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("ECP"));
        ECNCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("ECN"));
    }
/*
 * @Author DengYimo
 * @Date  5:02
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void cancelSearch(MouseEvent event) {
        initialize(null, null);
        searchText.setText("");
    }
    /*
     * @Author DengYimo
     * @Date  5:02
     * @Description This is description of method
     * @Param [controller]
     * @Return void
     * @Since version-1.0
     */
    public void setParentController(StaffMainViewController controller) {
        staffMainViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:02
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerEva(EvaluateViewController controller) {
        evaluateViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:02
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    public void backToMainPage(MouseEvent event) {
        StaffMainViewController controller = (StaffMainViewController) ViewManager.newWindow("staffMainView.fxml");
        controller.setParentControllerPatientManagement(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
/*
 * @Author DengYimo
 * @Date  5:08
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void goToEvaluate(MouseEvent event){
        EvaluateViewController controller = (EvaluateViewController) ViewManager.newWindow("evaluateView.fxml");
        controller.setParentController(this);
        Stage currentStage = (Stage) evaBtn.getScene().getWindow();
        currentStage.close();
    }
}
