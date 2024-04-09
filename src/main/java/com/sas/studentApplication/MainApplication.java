package com.sas.studentApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApplication extends Application {

    private static final Logger logger = LogManager.getLogger(MainApplication.class);

    @Override
    public void start(Stage stage) throws IOException {

        System.setProperty("log4j.configurationFile", "log4j2.xml");
        logger.info("JavaFX application started.");

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        scene.getStylesheets().add("/css/Style.css");
        stage.setTitle("Student Application Portal - By Team SuperSonic");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}