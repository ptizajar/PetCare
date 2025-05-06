package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class HelloController extends Application {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1512, 982);
        stage.setTitle("PetCare");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button helloEnter;

    @FXML
    private Button helloRegistration;

    @FXML
    void initialize() {
        assert helloEnter != null : "fx:id=\"helloEnter\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert helloRegistration != null : "fx:id=\"helloRegistration\" was not injected: check your FXML file 'hello-view.fxml'.";
        helloEnter.setOnAction(event  -> {
            try {
                this.handleButtonAction(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        helloRegistration.setOnAction(event  -> {
            try {
                this.handleButtonActionAnotherForm(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML public void handleButtonAction(ActionEvent click) throws IOException {
        //Close current
        Stage stage = (Stage) helloEnter.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("enter.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Вход");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    public void handleButtonActionAnotherForm(ActionEvent event) throws IOException {
        Stage stage = (Stage) helloRegistration.getScene().getWindow();
        // do what you have to do
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.setTitle("Регистрация");
        stage1.setScene(new Scene(root1));
        stage1.show();

    }
;}
