package com.example.mynotesapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button btn;

    @FXML
    protected void onStartButtonClick(ActionEvent event) {
        btn.setText("You've clicked!");
    }
}
