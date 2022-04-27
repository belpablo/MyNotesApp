package com.example.mynotesapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


// Контроллер для окна редактирования заметок:
public class NoteEditorController extends MainController{

    @FXML
    TextArea textInput;

    // Сохраниение текста из textArea в файл
    @FXML
    public void savingTextFromArea(ActionEvent event) throws IOException {

        // Getting the text from Area
        String text = textInput.getText();

        // Creating new text file
        File file = new File("src/main/notesText/note" + MainController.noteNum + ".txt");

        // Writing content
        FileWriter writer = new FileWriter (file);
        writer.write(text);
        writer.close();
    }


    // Вставить содержимое файла в textArea
    @FXML
    public void pushTextFromFile() throws IOException {

        String filePath = "src/main/notesText/note" + MainController.noteNum + ".txt";

        String content = null;
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        textInput.insertText(0, content);
    }


    // Преобразование File в String
    public static String readFile(String path, Charset encoding) throws IOException {

        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
