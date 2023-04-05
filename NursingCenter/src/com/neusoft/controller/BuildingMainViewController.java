package com.neusoft.controller;

import com.neusoft.entity.Database;
import com.neusoft.entity.building.Bed;
import com.neusoft.entity.building.Building;
import com.neusoft.entity.building.Level;
import com.neusoft.entity.building.Room;
import com.neusoft.view.ViewManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
/*
 * @Author DengYimo
 * @Date  4:55
 * @Description 这是楼宇管理的控制器类
 * @Since version-1.0
 */
public class BuildingMainViewController implements Initializable {

//------------------------------------------------------楼宇管理--------------------------------------------------------------------


    @FXML
    private TextField maxCapacityField;
    @FXML
    private ListView<Building> buildingList;
    @FXML
    private ListView<Level> levelList;
    @FXML
    private ListView<Room> roomList;
    @FXML
    private ListView<Bed> bedList;
    @FXML
    private VBox buildingModifier;
    @FXML
    private TextField buildingField;
    @FXML
    private VBox levelModifier;
    @FXML
    private TextField levelField;
    @FXML
    private VBox roomModifier;
    @FXML
    private TextField roomField;
    @FXML
    private ChoiceBox<String> isRareChoice;
    @FXML
    private ChoiceBox<String> rareTypeChoice;
    @FXML
    private VBox bedModifier;
    @FXML
    private TextField bedField;
    @FXML
    private Text roomInfoField;
    @FXML
    private Button backToMain;

    private StaffMainViewController staffMainViewController;

    public void setParentController(StaffMainViewController controller) {
        staffMainViewController = controller;
    }
/*
 * @Author DengYimo
 * @Date  4:55
 * @Description This is description of method
 * @Param [event]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void backToMainPage(MouseEvent event) {
        StaffMainViewController controller = (StaffMainViewController) ViewManager.newWindow("staffMainView.fxml");
        controller.setParentControllerBuilding(this);
        Stage currentStage = (Stage) backToMain.getScene().getWindow();
        currentStage.close();
    }

/*
 * @Author DengYimo
 * @Date  4:55
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    //返回上级菜单
    @FXML
    private void preMenu() {
        buildingModifier.setVisible(false);
        levelModifier.setVisible(false);
        roomModifier.setVisible(false);
        bedModifier.setVisible(false);
        if (!bedList.getItems().isEmpty()) {
            bedList.getItems().clear();
            roomList.getSelectionModel().clearSelection();
            return;
        }
        if (!roomList.getItems().isEmpty()) {
            roomList.getItems().clear();
            levelList.getSelectionModel().clearSelection();
            return;
        }
        if (!levelList.getItems().isEmpty()) {
            levelList.getItems().clear();
            buildingList.getSelectionModel().clearSelection();
            return;
        }
        buildingList.getSelectionModel().clearSelection();
        return;

    }
/*
 * @Author DengYimo
 * @Date  4:55
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    //增加大楼
    @FXML
    private void addBuilding() {
        if (Pattern.matches(" *", buildingField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请输入大楼名称");
            alert.show();
        } else {
            String name = buildingField.getText();
            for (Building building : Database.getInstance().getBuildings()) {
                if (building.getName().equals(name)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "已存在同名大楼");
                    alert.show();
                    return;
                }
            }
            Database.getInstance().getBuildings().add(new Building(name));
            buildingList.getItems().setAll(Database.getInstance().getBuildings());
            buildingField.setText("");
        }
        Database.saveToFile();
    }
/*
 * @Author DengYimo
 * @Date  4:55
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    //删除大楼
    @FXML
    private void removeBuilding() {
        if (buildingList.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "尚未选择大楼");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.getButtonTypes().add(ButtonType.CANCEL);
            alert.setContentText("该操作不可逆，请确认是否删除。");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Database.getInstance().getBuildings().remove(buildingList.getSelectionModel().getSelectedItem());
                buildingList.getItems().setAll(Database.getInstance().getBuildings());
                levelList.getItems().clear();
                roomList.getItems().clear();
                bedList.getItems().clear();
            }
        }
        Database.saveToFile();
    }
/*
 * @Author DengYimo
 * @Date  4:55
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    //新建楼层
    @FXML
    private void addLevel() {
        Building father = buildingList.getSelectionModel().getSelectedItem();
        if (Pattern.matches(" *", levelField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请输入楼层名称");
            alert.show();
        } else {
            String name = levelField.getText();
            for (Level level : father.getLevels()) {
                if (level.getName().equals(name)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "已存在同名楼层");
                    alert.show();
                    return;
                }
            }
            father.getLevels().add(new Level(name, father));
            levelList.getItems().setAll(father.getLevels());
            levelField.setText("");
        }
        Database.saveToFile();
    }
/*
 * @Author DengYimo
 * @Date  4:55
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    //删除楼层
    @FXML
    private void removeLevel() {
        Building father = buildingList.getSelectionModel().getSelectedItem();
        if (levelList.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "尚未选择楼层");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.getButtonTypes().add(ButtonType.CANCEL);
            alert.setContentText("该操作不可逆，请确认是否删除。");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                father.getLevels().remove(levelList.getSelectionModel().getSelectedItem());
                levelList.getItems().setAll(father.getLevels());
                roomList.getItems().clear();
                bedList.getItems().clear();
            }
        }
        Database.saveToFile();
    }
/*
 * @Author DengYimo
 * @Date  4:55
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    //添加房间
    @FXML
    private void addRoom() {
        Level father = levelList.getSelectionModel().getSelectedItem();
        if (Pattern.matches(" *", roomField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请输入房间名称");
            alert.show();
        } else if (isRareChoice.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请选择是否为稀有房间");
            alert.show();
        } else if (isRareChoice.getSelectionModel().getSelectedItem().equals("是") && rareTypeChoice.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请选择稀有房间类型");
            alert.show();
        } else if (isRareChoice.getSelectionModel().getSelectedItem().equals("是") && maxCapacityField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请输入最大容量限制");
            alert.show();
        } else {
            String name = roomField.getText();
            for (Room room : father.getRooms()) {
                if (room.getName().equals(name)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "已存在同名房间");
                    alert.show();
                    return;
                }
            }
            if (isRareChoice.getSelectionModel().getSelectedItem().equals("是")) {
                int capacity = Integer.parseInt(maxCapacityField.getText());
                father.getRooms().add(new Room(roomField.getText(), true
                        , Room.getTypeByChinese(rareTypeChoice.getSelectionModel().getSelectedItem()), father
                        , capacity, capacity));
            } else {
                father.getRooms().add(new Room(roomField.getText(), false, father));
            }
            roomList.getItems().setAll(father.getRooms());
            roomField.setText("");
            maxCapacityField.setText("");
            isRareChoice.getSelectionModel().clearSelection();
            rareTypeChoice.getSelectionModel().clearSelection();
            Database.saveToFile();
        }

    }
/*
 * @Author DengYimo
 * @Date  4:55
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    //删除房间
    @FXML
    private void removeRoom() {
        Level father = levelList.getSelectionModel().getSelectedItem();
        if (levelList.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "尚未选择楼层");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.getButtonTypes().add(ButtonType.CANCEL);
            alert.setContentText("该操作不可逆，请确认是否删除。");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                father.getRooms().remove(roomList.getSelectionModel().getSelectedItem());
                roomList.getItems().setAll(father.getRooms());
                bedList.getItems().clear();
                Database.saveToFile();
            }
        }
    }
/*
 * @Author DengYimo
 * @Date  4:56
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    //添加床
    @FXML
    private void addBed() {
        Room father = roomList.getSelectionModel().getSelectedItem();
        if (Pattern.matches(" *", bedField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "请输入床号");
            alert.show();
        } else if (father.isRareRoom()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "稀有房间不能创建床位");
            alert.show();
        } else {
            String name = bedField.getText();
            for (Bed bed : father.getBeds()) {
                if (bed.getName().equals(name)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "已存在同名床位 ");
                    alert.show();
                    return;
                }
            }
            father.getBeds().add(new Bed(name, father));
            bedList.getItems().setAll(father.getBeds());
            bedField.setText("");
            Database.saveToFile();

        }
    }
/*
 * @Author DengYimo
 * @Date  4:56
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    //删除床位
    @FXML
    private void removeBed() {
        Room father = roomList.getSelectionModel().getSelectedItem();
        if (bedList.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "尚未选择床位");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.getButtonTypes().add(ButtonType.CANCEL);
            alert.setContentText("该操作不可逆，请确认是否删除。");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                father.getBeds().remove(bedList.getSelectionModel().getSelectedItem());
                bedList.getItems().setAll(father.getBeds());
                Database.saveToFile();
            }
        }

    }
    //楼宇管理初始化
/*
 * @Author DengYimo
 * @Date  4:56
 * @Description This is description of method
 * @Param [location, resources]
 * @Return void
 * @Since version-1.0
 */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        //清理数据
        buildingList.getItems().clear();
        levelList.getItems().clear();
        roomList.getItems().clear();
        bedList.getItems().clear();
        buildingField.setText("");
        levelField.setText("");
        roomField.setText("");
        isRareChoice.getItems().clear();
        rareTypeChoice.getItems().clear();
        maxCapacityField.setText("");
        bedField.setText("");
        roomInfoField.setText("");
        buildingModifier.setVisible(false);
        levelModifier.setVisible(false);
        roomModifier.setVisible(false);
        bedModifier.setVisible(false);
//    	buildingList.setItems(n);
        //设置房间信息展示栏
        roomInfoField.setText("");
        //添加房间选项栏
        isRareChoice.getItems().addAll("是", "否");
        for (String string : Room.RARETYPES) {
            rareTypeChoice.getItems().addAll(string);
        }
        //添加切换窗口的监听器
        ObservableList<Building> obl = buildingList.getItems();
        obl.setAll(Database.getInstance().getBuildings());
        buildingList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Building>() {

           /*
            * @Author DengYimo
            * @Date  4:56
            * @Description This is description of method
            * @Param [observable, oldValue, newValue]
            * @Return void
            * @Since version-1.0
            */ @Override
            public void changed(ObservableValue<? extends Building> observable, Building oldValue, Building newValue) {
                // TODO Auto-generated method stub
                roomList.getItems().clear();
                bedList.getItems().clear();
                if (newValue != null) levelList.getItems().setAll(newValue.getLevels());
            }
        });
        levelList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Level>() {

           /*
            * @Author DengYimo
            * @Date  4:56
            * @Description This is description of method
            * @Param [observable, oldValue, newValue]
            * @Return void
            * @Since version-1.0
            */ @Override
            public void changed(ObservableValue<? extends Level> observable, Level oldValue, Level newValue) {
                // TODO Auto-generated method stub

                bedList.getItems().clear();
                if (newValue != null) roomList.getItems().setAll(newValue.getRooms());

            }
        });
        roomList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Room>() {

            /*
             * @Author DengYimo
             * @Date  4:56
             * @Description This is description of method
             * @Param [observable, oldValue, newValue]
             * @Return void
             * @Since version-1.0
             */@Override
            public void changed(ObservableValue<? extends Room> observable, Room oldValue, Room newValue) {
                // TODO Auto-generated method stub
                if (newValue != null) {
                    roomInfoField.setText("是否为稀有房间：" + (newValue.isRareRoom() ? "是" : "否"));
                    if (newValue.isRareRoom())
                        roomInfoField.setText(roomInfoField.getText()
                                + "\n" + "房间种类：" + Room.getType(newValue.getRareType())
                                + "\n" + "最大容量：" + newValue.getMaxCapacity()
                                + "\n" + "剩余容量：" + newValue.getResCapacity());
                    bedList.getItems().setAll(newValue.getBeds());
                } else {
                    roomInfoField.setText("");
                }

            }
        });
        bedList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Bed>() {

            /*
             * @Author DengYimo
             * @Date  4:56
             * @Description This is description of method
             * @Param [observable, oldValue, newValue]
             * @Return void
             * @Since version-1.0
             */@Override
            public void changed(ObservableValue<? extends Bed> observable, Bed oldValue, Bed newValue) {
                // TODO Auto-generated method stub
                if (newValue != null) {
                    if (newValue.getOwner() != null)
                        roomInfoField.setText(newValue.getName() + "，占有者：" + newValue.getOwner().toString());
                    else roomInfoField.setText(newValue.getName() + "：当前空闲");
                } else {
                    roomInfoField.setText("");
                }

            }
        });
        isRareChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            /*
             * @Author DengYimo
             * @Date  4:56
             * @Description This is description of method
             * @Param [observable, oldValue, newValue]
             * @Return void
             * @Since version-1.0
             */@Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // TODO Auto-generated method stub
                if (newValue == null) return;
                if (newValue.equals("否")) {
                    if (rareTypeChoice.getSelectionModel() != null)
                        rareTypeChoice.getSelectionModel().clearSelection();
                    rareTypeChoice.setDisable(true);
                    maxCapacityField.setDisable(true);
                } else if (newValue.equals("是")) {
                    rareTypeChoice.setDisable(false);
                    maxCapacityField.setDisable(false);
                }
            }

        });
        buildingList.focusedProperty().addListener(new ChangeListener<Boolean>() {
            /*
             * @Author DengYimo
             * @Date  4:56
             * @Description This is description of method
             * @Param [observable, oldValue, newValue]
             * @Return void
             * @Since version-1.0
             */@Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if (newValue == null) return;
                if (newValue == true) {
                    buildingModifier.setVisible(true);
                    levelModifier.setVisible(false);
                    roomModifier.setVisible(false);
                    bedModifier.setVisible(false);
                }
                if (newValue == false) {
                    if (buildingList.isFocused() || levelList.isFocused() || roomList.isFocused() || bedList.isFocused()) {
                        buildingModifier.setVisible(false);
                        buildingField.setText("");
                    }
                }

            }
        });
        levelList.focusedProperty().addListener(new ChangeListener<Boolean>() {
            /*
             * @Author DengYimo
             * @Date  4:56
             * @Description This is description of method
             * @Param [observable, oldValue, newValue]
             * @Return void
             * @Since version-1.0
             */@Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if (newValue == null) return;
                if (newValue == true) {
                    if (buildingList.getSelectionModel().getSelectedItem() != null) {
                        buildingModifier.setVisible(false);
                        levelModifier.setVisible(true);
                        roomModifier.setVisible(false);
                        bedModifier.setVisible(false);
                    }
                }
                if (newValue == false) {
                    if (buildingList.isFocused() || levelList.isFocused() || roomList.isFocused() || bedList.isFocused()) {
                        levelModifier.setVisible(false);
                        levelField.setText("");
                    }
                }
            }
        });
        roomList.focusedProperty().addListener(new ChangeListener<Boolean>() {
            /*
             * @Author DengYimo
             * @Date  4:56
             * @Description This is description of method
             * @Param [observable, oldValue, newValue]
             * @Return void
             * @Since version-1.0
             */@Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if (newValue == null) return;
                if (newValue == true) {
                    if (levelList.getSelectionModel().getSelectedItem() != null) {
                        buildingModifier.setVisible(false);
                        levelModifier.setVisible(false);
                        roomModifier.setVisible(true);
                        bedModifier.setVisible(false);
                    }
                }
                if (newValue == false) {
                    if (buildingList.isFocused() || levelList.isFocused() || roomList.isFocused() || bedList.isFocused()) {
                        roomModifier.setVisible(false);

                        roomField.setText("");
                        maxCapacityField.setText("");
                        isRareChoice.getSelectionModel().clearSelection();
                        rareTypeChoice.getSelectionModel().clearSelection();
                    }
                }

            }
        });
        bedList.focusedProperty().addListener(new ChangeListener<Boolean>() {
            /*
             * @Author DengYimo
             * @Date  4:57
             * @Description This is description of method
             * @Param [observable, oldValue, newValue]
             * @Return void
             * @Since version-1.0
             */@Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // TODO Auto-generated method stub
                if (newValue == null) return;
                if (newValue == true) {
                    if (roomList.getSelectionModel().getSelectedItem() != null) {
                        buildingModifier.setVisible(false);
                        levelModifier.setVisible(false);
                        roomModifier.setVisible(false);
                        bedModifier.setVisible(true);
                    }
                }
                if (newValue == false) {
                    if (buildingList.isFocused() || levelList.isFocused() || roomList.isFocused() || bedList.isFocused()) {
                        bedModifier.setVisible(false);
                        bedField.setText("");
                    }
                }

            }
        });
        maxCapacityField.textProperty().addListener(new ChangeListener<String>() {

            /*
             * @Author DengYimo
             * @Date  4:57
             * @Description This is description of method
             * @Param [observable, oldValue, newValue]
             * @Return void
             * @Since version-1.0
             */@Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // TODO Auto-generated method stub
                if (newValue == null) return;
                if (!Pattern.matches("[0-9]{0,3}", newValue))
                    maxCapacityField.setText(oldValue);
                return;
            }
        });
    }
}
