package com.neusoft.controller;

import com.neusoft.service.PatientManager;
import com.neusoft.entity.*;
import com.neusoft.util.IdGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  4:59
 * @Description 这是新建病患的控制器类
 * @Since version-1.0
 */
public class NewPatientViewController implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField ECPField;
    @FXML
    private TextField ECNField;
    @FXML
    private Label exitLabel;
    @FXML
    private CheckBox checkBox;

    private PatientManagementViewController patientManagementViewController;
    private Patient inPatient;
/*
 * @Author DengYimo
 * @Date  4:59
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
 * @Date  4:59
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void saveHandled(MouseEvent event) {
        String name = nameField.getText();
        String birthday = birthdayField.getText();
        String gender = genderField.getText();
        String id = "PATIENT" + IdGenerator.getCode();
        String contact = contactField.getText();
        String ECP = ECPField.getText();
        String ECN = ECNField.getText();

        if (checkBox.isSelected()) {
            if (name.equals("") || gender.equals("") || birthday.equals("") || contact.equals("") || ECP.equals("") || ECN.equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "核对一下再试试吧");
                alert.setHeaderText("病患信息输入不完整");
                alert.show();
                return;
            }
            if (inPatient != null) {
                PatientManager.getInstance().removePatient(inPatient);
            }
            PatientManager.getInstance().addPatient(new Patient(name, birthday, gender, id, contact, ECP, ECN));
            Alert info = new Alert(Alert.AlertType.INFORMATION,"病患已添加");
            info.showAndWait();
            patientManagementViewController.initialize(null, null);
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
 * @Date  4:59
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void close(MouseEvent event) {
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }
/*
 * @Author DengYimo
 * @Date  5:05
 * @Description This is description of method
 * @Param [location, resources]
 * @Return void
 * @Since version-1.0
 */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
