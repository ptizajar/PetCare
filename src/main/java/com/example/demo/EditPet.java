package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.demo.models.Breed;
import com.example.demo.models.Data;
import com.example.demo.models.Pet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditPet {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker editPetDateVet;

    @FXML
    private Button editPetOkButton;

    @FXML
    private TextField editPetVaccinations;
    private Pet newPet;

    public void setData(Pet pet){
        newPet = pet;
        LocalDate dt = LocalDate.parse(pet.dateVisit);
        editPetDateVet.setValue(dt);
        String vaccinationsText = String.join(", ", pet.vaccinations);
        editPetVaccinations.setText(vaccinationsText);
    }
    @FXML
    void initialize() {
        assert editPetDateVet != null : "fx:id=\"editPetDateVet\" was not injected: check your FXML file 'edit_pet.fxml'.";
        assert editPetOkButton != null : "fx:id=\"editPetOkButton\" was not injected: check your FXML file 'edit_pet.fxml'.";
        assert editPetVaccinations != null : "fx:id=\"editPetVaccinations\" was not injected: check your FXML file 'edit_pet.fxml'.";
        editPetOkButton.setOnAction(event  -> {
            try {
                this.okButton(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void okButton(ActionEvent event) throws IOException {
        newPet.dateVisit = editPetDateVet.getValue().toString();
        String[] vacText = editPetVaccinations.getText().split(",");
        newPet.vaccinations = vacText;
        Data.updatePet(newPet);
        Stage stage = (Stage) editPetVaccinations.getScene().getWindow();
        stage.close();
    }
}
