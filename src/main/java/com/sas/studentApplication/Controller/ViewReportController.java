package com.sas.studentApplication.Controller;

import com.sas.studentApplication.Config.UserSession;
import com.sas.studentApplication.DOA.ApplicationDetailDOA;
import com.sas.studentApplication.DOA.ApplicationDetailDoaImpl;
import com.sas.studentApplication.DTO.ApplicationDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewReportController implements Initializable {

    @FXML
    private TableView<ApplicationDetail> reportTableView;

    @FXML
    private TableColumn<ApplicationDetail, Integer> appIdColumn;

    @FXML
    private TableColumn<ApplicationDetail, String> fullNameColumn;

    @FXML
    private TableColumn<ApplicationDetail, String> phoneNoColumn;

    @FXML
    private TableColumn<ApplicationDetail, String> emailColumn;

    @FXML
    private TableColumn<ApplicationDetail, String> programColumn;

    @FXML
    private TableColumn<ApplicationDetail, String> statusColumn;

    @FXML
    private Button onEditButton;

    ObservableList<ApplicationDetail> applicationDetailsList;

    ApplicationDetailDOA applicationDetailDOA = new ApplicationDetailDoaImpl();

    private AnchorPane rootPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appIdColumn.setCellValueFactory(new PropertyValueFactory<>("appId"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phoneNoColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("emailId"));
        programColumn.setCellValueFactory(new PropertyValueFactory<>("programChoice"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Initialize the applicationDetailsList
        applicationDetailsList = FXCollections.observableArrayList();

        loadTheApplication();
    }

    @FXML
    private void loadTheApplication(){

        List<ApplicationDetail> applicationDetailList = new ArrayList<>();
        //Clear the list to load the data again
        if(!applicationDetailsList.isEmpty()){
            applicationDetailsList.clear();
        }

        applicationDetailDOA.getAllApplicationDetails();

        if(UserSession.getInstance(null,0,null,null).getRole().equals("USER")){
            int userId = UserSession.getInstance(null,0,null,null).getUserId();
            applicationDetailList = applicationDetailDOA.getApplicationDetailsByUserId(userId);
        }else{
            // Retrieve the list of ApplicationDetail objects from the DAO
            applicationDetailList = applicationDetailDOA.getAllApplicationDetails();
        }


        if (applicationDetailList != null) {
            // Adding  all retrieved ApplicationDetail objects to the observable list
            applicationDetailsList.addAll(applicationDetailList);
            // Set the items of the TableView to the observable list
            reportTableView.setItems(applicationDetailsList);
        } else {
            System.err.println("Failed to retrieve application details from the database.");
        }
    }

    public void onEditClick(ActionEvent actionEvent) throws IOException {
       ApplicationDetail appData = reportTableView.getSelectionModel().getSelectedItem();
        if (appData != null) {
            // Print or perform actions with the selected ApplicationDetail object
            System.out.println("Selected ApplicationDetail: " + appData.toString());
            System.out.println("You have clicked View Report!");
            // Load the dashboard.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sas/studentApplication/dashboard.fxml"));
            Parent dashboardRoot = loader.load();

            // Get the controller instance from the FXMLLoader
            DashboardController dashboardController = loader.getController();

            // Call a method of the DashboardController
            dashboardController.settingRegisterSceneForEdit(appData);

            // Get the scene from the current window
            Scene scene = ((Node) actionEvent.getSource()).getScene();

            // Set the dashboardRoot as the content of the scene
            scene.setRoot(dashboardRoot);



        } else {
            // If no row is selected, display a message or perform other actions
            System.out.println("No row selected.");
        }
    }

}
