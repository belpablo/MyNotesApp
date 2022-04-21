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
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

// ЕДИНЫЙ КОНТРОЛЛЕР ДЛЯ ВСЕХ ОКОН ПРИЛОЖЕНИЯ
public class Controller {

    @FXML
    private Button btn_1;
    @FXML
    private Button btn_2;
    @FXML
    TextArea textInput;


    // Открытие нового окна с заметкой по её номеру (input type == string)
    @FXML
    protected void openNoteByNumber(ActionEvent event) throws IOException {

        //btn_1.setText("THE Note is already open");

        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        int value = Integer.parseInt(data);

        Stage stage = new Stage();
        stage.setTitle("Note number " + value);
        stage.setWidth(640);
        stage.setHeight(360);

        String noteType;
        File file = new File("src/main/notesText/note" + value + ".txt");

        if (file.createNewFile()) {
            noteType = "new-note-view.fxml";
        } else {
            noteType = "existing-note-view.fxml";
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(noteType));

        Scene scene = new Scene(fxmlLoader.load(), 640, 360);
        stage.setScene(scene);
        stage.show();

    }


    // Сохраниение текста из textArea в файл
    @FXML
    public void savingTextFromArea(ActionEvent event) throws IOException {

        // Getting the text from Area
        String text = textInput.getText();

        // Getting the number of the note
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        int value = Integer.parseInt(data);

        // Creating new text file
        File file = new File("src/main/notesText/note" + value + ".txt");

        // Writing content
        FileWriter writer = new FileWriter (file);
        writer.write(text);
        writer.close();
    }


    // Вставить содержимое файла в textArea
    @FXML
    public void pushTextFromFile() throws IOException {

        String filePath = "src/main/notesText/note1.txt";

        String content = null;
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        textInput.insertText(0, content);
    }


    // Закрыть окно
    public void closeTheStage() throws IOException{

        Stage stage = (Stage) btn_2.getScene().getWindow();
        stage.close();
    }


    // Преобразование File в String
    public static String readFile(String path, Charset encoding) throws IOException {

        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
