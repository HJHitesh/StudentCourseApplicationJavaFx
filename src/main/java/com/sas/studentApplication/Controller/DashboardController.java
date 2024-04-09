package com.sas.studentApplication.Controller;

import com.sas.studentApplication.Config.UserSession;
import com.sas.studentApplication.DTO.ApplicationDetail;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    @FXML
    private ImageView adminImageView;

    @FXML
    private ImageView logoutImageView;

    @FXML
    private ImageView registerImageView;

    @FXML
    private ImageView viewReportImageView;

    @FXML
    private ImageView editImageView;

    @FXML
    private ImageView registerImageView1;

    @FXML
    private ImageView viewReportImageView1;

    @FXML
    private ImageView editImageView1;

    @FXML
    private VBox statusDiv;

    @FXML
    private HBox addUserHbox;

    @FXML
    BorderPane borderPane;

    @FXML
    Label registerLabel ;

    @FXML
    Label userloginLabel;

    private AnchorPane viewpane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        // Load images for adminImageView
        File adminFile = new File("Images/icon-person.png");
        Image adminImage = new Image(adminFile.toURI().toString());
        adminImageView.setImage(adminImage);

        // Load images for logoutImageView
        File logoutFile = new File("Images/log-out.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutImageView.setImage(logoutImage);

        // Repeat similar steps for other ImageViews
        // Load images for registerImageView
        File registerFile = new File("Images/register.png");
        Image registerImage = new Image(registerFile.toURI().toString());
        registerImageView.setImage(registerImage);

        // Load images for viewReportImageView
        File viewReportFile = new File("Images/analysis.png");
        Image viewReportImage = new Image(viewReportFile.toURI().toString());
        viewReportImageView.setImage(viewReportImage);

        // Load images for editImageView
        File editFile = new File("Images/status.png");
        Image editImage = new Image(editFile.toURI().toString());
        editImageView.setImage(editImage);

        // Repeat similar steps for other ImageViews
        // Load images for registerImageView
        File registerFile1 = new File("Images/register.png");
        Image registerImage1 = new Image(registerFile1.toURI().toString());
        registerImageView1.setImage(registerImage1);

        // Load images for viewReportImageView
        File viewReportFile1 = new File("Images/analysis.png");
        Image viewReportImage1 = new Image(viewReportFile1.toURI().toString());
        viewReportImageView1.setImage(viewReportImage1);

        // Load images for editImageView
        File editFile1 = new File("Images/status.png");
        Image editImage1 = new Image(editFile1.toURI().toString());
        editImageView1.setImage(editImage1);


        if (UserSession.getInstance(null,0,null,null).getRole().equals("USER")) {
            statusDiv.setVisible(false); // Hide the rejected elements
            addUserHbox.setVisible(false);
            //setting userName
            String userName = UserSession.getInstance(null,0,null,null).getUserName();

            userloginLabel.setText(userName);

        }else{
            statusDiv.setVisible(true);
            addUserHbox.setVisible(true);
        }

        String userName = UserSession.getInstance(null,0,null,null).getUserName();

        userloginLabel.setText(userName);


    }

    public AnchorPane switchToDashboardScene(String filename) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sas/studentApplication/"+filename+".fxml"));
            viewpane = loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return viewpane;
    }

    @FXML
    public void handleRegisterClick(MouseEvent event) {
        System.out.println("You have clicked Register!");
        AnchorPane pane = this.switchToDashboardScene("register");
        borderPane.setCenter(pane);
    }

    @FXML
    public void onClickAddUser(MouseEvent event) {
        System.out.println("You have clicked Add User!");
        AnchorPane pane = this.switchToDashboardScene("AddUser");
        borderPane.setCenter(pane);
    }

    @FXML
    public void handleViewReportClick(MouseEvent event) {
        System.out.println("You have clicked View Report!");
        AnchorPane pane = this.switchToDashboardScene("view_report");
        borderPane.setCenter(pane);
    }

    public void settingRegisterSceneForEdit(ApplicationDetail appData) {
        System.out.println("You have clicked Register!");
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(getClass().getResource("/com/sas/studentApplication/register.fxml"));
            viewpane = loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        borderPane.setCenter(viewpane);

        // Retrieve the controller associated with the loaded FXML file
        RegisterController registerController = (RegisterController) loader.getController();

        // Call the method on the controller
        registerController.settingValueForEdit(appData);

    }

    public void settingtheViewReport() {
        System.out.println("You have clicked Register!");
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(getClass().getResource("/com/sas/studentApplication/view_report.fxml"));
            viewpane = loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        borderPane.setCenter(viewpane);
    }

    @FXML
    public void handleLogoutClick(MouseEvent event) {
        System.out.println("You have clicked Logout!");
        UserSession.clearSession();
        try {
            // Load the login scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sas/studentApplication/login.fxml"));
            Parent root = loader.load();

            // Get the scene and stage from the borderPane
            Scene scene = borderPane.getScene();
            Stage stage = (Stage) scene.getWindow();

            // Set the login scene as the root of the stage
            scene.setRoot(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }









}
