package com.example.demo.models;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Breed {
    public String name;
    public String description;
    public ObservableList<Pet> pets;

    public Breed(String name, String description, ObservableList<Pet> pets) {
        this.name = name;
        this.description = description;
        this.pets = pets;
    }

    @Override
    public String toString() {
        return name;
    }
}
