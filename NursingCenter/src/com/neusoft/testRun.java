package com.neusoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;
/*
 * @Author DengYimo
 * @Date  4:33
 * @Description 此类为运行主界面基本类，所有程序由此开始。
 * @Param 
 * @Return 
 * @Since version-1.0
 */
public class testRun extends Application {
    //用于拖拽效果的实现。
    private double xOffSet;
    private double yOffSet;

    /*
     * @Author：DengYimo
     * @Date  4:19
     * @Description 重写start方法，用于启动
     * @Param [primaryStage]
     * @Return void
     * @Since version-1.0
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/loginView.fxml")));

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getIcons().add(new Image("Hospital.png"));
        root.setOnMousePressed(event -> {
            xOffSet = event.getSceneX();
            yOffSet = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffSet);
            primaryStage.setY(event.getScreenY() - yOffSet);
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /*
     * @Author：DengYimo
     * @Date  4:19
     * @Description This is description of method
     * @Param [args]
     * @Return void
     * @Since version-1.0
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("javafx.version"));
        launch(args);
    }

}
