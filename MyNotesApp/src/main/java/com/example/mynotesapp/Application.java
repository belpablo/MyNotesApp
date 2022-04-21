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

        // Создание окна:
        stage.setTitle("MyNotesApp");
        stage.setWidth(640);
        stage.setHeight(360);

        /* Пока что реализован случай только для одной заметки:

            1) при запуске появляется приетствие и кнопка начать.
            2) По клику открывается окно с первой заметкой
            3) Редактирование заметки:
               В заметке должны быть поле текста заметки,

               Должно быть доступно:
               Редактирование заметки в окне.
               Сохранение заметки между сеансами приложения, в любом формате (по кнопке save + сразу выход из заметки).
        */

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 360);
        stage.setScene(scene);
        stage.show();


        /*

           Желательно:
           Создание нескольких заметок в приложении.
           Выводить список существующих заметок.
           Возможность редактирования любой заметки из списка.
           Удаление заметок
           Также сохранять все заметки между сеансами.
         */

        /*  Добавить случай когда заметки уже есть:

            Добавить возможность создания больше чем одной заметки
            Добавить отображение уже созданных заметок (первые N символов каждой заметки).
            сделать эти заметки кликабельными.
            Добавить ползунок для удобства.

            + добавить удаление и возможность называть разные заметки самостоятельно.

         */
    }
}