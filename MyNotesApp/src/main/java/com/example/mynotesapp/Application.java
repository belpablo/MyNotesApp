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

        /* Запуск приложения. Случай, когда ещё нет заметок:

            Появляется приетствие и кнопка начать.
            По клику должно открываться окно с первой (пустой) заметкой
        */

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 360);
        stage.setScene(scene);
        stage.show();

        /* Запуск приложения. Случай, когда заметки уже есть:

            Добавить отображение заголовков и/или (если нет заголовка) то первые N символов.
            Добавить ползунок для удобства

         */

        /* Создание/редактирование заметки:

           Открывается новое окно.
           В заметке должны быть поля ```Заголовок``` и ```Текст заметки```,
           названия должны быть видны для пользователя.

           Должно быть доступно:
           Редактирование заметки в окне.
           Сохранение заметки между сеансами приложения, в любом формате.
           При первом запуске, приложение должно иметь одну заметку с текстом

         */
    }
}