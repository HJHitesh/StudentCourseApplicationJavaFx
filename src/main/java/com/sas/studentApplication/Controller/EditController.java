package com.sas.studentApplication.Controller;

import com.sas.studentApplication.Config.DBConstantUtil;
import com.sas.studentApplication.Config.UserSession;
import com.sas.studentApplication.DOA.ApplicationDetailDOA;
import com.sas.studentApplication.DOA.ApplicationDetailDoaImpl;
import com.sas.studentApplication.DTO.ApplicationDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class EditController implements Initializable {

    @FXML
        private ChoiceBox<String> myProgramChoice;

    @FXML
    private TextField emailIdTextFeild;

    @FXML
    private TextField fullNameTextFeild;

    @FXML
    private TextField passwordTexField;

    @FXML
    private TextField phoneNoTextField;

    @FXML
    private TextField userNameTextFeild;

    @FXML
    private Button onRegistrationSubmit;

    private ApplicationDetailDOA applicationDetailDOA = new ApplicationDetailDoaImpl();

    ObservableList<String> programChoices = FXCollections.observableArrayList("IT","COMP","MECH");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        myProgramChoice.setItems(programChoices);
        myProgramChoice.setValue("IT");
    }



    public void onSubmit(){

        String fullName = fullNameTextFeild.getText();
        String userName = userNameTextFeild.getText();
        String password = passwordTexField.getText();
        String emailId = emailIdTextFeild.getText();
        String phoneNumber = phoneNoTextField.getText();
        String programEnrolled = myProgramChoice.getValue();

        // Create an instance of ApplicationDetail and set its properties
        ApplicationDetail applicationDetail = new ApplicationDetail();
        applicationDetail.setFullName(fullName);
        applicationDetail.setUserId(UserSession.getInstance(null,0,null,null).getUserId());
        applicationDetail.setUserName(userName);
        applicationDetail.setPassword(password);
        applicationDetail.setEmailId(emailId);
        applicationDetail.setPhoneNumber(phoneNumber);
        applicationDetail.setProgramChoice(programEnrolled);
        applicationDetail.setStatus(DBConstantUtil.ApplicationDetailStatus.PENDING.getValue()); // Set default status
        applicationDetail.setCreatedBy(1); // Set default createdBy
        applicationDetail.setCreatedOn(new Date()); // Set current timestamp
        applicationDetail.setModifiedBy(1); // Set default createdBy
        applicationDetail.setModifiedOn(new Date()); // Set current timestamp

        boolean value = applicationDetailDOA.save(applicationDetail);

        if(value){

            System.out.println("Successfully save");

        }else{
            System.out.println("Successfully unsuccessfull");
        }
    }
}
