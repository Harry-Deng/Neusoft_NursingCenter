package com.neusoft.controller;

import com.neusoft.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description 这是员工主页面
 * @Since version-1.0
 */
public class StaffMainViewController {
    @FXML
    private Button buildingManagement;
    @FXML
    private Button patientManagement;
    @FXML
    private Button modelManagement;
    @FXML
    private Button selfInfoBtn;
    @FXML
    private Button rareRoomBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button goToCheckInInfo;

    private LoginViewController loginViewController;
    private PatientManagementViewController patientManagementViewController;
    private ConstructionViewController constructionViewController;
    private TemplateManagementViewController templateManagementViewController;
    private RareRoomManagementViewController rareRoomManagementViewController;
    private BuildingMainViewController buildingMainViewController;
    private CheckInInfoViewController checkInInfoViewController;
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerLogin(LoginViewController controller) {
        loginViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerPatientManagement(PatientManagementViewController controller) {
        patientManagementViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerTemplateManagement(TemplateManagementViewController controller) {
        templateManagementViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerConstruction(ConstructionViewController controller) {
        constructionViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerRareRoom(RareRoomManagementViewController controller) {
        rareRoomManagementViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerBuilding(BuildingMainViewController controller) {
        buildingMainViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentControllerCheckIn(CheckInInfoViewController controller) {
        checkInInfoViewController = controller;
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
    public void exitButton(MouseEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
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
    public void logoutButton(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        LoginViewController controller = (LoginViewController) ViewManager.newWindow("loginView.fxml");
        controller.setParentControllerStaff(this);
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
    public void goToPatientManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        PatientManagementViewController controller = (PatientManagementViewController) ViewManager.newWindow("patientManagementView.fxml");
        controller.setParentController(this);
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
    public void goToOtherManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        ConstructionViewController controller = (ConstructionViewController) ViewManager.newWindow("constructionView.fxml");
        controller.setParentController(this);
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
    public void goToTemplateManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        TemplateManagementViewController controller = (TemplateManagementViewController) ViewManager.newWindow("templateManagementView.fxml");
        controller.setParentController(this);
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
    public void goToRareRoomManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        RareRoomManagementViewController controller = (RareRoomManagementViewController) ViewManager.newWindow("rareRoomManagementView.fxml");
        controller.setParentController(this);
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
    public void goToBuildingManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        BuildingMainViewController controller = (BuildingMainViewController) ViewManager.newWindow("buildingMainView.fxml");
        controller.setParentController(this);
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
    public void goToCheckInInfoManagement(MouseEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
        CheckInInfoViewController controller = (CheckInInfoViewController) ViewManager.newWindow("checkInInfoView.fxml");
        controller.setParentController(this);
    }
/*
 * @Author DengYimo
 * @Date  5:04
 * @Description This is description of method
 * @Param [loginViewController]
 * @Return void
 * @Since version-1.0
 */
    public void setLoginViewController(LoginViewController loginViewController) {
        this.loginViewController = loginViewController;
    }
}
