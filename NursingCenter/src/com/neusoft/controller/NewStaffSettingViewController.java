package com.neusoft.controller;

import com.jfoenix.controls.JFXComboBox;
import com.neusoft.service.UserManager;
import com.neusoft.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  5:00
 * @Description 这是员工信息修改界面的控制器类
 * @Since version-1.0
 */
public class NewStaffSettingViewController implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField birthdayField;
    @FXML
    private JFXComboBox<Type> titleComboBox;
    @FXML
    private TextField specialField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField idField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label exitLabel;
    @FXML
    private CheckBox checkBox;

    private AdminMainViewController adminMainViewController;
    private Staff inStaff;
    private final Type defaultType = new Type("无");
/*
 * @Author DengYimo
 * @Date  5:00
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentController(AdminMainViewController controller) {
        adminMainViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:00
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    void saveHandled(MouseEvent event) {
        String name = nameField.getText();
        String birthday = birthdayField.getText();
        String type = titleComboBox.getSelectionModel().getSelectedItem().toString();
        String special = specialField.getText();
        String contact = contactField.getText();
        String id = idField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (checkBox.isSelected()) {
            if (name.equals("") || special.equals("") || birthday.equals("") || contact.equals("") || username.equals("") || password.equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "核对一下再试试吧");
                alert.setHeaderText("信息输入不能有空值");
                alert.show();
                return;
            } else if (type.equals("无")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "核对一下再试试吧");
                alert.setHeaderText("职称未选择");
                alert.show();
                return;
            }
            if (inStaff != null) {
                UserManager.getInstance().removeStaff(inStaff);
            }
            UserManager.getInstance().addStaff(new Staff(username, password, name, birthday, special, type, contact, id));
            Alert info = new Alert(Alert.AlertType.INFORMATION, "员工账号-"+ inStaff.getName() +"-已修改");
            info.showAndWait();
            adminMainViewController.initialize(null, null);
            Stage currentStage = (Stage) exitLabel.getScene().getWindow();
            currentStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "请勾选同意协议");
            alert.setHeaderText("");
            alert.show();
        }
    }
/*
 * @Author DengYimo
 * @Date  5:00
 * @Description This is description of method
 * @Param [location, resources]
 * @Return void
 * @Since version-1.0
 */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Type> typeObservableList = FXCollections.observableArrayList();
        List<Type> types = StaffType.getInstance().getTypes();
        typeObservableList.addAll(types);
        titleComboBox.setItems(typeObservableList);
        titleComboBox.setValue(defaultType);
    }
    /*
     * @Author DengYimo
     * @Date  5:00
     * @Description This is description of method
     * @Param [staff]
     * @Return void
     * @Since version-1.0
     */
    public void setStaff(Staff staff) {
        inStaff = staff;
        nameField.setText(staff.getName());
        birthdayField.setText(staff.getBirthday());
        specialField.setText(staff.getSpecialty());
        contactField.setText(staff.getContact());
        idField.setText(staff.getId());
        usernameField.setText(staff.getAccount());
        passwordField.setText(staff.getPassword());
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
    void close(MouseEvent event) {
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }
}

