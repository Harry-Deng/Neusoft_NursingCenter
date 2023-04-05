package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.neusoft.entity.TemplateShow;
import com.neusoft.service.TemplateShowManager;
import com.neusoft.view.ViewManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description 这是员工新建员工界面的控制器类
 * @Since version-1.0
 */
public class NewTemplateViewController implements Initializable {
    @FXML
    private TextField idField;
    @FXML
    private TextField contentField;
    @FXML
    private TextField modeField;
    @FXML
    private JFXButton clearBtn;
    @FXML
    private JFXButton saveBtn;
    @FXML
    private Label exitLabel;
    @FXML
    private JFXCheckBox checkBox;

    private ShowTemplateViewController showTemplateViewController;
/*
 * @Author DengYimo
 * @Date  5:01
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentController(ShowTemplateViewController controller) {
        showTemplateViewController = controller;
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
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    @FXML
    void close() {
        ShowTemplateViewController controller = (ShowTemplateViewController) ViewManager.newWindow("ShowTemplateView.fxml");
        controller.setParentControllerNewTemplate(this);
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
        idField.setText("");
        contentField.setText("");
        modeField.setText("");
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
        String id = idField.getText();
        String content = contentField.getText();
        String mode = modeField.getText();

        if (id.equals("") && content.equals("") && mode.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "核对一下再试试吧");
            alert.setHeaderText("信息输入不能有空值");
            alert.show();
        }

        if (checkBox.isSelected()) {
            TemplateShow templateShow = new TemplateShow(id, content, mode);
            if (TemplateShowManager.getInstance().addTemplateShow(templateShow)) {
                Alert regSuccess = new Alert(Alert.AlertType.INFORMATION, "新的问题已添加");
                regSuccess.setHeaderText("添加成功");
                regSuccess.showAndWait();
                showTemplateViewController.initialize(null, null);
                close();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "请勾选同意协议");
            alert.setHeaderText("");
            alert.show();
        }
    }

}
