package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.neusoft.view.ViewManager;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.net.URL;
import java.util.ResourceBundle;

/*
 * @Author DengYimo
 * @Date  4:58
 * @Description 这是登录主页面的控制器类
 * @Since version-1.0
 */
public class LoginViewController implements Initializable {
    @FXML
    private StackPane basicLayer;
    @FXML
    private AnchorPane mainLayer;
    @FXML
    private AnchorPane moveLayer;
    @FXML
    private JFXButton toAdminPage;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label s1;
    @FXML
    private Label s2;
    @FXML
    private Label s3;
    @FXML
    private JFXButton toStaffPage;
    @FXML
    private Label staffTitle;
    @FXML
    private Label adminTitle;
    @FXML
    private Label staffTips;
    @FXML
    private Label adminTips;
    @FXML
    private JFXButton staffLoginBtn;
    @FXML
    private JFXButton adminLoginBtn;
    @FXML
    private TextField staffUsername;
    @FXML
    private Label staffPWForgot;
    @FXML
    private PasswordField staffPassword;
    @FXML
    private TextField adminUserName;
    @FXML
    private PasswordField adminPassword;
    @FXML
    private Label adminPWForgot;
    @FXML
    private AnchorPane loginLayer;
    @FXML
    private JFXButton otherAccess1;
    @FXML
    private JFXButton otherAccess2;
    @FXML
    private JFXButton otherAccess3;
    @FXML
    private Label Exit;

    private AdminMainViewController adminMainViewController;
    private StaffMainViewController staffMainViewController;
/*
 * @Author DengYimo
 * @Date  4:58
 * @Description This is description of method
 * @Param [url, rb]
 * @Return void
 * @Since version-1.0
 */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        toStaffPage.setVisible(false);
        adminTips.setVisible(false);
        adminTitle.setVisible(false);
        adminLoginBtn.setVisible(false);
        adminUserName.setVisible(false);
        adminPassword.setVisible(false);
        adminPWForgot.setVisible(false);
        staffUsername.setVisible(true);
        staffPWForgot.setVisible(true);
        staffPassword.setVisible(true);
    }
/*
 * @Author DengYimo
 * @Date  4:58
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    private void btn(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(moveLayer);

        slide.setToX(491);
        slide.play();

        loginLayer.setTranslateX(-309);
        adminLoginBtn.setVisible(true);
        adminTips.setVisible(true);
        adminTitle.setVisible(true);

        s1.setVisible(true);
        s2.setVisible(true);
        s3.setVisible(true);
        toStaffPage.setVisible(true);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        moveLayer.setStyle("-fx-background-color: linear-gradient(to bottom left, #A868A0, #2D75E8);");
        otherAccess1.setStyle("-fx-background-color: linear-gradient(to bottom left, #A868A0, #2D75E8); -fx-background-radius: 300");
        otherAccess2.setStyle("-fx-background-color: linear-gradient(to bottom left, #A868A0, #2D75E8); -fx-background-radius: 300");
        otherAccess3.setStyle("-fx-background-color: linear-gradient(to bottom left, #A868A0, #2D75E8); -fx-background-radius: 300");
        toAdminPage.setVisible(false);
        staffTips.setVisible(false);
        staffTitle.setVisible(false);
        staffLoginBtn.setVisible(false);
        adminUserName.setVisible(true);
        adminPassword.setVisible(true);
        adminPWForgot.setVisible(true);
        staffUsername.setVisible(false);
        staffPWForgot.setVisible(false);
        staffPassword.setVisible(false);

        slide.setOnFinished((e->{
        }));
    }
/*
 * @Author DengYimo
 * @Date  4:58
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    private void btn2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(moveLayer);

        slide.setToX(0);
        slide.play();

        loginLayer.setTranslateX(0);
        adminLoginBtn.setVisible(false);
        adminTips.setVisible(false);
        adminTitle.setVisible(false);

        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        toStaffPage.setVisible(false);
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        moveLayer.setStyle("-fx-background-color:linear-gradient(to bottom left, #0250c5 0%, #d43f8d 100%);");
        otherAccess1.setStyle("-fx-background-color: linear-gradient(to bottom left, #0250c5 0%, #d43f8d 100%); -fx-background-radius: 300");
        otherAccess2.setStyle("-fx-background-color: linear-gradient(to bottom left, #0250c5 0%, #d43f8d 100%); -fx-background-radius: 300");
        otherAccess3.setStyle("-fx-background-color: linear-gradient(to bottom left, #0250c5 0%, #d43f8d 100%); -fx-background-radius: 300");
        toAdminPage.setVisible(true);
        staffTips.setVisible(true);
        staffTitle.setVisible(true);
        staffLoginBtn.setVisible(true);
        adminUserName.setVisible(false);
        adminPassword.setVisible(false);
        adminPWForgot.setVisible(false);
        staffUsername.setVisible(true);
        staffPWForgot.setVisible(true);
        staffPassword.setVisible(true);

        slide.setOnFinished((e->{
        }));
    }
/*
 * @Author DengYimo
 * @Date  4:58
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    @FXML
    private void staffLoginBtn() {
        if("staff".equals(staffUsername.getText())||"唐僧".equals(staffUsername.getText())||"西天主".equals(staffUsername.getText())||"红孩儿".equals(staffUsername.getText())||"牛魔王".equals(staffUsername.getText())||"孙悟空".equals(staffUsername.getText())&&"123456".equals(staffPassword.getText())){
            staffSign();
            Stage stage = (Stage)Exit.getScene().getWindow();
            stage.close();
            String tilte = "Sign In";
            String message = staffUsername.getText() + " log in!";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        }else if (!"staff".equals(staffUsername.getText()) || !"123456".equals(staffPassword.getText())){
            String tilte = "Sign In";
            String message = "Error Staff Information ";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }

    }
/*
 * @Author DengYimo
 * @Date  4:58
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    private void staffSign() {
        StaffMainViewController controller = (StaffMainViewController) ViewManager.newWindow("staffMainView.fxml");
        controller.setParentControllerLogin(this);
    }
/*
 * @Author DengYimo
 * @Date  4:58
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    private void adminSign() {
        AdminMainViewController controller = (AdminMainViewController) ViewManager.newWindow("adminMainView.fxml");
        controller.setParentController(this);
    }
/*
 * @Author DengYimo
 * @Date  4:58
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    @FXML
    private void adminLoginBtn() {
        if("admin".equals(adminUserName.getText())&&"123456".equals(adminPassword.getText())){
            adminSign();
            Stage stage = (Stage)Exit.getScene().getWindow();
            stage.close();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle("Sign In");
            tray.setMessage(adminUserName.getText() + " log in!");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
        }else if (!"admin".equals(adminUserName.getText()) || !"123456".equals(adminPassword.getText())){
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle("Sign In");
            tray.setMessage("Error Admin Information");
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }
    }
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    void enterPressedAdmin(KeyEvent event) throws Exception {
        if(event.getCode() == KeyCode.ENTER) {
            adminLoginBtn();
        }
    }
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    void enterPressedStaff(KeyEvent event) throws Exception {
        if(event.getCode() == KeyCode.ENTER) {
            staffLoginBtn();
        }
    }
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void exitLoginPage(MouseEvent event){
        Stage stage = (Stage)Exit.getScene().getWindow();
        stage.close();
    }
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void exitBtnToRed(MouseEvent event){
        Exit.setTextFill(Paint.valueOf("Red"));
    }
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void exitBtnToPurple(MouseEvent event){
        Exit.setTextFill(Paint.valueOf("#3F2B63"));
    }
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void forgotRemindAdmin(MouseEvent event) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.FADE;

        tray.setAnimationType(type);
        tray.setTitle("默认管理员");
        tray.setMessage("账号：admin\n密码: 123456");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(3000));
    }
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void forgotRemindStaff(MouseEvent event) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.FADE;

        tray.setAnimationType(type);
        tray.setTitle("默认员工");
        tray.setMessage("账号: staff\n密码: 123456");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(100));
    }
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerAdmin(AdminMainViewController controller) {
        adminMainViewController = controller;
    }
    /*
     * @Author DengYimo
     * @Date  5:04
     * @Description This is description of method
     * @Param [controller]
     * @Return void
     * @Since version-1.0
     */
    public void setParentControllerStaff(StaffMainViewController controller) {
        staffMainViewController = controller;
    }

}

