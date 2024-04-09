package com.sas.studentApplication.Controller;

import com.sas.studentApplication.Config.UserSession;
import com.sas.studentApplication.DOA.UserDOA;
import com.sas.studentApplication.DOA.UserDoaImpl;
import com.sas.studentApplication.DTO.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Set;
import java.util.*;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private ImageView lockImageView;

    @FXML
    private TextField textFeildUsername;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    private UserDOA userDao = new UserDoaImpl();

    @FXML
    private HBox hBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        //Main image
        File brandingFile = new File("Images/art-colorful-contemporary-2047905_dxtao7.jpg");
        Image brandingImage = null;
        try {
            brandingImage = new Image(brandingFile.toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        brandingImageView.setImage(brandingImage);

        //lock image
        File lockFile = new File("Images/icons8-lock-64.png");
        Image lockImage = null;
        try {
            lockImage = new Image(lockFile.toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        lockImageView.setImage(lockImage);

    }

    public void loginButtonOnAction(ActionEvent event){
        if(textFeildUsername.getText().isBlank() == false && passwordField.getText().isBlank() == false){
            validateLogin();
        }else{
            loginMessageLabel.setText(" You have to enter UserName and Password");
        }

    }

    public void validateLogin(){
        String username = textFeildUsername.getText();
        String password = passwordField.getText();

        User user = userDao.validateUser(username, password);
        if (user != null) {
            //Setting the login for the user
            // Create user session
            Set<String> privileges = new HashSet<>();
            privileges.add("READ");
            privileges.add("WRITE");

            UserSession userSession = UserSession.getInstance(user.getUserName(),user.getId(),user.getRole(), privileges);

            // Retrieve user information
            System.out.println("Username: " + userSession.getUserName());
            System.out.println("Username Id: " + userSession.getUserId());
            System.out.println("User Role: " + userSession.getRole());
            System.out.println("Privileges: " + userSession.getPriviledges());

            switchToDashboardScene();
        } else {
            loginMessageLabel.setText("Invalid Login");
        }
    }

    public void switchToDashboardScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sas/studentApplication/dashboard.fxml"));
            Parent root = loader.load();

            // Get the controller instance
            DashboardController dashboardController = loader.getController();
            dashboardController.initialize(null,null);

            Scene dashboardScene = new Scene(root);
            Stage stage = (Stage) loginButton.getScene().getWindow(); // Assuming loginButton is a node in Login.fxml
            stage.setScene(dashboardScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}