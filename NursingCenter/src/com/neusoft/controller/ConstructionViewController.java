package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.neusoft.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/*
 * @Author DengYimo
 * @Date  4:57
 * @Description 这事拓展页面的控制器类
 * @Since version-1.0
 */
public class ConstructionViewController {
    @FXML
    private JFXButton backToMain;

    private StaffMainViewController staffMainViewController;
/*
 * @Author DengYimo
 * @Date  4:57
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
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    public void backToMainPage(MouseEvent event){
        StaffMainViewController controller = (StaffMainViewController) ViewManager.newWindow("staffMainView.fxml");
        controller.setParentControllerConstruction(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
}
