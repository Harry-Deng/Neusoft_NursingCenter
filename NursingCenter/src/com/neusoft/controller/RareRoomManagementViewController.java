package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.neusoft.entity.Database;
import com.neusoft.entity.Patient;
import com.neusoft.service.PatientManager;
import com.neusoft.entity.building.Building;
import com.neusoft.entity.building.Level;
import com.neusoft.entity.building.RareRoomApplication;
import com.neusoft.entity.building.Room;
import com.neusoft.view.ViewManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
/*
 * @Author DengYimo
 * @Date  5:02
 * @Description 这是稀有房屋管理界面的控制器类
 * @Since version-1.0
 */
public class RareRoomManagementViewController implements Initializable {
    private ObservableList<Room> rareRoomList = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<Patient> rareAplicationPatientChoice;
    @FXML
    private TextField rareApplicationTimeField;
    @FXML
    private TextField rareSearchField;
    @FXML
    private TableView<Room> rareTableView;
    @FXML
    private JFXButton backToMain;

    private StaffMainViewController staffMainViewController;
/*
 * @Author DengYimo
 * @Date  5:02
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
    @FXML
    public void backToMainPage(MouseEvent event) {
        StaffMainViewController controller = (StaffMainViewController) ViewManager.newWindow("staffMainView.fxml");
        controller.setParentControllerRareRoom(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }
/*
 * @Author DengYimo
 * @Date  5:02
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    private void rareSearchFieldKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            rareRoomSearchButtonFired();
        }
    }
    /*
     * @Author DengYimo
     * @Date  5:08
     * @Description This is description of method
     * @Param []
     * @Return void
     * @Since version-1.0
     */
    @FXML
    private void rareRoomSearchButtonFired() {
        if(rareSearchField.getText().equals("")) {
            Patient patient = rareAplicationPatientChoice.getSelectionModel().getSelectedItem();
            String s = rareApplicationTimeField.getText();
            initialize(null,null);
            rareAplicationPatientChoice.getSelectionModel().select(patient);
            rareApplicationTimeField.setText(s);
            return ;
        }
        ArrayList<Room> rooms = new ArrayList<Room>();
        for(Building buidling : Database.getInstance().getBuildings()) {
            for(Level level : buidling.getLevels()) {
                for(Room room : level.getRooms()) {
                    room.refreshApplicationTime();
                    if( room.isRareRoom() && room.getRareType() == room.getTypeByChinese(rareSearchField.getText()) ) {
                        rooms.add(room);
                    }
                }
            }
        }
        rareRoomList.setAll(rooms);
    }
    @FXML
    private void rareRoomRefresh() {
        initialize(null,null);
    }
    @FXML
    private void rareRoomApplicationButtonFired() {
        if(rareTableView.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请选择申请的房间。");
            alert.show();
            return ;
        }
        if(rareAplicationPatientChoice.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请选择申请人 。");
            alert.show();
            return ;
        }
        if(rareApplicationTimeField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请输入申请时间（小时）。");
            alert.show();
            return ;
        }
        Room room = rareTableView.getSelectionModel().getSelectedItem();
        Patient patient = rareAplicationPatientChoice.getSelectionModel().getSelectedItem();
        long time = Long.parseLong(rareApplicationTimeField.getText()) * RareRoomApplication.TIMESCALE;
//    	room.getApplicationList().add(e);
//    	if(room)
        room.refreshApplicationTime();
        if(room.getApplicationList().size() >= room.getMaxCapacity()) {
            long mintime = Long.MAX_VALUE;
            long nowtime = new Date().getTime();
            for(RareRoomApplication application : room.getApplicationList())
                mintime = Math.min(mintime, application.getStartTime().getTime() + application.getDurationTime());
            String s = "";
            if(mintime - nowtime < 60 * 1000) s = String.valueOf((mintime - nowtime) / 1000) + "秒";
            else if(mintime - nowtime < 60 * 60 * 1000) s = String.valueOf((mintime - nowtime) / 60 / 1000) + "分"
                    +  String.valueOf((mintime - nowtime) / 1000 % 60) + "秒";

            else if(mintime - nowtime < 60 * 60 * 60 * 1000) s = String.valueOf((mintime - nowtime) / 60 / 60 / 1000) + "小时"
                    + String.valueOf((mintime - nowtime) % (60 * 60 * 1000) / 60 / 1000) + "分"
                    +  String.valueOf((mintime - nowtime) % (60 * 1000) / 1000 % 60) + "秒";
            Alert alert = new Alert(Alert.AlertType.ERROR, "当前房间申请数已满，还需" + s);
            alert.show();
            return ;
        }
        room.getApplicationList().add(new RareRoomApplication(new Date(), time, patient, room));
        room.refreshApplicationTime();
        initialize(null,null);
        Database.saveToFile();
    }
    //稀有设备管理界面初始化
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //初始化表格
        //[start]
        rareSearchField.setText("");
        rareApplicationTimeField.setText("");
        rareRoomList.clear();
        for(Building buidling : Database.getInstance().getBuildings()) {
            for(Level level : buidling.getLevels()) {
                for(Room room : level.getRooms()) {
                    room.refreshApplicationTime();
                    if(room.isRareRoom()) {
                        rareRoomList.add(room);
                    }
                }
            }
        }
        rareTableView.setItems(rareRoomList);
        rareTableView.getColumns().clear();
        TableColumn<Room, String> roomTypeColumn = new TableColumn<Room, String>("房间种类");
        TableColumn<Room, String> roomPositionColumn = new TableColumn<Room, String>("位置");
        TableColumn<Room, String> maxCapacityColumn = new TableColumn<Room, String>("最大容纳人数");
        TableColumn<Room, String> resCapacityColumn = new TableColumn<Room, String>("剩余容纳人数");
        roomTypeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Room, String> param) {
                // TODO Auto-generated method stub
                SimpleStringProperty str = new SimpleStringProperty();
                str.setValue(param.getValue().getType(param.getValue().getRareType()));
                return str;
            }
        });
        roomPositionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Room, String> param) {
                // TODO Auto-generated method stub
                SimpleStringProperty str = new SimpleStringProperty();
                Room room = param.getValue();
                Level level = room.getFather();
                Building building = level.getFather();
                str.setValue(building.getName() + "->"
                        + level.getName() + "->"
                        + room.getName());
                return str;
            }
        });
        maxCapacityColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Room, String> param) {
                // TODO Auto-generated method stub

                return new SimpleStringProperty(String.valueOf(param.getValue().getMaxCapacity()));
            }
        });
        resCapacityColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Room, String> param) {
                // TODO Auto-generated method stub

                return new SimpleStringProperty(String.valueOf(param.getValue().getResCapacity()));
            }
        });
        rareTableView.getColumns().add(roomTypeColumn);
        rareTableView.getColumns().add(roomPositionColumn);
        rareTableView.getColumns().add(maxCapacityColumn);
        rareTableView.getColumns().add(resCapacityColumn);
        rareTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //[end]
        rareAplicationPatientChoice.setConverter(new StringConverter<Patient>() {
            @Override
            public String toString(Patient object) {
                return object.getName();
            }

            @Override
            public Patient fromString(String string) {
                return null;
            }
        });
        //初始化choicebox
        rareAplicationPatientChoice.getItems().setAll(PatientManager.getInstance().getPatients());
        //输入框监听器
//    	rareAplicationPatientChoice.set
        rareApplicationTimeField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // TODO Auto-generated method stub
                if(newValue == null) return ;
                if(!Pattern.matches("[0-9]{0,6}", newValue)) {
                    rareApplicationTimeField.setText(oldValue);
                }
            }
        });
    }
}
