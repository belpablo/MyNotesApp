package com.example.mynotesapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("MyNotesApp");
        stage.setWidth(640);
        stage.setHeight(360);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 360);
        stage.setScene(scene);
        stage.show();

        /* Пока что реализован случай только для одной заметки:

            1) при запуске появляется окно приветствия и кнопки начать / выйти.
            2) По клику открывается окно с первой заметкой
            3) В этом окне можно редактировать заметку и можно выйти окно приветствия
        */

        /*
           Добавить:

           Создание нескольких заметок в приложении
           Выводить список существующих заметок в окно приветствия (первые N символов каждой заметки)
           Сделать эти заметки кликабельными (Возможность редактирования любой заметки из списка)
           Добавить ползунок для удобства
           добавить удаление заметок
           Также сохранять все заметки между сеансами
           Возможность называть разные заметки самостоятельно

         */
    }
}