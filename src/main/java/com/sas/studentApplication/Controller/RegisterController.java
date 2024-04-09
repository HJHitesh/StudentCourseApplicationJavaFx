package com.sas.studentApplication.Controller;

import com.sas.studentApplication.Config.DBConstantUtil;
import com.sas.studentApplication.Config.UserSession;
import com.sas.studentApplication.DOA.ApplicationDetailDOA;
import com.sas.studentApplication.DOA.ApplicationDetailDoaImpl;
import com.sas.studentApplication.DTO.ApplicationDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

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
    public TextField appIdTextField;

    @FXML
    private Button onRegistrationSubmit;

    @FXML
    private Button approveButton;

    @FXML
    private Button rejectedButton;

    private Parent dashboardRoot;
    private DashboardController dashboardController;

    private ApplicationDetailDOA applicationDetailDOA = new ApplicationDetailDoaImpl();

    ObservableList<String> programChoices = FXCollections.observableArrayList("IT","COMP","MECH");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        myProgramChoice.setItems(programChoices);
        myProgramChoice.setValue("IT");
        appIdTextField.clear();


            approveButton.setVisible(false);
            rejectedButton.setVisible(false);

    }

    public void onSubmit() throws IOException {

        String fullName = fullNameTextFeild.getText();
        String userName = userNameTextFeild.getText();
        String password = passwordTexField.getText();
        String emailId = emailIdTextFeild.getText();
        String phoneNumber = phoneNoTextField.getText();
        String programEnrolled = myProgramChoice.getValue();

        // Create an instance of ApplicationDetail and set its properties
        ApplicationDetail applicationDetail = new ApplicationDetail();
        if(!appIdTextField.getText().isEmpty()){
            applicationDetail.setAppId(Integer.parseInt(appIdTextField.getText()));
        }
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
            // Load the dashboard.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sas/studentApplication/dashboard.fxml"));
            Parent dashboardRoot = loader.load();

            DashboardController dashboardController = loader.getController();
            dashboardController.settingtheViewReport();
            // Get the current scene
            Scene scene = fullNameTextFeild.getScene();
            scene.setRoot(dashboardRoot);

        }else{
            System.out.println("Successfully unsuccessfull");
        }
    }

    public void settingValueForEdit(ApplicationDetail appData) {

        if (appData != null) {
            // Auto-populate values from the ApplicationDetail object to text fields
            if (fullNameTextFeild != null) fullNameTextFeild.setText(appData.getFullName());
            if (userNameTextFeild != null) userNameTextFeild.setText(appData.getUserName());
            if (passwordTexField != null) passwordTexField.setText(appData.getPassword());
            if (emailIdTextFeild != null) emailIdTextFeild.setText(appData.getEmailId());
            if (phoneNoTextField != null) phoneNoTextField.setText(appData.getPhoneNumber());
            if (myProgramChoice != null) myProgramChoice.setValue(appData.getProgramChoice());
            appIdTextField.setText(String.valueOf(appData.getAppId()));

            if(!UserSession.getInstance(null,0,null,null).getRole().equals("USER")) {
                approveButton.setVisible(true);
                rejectedButton.setVisible(true);
            }
        } else {
            System.err.println("Null ApplicationDetail provided for editing.");
        }

    }

    public void onApprove() throws IOException {

            String fullName = fullNameTextFeild.getText();
            String userName = userNameTextFeild.getText();
            String password = passwordTexField.getText();
            String emailId = emailIdTextFeild.getText();
            String phoneNumber = phoneNoTextField.getText();
            String programEnrolled = myProgramChoice.getValue();

            // Create an instance of ApplicationDetail and set its properties
            ApplicationDetail applicationDetail = new ApplicationDetail();
            if(!appIdTextField.getText().isEmpty()){
                applicationDetail.setAppId(Integer.parseInt(appIdTextField.getText()));
            }
            applicationDetail.setFullName(fullName);
            applicationDetail.setUserId(UserSession.getInstance(null,0,null,null).getUserId());
            applicationDetail.setUserName(userName);
            applicationDetail.setPassword(password);
            applicationDetail.setEmailId(emailId);
            applicationDetail.setPhoneNumber(phoneNumber);
            applicationDetail.setProgramChoice(programEnrolled);
            applicationDetail.setStatus(DBConstantUtil.ApplicationDetailStatus.APPROVED.getValue()); // Set default status
            applicationDetail.setCreatedBy(1); // Set default createdBy
            applicationDetail.setCreatedOn(new Date()); // Set current timestamp
            applicationDetail.setModifiedBy(1); // Set default createdBy
            applicationDetail.setModifiedOn(new Date()); // Set current timestamp

            boolean value = applicationDetailDOA.save(applicationDetail);

            if(value){
                System.out.println("Successfully save");
                // Load the dashboard.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sas/studentApplication/dashboard.fxml"));
                Parent dashboardRoot = loader.load();

                DashboardController dashboardController = loader.getController();
                dashboardController.settingtheViewReport();
                // Get the current scene
                Scene scene = fullNameTextFeild.getScene();
                scene.setRoot(dashboardRoot);

            }else{
                System.out.println("Successfully unsuccessfull");
            }
        }

    public void onRejected() throws IOException {

        String fullName = fullNameTextFeild.getText();
        String userName = userNameTextFeild.getText();
        String password = passwordTexField.getText();
        String emailId = emailIdTextFeild.getText();
        String phoneNumber = phoneNoTextField.getText();
        String programEnrolled = myProgramChoice.getValue();

        // Create an instance of ApplicationDetail and set its properties
        ApplicationDetail applicationDetail = new ApplicationDetail();
        if(!appIdTextField.getText().isEmpty()){
            applicationDetail.setAppId(Integer.parseInt(appIdTextField.getText()));
        }
        applicationDetail.setFullName(fullName);
        applicationDetail.setUserId(UserSession.getInstance(null,0,null,null).getUserId());
        applicationDetail.setUserName(userName);
        applicationDetail.setPassword(password);
        applicationDetail.setEmailId(emailId);
        applicationDetail.setPhoneNumber(phoneNumber);
        applicationDetail.setProgramChoice(programEnrolled);
        applicationDetail.setStatus(DBConstantUtil.ApplicationDetailStatus.REJECTED.getValue()); // Set default status
        applicationDetail.setCreatedBy(1); // Set default createdBy
        applicationDetail.setCreatedOn(new Date()); // Set current timestamp
        applicationDetail.setModifiedBy(1); // Set default createdBy
        applicationDetail.setModifiedOn(new Date()); // Set current timestamp

        boolean value = applicationDetailDOA.save(applicationDetail);

        if(value){
            System.out.println("Successfully save");
            // Load the dashboard.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sas/studentApplication/dashboard.fxml"));
            Parent dashboardRoot = loader.load();

            DashboardController dashboardController = loader.getController();
            dashboardController.settingtheViewReport();
            // Get the current scene
            Scene scene = fullNameTextFeild.getScene();
            scene.setRoot(dashboardRoot);

        }else{
            System.out.println("Successfully unsuccessfull");
        }
    }
}
