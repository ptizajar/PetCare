package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.demo.models.Breed;
import com.example.demo.models.Data;
import com.example.demo.models.Pet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddBreed {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addBreedName;

    @FXML
    private Button addBreedOK;

    @FXML
    private TextField addBreedDescription;

    @FXML
    void initialize() {
        assert addBreedName != null : "fx:id=\"addBreedName\" was not injected: check your FXML file 'add_breed.fxml'.";
        assert addBreedOK != null : "fx:id=\"addBreedOK\" was not injected: check your FXML file 'add_breed.fxml'.";
        assert addBreedDescription != null : "fx:id=\"addPetDescription\" was not injected: check your FXML file 'add_breed.fxml'.";
        addBreedOK.setOnAction(event  -> {
            try {
                this.handleButton(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void handleButton(ActionEvent event) throws IOException {
        if(addBreedName.getText().matches(".*\\d.*")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Невалидные данные");
            a.show();
        }
        else{
            ObservableList<Pet> _pets = FXCollections.observableArrayList();
            Breed newBreed = new Breed(addBreedName.getText(),addBreedDescription.getText(),_pets);
            Data.addBreed(newBreed);
            Stage stage = (Stage) addBreedOK.getScene().getWindow();
            stage.close();
        }

    }
}
