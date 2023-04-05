package com.neusoft.controller;

import com.neusoft.entity.TemplateShow;
import com.neusoft.service.TemplateShowManager;
import com.neusoft.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description 这是展示模板的控制器类
 * @Since version-1.0
 */
public class ShowTemplateViewController implements Initializable {
    @FXML
    private TableView<TemplateShow> tableView;
    @FXML
    private TableColumn<TemplateShow, String> idCol;
    @FXML
    private TableColumn<TemplateShow, String> contentCol;
    @FXML
    private TableColumn<TemplateShow, String> modeCol;
    @FXML
    private Label exitLabel;

    private ObservableList<TemplateShow> templateShowObservableList = FXCollections.observableArrayList();

    private TemplateManagementViewController templateManagementViewController;

    private NewTemplateViewController newTemplateViewController;
/*
 * @Author DengYimo
 * @Date  5:03
 * @Description This is description of method
 * @Param [controller]
 * @Return void
 * @Since version-1.0
 */
    public void setParentController(TemplateManagementViewController controller) {
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
    public void setParentControllerNewTemplate(NewTemplateViewController controller) {
        newTemplateViewController = controller;
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
    public void newProblem(MouseEvent event) {
        NewTemplateViewController controller = (NewTemplateViewController) ViewManager.newWindow("newTemplateView.fxml");
        controller.setParentController(this);
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
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
    public void close(MouseEvent event) {
        TemplateManagementViewController controller = (TemplateManagementViewController) ViewManager.newWindow("templateManagementView.fxml");
        controller.setParentControllerShow(this);
        Stage currentStage = (Stage) exitLabel.getScene().getWindow();
        currentStage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        templateShowObservableList.clear();
        List<TemplateShow> templateShows = TemplateShowManager.getInstance().getTemplateShows();
        templateShowObservableList.addAll(templateShows);
        tableView.setItems(templateShowObservableList);
        idCol.setCellValueFactory(new PropertyValueFactory<TemplateShow, String>("id"));
        contentCol.setCellValueFactory(new PropertyValueFactory<TemplateShow, String>("content"));
        modeCol.setCellValueFactory(new PropertyValueFactory<TemplateShow, String>("mode"));
    }
}
