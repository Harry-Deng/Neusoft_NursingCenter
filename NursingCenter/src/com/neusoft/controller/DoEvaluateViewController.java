package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.neusoft.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Optional;
/*
 * @Author DengYimo
 * @Date  4:57
 * @Description 这是评估界面的控制器类
 * @Since version-1.0
 */
public class DoEvaluateViewController {
    @FXML
    private JFXButton saveBtn;
    @FXML
    private Label exitLabel;

    private EvaluateViewController evaluateViewController;

    public void setParentController(EvaluateViewController controller) {
        evaluateViewController = controller;
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
    public void close() {
        EvaluateViewController controller = (EvaluateViewController) ViewManager.newWindow("evaluateView.fxml");
        controller.setParentControllerEva(this);
        Stage stage = (Stage) exitLabel.getScene().getWindow();
        stage.close();
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
    public void saveHandled(MouseEvent event) {
        Alert delWarning = new Alert(Alert.AlertType.INFORMATION, "60/100(分)");
        delWarning.setHeaderText("本次评估得分为：");
        delWarning.setTitle("评估完毕");
        Optional<ButtonType> op = delWarning.showAndWait();
        if (op.get() == ButtonType.OK) {
            close();
        }
    }

}
