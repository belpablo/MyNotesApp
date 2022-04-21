package com.example.mynotesapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    /* Мысль следующая завести столько кнопок, сколько их всего максимум бывает на странице наших заметок.
        Всё равно на каждое новое окно создаётся новый экземпляр этого класса контроллера,
        так что думаю можно не писать разные контроллеры для разных типов окон (стартового окна / окна заметки)

     */

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    /*
    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    ...

     */

    @FXML
    protected void onTHENoteButtonClick(ActionEvent event) throws IOException {

        btn_1.setText("THE Note is already open");

        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        int value = Integer.parseInt(data);

        Stage stage = new Stage();
        stage.setTitle("Note number " + value);
        stage.setWidth(640);
        stage.setHeight(360);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("empty-note-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 360);
        stage.setScene(scene);
        stage.show();
    }

    // Текстового поля достаточно одного
    @FXML
    TextArea textArea;

    @FXML
    protected void savingTextFromArea(ActionEvent event) throws IOException {

        // Getting the text from Area
        String text = textArea.getText();

        // Getting the number of the note
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        int value = Integer.parseInt(data);

        // Creating new text file
        File file = new File("C:\\Users\\belpa\\Documents\\NewLife_22\\Java_start\\MyNotesApp\\src\\main\\notesText\\Note" +
                value + ".txt");
        file.createNewFile();

        // Writing content
        FileWriter writer = new FileWriter (file);
        writer.write(text);
        writer.close();
    }

    public void quitFromTHENote(ActionEvent event) throws IOException{
    }
}
