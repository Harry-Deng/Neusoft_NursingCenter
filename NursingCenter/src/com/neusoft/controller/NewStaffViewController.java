package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.neusoft.entity.Staff;
import com.neusoft.service.UserManager;
import com.neusoft.util.IdGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class NewStaffViewController implements Initializable {
    @FXML
    private JFXCheckBox checkBox;
    @FXML
    private JFXButton clearBtn;
    @FXML
    private JFXButton saveBtn;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField passwordField2;
    @FXML
    private Label exitLabel;

    private AdminMainViewController adminMainViewController;
/*
 * @Author DengYimo
 * @Date  5:01
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
 * @Date  5:01
 * @Description This is description of method
 * @Param [location, resources]
 * @Return void
 * @Since version-1.0
 */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    void close(MouseEvent event) {
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
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
    void clearText(MouseEvent event) {
        usernameField.setText("");
        passwordField.setText("");
        passwordField2.setText("");
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
    void registHandled(MouseEvent event) {
        String account = usernameField.getText();
        String password = passwordField.getText();
        String passwordConfirmation = passwordField2.getText();

        if (account.equals("") && password.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "核对一下再试试吧");
            alert.setHeaderText("信息输入不能有空值");
            alert.show();
            return;
        } else if (!password.equals(passwordConfirmation)) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "核对一下再试试吧");
            alert.setHeaderText("两次密码输入不一致");
            alert.show();
            passwordField.setText("");
            passwordField2.setText("");
            return;
        }

        if (checkBox.isSelected()) {
            Staff staff = new Staff(account, password, "default", "00000000", "default", "default", "00000000000", "STAFF" + IdGenerator.getCode());
            if (UserManager.getInstance().addStaff(staff)) {
                Alert regSuccess = new Alert(Alert.AlertType.INFORMATION, "新的员工账号已可用");
                regSuccess.setHeaderText("注册成功");
                regSuccess.showAndWait();
                Stage currentStage = (Stage) exitLabel.getScene().getWindow();
                adminMainViewController.initialize(null, null);
                currentStage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "注册失败");
                alert.setHeaderText("已存在相同账号的用户");
                alert.show();
                usernameField.setText("");
                passwordField.setText("");
                passwordField2.setText("");
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "请勾选同意协议");
            alert.setHeaderText("");
            alert.show();
        }
    }
}
