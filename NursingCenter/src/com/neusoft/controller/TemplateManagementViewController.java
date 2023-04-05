package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.neusoft.service.MLSManager;
import com.neusoft.entity.*;
import com.neusoft.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  5:04
 * @Description 这是模板管理主页面
 * @Since version-1.0
 */
public class TemplateManagementViewController implements Initializable {
    @FXML
    private JFXButton backToMain;
    @FXML
    private JFXButton showBtn;
    @FXML
    private TableView<ModelListShow> tableView;
    @FXML
    private TableColumn<ModelListShow, String> idCol;
    @FXML
    private TableColumn<ModelListShow, String> contentCol;
    @FXML
    private TableColumn<ModelListShow, String> modeCol;
    @FXML
    private JFXButton delFileBtn;

    private StaffMainViewController staffMainViewController;
    private ShowTemplateViewController showTemplateViewController;

    private ObservableList<ModelListShow> MLSObservableList = FXCollections.observableArrayList();
    /*
     * @Author DengYimo
     * @Date  5:04
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
 * @Date  5:04
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerShow(ShowTemplateViewController controller) {
        showTemplateViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:04
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    public void backToMainPage(MouseEvent event) {
        StaffMainViewController controller = (StaffMainViewController) ViewManager.newWindow("staffMainView.fxml");
        controller.setParentControllerTemplateManagement(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
    /*
     * @Author DengYimo
     * @Date  5:04
     * @Description This is description of method
     * @Param [location, resources]
     * @Return void
     * @Since version-1.0
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        MLSObservableList.clear();
        List<ModelListShow> patients = MLSManager.getInstance().getModelListShows();
        MLSObservableList.addAll(patients);
        tableView.setItems(MLSObservableList);
        idCol.setCellValueFactory(new PropertyValueFactory<ModelListShow, String>("id"));
        contentCol.setCellValueFactory(new PropertyValueFactory<ModelListShow, String>("content"));
        modeCol.setCellValueFactory(new PropertyValueFactory<ModelListShow, String>("mode"));
    }
    /*
     * @Author DengYimo
     * @Date  5:04
     * @Description This is description of method
     * @Param [event]
     * @Return void
     * @Since version-1.0
     */
    @FXML
    public void delTemplate(MouseEvent event) {
        if (tableView.getSelectionModel().getSelectedItems().size() >= 1) {
            Alert delWarning = new Alert(Alert.AlertType.CONFIRMATION, "确定删除所选模板吗？");
            delWarning.setHeaderText("点击确认删除模板");
            delWarning.setTitle("");
            Optional<ButtonType> op = delWarning.showAndWait();
            if (op.get() == ButtonType.OK) {
                for (ModelListShow selectedSingle : tableView.getSelectionModel().getSelectedItems()) {
                    MLSManager.getInstance().removeModelListShow(selectedSingle);
                }
                initialize(null, null);
            }
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "请选中表格中至少一个模板");
            nullWarning.setHeaderText("未选中任何一个模板！");
            nullWarning.show();
        }
    }
/*
 * @Author DengYimo
 * @Date  5:09
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void showTemplate(MouseEvent event) {
        ShowTemplateViewController controller = (ShowTemplateViewController) ViewManager.newWindow("showTemplateView.fxml");
        controller.setParentController(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
}
