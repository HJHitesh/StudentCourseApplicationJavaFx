package com.sas.studentApplication.Controller;

import com.sas.studentApplication.DOA.UserDOA;
import com.sas.studentApplication.DOA.UserDoaImpl;
import com.sas.studentApplication.DTO.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUserController implements Initializable {

    @FXML
    private Button AddButton;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userNameTextField;

    ObservableList<String> roleChoices = FXCollections.observableArrayList("REGISTAR","USER");

    @FXML
    private ChoiceBox<String> roleChoice;

    @FXML
    private Label responseMessage;

    private UserDOA userDao = new UserDoaImpl();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        //Setting the Check box
        roleChoice.setItems(roleChoices);
        roleChoice.setValue("USER");
        responseMessage.setVisible(false);
    }
    @FXML
    void onAddButtonClick(ActionEvent event) {

        String userName = userNameTextField.getText();
        String password = passwordField.getText();
        String role = roleChoice.getValue();

        User newUser = new User();
        newUser.setPassword(password);
        newUser.setUserName(userName);
        newUser.setRole(role);
        newUser.setStatus("ACTIVE");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        newUser.setCreatedOn(now.format(formatter));
        newUser.setUpdateOn(newUser.getCreatedOn());
        newUser.setCreatedBy(1);

        // Call the save method of UserDao to save the user
        boolean value = userDao.save(newUser);

        if(value){
            responseMessage.setText("Successfully added");
            responseMessage.setVisible(true);
        }else{
            responseMessage.setText("Operation Fail");
            responseMessage.setVisible(true);
        }



        userNameTextField.clear();
        passwordField.clear();
        userNameTextField.clear();

    }

}
