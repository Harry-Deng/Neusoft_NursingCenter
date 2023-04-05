package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.neusoft.entity.Staff;
import com.neusoft.entity.Type;
import com.neusoft.service.UserManager;
import com.neusoft.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/*
 * @Author DengYimo
 * @Date  4:54
 * @Description 这是主页面的控制器类
 * @Since version-1.0
 */
public class AdminMainViewController implements Initializable {

    @FXML
    private TableView<Staff> tableView;
    @FXML
    private ComboBox<Type> chooseTitle;
    @FXML
    private Button createAccount;
    @FXML
    private JFXButton closePage;
    @FXML
    private Button deleteAccount;
    @FXML
    private Label exitAccount;
    @FXML
    private TableColumn<Staff, String> usernameCol;
    @FXML
    private TableColumn<Staff, String> nameCol;
    @FXML
    private TableColumn<Staff, String> birthdayCol;
    @FXML
    private TableColumn<Staff, String> titleCol;
    @FXML
    private TableColumn<Staff, String> specialtyCol;
    @FXML
    private TableColumn<Staff, String> idCol;
    @FXML
    private TableColumn<Staff, String> contactCol;
    @FXML
    private TableColumn<Staff, String> passwordEater;

    private ObservableList<Staff> staffObservableList = FXCollections.observableArrayList();
    
    private LoginViewController loginViewController;
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param [location, resources]
 * @Return void
 * @Since version-1.0
 */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        staffObservableList.clear();
        List<Staff> staffs = UserManager.getInstance().getStaffs();
        staffObservableList.addAll(staffs);
        tableView.setItems(staffObservableList);
        birthdayCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("birthday"));
        specialtyCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("specialty"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("title"));
        contactCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("contact"));
        idCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("id"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("account"));
        passwordEater.setCellValueFactory(new PropertyValueFactory<Staff, String>("password"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    void modifyStaff(MouseEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Staff selectedStaff = tableView.getSelectionModel().getSelectedItem();
            NewStaffSettingViewController controller = (NewStaffSettingViewController) ViewManager.newWindow("staffSettingView.fxml");
            controller.setStaff(selectedStaff);
            controller.setParentController(this);
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "请选中表格中一名员工");
            nullWarning.setHeaderText("未选中任何一名员工！");
            nullWarning.show();
        }
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentController(LoginViewController controller) {
        loginViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void closeAdminPage(MouseEvent event) {
        Stage stage = (Stage) closePage.getScene().getWindow();
        stage.close();
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void exitBtnToRed(MouseEvent event) {
        closePage.setTextFill(Paint.valueOf("Red"));
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void exitBtnToPurple(MouseEvent event) {
        closePage.setTextFill(Paint.valueOf("#33277b"));
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void createNewAccount(MouseEvent event) {
        NewStaffViewController controller = (NewStaffViewController) ViewManager.newWindow("newStaffView.fxml");
        controller.setParentController(this);
    }
/*
 * @Author DengYimo
 * @Date  4:55
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void logoutAccount(MouseEvent event) {
        Stage stage = (Stage) closePage.getScene().getWindow();
        stage.close();
        LoginViewController controller = (LoginViewController) ViewManager.newWindow("loginView.fxml");
        controller.setParentControllerAdmin(this);
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
    void removeStaff(MouseEvent event) {
        if (tableView.getSelectionModel().getSelectedItems().size() >= 1) {
            Alert delWarning = new Alert(Alert.AlertType.CONFIRMATION, "确定删除所选员工吗？");
            delWarning.setHeaderText("点击确认删除账号");
            delWarning.setTitle("");
            Optional<ButtonType> op = delWarning.showAndWait();
            if (op.get() == ButtonType.OK) {
                for (Staff selectedStaffSingle : tableView.getSelectionModel().getSelectedItems()) {
                    UserManager.getInstance().removeStaff(selectedStaffSingle);
                }
                initialize(null, null);
            }
        } else {
            Alert nullWarning = new Alert(Alert.AlertType.ERROR, "请选中表格中至少一名员工");
            nullWarning.setHeaderText("未选中任何一名员工！");
            nullWarning.show();
        }
    }

}
