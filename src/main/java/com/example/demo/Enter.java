package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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

public class Enter {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterButtonEnter;

    @FXML
    private TextField enterLoginField;

    @FXML
    private PasswordField enterPasswordField;

    @FXML
    void initialize() {
        assert enterButtonEnter != null : "fx:id=\"enterButtonEnter\" was not injected: check your FXML file 'enter.fxml'.";
        assert enterLoginField != null : "fx:id=\"enterLoginField\" was not injected: check your FXML file 'enter.fxml'.";
        assert enterPasswordField != null : "fx:id=\"enterPasswordField\" was not injected: check your FXML file 'enter.fxml'.";
        enterButtonEnter.setOnAction(event  -> {
            try {
                this.handleButtonActionAnotherForm(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void handleButtonActionAnotherForm(ActionEvent event) throws IOException {
        String login = enterLoginField.getText();
        String password = enterPasswordField.getText();
        try {
            Data.logining(login,password);
            Stage stage = (Stage) enterButtonEnter.getScene().getWindow();
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
}
