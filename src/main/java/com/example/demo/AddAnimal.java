package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.demo.models.Breed;
import com.example.demo.models.Data;
import com.example.demo.models.Pet;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AddAnimal {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView AddPetPhotoField;

    @FXML
    private ComboBox<Breed> addPetBreed;

    @FXML
    private TextField addPetColor;

    @FXML
    private DatePicker addPetDateBorn;

    @FXML
    private DatePicker addPetDateVet;

    @FXML
    private TextField addPetName;

    @FXML
    private Button addPetOkButton;

    @FXML
    private Button addPetPhotoButton;

    @FXML
    private TextField addPetType;

    @FXML
    private TextField addPetVaccinations;

    @FXML
    void initialize() {
        assert AddPetPhotoField != null : "fx:id=\"AddPetPhotoField\" was not injected: check your FXML file 'add_animal.fxml'.";
        assert addPetBreed != null : "fx:id=\"addPetBreed\" was not injected: check your FXML file 'add_animal.fxml'.";
        assert addPetColor != null : "fx:id=\"addPetColor\" was not injected: check your FXML file 'add_animal.fxml'.";
        assert addPetDateBorn != null : "fx:id=\"addPetDateBorn\" was not injected: check your FXML file 'add_animal.fxml'.";
        assert addPetDateVet != null : "fx:id=\"addPetDateVet\" was not injected: check your FXML file 'add_animal.fxml'.";
        assert addPetName != null : "fx:id=\"addPetName\" was not injected: check your FXML file 'add_animal.fxml'.";
        assert addPetOkButton != null : "fx:id=\"addPetOkButton\" was not injected: check your FXML file 'add_animal.fxml'.";
        assert addPetPhotoButton != null : "fx:id=\"addPetPhotoButton\" was not injected: check your FXML file 'add_animal.fxml'.";
        assert addPetType != null : "fx:id=\"addPetType\" was not injected: check your FXML file 'add_animal.fxml'.";
        assert addPetVaccinations != null : "fx:id=\"addPetVaccinations\" was not injected: check your FXML file 'add_animal.fxml'.";
        addPetBreed.setItems(Data.getBreeds());
        addPetOkButton.setOnAction(event  -> {
            try {
                this.handleButton(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        addPetPhotoButton.setOnAction(event  -> {
            try {
                this.addPhoto(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void handleButton(ActionEvent event) throws IOException {
        if(addPetName.getText().matches(".*\\d.*") | addPetType.getText().matches(".*\\d.*") |addPetColor.getText().matches(".*\\d.*")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Невалидные данные");
            a.show();
        }
        else{

        Pet newPet = new Pet(addPetName.getText(),addPetType.getText(),addPetBreed.getSelectionModel().getSelectedItem().toString(), addPetColor.getText(),
                 localDateToDate(addPetDateBorn.getValue()), localDateToDate(addPetDateVet.getValue()),addPetVaccinations.getText().split(","), AddPetPhotoField.getImage());
        //Data._pets.add(newPet);
       Data.addPet(addPetBreed.getValue(),newPet);
        Stage stage = (Stage) addPetOkButton.getScene().getWindow();
        stage.close();}
    }

    @FXML
    private void addPhoto(ActionEvent event) throws IOException{
       Window stage = (Window) addPetPhotoButton.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        Image image = new Image(selectedFile.toURI().toString());

        AddPetPhotoField.setImage(image);

    }
    private static String localDateToDate(LocalDate localDate){
        final String format = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        formatter.format(localDate);
        return localDate.format(formatter);
    }
    }


