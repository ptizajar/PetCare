package com.example.demo;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.demo.models.Breed;
import com.example.demo.models.Data;
import com.example.demo.models.Owners;
import com.example.demo.models.Pet;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Reports {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label reportBreedOwner;

    @FXML
    private Label reportBreedPets;

    @FXML
    private Label reportVaccinationOwner;

    @FXML
    private DatePicker reportVaccinationsDate;

    @FXML
    private Label reportVaccinationsPets;

    @FXML
    private Label reportVaccinationsVaccinations;

    @FXML
    private ComboBox<Breed> reportsBreed;

    @FXML
    private Button reportsMainButton;

    @FXML
    private Button reportsPdfButton;

    @FXML
    private Label reportsPetBreed;

    @FXML
    private Label reportsPetColor;

    @FXML
    private ComboBox<Pet> reportsPetCombobox;

    @FXML
    private Label reportsPetDateborn;

    @FXML
    private Label reportsPetOwner;

    @FXML
    private Label reportsPetPet;

    @FXML
    private Label reportsPetType;
    @FXML
    private Button reportsBreedCreate;
    @FXML
    private Button reportsVaccinationsCreate;
    @FXML
    private Button reportsPetCreate;
    @FXML
    private AnchorPane reportsAnchorPane;
    @FXML
    private AnchorPane reportsPaneBreed;
    @FXML
    private AnchorPane repotrsPaneBreedToprint;
    @FXML
    private AnchorPane reportsVaccinationToprint;
    @FXML
    private Button pdfVaccination;
    @FXML
    private Button pdfPet;
    @FXML
    private ImageView reportsPetImage;
    @FXML
    private AnchorPane petReportToprint;

    @FXML
    void initialize() {
        assert reportBreedOwner != null : "fx:id=\"reportBreedOwner\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportBreedPets != null : "fx:id=\"reportBreedPets\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportVaccinationOwner != null : "fx:id=\"reportVaccinationOwner\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportVaccinationsDate != null : "fx:id=\"reportVaccinationsDate\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportVaccinationsPets != null : "fx:id=\"reportVaccinationsPets\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportVaccinationsVaccinations != null : "fx:id=\"reportVaccinationsVaccinations\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsBreed != null : "fx:id=\"reportsBreed\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsMainButton != null : "fx:id=\"reportsMainButton\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsPdfButton != null : "fx:id=\"reportsPdfButton\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsPetBreed != null : "fx:id=\"reportsPetBreed\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsPetColor != null : "fx:id=\"reportsPetColor\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsPetCombobox != null : "fx:id=\"reportsPetCombobox\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsPetDateborn != null : "fx:id=\"reportsPetDateborn\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsPetOwner != null : "fx:id=\"reportsPetOwner\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsPetPet != null : "fx:id=\"reportsPetPet\" was not injected: check your FXML file 'reports.fxml'.";
        assert reportsPetType != null : "fx:id=\"reportsPetType\" was not injected: check your FXML file 'reports.fxml'.";
        ObservableList<Breed> thisBreeds = Data.getBreeds();
        reportsBreed.setItems(thisBreeds);
        for (int i = 0; i < thisBreeds.size(); i++) {
            reportsPetCombobox.getItems().addAll(thisBreeds.get(i).pets);
        }
        ;
        reportsMainButton.setOnAction(event -> {
            try {
                this.handleButtonMain(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        reportsBreedCreate.setOnAction(event -> {
            try {
                this.handleButtonBreedCreate(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        reportsPetCreate.setOnAction(event -> {
            try {
                this.handleButtonPetCreate(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        reportsVaccinationsCreate.setOnAction(event -> {
            try {
                this.handleButtonVaccinationCreate(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        reportsPdfButton.setOnAction(event -> {
            try {
                this.createPdf(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        pdfVaccination.setOnAction(event -> {
            try {
                this.createPdfVaccinations(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        pdfPet.setOnAction(event -> {
            try {
                this.createPdfPet(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    ;

    @FXML
    private void handleButtonMain(ActionEvent event) throws IOException {

        Stage stage = (Stage) reportsMainButton.getScene().getWindow();
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

    @FXML
    private void handleButtonBreedCreate(ActionEvent event) throws IOException {
        Breed chosenBreed = reportsBreed.getValue();
        String chosenPets = "";
        for (int i = 0; i < chosenBreed.pets.size(); i++) {
            if (i < chosenBreed.pets.size() - 1) {
                chosenPets = chosenPets + chosenBreed.pets.get(i).toString() + ", ";
            } else {
                chosenPets = chosenPets + chosenBreed.pets.get(i).toString();
            }
        }
        reportBreedPets.setText(chosenPets);
        reportBreedOwner.setText(Data.currentOwner.name);
    }

    @FXML
    private void handleButtonPetCreate(ActionEvent event) throws IOException {
        Pet chosenPet = reportsPetCombobox.getValue();
        reportsPetPet.setText(chosenPet.name);
        reportsPetType.setText(chosenPet.type);
        reportsPetBreed.setText(chosenPet.breed);
        reportsPetColor.setText(chosenPet.color);
        reportsPetDateborn.setText(chosenPet.dateBorn);
        reportsPetImage.setImage(chosenPet.photo);
        reportsPetOwner.setText(Data.currentOwner.name);

    }

    @FXML
    private void handleButtonVaccinationCreate(ActionEvent event) throws IOException {
        LocalDate chosenDate = reportVaccinationsDate.getValue();
        localDateToDate(chosenDate);
        String textChosenPets = "";
        String textVaccinations = "";
        String textChosenDate = chosenDate.toString();
        ObservableList<Breed> thisBreeds = Data.getBreeds();
        for (int i = 0; i < thisBreeds.size(); i++) {
            for (int j = 0; j < thisBreeds.get(i).pets.size(); j++) {
                String petDate = thisBreeds.get(i).pets.get(j).dateVisit;
                if (textChosenDate.equals(petDate)) {
                    if (j < thisBreeds.get(i).pets.size() - 1) {
                        textChosenPets = textChosenPets + thisBreeds.get(i).pets.get(j).name + ", ";
                    } else {
                        textChosenPets = textChosenPets + thisBreeds.get(i).pets.get(j).name;
                    }
                    String vaccinationsText = String.join(", ", thisBreeds.get(i).pets.get(j).vaccinations);
                    if (j < thisBreeds.get(i).pets.size() - 1) {
                        textVaccinations = textVaccinations + vaccinationsText + ", ";
                    } else {
                        textVaccinations = textVaccinations + vaccinationsText;
                    }
                }
            }
        }
        reportVaccinationsPets.setText(textChosenPets);
        reportVaccinationsVaccinations.setText(textVaccinations);
        reportVaccinationOwner.setText(Data.currentOwner.name);
    }

    private static String localDateToDate(LocalDate localDate) {
        final String format = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        formatter.format(localDate);
        return localDate.format(formatter);
    }

    @FXML
    private void createPdf(ActionEvent event) throws IOException {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            job.showPrintDialog(reportsBreed.getScene().getWindow());

            job.printPage(repotrsPaneBreedToprint);
            job.endJob();
        }
    }

    @FXML
    private void createPdfVaccinations(ActionEvent event) throws IOException {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            job.showPrintDialog(reportsBreed.getScene().getWindow());

            job.printPage(reportsVaccinationToprint);
            job.endJob();
        }
    }
    @FXML
    private void createPdfPet(ActionEvent event) throws IOException {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            job.showPrintDialog(reportsBreed.getScene().getWindow());

            job.printPage(petReportToprint);

            job.endJob();
        }
    }

}
