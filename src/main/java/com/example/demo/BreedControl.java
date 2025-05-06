package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import com.example.demo.models.Breed;
import com.example.demo.models.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BreedControl extends AnchorPane {
    public Supplier<Void> listener;

    @FXML
    private ResourceBundle resources;
    @FXML
    private GridPane breedControlGrid;
    @FXML
    private URL location;
    @FXML
    private Text breedControlTextLeft;

    @FXML
    private Text breedControlTextRight;
    @FXML
    private Button breedControlEditButton;
    @FXML
    private Button breedControlDeleteButton;
    public Breed newBreed;

    public BreedControl() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "breed_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public Void setData(Breed data) {
        newBreed = data;
        breedControlGrid.getChildren().removeIf(node -> {
            Integer row = GridPane.getRowIndex(node);
            return row!= null &&row>0;

        });
        breedControlTextLeft.setText(data.name);
        breedControlTextRight.setText(data.description);
        for (int i = 0;i<data.pets.size();i++){
            PetControl pet = new PetControl();
            pet.setOnRemove(() -> this.setData(newBreed));
            pet.setData(data.pets.get(i),data);
            breedControlGrid.addRow(i+1, pet);
        }

        return null;
    }

    @FXML
    void initialize() {
        breedControlEditButton.setOnAction(event  -> {
            try {
                this.handleButtonEdit(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        breedControlDeleteButton.setOnAction(event  -> {
            try {
                this.deleteBreed(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void handleButtonEdit(ActionEvent event) throws IOException {

        Stage stage = (Stage) breedControlEditButton.getScene().getWindow();
        // do what you have to do


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("edit_breed.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        fxmlLoader.<EditBreed>getController().setData(newBreed);
        Stage stage1 = new Stage();
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.setTitle("Редактировать");
        stage1.setScene(new Scene(root1));
        stage1.showAndWait();
        this.setData(newBreed);

    }
    @FXML
    private void deleteBreed(ActionEvent event) throws IOException {
        Data.removeBreed(newBreed);
        this.listener.get();
    }
    public void setOnRemove(Supplier<Void> listener) {
        this.listener = listener;
    }
}
