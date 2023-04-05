package com.neusoft.controller;

import com.jfoenix.controls.JFXButton;
import com.neusoft.entity.CheckInInfo;
import com.neusoft.entity.Database;
import com.neusoft.entity.Patient;
import com.neusoft.service.PatientManager;
import com.neusoft.entity.building.*;
import com.neusoft.view.ViewManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
/*
 * @Author DengYimo
 * @Date  5:02
 * @Description 这床位管理页面的控制器类
 * @Since version-1.0
 */
public class CheckInInfoViewController implements Initializable {
    private ObservableList<CheckInInfo> checkInInfoList = FXCollections.observableArrayList();
    @FXML
    private TableView<CheckInInfo> bedTableView;
    @FXML
    private ChoiceBox<Patient> checkInPatientChoiceBox;
    @FXML
    private ChoiceBox<Building> bedManBuildingChoice;
    @FXML
    private ChoiceBox<Level> bedManLevelChoice;
    @FXML
    private ChoiceBox<Room> bedManRoomChoice;
    @FXML
    private ChoiceBox<Bed> bedManBedChoice;

    @FXML
    private DatePicker checkInDatePicker;
    @FXML
    private DatePicker checkOutDatePicker;
    @FXML
    private Label bedManInfoLabel;
    @FXML
    private JFXButton backToMain;

    private StaffMainViewController staffMainViewController;

    public void setParentController(StaffMainViewController controller) {
        staffMainViewController = controller;
    }

    //[end]
    //删除记录
    @FXML
    private void bedManRemoveButtonFired() {
        CheckInInfo checkInInfo = bedTableView.getSelectionModel().getSelectedItem();
        if(checkInInfo == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请先在表中选择数据。");
            alert.show();
            return ;
        }
        if(checkInInfo.isInBed() == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "所选病人尚未出院，无法删除");
            alert.show();
            return ;
        }
        for(CheckInInfo info : bedTableView.getSelectionModel().getSelectedItems()) {
            Database.getInstance().getCheckInInfos().remove(info);
        }

        Database.saveToFile();
        initialize(null, null);
    }
    //入住按钮触发事件
    @FXML
    private void checkInButtonFired() {
        boolean isOk = true;
        isOk &= bedManBuildingChoice.getSelectionModel().getSelectedItem() != null;
        isOk &= bedManLevelChoice.getSelectionModel().getSelectedItem() != null;
        isOk &= bedManRoomChoice.getSelectionModel().getSelectedItem() != null;
        isOk &= bedManBedChoice.getSelectionModel().getSelectedItem() != null;
        if(!isOk) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "未选择床号");
            alert.show();
            return ;
        }
        isOk &= checkInPatientChoiceBox.getSelectionModel().getSelectedItem() != null;
        if(!isOk) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "未选择入住人");
            alert.show();
            return ;
        }
        isOk &= checkInDatePicker.getValue() != null;
        isOk &= checkOutDatePicker.getValue() != null;
        if(!isOk) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "未选择入住时间");
            alert.show();
            return ;
        }
        if(checkInDatePicker.getValue().isAfter(checkOutDatePicker.getValue())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "时间选择有误（离开时间晚于入住时间）");
            alert.show();
            return ;
        }
        if(bedManBedChoice.getSelectionModel().getSelectedItem().getOwner() != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "所选床位已经被占用");
            alert.show();
            return ;
        }
        for(Building building : Database.getInstance().getBuildings()) {
            for(Level level : building.getLevels()) {
                for(Room room : level.getRooms()) {
                    for(Bed bed : room.getBeds()) if(bed.getOwner() != null){
                        if(bed.getOwner().equals(checkInPatientChoiceBox.getSelectionModel().getSelectedItem())) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "该病人已入院，请重新选择。");
                            alert.show();
                            return ;
                        }
                    }
                }
            }
        }
        bedManBedChoice.getSelectionModel().getSelectedItem().setOwner(checkInPatientChoiceBox.getSelectionModel().getSelectedItem());
        Database.getInstance().getCheckInInfos().add(new CheckInInfo(bedManBedChoice.getSelectionModel().getSelectedItem()
                , checkInPatientChoiceBox.getSelectionModel().getSelectedItem()
                , checkInDatePicker.getValue()
                , checkOutDatePicker.getValue()
                , true));
        bedManInfoLabel.setText("");

        initialize(null, null);
        Database.saveToFile();

    }
    //找到空闲床位
    @FXML
    private void findAvailableBedButtonFired() {
        for(Building building : Database.getInstance().getBuildings()) {
            for(Level level : building.getLevels()) {
                for(Room room : level.getRooms()) {
                    for(Bed bed : room.getBeds()) {
                        if(bed.getOwner() == null) {
                            setSelectedBed(bed);
                            return ;
                        }
                    }
                }
            }
        }
        Alert alert = new Alert(Alert.AlertType.ERROR, "暂无可用床位");
        alert.show();
        return ;
    }
    //办理退房
    @FXML
    private void checkOutButtonFired() {
        if(bedTableView.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "您尚未在表格中选择记录");
            alert.show();
            return ;
        }
        CheckInInfo checkInInfo = bedTableView.getSelectionModel().getSelectedItem();
        checkInInfo.setInBed(false);
        checkInInfo.getBed().setOwner(null);

        initialize(null, null);
        Database.saveToFile();
        return ;
    }
    //调换床位
    @FXML
    private void swapBedButtonFired() {
        if(bedTableView.getSelectionModel().getSelectedItems().size() != 2) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "选择的床位不正确（需要恰好两个选择）");
            alert.show();
            return ;
        }
        Bed bed0 = bedTableView.getSelectionModel().getSelectedItems().get(0).getBed();
        Bed bed1 = bedTableView.getSelectionModel().getSelectedItems().get(1).getBed();
        Patient patient0 = bedTableView.getSelectionModel().getSelectedItems().get(0).getPatient();
        Patient patient1 = bedTableView.getSelectionModel().getSelectedItems().get(1).getPatient();
        bed0.setOwner(patient1);
        bed1.setOwner(patient0);
        bedTableView.getSelectionModel().getSelectedItems().get(0).setBed(bed1);
        bedTableView.getSelectionModel().getSelectedItems().get(1).setBed(bed0);

        initialize(null, null);
        Database.saveToFile();
        return ;
    }
    //初始化床位管理系统
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //------------------------------------------------------还原所有栏目-----------------------------------------------------------
        bedManInfoLabel.setText("");
        checkInInfoList.clear();
        bedTableView.getColumns().clear();
        bedTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        refreshcheckInPatientChoiceBox();
        //------------------------------------------------------表格展示-----------------------------------------------------------
        //[start]
        checkInInfoList.setAll(Database.getInstance().getCheckInInfos());
        bedTableView.setItems(checkInInfoList);
        TableColumn<CheckInInfo, String> positionColumn = new TableColumn<CheckInInfo, String>("位置");
        TableColumn<CheckInInfo, String> checkInTimeColumn = new TableColumn<CheckInInfo, String>("入住开始时间");
        TableColumn<CheckInInfo, String> checkOutTimeColumn = new TableColumn<CheckInInfo, String>("入住结束时间");
        TableColumn<CheckInInfo, String> stateColumn = new TableColumn<CheckInInfo, String>("状态");
        TableColumn<CheckInInfo, String> nameColumn = new TableColumn<CheckInInfo, String>("姓名");
        TableColumn<CheckInInfo, String> sexColumn = new TableColumn<CheckInInfo, String>("性别");
        positionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CheckInInfo,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CheckInInfo, String> param) {
                // TODO Auto-generated method stub
                SimpleStringProperty str = new SimpleStringProperty();
                Bed bed = param.getValue().getBed();
                Room room = bed.getFather();
                Level level = room.getFather();
                Building building = level.getFather();
                str.setValue(building.getName() + "->"
                        + level.getName() + "->"
                        + room.getName() + "->"
                        + bed.getName());
                return str;
            }
        });
        checkInTimeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CheckInInfo,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CheckInInfo, String> param) {
                // TODO Auto-generated method stub
                SimpleStringProperty str = new SimpleStringProperty();
                LocalDate date = param.getValue().getCheckInTime();
                str.setValue(date.toString());
                return str;
            }
        });
        checkOutTimeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CheckInInfo,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CheckInInfo, String> param) {
                // TODO Auto-generated method stub
                SimpleStringProperty str = new SimpleStringProperty();
                LocalDate date = param.getValue().getCheckOutTime();
                str.setValue(date.toString());
                return str;
            }
        });
        stateColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CheckInInfo,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CheckInInfo, String> param) {
                // TODO Auto-generated method stub
                return new SimpleStringProperty(param.getValue().isInBed() ? "入住中" : "已出院");
            }
        });
        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CheckInInfo,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CheckInInfo, String> param) {
                // TODO Auto-generated method stub
                return new SimpleStringProperty(param.getValue().getPatient().getName());
            }
        });
        sexColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CheckInInfo,String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CheckInInfo, String> param) {
                // TODO Auto-generated method stub
                return new SimpleStringProperty(param.getValue().getPatient().getGender());
            }
        });


        positionColumn.setPrefWidth(250);
        checkInTimeColumn.setPrefWidth(130);
        checkOutTimeColumn.setPrefWidth(130);
        positionColumn.setResizable(false);
        checkInTimeColumn.setResizable(false);
        checkOutTimeColumn.setResizable(false);
        stateColumn.setResizable(false);
        nameColumn.setResizable(false);
        sexColumn.setResizable(false);
        bedTableView.getColumns().add(positionColumn);
        bedTableView.getColumns().add(checkInTimeColumn);
        bedTableView.getColumns().add(checkOutTimeColumn);
        bedTableView.getColumns().add(stateColumn);
        bedTableView.getColumns().add(nameColumn);
        bedTableView.getColumns().add(sexColumn);
        //[end]
        //---------------------------------------------------楼层选择框监听器------------------------------------------------------
        //[start]
        bedManBuildingChoice.getItems().setAll(Database.getInstance().getBuildings());
        bedManLevelChoice.setDisable(true);
        bedManRoomChoice.setDisable(true);
        bedManBedChoice.setDisable(true);
        bedManBuildingChoice.getSelectionModel().clearSelection();
        bedManLevelChoice.getSelectionModel().clearSelection();
        bedManRoomChoice.getSelectionModel().clearSelection();
        bedManBedChoice.getSelectionModel().clearSelection();
        bedManBuildingChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Building>() {

            @Override
            public void changed(ObservableValue<? extends Building> observable, Building oldValue, Building newValue) {
                // TODO Auto-generated method stub
                if(newValue == null) return ;
                if(newValue == oldValue) return ;
                bedManLevelChoice.getSelectionModel().clearSelection();
                bedManRoomChoice.getSelectionModel().clearSelection();
                bedManBedChoice.getSelectionModel().clearSelection();
                bedManLevelChoice.setDisable(false);
                bedManRoomChoice.setDisable(true);
                bedManBedChoice.setDisable(true);
                bedManInfoLabel.setText("");
                bedManLevelChoice.getItems().setAll(newValue.getLevels());

            }
        });
        bedManLevelChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Level>() {

            @Override
            public void changed(ObservableValue<? extends Level> observable, Level oldValue, Level newValue) {
                // TODO Auto-generated method stub
                if(newValue == null) return ;
                if(newValue == oldValue) return ;
                bedManRoomChoice.getSelectionModel().clearSelection();
                bedManBedChoice.getSelectionModel().clearSelection();
                bedManRoomChoice.setDisable(false);
                bedManBedChoice.setDisable(true);
                bedManInfoLabel.setText("");
                bedManRoomChoice.getItems().setAll(newValue.getRooms());

            }
        });
        bedManRoomChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Room>() {

            @Override
            public void changed(ObservableValue<? extends Room> observable, Room oldValue, Room newValue) {
                // TODO Auto-generated method stub
                if(newValue == null) return ;
                if(newValue == oldValue) return ;
                bedManBedChoice.getSelectionModel().clearSelection();
                bedManBedChoice.setDisable(false);
                bedManInfoLabel.setText("");
                bedManBedChoice.getItems().setAll(newValue.getBeds());



            }
        });
        bedManBedChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Bed>() {

            @Override
            public void changed(ObservableValue<? extends Bed> observable, Bed oldValue, Bed newValue) {
                // TODO Auto-generated method stub
                if(newValue == null) return ;
//				if(newValue == oldValue) return ;

                bedManInfoLabel.setText(newValue.getName() + (newValue.getOwner() == null ? "：空闲" : (" 占有者：" + newValue.getOwner().getName())));

            }


        });
        //[end]
        //入住人刷新
        refreshcheckInPatientChoiceBox();
    }
    //设置选择框里的床位
    private void setSelectedBed(Bed bed) {
        Room room = bed.getFather();
        Level level = room.getFather();
        Building building = level.getFather();
        bedManBuildingChoice.getSelectionModel().select(building);
        bedManLevelChoice.getSelectionModel().select(level);
        bedManRoomChoice.getSelectionModel().select(room);
        bedManBedChoice.getSelectionModel().select(bed);
        return ;
    }

    //刷新入住人choicebox
    void refreshcheckInPatientChoiceBox() {
        ArrayList<Patient> tmp = new ArrayList<Patient>();
        for(Patient patient : PatientManager.getInstance().getPatients()) {
            boolean f = false;
            for(Building building : Database.getInstance().getBuildings()) {
                for(Level level : building.getLevels())  {
                    for(Room room : level.getRooms())  {
                        for(Bed bed : room.getBeds())  {
                            if(bed.getOwner() != null)
                                f |= (bed.getOwner().equals(patient));
                        }
                    }
                }
            }
            if(!f) tmp.add(patient);
        }
        checkInPatientChoiceBox.getItems().setAll(tmp);
        //设置展示内容
        checkInPatientChoiceBox.setConverter(new StringConverter<Patient>() {

            @Override
            public String toString(Patient object) {
                // TODO Auto-generated method stub
                return object.getName() + "-" + object.getId();
            }

            @Override
            public Patient fromString(String arg0) {
                // TODO Auto-generated method stub
                return null;
            }
        });
        checkInPatientChoiceBox.getSelectionModel().clearSelection();
        checkInDatePicker.setValue(null);
        checkOutDatePicker.setValue(null);
        bedManBuildingChoice.getSelectionModel().clearSelection();
        bedManLevelChoice.getSelectionModel().clearSelection();
        bedManRoomChoice.getSelectionModel().clearSelection();
        bedManBedChoice.getSelectionModel().clearSelection();
        bedManLevelChoice.setDisable(true);
        bedManRoomChoice.setDisable(true);
        bedManBedChoice.setDisable(true);

    }

    @FXML
    public void backToMainPage(MouseEvent event){
        StaffMainViewController controller = (StaffMainViewController) ViewManager.newWindow("staffMainView.fxml");
        controller.setParentControllerCheckIn(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }

//[end]
}
