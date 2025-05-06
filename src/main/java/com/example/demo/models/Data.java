package com.example.demo.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.*;

public class Data {
    public static Owners currentOwner;
    private static ArrayList<Owners> Users = new ArrayList<Owners>(Arrays.asList(new Owners("sveta","sveta123","123456","tet@com")));
    private static Image photo1 = new Image("/фонtest.png",100,150,false,false);
    private static Pet _musya = new Pet("musya", "mlecopit","cat", "black", "01-01-2020","2025-01-01",new String[]{"beshenstvo","stolbnyak"},photo1);
    private static final ObservableList<Pet> _pets = FXCollections.observableArrayList(Arrays.asList(_musya));
    private static final Breed _cat = new Breed(
            "cat","nnn", _pets);

    private static final ObservableList<Breed> _breeds = FXCollections.observableArrayList(Arrays.asList(_cat));
    //public static final ArrayList<Pet> _pets = new ArrayList<Pet>(Arrays.asList(_musya));

    public static void registrate(Owners user) throws Exception {
        Owners o = Data.Users.stream().filter(u-> Objects.equals(u.login, user.login) )
                .findFirst().orElse(null);
        if(o!=null){
            throw new Exception("Логин уже существует");
        }
        else{
            Users.add(user);
            Data.currentOwner = user;
        }
    }

    public static void logining(String login, String password) throws Exception {
        Owners o = Data.Users.stream().filter(user-> Objects.equals(user.login, login) && Objects.equals(user.password, password))
                .findFirst().orElse(null);
        if(o==null){
            throw new Exception("Неверные данные");
        }
        else{
            currentOwner = o;
        }
    }

    public static ObservableList<Breed> getBreeds(){
        return _breeds;
    }

    public static void addBreed(Breed b){
        _breeds.add(b);
    }

    public static void addPet(Breed b, Pet p){
        b.pets.add(p);
    }

    public static void updateBreed(Breed b){

    }

    public static void updatePet(Pet p){

    }

    public static void removeBreed(Breed b){
        Data._breeds.remove(b);
    }

    public static void removePet(Breed b, Pet p){
        b.pets.remove(p);
    }
}
