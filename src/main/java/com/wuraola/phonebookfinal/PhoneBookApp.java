package com.wuraola.phonebookfinal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneBookApp extends Application{

    private TextField phoneField = new TextField();
    private TextField nameField = new TextField();
    private Button searchButton = new Button("Search");
    Label resultLabel = new Label();
    private List<PhoneBookEntry> entries = new ArrayList<>();

    @Override
            public void start(Stage stage) {

        initializeData();

        searchButton.setOnAction(event -> search());

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(searchButton,  1, 1);
        grid.add(resultLabel, 1, 2);

        Scene scene = new Scene(grid, 400, 400);
        stage.setTitle("Phone Book");
        stage.setScene(scene);
        stage.show();
    }


    private void initializeData() {

        name = "alice";
        name = name[0].toupper + name[1:]



        entries.add(new PhoneBookEntry("Alice", "08034567890"));
        entries.add(new PhoneBookEntry("Wuraola", "08034567855"));
        entries.add(new PhoneBookEntry("Iyiola", "08141970854"));
        entries.add(new PhoneBookEntry("Ayobami", "08062467880"));
        entries.add(new PhoneBookEntry("Daniella", "07034552190"));

        entries.sort(Comparator.comparing(PhoneBookEntry::getPhoneNumber));

    }


    private void search() {
        String name = nameField.getText();
//        String phoneNumber = phoneField.getText();
        PhoneBookEntry foundEntry = entries.stream()
                .filter(entry -> entry.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (foundEntry != null) {
            resultLabel.setText("Phone number: " + foundEntry.getPhoneNumber());
        }else {
            resultLabel.setText("No matching entry found");
        }
    }




    public static void main(String[] args) {
        launch(args);
    }





}
