package com.example.mynotesapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;

// Контроллер окна приветсвия
public class MainController {

    public static int noteNum;
    @FXML
    public ComboBox userNum;
    @FXML
    private Button btn_1;
    @FXML
    private Button btn_2;


    // Getting the number of the note
    public int getTheNumOfNote(ActionEvent event) {

        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();

        // Why does this get the null result??!
        System.out.println(userNum.getUserData());

        return Integer.parseInt(data);

    }


    // Открыть окно редактирования заметки по её номеру
    @FXML
    public void openNoteByNumber(ActionEvent event) throws IOException {

        //btn_1.setText("THE Note is already open");

        this.noteNum = getTheNumOfNote(event);

        Stage stage = new Stage();
        stage.setTitle("Note number " + this.noteNum);
        stage.setWidth(1280);
        stage.setHeight(720);

        String noteType;
        File file = new File("src/main/notesText/note" + this.noteNum + ".txt");

        if (file.createNewFile()) {
            noteType = "new-note-view.fxml";
        } else {
            noteType = "existing-note-view.fxml";
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(noteType));

        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }


    // Закрыть текущее окно
    public void closeTheStage() throws IOException{

        Stage stage = (Stage) btn_2.getScene().getWindow();
        stage.close();
    }
}
