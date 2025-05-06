package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import com.example.demo.models.Breed;
import com.example.demo.models.Data;
import com.example.demo.models.Pet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PetControl extends AnchorPane {
    public Supplier<Void> listener;
    public PetControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "pet_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private GridPane petControlGrid;

    @FXML
    private ImageView petControlPhoto;

    @FXML
    private Text petControlText1;

    @FXML
    private Text petControlText2;

    @FXML
    private Text petControlText3;
    @FXML
    private Button petControlEditButton;
    @FXML
    private Button petControlDeleteButton;
    private Pet newPet;
    private Breed remindBreed;

    public void setData(Pet pet, Breed breed){
        newPet = pet;
        remindBreed = breed;
        petControlGrid.getChildren().removeIf(node -> {
            Integer row = GridPane.getRowIndex(node);
            return row!= null &&row>0;

        });
        petControlPhoto.setImage(pet.photo);
        petControlText1.setText(pet.name+"\n"+pet.type+"\n"+pet.breed);
        petControlText2.setText(pet.color+"\n"+pet.dateBorn+"\n"+pet.dateVisit);
        petControlText3.setText(String.join("\n",pet.vaccinations));
    }
    @FXML
    void initialize() {
        petControlEditButton.setOnAction(event  -> {
            try {
                this.handleButtonEdit(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        petControlDeleteButton.setOnAction(event  -> {
            try {
                this.delete(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void handleButtonEdit(ActionEvent event) throws IOException {

        Stage stage = (Stage) petControlEditButton.getScene().getWindow();
        // do what you have to do


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("edit_pet.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        fxmlLoader.<EditPet>getController().setData(newPet);
        Stage stage1 = new Stage();
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.setTitle("Редактировать");
        stage1.setScene(new Scene(root1));
        stage1.showAndWait();
        this.setData(newPet,remindBreed);

    }
    @FXML
    private void delete(ActionEvent event) throws IOException {
        Data.removePet(remindBreed,newPet);
        this.listener.get();
    }

    public void setOnRemove(Supplier<Void> listener) {
        this.listener = listener;
    }
}
