package com.example.mynotesapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        // Стартовое окно
        stage.setTitle("MyNotesApp");
        stage.setWidth(1280);
        stage.setHeight(720);

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);

        // Заливка линейным градиентом заднего фона - почему-то не хочет работать
        scene.setFill(new LinearGradient(
                0, 0, 1, 1, true,           //sizing
                CycleMethod.NO_CYCLE,                       //cycling
                new Stop(0, Color.web("#81c483")),     //colors
                new Stop(1, Color.web("#fcc200")))
        );

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