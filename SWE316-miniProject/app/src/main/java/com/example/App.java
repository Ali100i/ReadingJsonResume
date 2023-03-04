package com.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private static String path1 = "src\\res\\CV1.json";
    private static String path2 = "src\\res\\CV2.json";
    private static String path3 = "src\\res\\CV3.json";
    private static jsonReader reader;
    public static Resume resume1;
    public static Resume resume2;
    public static Resume resume3;

    @Override
    public void start(Stage primaryStage)   {
        

        try{
        reader = new jsonReader(path1);
        resume1 = reader.resume_Generator();
        reader = new jsonReader(path2);
        resume2 = reader.resume_Generator();
        reader = new jsonReader(path3);
        resume3 = reader.resume_Generator();

        VBox root = FXMLLoader.load(getClass().getResource("resumeGUi.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Resume Parser");
        primaryStage.setScene(scene);
        primaryStage.show();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException, ParseException {
        launch(args);
    }

}
