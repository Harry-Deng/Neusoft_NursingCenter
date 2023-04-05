package com.neusoft.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;
/*
 * @Author DengYimo
 * @Date  4:30
 * @Description 此类用于不同界面的跳转，controller注入法。
 * @Since version-1.0
 */
public class ViewManager {
    private static double yOffSet;
    private static double xOffSet;
/*
 * @Author DengYimo
 * @Date  4:31
 * @Description This is description of method
 * @Param [fxmlFileName]
 * @Return java.lang.Object
 * @Since version-1.0
 */
    public static Object newWindow(String fxmlFileName) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(ViewManager.class.getResource(fxmlFileName));
            Parent root = loader.load();
            root.setOnMousePressed(event -> {
                xOffSet = event.getSceneX();
                yOffSet = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffSet);
                stage.setY(event.getScreenY() - yOffSet);
            });
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loader.getController();
    }
/*
 * @Author DengYimo
 * @Date  4:33
 * @Description This is description of method
 * @Param [fxmlFileName]
 * @Return javafx.scene.layout.AnchorPane
 * @Since version-1.0
 */
    public static AnchorPane getPane(String fxmlFileName) {
        AnchorPane pane = null;
        try {
            new FXMLLoader();
            pane = (AnchorPane) FXMLLoader.load(Objects.requireNonNull(ViewManager.class.getResource(fxmlFileName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pane;
    }
}
