package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.models.Data;
import com.example.demo.models.Pet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class Language {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton languageEnglishRadio;

    @FXML
    private Button languageOkButton;

    @FXML
    private RadioButton languageRussionRadio;

    @FXML
    void initialize() {

        assert languageEnglishRadio != null : "fx:id=\"languageEnglishRadio\" was not injected: check your FXML file 'language.fxml'.";
        assert languageOkButton != null : "fx:id=\"languageOkButton\" was not injected: check your FXML file 'language.fxml'.";
        assert languageRussionRadio != null : "fx:id=\"languageRussionRadio\" was not injected: check your FXML file 'language.fxml'.";
        languageRussionRadio.setSelected(true);
        ToggleGroup buttonGroup = new ToggleGroup();
        languageEnglishRadio.setToggleGroup(buttonGroup);
        languageRussionRadio.setToggleGroup(buttonGroup);
        languageOkButton.setOnAction(event -> {
            try {
                this.handleButton(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void handleButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) languageOkButton.getScene().getWindow();
        stage.close();

    }
}
