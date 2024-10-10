package com.example.sudoku;

import com.example.sudoku.view.SudokuView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SudokuView.getInstance();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}