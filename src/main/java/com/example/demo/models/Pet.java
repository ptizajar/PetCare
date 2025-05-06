package com.example.demo.models;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Pet {
    public String name;
    public String type;
    public String breed;
    public String color;
    public String dateBorn;
    public String dateVisit;
    public String[]  vaccinations;
    public Image photo;


    @Override
    public String toString() {
        return name;
    }

    public Pet(String name, String type, String breed, String color, String dateBorn, String dateVisit, String[] vaccinations, Image photo) {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.color = color;
        this.dateBorn = dateBorn;
        this.dateVisit = dateVisit;
        this.vaccinations = vaccinations;
        this.photo = photo;
    }
}
