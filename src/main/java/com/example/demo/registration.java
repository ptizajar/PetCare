package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.models.Data;
import com.example.demo.models.Owners;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class registration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField registrationEmailField;

    @FXML
    private TextField registrationLoginField;

    @FXML
    private TextField registrationNameField;

    @FXML
    private PasswordField registrationPasswordField;

    @FXML
    private Button registrationRegistrationButton;

    @FXML
    void initialize() {
        assert registrationEmailField != null : "fx:id=\"registrationEmailField\" was not injected: check your FXML file 'registration.fxml'.";
        assert registrationLoginField != null : "fx:id=\"registrationLoginField\" was not injected: check your FXML file 'registration.fxml'.";
        assert registrationNameField != null : "fx:id=\"registrationNameField\" was not injected: check your FXML file 'registration.fxml'.";
        assert registrationPasswordField != null : "fx:id=\"registrationPasswordField\" was not injected: check your FXML file 'registration.fxml'.";
        assert registrationRegistrationButton != null : "fx:id=\"registrationRegistrationButton\" was not injected: check your FXML file 'registration.fxml'.";
        registrationRegistrationButton.setOnAction(event  -> {
            try {
                this.handleButtonAction(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Pattern p = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(registrationEmailField.getText());
        if(registrationNameField.getText().matches(".*\\d.*") | !(m.find())){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Невалидные данные");
            a.show();
        }
        else {
            Owners u = new Owners(registrationNameField.getText(),registrationLoginField.getText(),registrationPasswordField.getText(),registrationEmailField.getText());
            try {
                Data.registrate(u);
                Stage stage = (Stage) registrationRegistrationButton.getScene().getWindow();
                // do what you have to do
                stage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-page.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage1 = new Stage();
                stage1.initModality(Modality.APPLICATION_MODAL);
                stage1.setTitle("Главная");
                stage1.setScene(new Scene(root1));
                stage1.show();
            }
            catch (Exception e){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(e.getMessage());
                a.show();
            }



    }

    }}



