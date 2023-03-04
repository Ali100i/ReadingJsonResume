package com.example;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class resumeGuiController {
    private int index = -1;
    private String Certifications1 = "";
    private String Certifications2 = "";
    private String Certifications3 = "";
    private String Emails1 = "";
    private String Emails2 = "";
    private String Emails3 = "";
    private String Skills1 = "";
    private String Skills2 = "";
    private String Skills3 = "";
    ObservableList resumes = FXCollections.observableArrayList();

    @FXML
    private TextArea certificatesTextArea;

    @FXML
    private TextField eduTextArea;

    @FXML
    private TextArea emailTextArea;

    @FXML
    private TextArea nameTextArea;

    @FXML
    private Button nextBtn;

    @FXML
    private Button previousBtn;

    @FXML
    private ListView<String> resumeList;

    @FXML
    private TextArea skillsTextArea;

    @FXML
    void nxtBtnClicked(ActionEvent event) {
        if(index+1 < resumes.size()){
            index++;
        }
        else{
            index = 0;
        }
        updateTextArea();
    }

    @FXML
    void prevBtnClicked(ActionEvent event) {
        if(index > 0){
            index--;
        }
        else{
            index = 0;
        }
        updateTextArea();
    }

    @FXML
    public void initialize() {
        // TODO
        addItemsToListView();
        for(int i = 0; i < App.resume1.getCertifications().size(); i++){
            Certifications1 += App.resume1.getCertifications().get(i) + "\n";
        }
        for(int i = 0; i < App.resume2.getCertifications().size(); i++){
            Certifications2 += App.resume2.getCertifications().get(i) + "\n";
        }
        for(int i = 0; i < App.resume3.getCertifications().size(); i++){
            Certifications3 += App.resume3.getCertifications().get(i) + "\n";

        }
        for(int i = 0; i < App.resume1.getSkills().size(); i++){
            Skills1 += App.resume1.getSkills().get(i).getName() + "\n";
        }
        for(int i = 0; i < App.resume2.getSkills().size(); i++){
            Skills2 += App.resume2.getSkills().get(i).getName() + "\n";
        }
        for(int i = 0; i < App.resume3.getSkills().size(); i++){
            Skills3 += App.resume3.getSkills().get(i).getName() + "\n";
        }
        for(int i = 0; i < App.resume1.getEmails().size(); i++){
            Emails1 += App.resume1.getEmails().get(i) + "\n";
        }
        for(int i = 0; i < App.resume2.getEmails().size(); i++){
            Emails2 += App.resume2.getEmails().get(i) + "\n";
        }
        for(int i = 0; i < App.resume3.getEmails().size(); i++){
            Emails3 += App.resume3.getEmails().get(i) + "\n";
        }
    }

    private void updateTextArea() {
        switch(index){
            case 0:
                resumeList.getSelectionModel().select(0);
                nameTextArea.setText(App.resume1.getPersonal().getName().getRaw());
                emailTextArea.setText(Emails1);
                eduTextArea.setText(App.resume1.getEducation().getEducation());
                skillsTextArea.setText(Skills1);
                certificatesTextArea.setText(Certifications1);
                break;
            case 1:
                resumeList.getSelectionModel().select(1);
                nameTextArea.setText(App.resume2.getPersonal().getName().getRaw());
                emailTextArea.setText(Emails2);
                eduTextArea.setText(App.resume2.getEducation().getEducation());
                skillsTextArea.setText(Skills2);
                certificatesTextArea.setText(Certifications2);
                break;
            case 2:
                resumeList.getSelectionModel().select(2);
                nameTextArea.setText(App.resume3.getPersonal().getName().getRaw());
                emailTextArea.setText(Emails3);
                eduTextArea.setText(App.resume3.getEducation().getEducation());
                skillsTextArea.setText(Skills3);
                certificatesTextArea.setText(Certifications3);
                break;
        }
    }

    private void addItemsToListView() {
        resumes.add(App.resume1.getPersonal().getName().getRaw());
        resumes.add(App.resume2.getPersonal().getName().getRaw());
        resumes.add(App.resume3.getPersonal().getName().getRaw());
        resumeList.setItems(resumes);
    }
    
}
