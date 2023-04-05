package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.neusoft.entity.PatientTester;
import com.neusoft.service.PatientTesterManager;
import com.neusoft.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  4:58
 * @Description 这是评估预览页面的控制器类
 * @Since version-1.0
 */
public class EvaluateViewController implements Initializable {
    @FXML
    private JFXButton doEvaBtn;
    @FXML
    private JFXButton backToMain;
    @FXML
    private TableView<PatientTester> tableView;
    @FXML
    private TableColumn<PatientTester, String> nameCol;
    @FXML
    private TableColumn<PatientTester, String> templateNameCol;
    @FXML
    private TableColumn<PatientTester, String> genderCol;
    @FXML
    private TableColumn<PatientTester, String> templateModeCol;
    @FXML
    private TableColumn<PatientTester, String> timeCol;
    @FXML
    private TableColumn<PatientTester, String> evaluaterCol;
    @FXML
    private TableColumn<PatientTester, String> adviceCol;

    private PatientManagementViewController patientManagementViewController;

    private DoEvaluateViewController doEvaluateViewController;

    private ObservableList<PatientTester> patientObservableList = FXCollections.observableArrayList();

/*
 * @Author DengYimo
 * @Date  4:58
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentController(PatientManagementViewController controller) {
        patientManagementViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  4:58
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerEva(DoEvaluateViewController controller) {
        doEvaluateViewController = controller;
    }

    public void backToMainPage(MouseEvent event) {
        PatientManagementViewController controller = (PatientManagementViewController) ViewManager.newWindow("patientManagementView.fxml");
        controller.setParentControllerEva(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
    /*
     * @Author DengYimo
     * @Date  4:58
     * @Description This is description of method
     * @Param [location, resources]
     * @Return void
     * @Since version-1.0
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        patientObservableList.clear();
        List<PatientTester> patients = PatientTesterManager.getInstance().getPatientTesters();
        patientObservableList.addAll(patients);
        tableView.setItems(patientObservableList);
        nameCol.setCellValueFactory(new PropertyValueFactory<PatientTester, String>("name"));
        genderCol.setCellValueFactory(new PropertyValueFactory<PatientTester, String>("gender"));
        templateNameCol.setCellValueFactory(new PropertyValueFactory<PatientTester, String>("templateName"));
        templateModeCol.setCellValueFactory(new PropertyValueFactory<PatientTester, String>("templateMode"));
        timeCol.setCellValueFactory(new PropertyValueFactory<PatientTester, String>("time"));
        evaluaterCol.setCellValueFactory(new PropertyValueFactory<PatientTester, String>("evaluater"));
        adviceCol.setCellValueFactory(new PropertyValueFactory<PatientTester, String>("advice"));
    }
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void doEvaluate(MouseEvent event) {
        DoEvaluateViewController controller = (DoEvaluateViewController) ViewManager.newWindow("doEvaluateView.fxml");
        controller.setParentController(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }


}
