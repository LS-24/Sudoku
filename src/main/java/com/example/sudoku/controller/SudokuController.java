package com.example.sudoku.controller;

/**
 * @autor larry zuñiga
 * SudokuController
 * Class that represents the visual part of the game
 *  * Manage events
 */

import com.example.sudoku.model.AlertBox;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;


/**
 * SudokuController
 *
 */
public class SudokuController {

    protected SudokuGame sudokuGame;

    @FXML
    private TextArea numeroSugeridoTextArea;

    @FXML
    private Button ayudaButton;

    @FXML
    private Button inicioButton;

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


    /**
     *controls help button events
     * @param event
     */
    @FXML
    void onAyudaButtonClick(ActionEvent event) {
        // Buscar una celda vacía
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (sudokuGame.getCuadricula().get(fila).get(columna) == 0) {
                    Integer sugerido = sudokuGame.sugerirNumero(fila, columna);
                    if (sugerido != null) {
                        numeroSugeridoTextArea.setText("Se sugiere el número " + sugerido + " para la celda (" + (fila + 1) + ", " + (columna + 1) + ").");
                        new AlertBox().showAlert(
                                "Sugerencia",
                                "Se sugiere el número " + sugerido + " para la celda (" + (fila + 1) + ", " + (columna + 1) + ").",
                                "¡Intenta usarlo!"
                        );
                    }
                    return; // Salir tras hacer una sugerencia
                }
            }
        }
        new AlertBox().showAlert("Sin celdas vacías", "No hay celdas vacías para sugerir.", "");
    }


    /**
     *controls game start button events
     * @param event
     */
    @FXML
    void onInicioButtonClick(ActionEvent event) {
        sudokuGame = new SudokuGame();
        ayudaButton.setDisable(false);
        numeroSugeridoTextArea.setText("");
        actualizarInterfaz(sudokuGame.getCuadricula());

    }

    /**
     *update the visual interface
     * @param cuadricula
     */
    public void actualizarInterfaz(ArrayList<ArrayList<Integer>> cuadricula) {
        c1F1TextField.setText(cuadricula.get(0).get(0) == 0 ? "" : String.valueOf(cuadricula.get(0).get(0)));
        c1F2TextField.setText(cuadricula.get(0).get(1) == 0 ? "" : String.valueOf(cuadricula.get(0).get(1)));
        c1F3TextField.setText(cuadricula.get(0).get(2) == 0 ? "" : String.valueOf(cuadricula.get(0).get(2)));
        c1F4TextField.setText(cuadricula.get(0).get(3) == 0 ? "" : String.valueOf(cuadricula.get(0).get(3)));
        c1F5TextField.setText(cuadricula.get(0).get(4) == 0 ? "" : String.valueOf(cuadricula.get(0).get(4)));
        c1F6TextField.setText(cuadricula.get(0).get(5) == 0 ? "" : String.valueOf(cuadricula.get(0).get(5)));

        c2F1TextField.setText(cuadricula.get(1).get(0) == 0 ? "" : String.valueOf(cuadricula.get(1).get(0)));
        c2F2TextField.setText(cuadricula.get(1).get(1) == 0 ? "" : String.valueOf(cuadricula.get(1).get(1)));
        c2F3TextField.setText(cuadricula.get(1).get(2) == 0 ? "" : String.valueOf(cuadricula.get(1).get(2)));
        c2F4TextField.setText(cuadricula.get(1).get(3) == 0 ? "" : String.valueOf(cuadricula.get(1).get(3)));
        c2F5TextField.setText(cuadricula.get(1).get(4) == 0 ? "" : String.valueOf(cuadricula.get(1).get(4)));
        c2F6TextField.setText(cuadricula.get(1).get(5) == 0 ? "" : String.valueOf(cuadricula.get(1).get(5)));

        c3F1TextField.setText(cuadricula.get(2).get(0) == 0 ? "" : String.valueOf(cuadricula.get(2).get(0)));
        c3F2TextField.setText(cuadricula.get(2).get(1) == 0 ? "" : String.valueOf(cuadricula.get(2).get(1)));
        c3F3TextField.setText(cuadricula.get(2).get(2) == 0 ? "" : String.valueOf(cuadricula.get(2).get(2)));
        c3F4TextField.setText(cuadricula.get(2).get(3) == 0 ? "" : String.valueOf(cuadricula.get(2).get(3)));
        c3F5TextField.setText(cuadricula.get(2).get(4) == 0 ? "" : String.valueOf(cuadricula.get(2).get(4)));
        c3F6TextField.setText(cuadricula.get(2).get(5) == 0 ? "" : String.valueOf(cuadricula.get(2).get(5)));

        c4F1TextField.setText(cuadricula.get(3).get(0) == 0 ? "" : String.valueOf(cuadricula.get(3).get(0)));
        c4F2TextField.setText(cuadricula.get(3).get(1) == 0 ? "" : String.valueOf(cuadricula.get(3).get(1)));
        c4F3TextField.setText(cuadricula.get(3).get(2) == 0 ? "" : String.valueOf(cuadricula.get(3).get(2)));
        c4F4TextField.setText(cuadricula.get(3).get(3) == 0 ? "" : String.valueOf(cuadricula.get(3).get(3)));
        c4F5TextField.setText(cuadricula.get(3).get(4) == 0 ? "" : String.valueOf(cuadricula.get(3).get(4)));
        c4F6TextField.setText(cuadricula.get(3).get(5) == 0 ? "" : String.valueOf(cuadricula.get(3).get(5)));

        c5F1TextField.setText(cuadricula.get(4).get(0) == 0 ? "" : String.valueOf(cuadricula.get(4).get(0)));
        c5F2TextField.setText(cuadricula.get(4).get(1) == 0 ? "" : String.valueOf(cuadricula.get(4).get(1)));
        c5F3TextField.setText(cuadricula.get(4).get(2) == 0 ? "" : String.valueOf(cuadricula.get(4).get(2)));
        c5F4TextField.setText(cuadricula.get(4).get(3) == 0 ? "" : String.valueOf(cuadricula.get(4).get(3)));
        c5F5TextField.setText(cuadricula.get(4).get(4) == 0 ? "" : String.valueOf(cuadricula.get(4).get(4)));
        c5F6TextField.setText(cuadricula.get(4).get(5) == 0 ? "" : String.valueOf(cuadricula.get(4).get(5)));

        c6F1TextField.setText(cuadricula.get(5).get(0) == 0 ? "" : String.valueOf(cuadricula.get(5).get(0)));
        c6F2TextField.setText(cuadricula.get(5).get(1) == 0 ? "" : String.valueOf(cuadricula.get(5).get(1)));
        c6F3TextField.setText(cuadricula.get(5).get(2) == 0 ? "" : String.valueOf(cuadricula.get(5).get(2)));
        c6F4TextField.setText(cuadricula.get(5).get(3) == 0 ? "" : String.valueOf(cuadricula.get(5).get(3)));
        c6F5TextField.setText(cuadricula.get(5).get(4) == 0 ? "" : String.valueOf(cuadricula.get(5).get(4)));
        c6F6TextField.setText(cuadricula.get(5).get(5) == 0 ? "" : String.valueOf(cuadricula.get(5).get(5)));
    }


    /**
     * controls the events generated in the Textfields
     * @param event
     */
    @FXML
    void onEntradasTextFields(KeyEvent event) {
        TextField source = (TextField) event.getSource();
        String input = event.getText();

        int fila = -1, columna = -1;

        // Determina la fila y la columna según el TextField que se activó
        if (source == c1F1TextField) { fila = 0; columna = 0; }
        else if (source == c1F2TextField) { fila = 0; columna = 1; }
        else if (source == c1F3TextField) { fila = 0; columna = 2; }
        else if (source == c1F4TextField) { fila = 0; columna = 3; }
        else if (source == c1F5TextField) { fila = 0; columna = 4; }
        else if (source == c1F6TextField) { fila = 0; columna = 5; }
        else if (source == c2F1TextField) { fila = 1; columna = 0; }
        else if (source == c2F2TextField) { fila = 1; columna = 1; }
        else if (source == c2F3TextField) { fila = 1; columna = 2; }
        else if (source == c2F4TextField) { fila = 1; columna = 3; }
        else if (source == c2F5TextField) { fila = 1; columna = 4; }
        else if (source == c2F6TextField) { fila = 1; columna = 5; }
        else if (source == c3F1TextField) { fila = 2; columna = 0; }
        else if (source == c3F2TextField) { fila = 2; columna = 1; }
        else if (source == c3F3TextField) { fila = 2; columna = 2; }
        else if (source == c3F4TextField) { fila = 2; columna = 3; }
        else if (source == c3F5TextField) { fila = 2; columna = 4; }
        else if (source == c3F6TextField) { fila = 2; columna = 5; }
        else if (source == c4F1TextField) { fila = 3; columna = 0; }
        else if (source == c4F2TextField) { fila = 3; columna = 1; }
        else if (source == c4F3TextField) { fila = 3; columna = 2; }
        else if (source == c4F4TextField) { fila = 3; columna = 3; }
        else if (source == c4F5TextField) { fila = 3; columna = 4; }
        else if (source == c4F6TextField) { fila = 3; columna = 5; }
        else if (source == c5F1TextField) { fila = 4; columna = 0; }
        else if (source == c5F2TextField) { fila = 4; columna = 1; }
        else if (source == c5F3TextField) { fila = 4; columna = 2; }
        else if (source == c5F4TextField) { fila = 4; columna = 3; }
        else if (source == c5F5TextField) { fila = 4; columna = 4; }
        else if (source == c5F6TextField) { fila = 4; columna = 5; }
        else if (source == c6F1TextField) { fila = 5; columna = 0; }
        else if (source == c6F2TextField) { fila = 5; columna = 1; }
        else if (source == c6F3TextField) { fila = 5; columna = 2; }
        else if (source == c6F4TextField) { fila = 5; columna = 3; }
        else if (source == c6F5TextField) { fila = 5; columna = 4; }
        else if (source == c6F6TextField) { fila = 5; columna = 5; }





        // Validar el texto ingresado
        if (input.matches("[1-6]?")) {
            int value = input.isEmpty() ? 0 : Integer.parseInt(input);
            System.out.println("Cuadrícula antes: " + sudokuGame.getCuadricula());
            sudokuGame.setNumero(fila, columna, value);
            System.out.println("Cuadrícula después: " + sudokuGame.getCuadricula());
            actualizarInterfaz(sudokuGame.getCuadricula());
            if (sudokuGame.isJuegoTerminado()) {
                new AlertBox().showAlert("¡Felicidades!", "¡Has completado el Sudoku correctamente!", "¡Buen trabajo!");
                // Desactivar botones y campos
                ayudaButton.setDisable(true);
                inicioButton.setDisable(true);
                // Aquí puedes deshabilitar todos los TextFields también
            }
        } else {
            source.setText(""); // Limpiar el campo si el valor es inválido
            // O puedes mostrar un mensaje de error si lo deseas
        }


}


}
