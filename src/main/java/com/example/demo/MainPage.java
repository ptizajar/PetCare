package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.models.Breed;
import com.example.demo.models.Data;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainPage implements Initializable {





    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button mainAddBreed;

    @FXML
    private Button mainAddPet;

    @FXML
    private Button mainReports;

    @FXML
    private Button mainSettings;

    @FXML
    private GridPane maneGrid;

public Void setData(){
    maneGrid.getChildren().removeIf(node -> GridPane.getRowIndex(node) >= 0);
    ObservableList<Breed> breeds = Data.getBreeds();
    for(int i = 0; i< breeds.size(); i++){
        BreedControl breed = new BreedControl();
        breed.setData(breeds.get(i));
        breed.setOnRemove(() -> this.setData());
        maneGrid.addRow(i, breed);
    }
    return null;
}

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert mainAddBreed != null : "fx:id=\"mainAddBreed\" was not injected: check your FXML file 'main-page.fxml'.";
        assert mainAddPet != null : "fx:id=\"mainAddPet\" was not injected: check your FXML file 'main-page.fxml'.";
        assert mainReports != null : "fx:id=\"mainReports\" was not injected: check your FXML file 'main-page.fxml'.";
        assert mainSettings != null : "fx:id=\"mainSettings\" was not injected: check your FXML file 'main-page.fxml'.";
        assert maneGrid != null : "fx:id=\"maneGrid\" was not injected: check your FXML file 'main-page.fxml'.";

       setData();
        mainAddPet.setOnAction(event  -> {
            try {
                this.handleButtonAddPet(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        mainAddBreed.setOnAction(event  -> {
            try {
                this.handleButtonAddBreed(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        mainReports.setOnAction(event  -> {
            try {
                this.handleButtonReports(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        mainSettings.setOnAction(event  -> {
            try {
                this.handleButtonLanguage(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void handleButtonAddPet(ActionEvent event) throws IOException {

        Stage stage = (Stage) mainAddPet.getScene().getWindow();
        // do what you have to do


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_animal.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.setTitle("Добавить питомца");
        stage1.setScene(new Scene(root1));
        stage1.showAndWait();
        setData();

    }

    @FXML
    private void handleButtonAddBreed(ActionEvent event) throws IOException {

        Stage stage = (Stage) mainAddBreed.getScene().getWindow();
        // do what you have to do


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_breed.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.setTitle("Добавить породу");
        stage1.setScene(new Scene(root1));
        stage1.showAndWait();
        setData();
    }

    @FXML
    private void handleButtonReports(ActionEvent event) throws IOException {

        Stage stage = (Stage) mainAddBreed.getScene().getWindow();
        // do what you have to do
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reports.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.setTitle("Отчёты");
        stage1.setScene(new Scene(root1));
        stage1.show();

    }

    @FXML
    private void handleButtonLanguage(ActionEvent event) throws IOException {

        Stage stage = (Stage) mainSettings.getScene().getWindow();
        // do what you have to do


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("language.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.setTitle("Язык");
        stage1.setScene(new Scene(root1));
        stage1.show();

    }
}
