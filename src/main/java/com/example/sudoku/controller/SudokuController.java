package com.example.sudoku.controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;


/**
 * SudokuController
 * run the game
 */

public class SudokuController {

    protected SudokuGame sudokuGame;

    @FXML
    private Button ayudaButton;

    @FXML
    private TextField c1F1TextField;

    @FXML
    private TextField c1F2TextField;

    @FXML
    private TextField c1F3TextField;

    @FXML
    private TextField c1F4TextField;

    @FXML
    private TextField c1F5TextField;

    @FXML
    private TextField c1F6TextField;

    @FXML
    private TextField c2F1TextField;

    @FXML
    private TextField c2F2TextField;

    @FXML
    private TextField c2F3TextField;

    @FXML
    private TextField c2F4TextField;

    @FXML
    private TextField c2F5TextField;

    @FXML
    private TextField c2F6TextField;

    @FXML
    private TextField c3F1TextField;

    @FXML
    private TextField c3F2TextField;

    @FXML
    private TextField c3F3TextField;

    @FXML
    private TextField c3F4TextField;

    @FXML
    private TextField c3F5TextField;

    @FXML
    private TextField c3F6TextField;

    @FXML
    private TextField c4F1TextField;

    @FXML
    private TextField c4F2TextField;

    @FXML
    private TextField c4F3TextField;

    @FXML
    private TextField c4F4TextField;

    @FXML
    private TextField c4F5TextField;

    @FXML
    private TextField c4F6TextField;

    @FXML
    private TextField c5F1TextField;

    @FXML
    private TextField c5F2TextField;

    @FXML
    private TextField c5F3TextField;

    @FXML
    private TextField c5F4TextField;

    @FXML
    private TextField c5F5TextField;

    @FXML
    private TextField c5F6TextField;

    @FXML
    private TextField c6F1TextField;

    @FXML
    private TextField c6F2TextField;

    @FXML
    private TextField c6F3TextField;

    @FXML
    private TextField c6F4TextField;

    @FXML
    private TextField c6F5TextField;

    @FXML
    private TextField c6F6TextField;

    @FXML
    private Button inicioButton;


    @FXML
    void onAyudaButtonClick(ActionEvent event) {

    }

    @FXML
    void onInicioButtonClick(ActionEvent event) {
        sudokuGame = new SudokuGame();
        ArrayList<ArrayList<Integer>> cuadricula = sudokuGame.getCuadricula();

        actualizarInterfaz(cuadricula);

    }

    private void actualizarInterfaz(ArrayList<ArrayList<Integer>> cuadricula) {
        c1F1TextField.setText(String.valueOf(cuadricula.get(0).get(0)));
        c1F2TextField.setText(String.valueOf(cuadricula.get(0).get(1)));
        c1F3TextField.setText(String.valueOf(cuadricula.get(0).get(2)));
        c1F4TextField.setText(String.valueOf(cuadricula.get(0).get(3)));
        c1F5TextField.setText(String.valueOf(cuadricula.get(0).get(4)));
        c1F6TextField.setText(String.valueOf(cuadricula.get(0).get(5)));

        c2F1TextField.setText(String.valueOf(cuadricula.get(1).get(0)));
        c2F2TextField.setText(String.valueOf(cuadricula.get(1).get(1)));
        c2F3TextField.setText(String.valueOf(cuadricula.get(1).get(2)));
        c2F4TextField.setText(String.valueOf(cuadricula.get(1).get(3)));
        c2F5TextField.setText(String.valueOf(cuadricula.get(1).get(4)));
        c2F6TextField.setText(String.valueOf(cuadricula.get(1).get(5)));

        c3F1TextField.setText(String.valueOf(cuadricula.get(2).get(0)));
        c3F2TextField.setText(String.valueOf(cuadricula.get(2).get(1)));
        c3F3TextField.setText(String.valueOf(cuadricula.get(2).get(2)));
        c3F4TextField.setText(String.valueOf(cuadricula.get(2).get(3)));
        c3F5TextField.setText(String.valueOf(cuadricula.get(2).get(4)));
        c3F6TextField.setText(String.valueOf(cuadricula.get(2).get(5)));

        c4F1TextField.setText(String.valueOf(cuadricula.get(3).get(0)));
        c4F2TextField.setText(String.valueOf(cuadricula.get(3).get(1)));
        c4F3TextField.setText(String.valueOf(cuadricula.get(3).get(2)));
        c4F4TextField.setText(String.valueOf(cuadricula.get(3).get(3)));
        c4F5TextField.setText(String.valueOf(cuadricula.get(3).get(4)));
        c4F6TextField.setText(String.valueOf(cuadricula.get(3).get(5)));

        c5F1TextField.setText(String.valueOf(cuadricula.get(4).get(0)));
        c5F2TextField.setText(String.valueOf(cuadricula.get(4).get(1)));
        c5F3TextField.setText(String.valueOf(cuadricula.get(4).get(2)));
        c5F4TextField.setText(String.valueOf(cuadricula.get(4).get(3)));
        c5F5TextField.setText(String.valueOf(cuadricula.get(4).get(4)));
        c5F6TextField.setText(String.valueOf(cuadricula.get(4).get(5)));

        c6F1TextField.setText(String.valueOf(cuadricula.get(5).get(0)));
        c6F2TextField.setText(String.valueOf(cuadricula.get(5).get(1)));
        c6F3TextField.setText(String.valueOf(cuadricula.get(5).get(2)));
        c6F4TextField.setText(String.valueOf(cuadricula.get(5).get(3)));
        c6F5TextField.setText(String.valueOf(cuadricula.get(5).get(4)));
        c6F6TextField.setText(String.valueOf(cuadricula.get(5).get(5)));
    }


    @FXML
    void onInputC1F1TextField(KeyEvent event) {
        sudokuGame.onEntradaTextField(event, 0, 0);
    }

    @FXML
    void onInputC1F2TextField(KeyEvent event) {

    }

    @FXML
    void onInputC1F3TextField(KeyEvent event) {

    }

    @FXML
    void onInputC1F4TextField(KeyEvent event) {

    }

    @FXML
    void onInputC1F5TextField(KeyEvent event) {

    }

    @FXML
    void onInputC1F6TextField(KeyEvent event) {

    }

    @FXML
    void onInputC2F1TextField(KeyEvent event) {

    }

    @FXML
    void onInputC2F2TextField(KeyEvent event) {

    }

    @FXML
    void onInputC2F3TextField(KeyEvent event) {

    }

    @FXML
    void onInputC2F4TextField(KeyEvent event) {

    }

    @FXML
    void onInputC2F5TextField(KeyEvent event) {

    }

    @FXML
    void onInputC2F6TextField(KeyEvent event) {

    }

    @FXML
    void onInputC3F1TextField(KeyEvent event) {

    }

    @FXML
    void onInputC3F2TextField(KeyEvent event) {

    }

    @FXML
    void onInputC3F3TextField(KeyEvent event) {

    }

    @FXML
    void onInputC3F4TextField(KeyEvent event) {

    }

    @FXML
    void onInputC3F5TextField(KeyEvent event) {

    }

    @FXML
    void onInputC3F6TextField(KeyEvent event) {

    }

    @FXML
    void onInputC4F1TextField(KeyEvent event) {

    }

    @FXML
    void onInputC4F2TextField(KeyEvent event) {

    }

    @FXML
    void onInputC4F3TextField(KeyEvent event) {

    }

    @FXML
    void onInputC4F4TextField(KeyEvent event) {

    }

    @FXML
    void onInputC4F5TextField(KeyEvent event) {

    }

    @FXML
    void onInputC4F6TextField(KeyEvent event) {

    }

    @FXML
    void onInputC5F1TextField(KeyEvent event) {

    }

    @FXML
    void onInputC5F2TextField(KeyEvent event) {

    }

    @FXML
    void onInputC5F3TextField(KeyEvent event) {

    }

    @FXML
    void onInputC5F4TextField(KeyEvent event) {

    }

    @FXML
    void onInputC5F5TextField(KeyEvent event) {

    }

    @FXML
    void onInputC5F6TextField(KeyEvent event) {

    }

    @FXML
    void onInputC6F1TextField(KeyEvent event) {

    }

    @FXML
    void onInputC6F2TextField(KeyEvent event) {

    }

    @FXML
    void onInputC6F3TextField(KeyEvent event) {

    }

    @FXML
    void onInputC6F4TextField(KeyEvent event) {

    }

    @FXML
    void onInputC6F5TextField(KeyEvent event) {

    }

    @FXML
    void onInputC6F6TextField(KeyEvent event) {

    }





}