package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.models.Breed;
import com.example.demo.models.Data;
import com.example.demo.models.Pet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditBreed {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField editBreedDescription;
    @FXML
    private TextField editBreedName;


    private Breed newBreed;

    @FXML
    private Button editBreedOkButton;
    public void setData(Breed breed){
        newBreed = breed;
        editBreedDescription.setText(breed.description);
    }

    @FXML
    void initialize() {
        assert editBreedDescription != null : "fx:id=\"editBreedDescription\" was not injected: check your FXML file 'edit_breed.fxml'.";

        assert editBreedOkButton != null : "fx:id=\"editBreedOkButton\" was not injected: check your FXML file 'edit_breed.fxml'.";
        editBreedOkButton.setOnAction(event  -> {
            try {
                this.okButton(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void okButton(ActionEvent event) throws IOException {
        if(editBreedName.getText().matches(".*\\d.*")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Невалидные данные");
            a.show();
        }
        else{
        newBreed.name = editBreedName.getText();
        newBreed.description = editBreedDescription.getText();
        Data.updateBreed(newBreed);
        Stage stage = (Stage) editBreedDescription.getScene().getWindow();
        stage.close();}
    }
}
