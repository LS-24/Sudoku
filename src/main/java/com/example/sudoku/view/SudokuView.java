package com.example.sudoku.view;

import com.example.sudoku.controller.SudokuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * SUdokuView
 * create a new window
 */
public class SudokuView extends Stage {

    private SudokuController controller;

    public SudokuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sudoku/Sudoku-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        setScene(scene);
        setTitle("Sudoku");
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/sudoku/imagen/sudoku.png"))));
        setResizable(false);
        show();
    }

    public static SudokuView getInstance() throws IOException {
        if (sudokuViewHolder.INSTANCE == null) {
            return sudokuViewHolder.INSTANCE = new SudokuView();
        }else {
            return sudokuViewHolder.INSTANCE;
        }
    }

    private static class sudokuViewHolder {
        private static SudokuView INSTANCE;
    }
}
